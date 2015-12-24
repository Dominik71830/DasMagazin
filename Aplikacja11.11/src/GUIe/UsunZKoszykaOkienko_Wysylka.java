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
import java.awt.Color;

public class UsunZKoszykaOkienko_Wysylka extends JDialog {
	
	static Funkcje funkcje;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			funkcje = new Funkcje();
			UsunZKoszykaOkienko_Wysylka dialog = new UsunZKoszykaOkienko_Wysylka((Integer) null, null,null,null,null,null);
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
	public UsunZKoszykaOkienko_Wysylka(int row, Produkt _tempProdukt, List<Produkt> _kupione, JTable _tableDodane, JTextField _textFieldSuma, JTextField _textFieldMasa) throws Exception {
		setTitle("Ile usun\u0105\u0107");
		funkcje = new Funkcje();
		setBounds(100, 100, 250, 145);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 0, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblIleUsunProduktw = new JLabel("Ile usun¹æ produkt\u00F3w");
		lblIleUsunProduktw.setForeground(Color.BLACK);
		lblIleUsunProduktw.setBounds(27, 24, 124, 22);
		contentPanel.add(lblIleUsunProduktw);
		
		textField = new JTextField();
		textField.setBackground(new Color(204, 153, 255));
		textField.setBounds(156, 25, 42, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setForeground(Color.BLACK);
		btnOk.setBackground(new Color(153, 102, 204));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
				
				Double suma = Double.parseDouble(_textFieldSuma.getText());
				Double masa = Double.parseDouble(_textFieldMasa.getText());
				String nazwa = _tempProdukt.getNazwa();
				int ilosc = Integer.parseInt(textField.getText());
				Double cena = _tempProdukt.getCena();
				Double cena_jednostkowa = _tempProdukt.getCena()/_tempProdukt.getIlosc();
				Double objetosc_jednostkowa = _tempProdukt.getObjetosc()/_tempProdukt.getIlosc();
				
				if ((_tempProdukt.getIlosc()<ilosc) || ilosc<=0)
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
					suma = suma-usuniety.getCena();
					funkcje.zaokraglij(suma);
					_textFieldSuma.setText(Double.toString(suma));	
					masa = masa-_tempProdukt.getObjetosc();
					funkcje.zaokraglij(masa);
					_textFieldMasa.setText(Double.toString(masa));
					_kupione.remove(row);
					
				} else if (_tempProdukt.getIlosc()>ilosc){
					usuniety.setIlosc(_tempProdukt.getIlosc()-ilosc);
					usuniety.setCena(_tempProdukt.getCena()-(ilosc*cena_jednostkowa));
					usuniety.setObjetosc(_tempProdukt.getObjetosc()-(ilosc*objetosc_jednostkowa));
					//funkcje.zaokraglij(masa);
					masa = masa-(ilosc*objetosc_jednostkowa);
					_textFieldMasa.setText(Double.toString(masa));
					//funkcje.zaokraglij(suma);
					suma = suma-(ilosc*cena_jednostkowa);
					_textFieldSuma.setText(Double.toString(suma));
					_kupione.remove(row);
					_kupione.add(row, usuniety);
				} 
				
				ModelTablicyProduktowDodanych model = new ModelTablicyProduktowDodanych(_kupione);
				_tableDodane.setModel(model);
				/////////////////////
				setVisible(false);
				dispose();
				
				// tutaj trzeba odswiezyæ comboboxa z produktami

				
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, "Proszê podaæ poprawn¹ iloœæ");
				}
			}
		});
		btnOk.setBounds(75, 57, 89, 23);
		contentPanel.add(btnOk);
	}
}
