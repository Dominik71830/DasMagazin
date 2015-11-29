package GUIe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

import pakiet.*;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import java.awt.Color;

public class MagazynOkno extends JDialog {
	private JTextField textFieldWyszukiwarka;
	private JTextField textFieldNazwa;
	private JTextField textFieldIlosc;
	private JTextField textFieldCena;
	private JTextField textFieldObjetosc;
	
	private static Funkcje funkcje;
	private JTable table;
	
	private boolean updatemode = false;
	private Produkt poprzedniprodukt = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MagazynOkno dialog = new MagazynOkno();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public MagazynOkno() {
		
		try
		{
		funkcje= new Funkcje();
		}
		catch(Exception exc)
		{
			JOptionPane.showMessageDialog(null,"B³¹d przy inicjalizacji okna " + exc);
		}
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(291, 62, 358, 267);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		setBounds(100, 100, 684, 417);
		getContentPane().setLayout(null);
		
		Double[] VatStrings = {0.05,0.08,0.23};
		JComboBox comboBoxVat = new JComboBox(VatStrings);
		comboBoxVat.setEnabled(false);
		comboBoxVat.setBounds(78, 136, 72, 20);
		getContentPane().add(comboBoxVat);
		
		JLabel JLabelKategoria = new JLabel("Kategoria:");
		JLabelKategoria.setBounds(10, 164, 58, 14);
		getContentPane().add(JLabelKategoria);
		
		String[] KategorieStrings = {"spo¿ywcze","meble","przemys³owe","elektroniczne"};
		JComboBox comboBoxKategoria = new JComboBox(KategorieStrings);
		comboBoxKategoria.setEnabled(false);
		comboBoxKategoria.setBounds(78, 161, 72, 20);
		getContentPane().add(comboBoxKategoria);
		
		JLabel JLabelNazwa = new JLabel("Nazwa:");
		JLabelNazwa.setBounds(10, 11, 58, 25);
		getContentPane().add(JLabelNazwa);
		
		textFieldWyszukiwarka = new JTextField();
		textFieldWyszukiwarka.setBounds(78, 11, 336, 25);
		getContentPane().add(textFieldWyszukiwarka);
		textFieldWyszukiwarka.setColumns(10);
		
		JButton ButtonOpcjeZaaw = new JButton("Opcje zaaw.");
		ButtonOpcjeZaaw.setBounds(550, 11, 101, 25);
		getContentPane().add(ButtonOpcjeZaaw);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!updatemode){
				zapiszProdukt();
				}
				else if(updatemode){
					try {
						edytujProdukt();
					} catch (SQLException exc) {
						JOptionPane.showMessageDialog(null,"Blad przy edytowaniu " + exc);
					} 
				}
				//JOptionPane.showMessageDialog(null, "A teraz je wy³¹cze");
				dezaktywujPola();
			}

			private void edytujProdukt() throws SQLException {
				
				int row = table.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz produkt");				
					return;
				}
				
				poprzedniprodukt = (Produkt) table.getValueAt(row, ModelTablicyProduktow.OBJECT_COL);
				
				
				String nazwa = textFieldNazwa.getText();
				Double cena = Double.parseDouble(textFieldCena.getText());
				int ilosc = Integer.parseInt(textFieldIlosc.getText());
				String kategoria = comboBoxKategoria.getSelectedItem().toString();
				Double vat = Double.parseDouble(comboBoxVat.getSelectedItem().toString());
				Double objetosc = Double.parseDouble(textFieldObjetosc.getText());
				
				Produkt tempprodukt = poprzedniprodukt;
						
				tempprodukt.setNazwa(nazwa);;
				tempprodukt.setCena(cena);
				tempprodukt.setIlosc(ilosc);
				tempprodukt.setKategoria(kategoria);
				tempprodukt.setVat(vat);
				tempprodukt.setObjetosc(objetosc);
				
				try {
					
					funkcje.updateProdukt(tempprodukt);
				
					funkcje.odswiezProdukty(table);
					JOptionPane.showMessageDialog(null,"Produkt zaktualizowany");
					}
				 catch (Exception exc) {
					JOptionPane.showMessageDialog(null,"Blad przy edytowaniu " + exc);
				}
				
			}

			private void dezaktywujPola() {
				textFieldNazwa.setText("");
				textFieldIlosc.setText("");
				textFieldCena.setText("");
				textFieldObjetosc.setText("");
				
				textFieldNazwa.setEditable(false);
				textFieldIlosc.setEditable(false);
				textFieldCena.setEditable(false);
				textFieldObjetosc.setEditable(false);
				
				comboBoxKategoria.setEnabled(false);
				comboBoxVat.setEnabled(false);
				
				btnOk.setEnabled(false);
				
			}

			private void zapiszProdukt() {
				String nazwa = textFieldNazwa.getText();
				Double cena = Double.parseDouble(textFieldCena.getText());
				int ilosc = Integer.parseInt(textFieldIlosc.getText());
				String kategoria = comboBoxKategoria.getSelectedItem().toString();
				Double vat = Double.parseDouble(comboBoxVat.getSelectedItem().toString());
				Double objetosc = Double.parseDouble(textFieldObjetosc.getText());
				
				Produkt tempprodukt = null;
				
				
				tempprodukt = new Produkt(nazwa, ilosc, vat, cena, kategoria, objetosc);
			
				
				try {
					
					funkcje.addProdukt(tempprodukt);
				
					funkcje.odswiezProdukty(table);
					
				
						JOptionPane.showMessageDialog(null,"Produkt dodany");
					}
				 catch (Exception exc) {
					JOptionPane.showMessageDialog(null,"Blad przy zapisywaniu " + exc);
				}
				
			}

			
		});
		btnOk.setEnabled(false);
		btnOk.setBackground(Color.RED);
		btnOk.setBounds(31, 223, 91, 23);
		getContentPane().add(btnOk);
		
		JButton ButtonSzukaj = new JButton("Szukaj");
		ButtonSzukaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nazwa = textFieldWyszukiwarka.getText();
				
				try{
					List<Produkt> produkty = null;
					
					if (nazwa != null && nazwa.trim().length() > 0) { 
						produkty = funkcje.searchProdukt(nazwa);
					} else {
						produkty = funkcje.getAllProdukty();
					}
					
					ModelTablicyProduktow model = new ModelTablicyProduktow(produkty);
					
					table.setModel(model);
					}
					catch(Exception exc) {
						JOptionPane.showMessageDialog(null,exc); 
						
				}
			}
		});
		ButtonSzukaj.setBounds(424, 11, 116, 25);
		getContentPane().add(ButtonSzukaj);
		
		
		
		JButton ButtonPowrot = new JButton("Powr\u00F3t");
		ButtonPowrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		ButtonPowrot.setBounds(544, 342, 107, 23);
		getContentPane().add(ButtonPowrot);
		
		JLabel JLabelNazwaDodaj = new JLabel("Nazwa:");
		JLabelNazwaDodaj.setBounds(10, 62, 46, 17);
		getContentPane().add(JLabelNazwaDodaj);
		
		textFieldNazwa = new JTextField();
		textFieldNazwa.setEditable(false);
		textFieldNazwa.setBounds(78, 60, 174, 20);
		getContentPane().add(textFieldNazwa);
		textFieldNazwa.setColumns(10);
		
		JLabel JLabelIlosc = new JLabel("Ilo\u015B\u0107: ");
		JLabelIlosc.setBounds(10, 90, 46, 14);
		getContentPane().add(JLabelIlosc);
		
		textFieldIlosc = new JTextField();
		textFieldIlosc.setEditable(false);
		textFieldIlosc.setBounds(78, 87, 174, 20);
		getContentPane().add(textFieldIlosc);
		textFieldIlosc.setColumns(10);
		
		JLabel JLabelCena = new JLabel("Cena:");
		JLabelCena.setBounds(10, 115, 46, 14);
		getContentPane().add(JLabelCena);
		
		textFieldCena = new JTextField();
		textFieldCena.setEditable(false);
		textFieldCena.setBounds(78, 112, 174, 20);
		getContentPane().add(textFieldCena);
		textFieldCena.setColumns(10);
		
		JLabel JLabelVat = new JLabel("Vat:");
		JLabelVat.setBounds(10, 139, 46, 14);
		getContentPane().add(JLabelVat);
		
		
		
		JLabel JLabelObjetosc = new JLabel("Obj\u0119to\u015B\u0107:");
		JLabelObjetosc.setBounds(10, 189, 52, 17);
		getContentPane().add(JLabelObjetosc);
		
		textFieldObjetosc = new JTextField();
		textFieldObjetosc.setEditable(false);
		textFieldObjetosc.setBounds(78, 186, 174, 20);
		getContentPane().add(textFieldObjetosc);
		textFieldObjetosc.setColumns(10);
		
		JButton ButtonDodajProdukt = new JButton("Dodaj produkt");
		ButtonDodajProdukt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aktywujPola();
				updatemode=false;
				//JOptionPane.showMessageDialog(null, "W³¹czy³em okna");	
			}
			
			private void aktywujPola() {
				
				textFieldNazwa.setEditable(true);
				textFieldIlosc.setEditable(true);
				textFieldCena.setEditable(true);
				textFieldObjetosc.setEditable(true);
				
				comboBoxKategoria.setEnabled(true);
				comboBoxVat.setEnabled(true);
				
				btnOk.setEnabled(true);
			}
			
			
			
		});
		ButtonDodajProdukt.setBounds(10, 342, 107, 23);
		getContentPane().add(ButtonDodajProdukt);
		
		JButton ButtonZmien = new JButton("Zmie\u0144");
		ButtonZmien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz produkt");				
					return;
				}
				
				Produkt tempprodukt = (Produkt) table.getValueAt(row, ModelTablicyProduktow.OBJECT_COL);
				
				
				aktywujPola();
				updatemode=true;
				wypelnijOkno(tempprodukt);
				
				
			}

			private void aktywujPola() {
				
				textFieldNazwa.setEditable(true);
				textFieldIlosc.setEditable(true);
				textFieldCena.setEditable(true);
				textFieldObjetosc.setEditable(true);
				
				comboBoxKategoria.setEnabled(true);
				comboBoxVat.setEnabled(true);
				
				btnOk.setEnabled(true);
			}



			private void wypelnijOkno(Produkt _tempprodukt) {
				textFieldNazwa.setText(_tempprodukt.getNazwa());
				textFieldIlosc.setText(Integer.toString(_tempprodukt.getIlosc()));
				textFieldCena.setText(Double.toString(_tempprodukt.getCena()));
				textFieldObjetosc.setText(Double.toString(_tempprodukt.getObjetosc()));
				////////////////////////////
				switch(Double.toString(_tempprodukt.getVat())){
				case "0.05":
					comboBoxVat.setSelectedIndex(0);
					break;
				case "0.08":
					comboBoxVat.setSelectedIndex(1);
					break;
				case "0.23":
					comboBoxVat.setSelectedIndex(2);
					break;
				}
				////////////////////////////
				switch(_tempprodukt.getKategoria()){
				case "spo¿ywcze":
					comboBoxKategoria.setSelectedIndex(0);
					break;
				case "meble":
					comboBoxKategoria.setSelectedIndex(1);
					break;
				case "przemys³owe":
					comboBoxKategoria.setSelectedIndex(2);
					break;
				case "elektroniczne":
					comboBoxKategoria.setSelectedIndex(3);
					break;
				}
				 
			}
			
		});
		ButtonZmien.setBounds(127, 342, 107, 23);
		getContentPane().add(ButtonZmien);
		
		JButton ButtonHistoriaZmian = new JButton("Historia zmian");
		ButtonHistoriaZmian.setBounds(244, 342, 107, 23);
		getContentPane().add(ButtonHistoriaZmian);
	
		
		JButton buttonUsun = new JButton("Usu\u0144 produkt");
		buttonUsun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int row = table.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz produkt");				
					return;
				}
				
				Produkt tempprodukt = (Produkt) table.getValueAt(row, ModelTablicyProduktow.OBJECT_COL);
				
				ZatwierdzenieOUsuwaniuOkienko zat = new ZatwierdzenieOUsuwaniuOkienko(tempprodukt,table);
				zat.setVisible(true);
			}
		});
		buttonUsun.setBounds(361, 342, 107, 23);
		getContentPane().add(buttonUsun);
		
		
		
		
		

	}
}
