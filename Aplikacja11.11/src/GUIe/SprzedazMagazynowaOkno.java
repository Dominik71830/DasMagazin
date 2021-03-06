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
import java.awt.Color;

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
		getContentPane().setBackground(new Color(102, 0, 102));
		setTitle("Dystrybucja");
		listaProduktow = new ArrayList<Produkt>();
		funkcje = new Funkcje();
		setBounds(100, 100, 780, 520);
		  setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneFormularze = new JScrollPane();
		scrollPaneFormularze.setBounds(47, 21, 618, 400);
		getContentPane().add(scrollPaneFormularze);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setBackground(new Color(204, 153, 255));
		scrollPaneFormularze.setViewportView(table);
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		btnPowrt.setForeground(Color.BLACK);
		btnPowrt.setBackground(new Color(153, 102, 204));
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnPowrt.setBounds(665, 448, 89, 23);
		getContentPane().add(btnPowrt);
		
		JButton btnWywietlFormularz = new JButton("Wy\u015Bwietl formularz");
		btnWywietlFormularz.setForeground(Color.BLACK);
		btnWywietlFormularz.setBackground(new Color(153, 102, 204));
		btnWywietlFormularz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//wybranie formularza z tabeli
				int row = table.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz formularz");				
					return;
				}
				
				FormularzWysylka tempformularz = (FormularzWysylka)table.getValueAt(row, ModelTablicyFormularzyWysylkowych.OBJECT_COL);
				
				
				//wywolanie okna do wyswietlenia foremularza
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
		btnWywietlFormularz.setBounds(10, 448, 130, 23);
		getContentPane().add(btnWywietlFormularz);
		
		JButton btnDodajFormularz = new JButton("Dodaj formularz");
		btnDodajFormularz.setForeground(Color.BLACK);
		btnDodajFormularz.setBackground(new Color(153, 102, 204));
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
		btnDodajFormularz.setBounds(150, 448, 130, 23);
		getContentPane().add(btnDodajFormularz);
		
		JButton btnUsuFormularz = new JButton("Usu\u0144 formularz");
		btnUsuFormularz.setForeground(Color.BLACK);
		btnUsuFormularz.setBackground(new Color(153, 102, 204));
		btnUsuFormularz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//wybranie formularza z tabeli
				int row = table.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz formularz");				
					return;
				}
				
				FormularzWysylka tempformularz = (FormularzWysylka)table.getValueAt(row, ModelTablicyFormularzyWysylkowych.OBJECT_COL);
				
				//wywolanie okna do usuwania
				ZatwierdzenieOUsuwaniuOkienko zat = new ZatwierdzenieOUsuwaniuOkienko(null,null,tempformularz,table,3);
				zat.setVisible(true);
			}
		});
		btnUsuFormularz.setBounds(290, 448, 130, 23);
		getContentPane().add(btnUsuFormularz);
		
		
		//wypelnianie tabeli formularzami
		List<FormularzWysylka> formularze = null;
		
		formularze = funkcje.getAllFormularzeWysylkowe();
		
		
		ModelTablicyFormularzyWysylkowych model = new ModelTablicyFormularzyWysylkowych(formularze);
		
		table.setModel(model);
	}
}
