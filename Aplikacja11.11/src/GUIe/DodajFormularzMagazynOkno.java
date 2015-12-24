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
		getContentPane().setBackground(new Color(102, 0, 102));
		setTitle("Dodaj formularz");
		funkcje = new Funkcje();
		masa = 0.0;
		suma = 0.0;
		kupione.removeAll(kupione); //wyczyszczenie listy z poprzedniego formularza
		
		
		//pobranie ladownosci dla najbardziej pojemnego auta w bazie
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
		textFieldCena.setForeground(Color.BLACK);
		textFieldCena.setBackground(new Color(204, 153, 255));
		textFieldCena.setBounds(564, 415, 60, 20);
		getContentPane().add(textFieldCena);
		textFieldCena.setColumns(10);
		textFieldCena.setEditable(false);
		
		setBounds(100, 100, 1100, 560);
		  setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 742, 393);
		getContentPane().add(scrollPane);
		
		tableDodane = new JTable();
		tableDodane.setForeground(Color.BLACK);
		tableDodane.setBackground(new Color(204, 153, 255));
		scrollPane.setViewportView(tableDodane);
		
		JComboBox comboBoxProdukty = new JComboBox();
		comboBoxProdukty.setForeground(Color.BLACK);
		comboBoxProdukty.setBackground(new Color(153, 102, 204));
		comboBoxProdukty.setBounds(773, 55, 244, 20);
		getContentPane().add(comboBoxProdukty);
		funkcje.wypelnijComboboxaProduktami(comboBoxProdukty);
		
		textFieldIle = new JTextField();
		textFieldIle.setForeground(Color.BLACK);
		textFieldIle.setBackground(new Color(204, 153, 255));
		textFieldIle.setBounds(1027, 55, 47, 20);
		getContentPane().add(textFieldIle);
		textFieldIle.setColumns(10);
		
		JComboBox comboBoxMiejsceDocelowe = new JComboBox();
		comboBoxMiejsceDocelowe.setForeground(Color.BLACK);
		comboBoxMiejsceDocelowe.setBackground(new Color(153, 102, 204));
		comboBoxMiejsceDocelowe.setBounds(773, 150, 244, 20);
		getContentPane().add(comboBoxMiejsceDocelowe);
		funkcje.wypelnijComboboxaMiejscamiDocelowymi(comboBoxMiejsceDocelowe);
		
		
		
		JLabel lblWstawProdukty = new JLabel("Wstaw produkty");
		lblWstawProdukty.setForeground(Color.BLACK);
		lblWstawProdukty.setBounds(773, 30, 89, 14);
		getContentPane().add(lblWstawProdukty);
		
		JLabel lblWybierzMiejsce = new JLabel("Wybierz miejsce docelowe");
		lblWybierzMiejsce.setForeground(Color.BLACK);
		lblWybierzMiejsce.setBounds(773, 125, 147, 14);
		getContentPane().add(lblWybierzMiejsce);
		
		JLabel lblWybierzSamochdDostawczy = new JLabel("Wybierz samoch\u00F3d dostawczy");
		lblWybierzSamochdDostawczy.setForeground(Color.BLACK);
		lblWybierzSamochdDostawczy.setBounds(773, 197, 170, 14);
		getContentPane().add(lblWybierzSamochdDostawczy);
		
		JComboBox comboBoxAuta = new JComboBox();
		comboBoxAuta.setForeground(Color.BLACK);
		comboBoxAuta.setBackground(new Color(153, 102, 204));
		comboBoxAuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//ustawianie koloru znacznika dostepnosci auta
				Samochod samochod = (Samochod)comboBoxAuta.getSelectedItem();
				if(samochod.isCzy_jest_na_stanie())
					btnKolorki.setBackground(Color.GREEN);
				else if(!samochod.isCzy_jest_na_stanie()){
					btnKolorki.setBackground(Color.RED);
				}
			}
		});
		comboBoxAuta.setBounds(773, 222, 244, 20);
		getContentPane().add(comboBoxAuta);
		funkcje.wypelnijComboboxaAutami(comboBoxAuta);
		
		JButton btnZrobione = new JButton("Zrobione");
		btnZrobione.setForeground(Color.BLACK);
		btnZrobione.setBackground(new Color(153, 102, 204));
		btnZrobione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sprawdzanie ³adownoœci
				Samochod samochod = (Samochod) comboBoxAuta.getSelectedItem();
				ladownosc_dopuszczalna = samochod.getLadownosc();
				
				Double ladownosc_minimalna = 0.45 * ladownosc_dopuszczalna;
				
				if(masa >= ladownosc_minimalna && masa<=ladownosc_dopuszczalna){
					if(samochod.isCzy_jest_na_stanie()){
					zapiszFormularzMagazyn();
					setVisible(false);
					dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Pojazd niedostêpny z przyczyn nieoczekiwanych.");
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Zbyt ma³o produktów lub przekroczona waga towarów");
				}
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
		btnPowrt.setForeground(Color.BLACK);
		btnPowrt.setBackground(new Color(153, 102, 204));
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnPowrt.setBounds(954, 460, 120, 23);
		getContentPane().add(btnPowrt);
		
		JButton btnUsu = new JButton("Usu\u0144");
		btnUsu.setForeground(Color.BLACK);
		btnUsu.setBackground(new Color(153, 102, 204));
		btnUsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				suma=0.0;
				masa=0.0;
				
				//wybranie produktu do usuniciea
				int row = tableDodane.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz produkt który chcesz usun¹æ z listy");							
					return;
				}
				
				Produkt tempProdukt = (Produkt)tableDodane.getValueAt(row, ModelTablicyProduktow.OBJECT_COL);
				
				
				//wywolanie okna z iloscia do usuniecia
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
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(153, 102, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
				Produkt tempProdukt = (Produkt) comboBoxProdukty.getSelectedItem();
				
				String nazwa = tempProdukt.getNazwa();
				int ilosc = Integer.parseInt(textFieldIle.getText());
				
				//czy ilosc jest sensowna
				if(ilosc >0 && ilosc <= funkcje.ileJestNaMagazynie(tempProdukt))
				{
				textFieldIle.setText("");
				Double cena = ilosc * tempProdukt.getCena();
				Double objetosc = ilosc * tempProdukt.getObjetosc();
				
				Produkt kupiony = new Produkt(nazwa,ilosc,cena,objetosc);
				
				//odjecie roznicy w ilosci
				int roznica = tempProdukt.getIlosc()-ilosc;
				try {
					funkcje.odejmijIlosc(tempProdukt,roznica);
				} catch (SQLException exc) {
					JOptionPane.showMessageDialog(null, "B³¹d przy odejmowaniu iloœci produktu "+exc);
				}
				
				//zlicznie masy
				masa += kupiony.getObjetosc();
				masa = funkcje.zaokraglij(masa);
				textFieldMasa.setText(Double.toString(masa));
				
				//zliczenie sumy
				suma += kupiony.getCena();
				suma = funkcje.zaokraglij(suma);
				textFieldCena.setText(Double.toString(suma));
	
				kupione.add(kupiony);
	
				ModelTablicyProduktowDodanych model = new ModelTablicyProduktowDodanych(kupione);
				tableDodane.setModel(model);
				
				//sprawdzanie czy nie przekroczono max ladownosci najwiekszego auta
				if(ladownosc_najwiekszego_auta < masa){
					//JOptionPane.showMessageDialog(null, ladownosc_najwiekszego_auta);
					JOptionPane.showMessageDialog(null, "Przekroczono maksymaln¹ dopuszczaln¹ ³adownoœæ dla jednego transportu. Proszê zmniejszyæ iloœæ produktów");	
					btnZrobione.setEnabled(false);
				}
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Proszê podaæ poprawn¹ iloœæ");
				}
				
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, "Proszê podaæ poprawn¹ iloœæ");
				}
				
				
			}
		});
		btnNewButton.setBounds(1001, 86, 73, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblSuma = new JLabel("Suma");
		lblSuma.setForeground(Color.BLACK);
		lblSuma.setBounds(529, 418, 46, 14);
		getContentPane().add(lblSuma);
		
		textFieldMasa = new JTextField();
		textFieldMasa.setForeground(Color.BLACK);
		textFieldMasa.setBackground(new Color(204, 153, 255));
		textFieldMasa.setBounds(689, 415, 63, 20);
		getContentPane().add(textFieldMasa);
		textFieldMasa.setColumns(10);
		
		JLabel lblMasa = new JLabel("Masa");
		lblMasa.setForeground(Color.BLACK);
		lblMasa.setBounds(653, 418, 33, 14);
		getContentPane().add(lblMasa);
		
		

	}
}
