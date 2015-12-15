package GUIe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.SwingConstants;

import pakiet.FormularzDetal;
import pakiet.FormularzWysylka;
import pakiet.Funkcje;
import pakiet.ModelTablicyProduktow;
import pakiet.Produkt;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class ZatwierdzenieOUsuwaniuOkienko extends JDialog {

Funkcje funkcje;


	/**
	 * Create the dialog.
	 * @param tempprodukt 
	 * @param table 
	 */
	public ZatwierdzenieOUsuwaniuOkienko(Produkt _produkt,FormularzDetal _formularzDetal,FormularzWysylka _formularzWysylka, JTable _table,int _i) {
		
		try
		{
		funkcje= new Funkcje();
		}
		catch(Exception exc)
		{
			JOptionPane.showMessageDialog(null,"B³¹d przy inicjalizacji okna " + exc);
		}
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel JLabeltekst = new JLabel("Czy aby napewno chcesz usun\u0105\u0107 ten obiekt?");
		JLabeltekst.setHorizontalAlignment(SwingConstants.CENTER);
		JLabeltekst.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JLabeltekst.setBounds(21, 30, 384, 75);
		getContentPane().add(JLabeltekst);
		
		JButton btnTak = new JButton("Tak");
		btnTak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_i==1){//usuwanie produktu
					try {
						funkcje.wyzeruj(_produkt);
					} catch (SQLException exc) {
						JOptionPane.showMessageDialog(null,"B³¹d przy usuwaniu produktu " + exc);
					}
					funkcje.odswiezProdukty(_table);

				}
				else if(_i==2){//tu usuwanie formularza detal
					try {
						
						funkcje.deleteFormularzDetal(_formularzDetal);
					} catch (SQLException exc) {
						JOptionPane.showMessageDialog(null,"B³¹d przy usuwaniu formularza " + exc);
					}
					funkcje.odswiezFormularzeDetal(_table);
				}
				else if(_i==3){//tu usuwanie formularza wysylka
					try {
						
						funkcje.deleteFormularzWysylka(_formularzWysylka);
					} catch (SQLException exc) {
						JOptionPane.showMessageDialog(null,"B³¹d przy usuwaniu formularza " + exc);
					}
					funkcje.odswiezFormularzewysylkowe(_table);
				}
				
				
				
				setVisible(false);
				dispose();
			}
			
		});
		btnTak.setBounds(89, 169, 89, 23);
		getContentPane().add(btnTak);
		
		JButton btnNie = new JButton("Nie");
		btnNie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNie.setBounds(255, 169, 89, 23);
		getContentPane().add(btnNie);

	}


}
