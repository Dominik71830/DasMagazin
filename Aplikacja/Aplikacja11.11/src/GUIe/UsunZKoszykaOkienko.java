package GUIe;

import java.awt.BorderLayout;
import pakiet.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class UsunZKoszykaOkienko extends JDialog {
	
	static Funkcje funkcje;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			funkcje = new Funkcje();
			UsunZKoszykaOkienko dialog = new UsunZKoszykaOkienko((Integer) null, null,null,null,null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param row 
	 * @param _row 
	 * @param tableProdukty
	 * @param textFieldSuma 
	 * @param suma 
	 * @throws Exception 
	 */
	public UsunZKoszykaOkienko(int row, Produkt _tempProdukt, List<Produkt> _kupione, JTable _tableDodane, JTextField _textFieldSuma, JTable _tableProdukty) throws Exception {
		funkcje = new Funkcje();
		setBounds(100, 100, 250, 145);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblIleUsunProduktw = new JLabel("Ile usun¹æ produkt\u00F3w");
		lblIleUsunProduktw.setBounds(27, 24, 124, 22);
		contentPanel.add(lblIleUsunProduktw);
		
		textField = new JTextField();
		textField.setBounds(156, 25, 42, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Double suma = Double.parseDouble(_textFieldSuma.getText());
				String nazwa = _tempProdukt.getNazwa();
				int ilosc = Integer.parseInt(textField.getText());
				Double cena = _tempProdukt.getCena();
				Double cena_jednostkowa = _tempProdukt.getCena()/_tempProdukt.getIlosc();
				
				if ((_tempProdukt.getIlosc()<ilosc))
				{
					JOptionPane.showMessageDialog(null, "Podana wartoœæ jest wiêksza ni¿"
							+ " iloœæ tego produktu w koszyku!");
					return;
				}
				
				Produkt usuniety = new Produkt(nazwa,ilosc,cena);
				//JOptionPane.showMessageDialog(null, cena_jednostkowa);
				
				try {
					funkcje.zwrocIloscDoBazy(_tempProdukt, ilosc);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				//JOptionPane.showMessageDialog(null, usuniety.getIlosc());
				if(_tempProdukt.getIlosc()==ilosc){
					_kupione.remove(row);
					suma = suma-usuniety.getCena();
					_textFieldSuma.setText(Double.toString(suma));
				} else if (_tempProdukt.getIlosc()>ilosc){
					usuniety.setIlosc(_tempProdukt.getIlosc()-ilosc);
					usuniety.setCena(_tempProdukt.getCena()-(ilosc*cena_jednostkowa));
					_kupione.remove(row);
					_kupione.add(row, usuniety);
					suma = suma-(ilosc*cena_jednostkowa);
					_textFieldSuma.setText(Double.toString(suma));
				} 
				
				ModelTablicyProduktowDodanych model = new ModelTablicyProduktowDodanych(_kupione);
				_tableDodane.setModel(model);
				/////////////////////
				funkcje.odswiezProdukty(_tableProdukty);
				setVisible(false);
				dispose();
			}
		});
		btnOk.setBounds(62, 62, 89, 23);
		contentPanel.add(btnOk);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
