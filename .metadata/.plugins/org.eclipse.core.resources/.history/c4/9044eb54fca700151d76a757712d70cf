package GUIe;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import pakiet.FormularzDetal;
import pakiet.FormularzWysylka;
import pakiet.Funkcje;
import pakiet.MiejsceDocelowe;
import pakiet.ModelTablicyProduktow;
import pakiet.ModelTablicyProduktowDodanych;
import pakiet.Produkt;
import pakiet.Samochod;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class DodajFormularzMagazynOkno extends JDialog {
	private JTable tableDodane;
	private JTextField textFieldIle;
	Funkcje funkcje;
	Double masa;
	Double suma;
	Double ladownosc_dopuszczalna;
	Double ladownosc_najwiekszego_auta;
	private JTextField textFieldCena;
	private JTextField textFieldMasa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajFormularzMagazynOkno dialog = new DodajFormularzMagazynOkno(null,null);
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
	 * @param table 
	 * @param listaProduktow 
	 * @throws Exception 
	 */
	public DodajFormularzMagazynOkno(List<Produkt> kupione, JTable table) throws Exception {
		setTitle("Dodaj formularz");
		funkcje = new Funkcje();
		masa = 0.0;
		suma = 0.0;
		
		try {
			ladownosc_najwiekszego_auta = funkcje.getNajwiekszaLadownosc();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnKolorki = new JButton("");
		btnKolorki.setBounds(1039, 222, 20, 20);
		getContentPane().add(btnKolorki);
		btnKolorki.setEnabled(false);
		
		textFieldCena = new JTextField();
		textFieldCena.setBounds(608, 415, 47, 20);
		getContentPane().add(textFieldCena);
		textFieldCena.setColumns(10);
		textFieldCena.setEditable(false);
		
		setBounds(100, 100, 1100, 560);
		  setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 795, 393);
		getContentPane().add(scrollPane);
		
		tableDodane = new JTable();
		scrollPane.setViewportView(tableDodane);
		
		JComboBox comboBoxProdukty = new JComboBox();
		comboBoxProdukty.setBounds(848, 55, 169, 20);
		getContentPane().add(comboBoxProdukty);
		funkcje.wypelnijComboboxaProduktami(comboBoxProdukty);
		
		textFieldIle = new JTextField();
		textFieldIle.setBounds(1027, 55, 47, 20);
		getContentPane().add(textFieldIle);
		textFieldIle.setColumns(10);
		
		JComboBox comboBoxMiejsceDocelowe = new JComboBox();
		comboBoxMiejsceDocelowe.setBounds(848, 150, 169, 20);
		getContentPane().add(comboBoxMiejsceDocelowe);
		funkcje.wypelnijComboboxaMiejscamiDocelowymi(comboBoxMiejsceDocelowe);
		
		
		
		JLabel lblWstawProdukty = new JLabel("Wstaw produkty");
		lblWstawProdukty.setBounds(847, 30, 89, 14);
		getContentPane().add(lblWstawProdukty);
		
		JLabel lblWybierzMiejsce = new JLabel("Wybierz miejsce docelowe");
		lblWybierzMiejsce.setBounds(848, 125, 147, 14);
		getContentPane().add(lblWybierzMiejsce);
		
		JLabel lblWybierzSamochdDostawczy = new JLabel("Wybierz samoch\u00F3d dostawczy");
		lblWybierzSamochdDostawczy.setBounds(847, 200, 170, 14);
		getContentPane().add(lblWybierzSamochdDostawczy);
		
		JComboBox comboBoxAuta = new JComboBox();
		comboBoxAuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Samochod samochod = (Samochod)comboBoxAuta.getSelectedItem();
				if(samochod.isCzy_jest_na_stanie())
					btnKolorki.setBackground(Color.GREEN);
				else if(!samochod.isCzy_jest_na_stanie()){
					btnKolorki.setBackground(Color.RED);
				}
			}
		});
		comboBoxAuta.setBounds(848, 222, 170, 20);
		getContentPane().add(comboBoxAuta);
		funkcje.wypelnijComboboxaAutami(comboBoxAuta);
		
		JButton btnZrobione = new JButton("Zrobione");
		btnZrobione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sprawdzanie ³adownoœci
				Samochod samochod = (Samochod) comboBoxAuta.getSelectedItem();
				ladownosc_dopuszczalna = samochod.getLadownosc();
				
				Double ladownosc_minimalna = 0.45 * ladownosc_dopuszczalna;
				
				//if(masa >= ladownosc_minimalna){
					if(samochod.isCzy_jest_na_stanie()){
					zapiszFormularzMagazyn();
					setVisible(false);
					dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Pojazd niedostêpny z przyczyn nieoczekiwanych.");
					}
			//	}
				//else{
				//	JOptionPane.showMessageDialog(null,"Zbyt ma³o produktów. Proszê wybraæ auto o mniejszej ³adownoœci.");
				//}
			}

			private void zapiszFormularzMagazyn() {
				MiejsceDocelowe miejscedocelowe = (MiejsceDocelowe) comboBoxMiejsceDocelowe.getSelectedItem();
				Samochod samochod = (Samochod) comboBoxAuta.getSelectedItem();
				
				String adres = miejscedocelowe.getAdres();
				String produkty = funkcje.wypiszListe(kupione);
				String modelsamochodu = samochod.getModel();
				Double cena = Double.parseDouble(textFieldCena.getText());
			
				
				FormularzWysylka tempformularz = null;
				
				
				tempformularz = new FormularzWysylka(adres,produkty,modelsamochodu,cena);
			
				
				try {
					
					funkcje.addFormularzWysylka(tempformularz);
					
				
						JOptionPane.showMessageDialog(null,"Formularz dodany");
					}
				 catch (Exception exc) {
					JOptionPane.showMessageDialog(null,"Blad przy zapisywaniu formularza wysy³kowego " + exc);
				}
				////////// odswiezanie tabeli formularzy
				funkcje.odswiezFormularzewysylkowe(table);
				
			}
		});
		btnZrobione.setBounds(685, 460, 120, 23);
		getContentPane().add(btnZrobione);
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnPowrt.setBounds(954, 460, 120, 23);
		getContentPane().add(btnPowrt);
		
		JButton btnUsu = new JButton("Usu\u0144");
		btnUsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				suma=0.0;
				masa=0.0;
				int row = tableDodane.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz produkt który chcesz usun¹æ z listy");							
					return;
				}
				
				Produkt tempProdukt = (Produkt)tableDodane.getValueAt(row, ModelTablicyProduktow.OBJECT_COL);
				
				UsunZKoszykaOkienko_Wysylka okno = null;
				try {
					okno = new UsunZKoszykaOkienko_Wysylka(row, tempProdukt,kupione,tableDodane,textFieldCena, textFieldMasa);
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null,"B³¹d przy usuwaniu produktu z koszyka" + exc);
				}
				
				
				okno.setVisible(true);
			}
		});
		btnUsu.setBounds(816, 460, 120, 23);
		getContentPane().add(btnUsu);
		
		JButton btnNewButton = new JButton("Wstaw");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Produkt tempProdukt = (Produkt) comboBoxProdukty.getSelectedItem();
				
				String nazwa = tempProdukt.getNazwa();
				int ilosc = Integer.parseInt(textFieldIle.getText());
				textFieldIle.setText("");
				Double cena = ilosc * tempProdukt.getCena();
				Double objetosc = ilosc * tempProdukt.getObjetosc();
				
				Produkt kupiony = new Produkt(nazwa,ilosc,cena,objetosc);
				
				int roznica = tempProdukt.getIlosc()-ilosc;
				try {
					funkcje.odejmijIlosc(tempProdukt,roznica);
				} catch (SQLException exc) {
					JOptionPane.showMessageDialog(null, "B³¹d przy odejmowaniu iloœci produktu "+exc);
				}
				
				masa += kupiony.getObjetosc();
				masa = funkcje.zaokraglij(masa);
				textFieldMasa.setText(Double.toString(masa));
				
				suma += kupiony.getCena();
				suma = funkcje.zaokraglij(suma);
				textFieldCena.setText(Double.toString(suma));
	
				kupione.add(kupiony);
	
				ModelTablicyProduktowDodanych model = new ModelTablicyProduktowDodanych(kupione);
				tableDodane.setModel(model);
				
				if(ladownosc_najwiekszego_auta < masa){
					JOptionPane.showMessageDialog(null, "Przekroczono maksymaln¹ dopuszczaln¹ ³adownoœæ dla jednego transportu. Proszê zmniejszyæ iloœæ produktów");	
					btnZrobione.setEnabled(false);
				}
						
				
				// tutaj trzeba odswiezyæ comboboxa z produktami
				
			}
		});
		btnNewButton.setBounds(1001, 86, 73, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblSuma = new JLabel("Suma");
		lblSuma.setBounds(567, 418, 46, 14);
		getContentPane().add(lblSuma);
		
		textFieldMasa = new JTextField();
		textFieldMasa.setBounds(758, 415, 47, 20);
		getContentPane().add(textFieldMasa);
		textFieldMasa.setColumns(10);
		
		JLabel lblMasa = new JLabel("Masa");
		lblMasa.setBounds(715, 418, 33, 14);
		getContentPane().add(lblMasa);
		
		

	}
}
