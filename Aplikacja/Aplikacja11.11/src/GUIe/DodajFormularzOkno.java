package GUIe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DodajFormularzOkno extends JDialog {
	public DodajFormularzOkno() {
		setTitle("Dodaj formularz");
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(549, 26, 283, 292);
		getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(256, 26, 283, 292);
		getContentPane().add(scrollPane_1);
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		btnPowrt.setBounds(743, 344, 89, 23);
		getContentPane().add(btnPowrt);
		
		JLabel lblDodajProduktZ = new JLabel("Dodaj produkt z listy");
		lblDodajProduktZ.setBounds(10, 26, 135, 14);
		getContentPane().add(lblDodajProduktZ);
	}
}
