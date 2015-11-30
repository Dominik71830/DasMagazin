package GUIe;

import java.awt.EventQueue;
import pakiet.*;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;


public class DodajFormularzDetalOkno extends JDialog {
	static Funkcje funkcje;
	private static JTable tableDodane;
	private static JTable tableProdukty;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					funkcje = new Funkcje();
					DodajFormularzDetalOkno dialog = new DodajFormularzDetalOkno();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
					List<Produkt> produkty = null;
					
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
	}
}
