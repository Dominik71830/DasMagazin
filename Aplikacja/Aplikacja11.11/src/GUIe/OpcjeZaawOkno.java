package GUIe;

import java.awt.EventQueue;
import pakiet.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcjeZaawOkno extends JDialog {
	private JTextField textFieldNazwaZaaw;
	private JTextField textFieldCena_Od;
	private JTextField textFieldCena_Do;
	private JTextField textFieldIlosc_Od;
	private JTextField textField_Do;
	private JTextField textFieldObjetosc_Od;
	private JTextField textFieldObjetosc_Do;

	public OpcjeZaawOkno(String _nazwa, JTable table) {
		
		
		
		setTitle("Opcje Zaawansowane");
		setBounds(100, 100, 394, 328);
		getContentPane().setLayout(null);
		
		JLabel lblNazwa = new JLabel("Nazwa");
		lblNazwa.setBounds(28, 25, 58, 25);
		getContentPane().add(lblNazwa);
		
		textFieldNazwaZaaw = new JTextField();
		textFieldNazwaZaaw.setBounds(82, 27, 183, 20);
		getContentPane().add(textFieldNazwaZaaw);
		textFieldNazwaZaaw.setColumns(10);
		
		textFieldNazwaZaaw.setText(_nazwa); // kopiowanie nazwy
		
		JLabel lblCenaOd = new JLabel("Cena          od");
		lblCenaOd.setBounds(28, 61, 77, 14);
		getContentPane().add(lblCenaOd);
		
		textFieldCena_Od = new JTextField();
		textFieldCena_Od.setBounds(103, 58, 34, 20);
		getContentPane().add(textFieldCena_Od);
		textFieldCena_Od.setColumns(10);
		
		JLabel lblDo = new JLabel("do");
		lblDo.setBounds(147, 61, 17, 14);
		getContentPane().add(lblDo);
		
		textFieldCena_Do = new JTextField();
		textFieldCena_Do.setBounds(168, 58, 34, 20);
		getContentPane().add(textFieldCena_Do);
		textFieldCena_Do.setColumns(10);
		
		JLabel lblIloOd = new JLabel("Ilo\u015B\u0107           od");
		lblIloOd.setBounds(28, 92, 77, 14);
		getContentPane().add(lblIloOd);
		
		textFieldIlosc_Od = new JTextField();
		textFieldIlosc_Od.setBounds(103, 89, 34, 20);
		getContentPane().add(textFieldIlosc_Od);
		textFieldIlosc_Od.setColumns(10);
		
		textField_Do = new JTextField();
		textField_Do.setBounds(168, 89, 34, 20);
		getContentPane().add(textField_Do);
		textField_Do.setColumns(10);
		
		JLabel lblDo_1 = new JLabel("do");
		lblDo_1.setBounds(147, 92, 17, 14);
		getContentPane().add(lblDo_1);
		
		JLabel lblKategoria = new JLabel("Kategoria");
		lblKategoria.setBounds(28, 117, 58, 14);
		getContentPane().add(lblKategoria);
		
		JCheckBox chckbxSpozywcze = new JCheckBox("spo\u017Cywcze");
		chckbxSpozywcze.setBounds(82, 113, 97, 23);
		getContentPane().add(chckbxSpozywcze);
		
		JCheckBox chckbxmeble = new JCheckBox("meble");
		chckbxmeble.setBounds(82, 138, 97, 23);
		getContentPane().add(chckbxmeble);
		
		JCheckBox chckbxPrzemyslowe = new JCheckBox("przemys\u0142owe");
		chckbxPrzemyslowe.setBounds(82, 164, 97, 23);
		getContentPane().add(chckbxPrzemyslowe);
		
		JCheckBox chckbxElektroniczne = new JCheckBox("elektroniczne");
		chckbxElektroniczne.setBounds(82, 190, 97, 23);
		getContentPane().add(chckbxElektroniczne);
		
		JLabel lblObjto = new JLabel("Obj\u0119to\u015B\u0107     od");
		lblObjto.setBounds(28, 219, 77, 20);
		getContentPane().add(lblObjto);
		
		textFieldObjetosc_Od = new JTextField();
		textFieldObjetosc_Od.setBounds(103, 219, 34, 20);
		getContentPane().add(textFieldObjetosc_Od);
		textFieldObjetosc_Od.setColumns(10);
		
		JLabel lblDo_2 = new JLabel("do");
		lblDo_2.setBounds(147, 222, 17, 14);
		getContentPane().add(lblDo_2);
		
		textFieldObjetosc_Do = new JTextField();
		textFieldObjetosc_Do.setBounds(168, 219, 34, 20);
		getContentPane().add(textFieldObjetosc_Do);
		textFieldObjetosc_Do.setColumns(10);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnuluj.setBounds(261, 256, 89, 23);
		getContentPane().add(btnAnuluj);
		
		JButton btnSzukaj = new JButton("Szukaj");
		btnSzukaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Produkt> lista = new ArrayList<Produkt>();
				// 2 sposoby
				// albo przeczesa� t� list� za pomoc� zapyta� SQLowych
				// albo za pomoc� funckji Javowych
				
			}
		});
		btnSzukaj.setBounds(157, 256, 89, 23);
		getContentPane().add(btnSzukaj);

	}
}
