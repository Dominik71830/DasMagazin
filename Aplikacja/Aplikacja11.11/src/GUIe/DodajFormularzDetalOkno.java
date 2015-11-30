package GUIe;

import java.awt.EventQueue;
import pakiet.*;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;


public class DodajFormularzDetalOkno extends JDialog {
	static Funkcje funkcje;
	private static JTable tableDodane;
	private static JTable tableProdukty;
	
	static Double suma;
	
	static List<Produkt> produkty = null;
	static List<Produkt> kupione  = new ArrayList<Produkt>();
	private JTextField textFieldImie;
	private JTextField textFieldNazwisko;
	private JTextField textFieldSuma;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					funkcje = new Funkcje();
					DodajFormularzDetalOkno dialog = new DodajFormularzDetalOkno();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
					
					
					produkty = funkcje.getAllProdukty();
					
					
					ModelTablicyProduktow model = new ModelTablicyProduktow(produkty);
					
					tableProdukty.setModel(model);
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DodajFormularzDetalOkno() {
		setTitle("Dodaj formularz");
		setBounds(100, 100, 840, 420);
		getContentPane().setLayout(null);
		
		textFieldSuma = new JTextField();
		textFieldSuma.setEditable(false);
		textFieldSuma.setBounds(415, 298, 59, 20);
		getContentPane().add(textFieldSuma);
		textFieldSuma.setColumns(10);
		textFieldSuma.setText("0.0");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(506, 26, 283, 292);
		getContentPane().add(scrollPane);
		
		tableProdukty = new JTable();
		scrollPane.setViewportView(tableProdukty);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(191, 26, 283, 267);
		getContentPane().add(scrollPane_1);
		
		tableDodane = new JTable();
		scrollPane_1.setViewportView(tableDodane);
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnPowrt.setBounds(700, 329, 89, 23);
		getContentPane().add(btnPowrt);
		
		JButton btnDodaj = new JButton("Dodaj produkt");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				suma = 0.0;
				int row = tableProdukty.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz produkt z listy po prawej");				
					return;
				}
				
				Produkt temp = (Produkt)tableProdukty.getValueAt(row, ModelTablicyProduktow.OBJECT_COL);
				
				IloscOkienko okno = new IloscOkienko(temp,kupione,tableDodane,textFieldSuma);
				okno.setVisible(true);
			}
		});
		btnDodaj.setBounds(428, 329, 117, 23);
		getContentPane().add(btnDodaj);
		
		JButton btnZrobione = new JButton("Zrobione");
		btnZrobione.setBounds(52, 329, 89, 23);
		getContentPane().add(btnZrobione);
		
		JLabel lblImieKlienta = new JLabel("Imie");
		lblImieKlienta.setBounds(10, 69, 50, 14);
		getContentPane().add(lblImieKlienta);
		
		textFieldImie = new JTextField();
		textFieldImie.setBounds(64, 66, 117, 20);
		getContentPane().add(textFieldImie);
		textFieldImie.setColumns(10);
		
		JLabel lblNazwiskoKlienta = new JLabel("Nazwisko");
		lblNazwiskoKlienta.setBounds(10, 94, 50, 14);
		getContentPane().add(lblNazwiskoKlienta);
		
		textFieldNazwisko = new JTextField();
		textFieldNazwisko.setBounds(64, 91, 117, 20);
		getContentPane().add(textFieldNazwisko);
		textFieldNazwisko.setColumns(10);
		
		
		
		JLabel lblSuma = new JLabel("Suma");
		lblSuma.setBounds(370, 304, 35, 14);
		getContentPane().add(lblSuma);
		
		JLabel lblDaneKlienta = new JLabel("Dane Klienta");
		lblDaneKlienta.setBounds(10, 41, 79, 14);
		getContentPane().add(lblDaneKlienta);
	}
}
