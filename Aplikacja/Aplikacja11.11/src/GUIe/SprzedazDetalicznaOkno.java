package GUIe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pakiet.FormularzDetal;
import pakiet.Funkcje;
import pakiet.ModelTablicyFormularzyDetal;
import pakiet.ModelTablicyProduktow;
import pakiet.Produkt;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class SprzedazDetalicznaOkno extends JDialog {
	private static JTable tableformularz;
	
	static Funkcje funkcje;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					funkcje = new Funkcje();
					SprzedazDetalicznaOkno dialog = new SprzedazDetalicznaOkno();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
					List<FormularzDetal> formularzeDetal = null;
					
					formularzeDetal = funkcje.getAllFormularzeDetal();
					
					
					
					ModelTablicyFormularzyDetal model = new ModelTablicyFormularzyDetal(formularzeDetal);
					
					tableformularz.setModel(model);
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public SprzedazDetalicznaOkno() {
		setTitle("Sprzeda\u017C detaliczna");
		setBounds(100, 100, 603, 411);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneFormularz = new JScrollPane();
		scrollPaneFormularz.setBounds(201, 21, 376, 301);
		getContentPane().add(scrollPaneFormularz);
		
		tableformularz = new JTable();
		scrollPaneFormularz.setViewportView(tableformularz);
		
		JButton btnWywietlFormularz = new JButton("Wy\u015Bwietl formularz");
		btnWywietlFormularz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnWywietlFormularz.setBounds(33, 21, 147, 23);
		getContentPane().add(btnWywietlFormularz);
		
		JButton btnDodajFormularz = new JButton("Dodaj formularz");
		btnDodajFormularz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DodajFormularzDetalOkno okno = new DodajFormularzDetalOkno();
				okno.setVisible(true);
			}
		});
		btnDodajFormularz.setBounds(33, 55, 147, 23);
		getContentPane().add(btnDodajFormularz);
		
		JButton btnUsunFormularz = new JButton("Usu\u0144 formularz");
		btnUsunFormularz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int row = tableformularz.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz formularz");				
					return;
				}
				
				FormularzDetal tempformularz = (FormularzDetal)tableformularz.getValueAt(row, ModelTablicyFormularzyDetal.OBJECT_COL);
				
				ZatwierdzenieOUsuwaniuOkienko zat = new ZatwierdzenieOUsuwaniuOkienko(null,tempformularz,tableformularz,2);
				zat.setVisible(true);
			}
		});
		btnUsunFormularz.setBounds(33, 89, 147, 23);
		getContentPane().add(btnUsunFormularz);
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnPowrt.setBounds(488, 339, 89, 23);
		getContentPane().add(btnPowrt);

	}
}
