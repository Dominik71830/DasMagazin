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


public class DodajFormularzDetalOkno extends JDialog {
	static Funkcje funkcje;
	private static JTable tableDodane;
	private static JTable tableProdukty;
	
	static List<Produkt> produkty = null;
	static List<Produkt> kupione  = new ArrayList<Produkt>();
	
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(506, 26, 283, 292);
		getContentPane().add(scrollPane);
		
		tableProdukty = new JTable();
		scrollPane.setViewportView(tableProdukty);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(191, 26, 283, 292);
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
		
		JLabel lblDodajProduktZ = new JLabel("Dodaj produkt z listy");
		lblDodajProduktZ.setBounds(25, 26, 135, 14);
		getContentPane().add(lblDodajProduktZ);
		
		JButton btnDodaj = new JButton("Dodaj produkt");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int row = tableProdukty.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz produkt z listy po prawej");				
					return;
				}
				
				Produkt temp = (Produkt)tableProdukty.getValueAt(row, ModelTablicyProduktow.OBJECT_COL);
				
				IloscOkienko okno = new IloscOkienko(temp,kupione,tableDodane);
				okno.setVisible(true);
			}
		});
		btnDodaj.setBounds(428, 329, 117, 23);
		getContentPane().add(btnDodaj);
		
		JButton btnZrobione = new JButton("Zrobione");
		btnZrobione.setBounds(52, 329, 89, 23);
		getContentPane().add(btnZrobione);
	}
}
