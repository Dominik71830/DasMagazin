package GUIe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MagazynOkno extends JDialog {
	private JTextField textFieldWyszukiwarka;
	private JTextField textFieldNazwa;
	private JTextField textFieldIlosc;
	private JTextField textFieldCena;
	private JTextField textFieldObjetosc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MagazynOkno dialog = new MagazynOkno();
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
	public MagazynOkno() {
		setBounds(100, 100, 684, 417);
		getContentPane().setLayout(null);
		
		JLabel JLabelNazwa = new JLabel("Nazwa:");
		JLabelNazwa.setBounds(10, 11, 58, 25);
		getContentPane().add(JLabelNazwa);
		
		textFieldWyszukiwarka = new JTextField();
		textFieldWyszukiwarka.setBounds(78, 11, 336, 25);
		getContentPane().add(textFieldWyszukiwarka);
		textFieldWyszukiwarka.setColumns(10);
		
		JButton ButtonOpcjeZaaw = new JButton("Opcje zaaw.");
		ButtonOpcjeZaaw.setBounds(550, 11, 108, 25);
		getContentPane().add(ButtonOpcjeZaaw);
		
		JButton ButtonSzukaj = new JButton("Szukaj");
		ButtonSzukaj.setBounds(424, 11, 116, 25);
		getContentPane().add(ButtonSzukaj);
		
		JTextArea ListaProduktow = new JTextArea();
		ListaProduktow.setBounds(283, 47, 375, 284);
		getContentPane().add(ListaProduktow);
		
		JButton ButtonPowrot = new JButton("Powr\u00F3t");
		ButtonPowrot.setBounds(562, 342, 89, 23);
		getContentPane().add(ButtonPowrot);
		
		JLabel JLabelNazwaDodaj = new JLabel("Nazwa:");
		JLabelNazwaDodaj.setBounds(10, 62, 46, 17);
		getContentPane().add(JLabelNazwaDodaj);
		
		textFieldNazwa = new JTextField();
		textFieldNazwa.setEditable(false);
		textFieldNazwa.setBounds(78, 60, 174, 20);
		getContentPane().add(textFieldNazwa);
		textFieldNazwa.setColumns(10);
		
		JLabel JLabelIlosc = new JLabel("Ilo\u015B\u0107: ");
		JLabelIlosc.setBounds(10, 90, 46, 14);
		getContentPane().add(JLabelIlosc);
		
		textFieldIlosc = new JTextField();
		textFieldIlosc.setEditable(false);
		textFieldIlosc.setBounds(78, 87, 174, 20);
		getContentPane().add(textFieldIlosc);
		textFieldIlosc.setColumns(10);
		
		JLabel JLabelCena = new JLabel("Cena:");
		JLabelCena.setBounds(10, 115, 46, 14);
		getContentPane().add(JLabelCena);
		
		textFieldCena = new JTextField();
		textFieldCena.setEditable(false);
		textFieldCena.setBounds(78, 112, 174, 20);
		getContentPane().add(textFieldCena);
		textFieldCena.setColumns(10);
		
		JLabel JLabelVat = new JLabel("Vat:");
		JLabelVat.setBounds(10, 139, 46, 14);
		getContentPane().add(JLabelVat);
		
		
		JComboBox comboBoxVat = new JComboBox();
		String[] KategorieStrings = {"spo�ywcze","meble","przemys�owe","elektroniczne"};
		JComboBox kategorieList = new JComboBox(KategorieStrings);
		comboBoxVat.setBounds(78, 136, 72, 20);
		getContentPane().add(comboBoxVat);
		
		JLabel JLabelKategoria = new JLabel("Kategoria:");
		JLabelKategoria.setBounds(10, 164, 58, 14);
		getContentPane().add(JLabelKategoria);
		
		JComboBox comboBoxKategoria = new JComboBox();
		comboBoxKategoria.setBounds(78, 161, 72, 20);
		getContentPane().add(comboBoxKategoria);
		
		JLabel JLabelObjetosc = new JLabel("Obj\u0119to\u015B\u0107:");
		JLabelObjetosc.setBounds(10, 189, 52, 17);
		getContentPane().add(JLabelObjetosc);
		
		textFieldObjetosc = new JTextField();
		textFieldObjetosc.setEditable(false);
		textFieldObjetosc.setBounds(78, 186, 174, 20);
		getContentPane().add(textFieldObjetosc);
		textFieldObjetosc.setColumns(10);
		
		JButton ButtonDodajProdukt = new JButton("Dodaj produkt");
		ButtonDodajProdukt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aktywujPola();
				JOptionPane.showMessageDialog(null, "W��czy�em okna");
				JOptionPane.showMessageDialog(null, "A teraz je wy��cze");
				dezaktywujPola();
			}

			private void dezaktywujPola() {
				
				textFieldNazwa.setEditable(false);
				textFieldIlosc.setEditable(false);
				textFieldCena.setEditable(false);
				textFieldObjetosc.setEditable(false);
				
				comboBoxKategoria.setEditable(false);
				comboBoxVat.setEditable(false);
			}

			private void aktywujPola() {
				
				textFieldNazwa.setEditable(true);
				textFieldIlosc.setEditable(true);
				textFieldCena.setEditable(true);
				textFieldObjetosc.setEditable(true);
				
				comboBoxKategoria.setEditable(true);
				comboBoxVat.setEditable(true);
			}
		});
		ButtonDodajProdukt.setBounds(10, 342, 101, 23);
		getContentPane().add(ButtonDodajProdukt);
		
		JButton ButtonZmien = new JButton("Zmie\u0144");
		ButtonZmien.setBounds(121, 342, 89, 23);
		getContentPane().add(ButtonZmien);
		
		JButton ButtonHistoriaZmian = new JButton("Historia zmian");
		ButtonHistoriaZmian.setBounds(220, 342, 101, 23);
		getContentPane().add(ButtonHistoriaZmian);

	}
}
