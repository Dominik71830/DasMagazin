package GUIe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class SprzedazMagazynowaOkno extends JDialog {
	private JTable tableProdukty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SprzedazMagazynowaOkno dialog = new SprzedazMagazynowaOkno();
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
	public SprzedazMagazynowaOkno() {
		setBounds(100, 100, 580, 362);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneProdukty = new JScrollPane();
		scrollPaneProdukty.setBounds(93, 21, 373, 251);
		getContentPane().add(scrollPaneProdukty);
		
		tableProdukty = new JTable();
		scrollPaneProdukty.setViewportView(tableProdukty);
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		btnPowrt.setBounds(465, 287, 89, 23);
		getContentPane().add(btnPowrt);
		
		JButton btnWywietlFormularz = new JButton("Wy\u015Bwietl formularz");
		btnWywietlFormularz.setBounds(10, 287, 130, 23);
		getContentPane().add(btnWywietlFormularz);
		
		JButton btnDodajFormularz = new JButton("Dodaj formularz");
		btnDodajFormularz.setBounds(152, 287, 130, 23);
		getContentPane().add(btnDodajFormularz);
		
		JButton btnUsuFormularz = new JButton("Usu\u0144 formularz");
		btnUsuFormularz.setBounds(292, 287, 130, 23);
		getContentPane().add(btnUsuFormularz);

	}
}
