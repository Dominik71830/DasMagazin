package GUIe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import pakiet.FormularzDetal;
import pakiet.FormularzWysylka;
import pakiet.Funkcje;
import pakiet.ModelTablicyFormularzyDetal;
import pakiet.ModelTablicyFormularzyWysylkowych;
import pakiet.Produkt;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class SprzedazMagazynowaOkno extends JDialog {
	Funkcje funkcje;
	private JTable table;
	List<Produkt> listaProduktow;

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
	 * @throws Exception 
	 */
	public SprzedazMagazynowaOkno() throws Exception {
		setTitle("Dystrybucja");
		listaProduktow = new ArrayList<Produkt>();
		funkcje = new Funkcje();
		setBounds(100, 100, 580, 362);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneFormularze = new JScrollPane();
		scrollPaneFormularze.setBounds(93, 21, 373, 251);
		getContentPane().add(scrollPaneFormularze);
		
		table = new JTable();
		scrollPaneFormularze.setViewportView(table);
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnPowrt.setBounds(465, 287, 89, 23);
		getContentPane().add(btnPowrt);
		
		JButton btnWywietlFormularz = new JButton("Wy\u015Bwietl formularz");
		btnWywietlFormularz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz formularz");				
					return;
				}
				
				FormularzWysylka tempformularz = (FormularzWysylka)table.getValueAt(row, ModelTablicyFormularzyWysylkowych.OBJECT_COL);
				
				WyswietlanieFormularzyOkno okno;
				
				try {
					okno = new WyswietlanieFormularzyOkno(null,tempformularz);
					okno.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnWywietlFormularz.setBounds(10, 287, 130, 23);
		getContentPane().add(btnWywietlFormularz);
		
		JButton btnDodajFormularz = new JButton("Dodaj formularz");
		btnDodajFormularz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodajFormularzMagazynOkno okno;
				try {
					okno = new DodajFormularzMagazynOkno(listaProduktow,table);
					okno.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnDodajFormularz.setBounds(152, 287, 130, 23);
		getContentPane().add(btnDodajFormularz);
		
		JButton btnUsuFormularz = new JButton("Usu\u0144 formularz");
		btnUsuFormularz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz formularz");				
					return;
				}
				
				FormularzWysylka tempformularz = (FormularzWysylka)table.getValueAt(row, ModelTablicyFormularzyWysylkowych.OBJECT_COL);
				
				ZatwierdzenieOUsuwaniuOkienko zat = new ZatwierdzenieOUsuwaniuOkienko(null,null,tempformularz,table,3);
				zat.setVisible(true);
			}
		});
		btnUsuFormularz.setBounds(292, 287, 130, 23);
		getContentPane().add(btnUsuFormularz);
		
		List<FormularzWysylka> formularze = null;
		
		formularze = funkcje.getAllFormularzeWysylkowe();
		
		
		ModelTablicyFormularzyWysylkowych model = new ModelTablicyFormularzyWysylkowych(formularze);
		
		table.setModel(model);
	}
}
