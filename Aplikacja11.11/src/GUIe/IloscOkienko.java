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
import java.io.EOFException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IloscOkienko extends JDialog {
	
	static Funkcje funkcje;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			funkcje = new Funkcje();
			IloscOkienko dialog = new IloscOkienko(null,null,null,null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param tableProdukty 
	 * @param textFieldSuma 
	 * @param suma 
	 * @throws Exception 
	 */
	public IloscOkienko(Produkt _tempProdukt, List<Produkt> _kupione, JTable _tableDodane, JTextField _textFieldSuma, JTable _tableProdukty) throws Exception {
		setTitle("Podaj ilo\u015B\u0107");
		funkcje = new Funkcje();
		setBounds(100, 100, 255, 155);
		  setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 0, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblIleDodaProduktw = new JLabel("Ile doda\u0107 produkt\u00F3w");
		lblIleDodaProduktw.setForeground(Color.BLACK);
		lblIleDodaProduktw.setBounds(27, 24, 124, 22);
		contentPanel.add(lblIleDodaProduktw);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
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
				int roznica;
				Double suma = Double.parseDouble(_textFieldSuma.getText());
				
				String nazwa = _tempProdukt.getNazwa();
				int ilosc = Integer.parseInt(textField.getText());
				
				//sprawdzanie sensownosci ilosci
				if(		ilosc>0 
						&&
						ilosc <= funkcje.ileJestNaMagazynie(_tempProdukt))
				{
				Double cena = ilosc * _tempProdukt.getCena();
				
				Produkt kupiony = new Produkt(nazwa,ilosc,cena);
				
				//odjecie roznicy z magazynu
				roznica = _tempProdukt.getIlosc()-ilosc;
				try {
					funkcje.odejmijIlosc(_tempProdukt,roznica);
				} catch (SQLException exc) {
					JOptionPane.showMessageDialog(null, "B��d przy odejmowaniu ilo�ci produktu "+exc);
				}
				
				//zliczenie i zaokraglenie sumy
				suma += kupiony.getCena();
				suma = funkcje.zaokraglij(suma);
				
				_textFieldSuma.setText(Double.toString(suma));
				
				_kupione.add(kupiony);
	
				ModelTablicyProduktowDodanych model = new ModelTablicyProduktowDodanych(_kupione);
				_tableDodane.setModel(model);
				/////////////////////odswiedzenie tebeli z produkktami
				funkcje.odswiezProdukty(_tableProdukty);
				setVisible(false);
				dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Prosz� poda� poprawn� warto��");
				}
				}
				
				
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, "Prosz� poda� poprawn� warto��");
				}
			}
		});
		btnOk.setBounds(74, 61, 89, 23);
		contentPanel.add(btnOk);
	}
}
