package GUIe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import pakiet.*;
import java.awt.Color;

public class OpcjeZaawOkno extends JDialog {
	private JTextField textFieldNazwaZaaw;
	private JTextField textFieldCena_Od;
	private JTextField textFieldCena_Do;
	private JTextField textFieldIlosc_Od;
	private JTextField textField_Do;
	private JTextField textFieldObjetosc_Od;
	private JTextField textFieldObjetosc_Do;

	public OpcjeZaawOkno(JTable table) throws Exception {
		getContentPane().setBackground(new Color(102, 0, 102));
		
		Funkcje funkcje = new Funkcje();
		setTitle("Opcje Zaawansowane");
		setBounds(0, 0, 375, 335);
		  setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNazwa = new JLabel("Nazwa");
		lblNazwa.setForeground(Color.BLACK);
		lblNazwa.setBounds(10, 25, 58, 25);
		getContentPane().add(lblNazwa);
		
		textFieldNazwaZaaw = new JTextField();
		textFieldNazwaZaaw.setForeground(Color.BLACK);
		textFieldNazwaZaaw.setBackground(new Color(204, 153, 255));
		textFieldNazwaZaaw.setBounds(82, 27, 183, 20);
		getContentPane().add(textFieldNazwaZaaw);
		textFieldNazwaZaaw.setColumns(10);
		
		JLabel lblCenaOd = new JLabel("Cena              od");
		lblCenaOd.setForeground(Color.BLACK);
		lblCenaOd.setBounds(10, 61, 88, 14);
		getContentPane().add(lblCenaOd);
		
		textFieldCena_Od = new JTextField();
		textFieldCena_Od.setForeground(Color.BLACK);
		textFieldCena_Od.setBackground(new Color(204, 153, 255));
		textFieldCena_Od.setBounds(108, 58, 34, 20);
		getContentPane().add(textFieldCena_Od);
		textFieldCena_Od.setColumns(10);
		
		JLabel lblDo = new JLabel("do");
		lblDo.setForeground(Color.BLACK);
		lblDo.setBounds(152, 61, 17, 14);
		getContentPane().add(lblDo);
		
		textFieldCena_Do = new JTextField();
		textFieldCena_Do.setForeground(Color.BLACK);
		textFieldCena_Do.setBackground(new Color(204, 153, 255));
		textFieldCena_Do.setBounds(179, 58, 34, 20);
		getContentPane().add(textFieldCena_Do);
		textFieldCena_Do.setColumns(10);
		
		JLabel lblIloOd = new JLabel("Ilo\u015B\u0107               od");
		lblIloOd.setForeground(Color.BLACK);
		lblIloOd.setBounds(10, 92, 88, 14);
		getContentPane().add(lblIloOd);
		
		textFieldIlosc_Od = new JTextField();
		textFieldIlosc_Od.setForeground(Color.BLACK);
		textFieldIlosc_Od.setBackground(new Color(204, 153, 255));
		textFieldIlosc_Od.setBounds(108, 89, 34, 20);
		getContentPane().add(textFieldIlosc_Od);
		textFieldIlosc_Od.setColumns(10);
		
		textField_Do = new JTextField();
		textField_Do.setForeground(Color.BLACK);
		textField_Do.setBackground(new Color(204, 153, 255));
		textField_Do.setBounds(179, 89, 34, 20);
		getContentPane().add(textField_Do);
		textField_Do.setColumns(10);
		
		JLabel lblDo_1 = new JLabel("do");
		lblDo_1.setForeground(Color.BLACK);
		lblDo_1.setBounds(152, 92, 17, 14);
		getContentPane().add(lblDo_1);
		
		JLabel lblKategoria = new JLabel("Kategoria");
		lblKategoria.setForeground(Color.BLACK);
		lblKategoria.setBounds(10, 117, 58, 14);
		getContentPane().add(lblKategoria);
		
		JCheckBox chckbxSpozywcze = new JCheckBox("spo\u017Cywcze");
		chckbxSpozywcze.setForeground(Color.BLACK);
		chckbxSpozywcze.setBackground(new Color(102, 0, 102));
		chckbxSpozywcze.setBounds(82, 113, 97, 23);
		getContentPane().add(chckbxSpozywcze);
		
		JCheckBox chckbxmeble = new JCheckBox("meble");
		chckbxmeble.setForeground(Color.BLACK);
		chckbxmeble.setBackground(new Color(102, 0, 102));
		chckbxmeble.setBounds(82, 138, 97, 23);
		getContentPane().add(chckbxmeble);
		
		JCheckBox chckbxPrzemyslowe = new JCheckBox("przemys\u0142owe");
		chckbxPrzemyslowe.setForeground(Color.BLACK);
		chckbxPrzemyslowe.setBackground(new Color(102, 0, 102));
		chckbxPrzemyslowe.setBounds(82, 164, 147, 23);
		getContentPane().add(chckbxPrzemyslowe);
		
		JCheckBox chckbxElektroniczne = new JCheckBox("elektroniczne");
		chckbxElektroniczne.setForeground(Color.BLACK);
		chckbxElektroniczne.setBackground(new Color(102, 0, 102));
		chckbxElektroniczne.setBounds(82, 190, 155, 23);
		getContentPane().add(chckbxElektroniczne);
		
		JLabel lblObjto = new JLabel("Obj\u0119to\u015B\u0107        od");
		lblObjto.setForeground(Color.BLACK);
		lblObjto.setBounds(10, 220, 97, 20);
		getContentPane().add(lblObjto);
		
		textFieldObjetosc_Od = new JTextField();
		textFieldObjetosc_Od.setForeground(Color.BLACK);
		textFieldObjetosc_Od.setBackground(new Color(204, 153, 255));
		textFieldObjetosc_Od.setBounds(103, 219, 34, 20);
		getContentPane().add(textFieldObjetosc_Od);
		textFieldObjetosc_Od.setColumns(10);
		
		JLabel lblDo_2 = new JLabel("do");
		lblDo_2.setForeground(Color.BLACK);
		lblDo_2.setBounds(147, 223, 17, 14);
		getContentPane().add(lblDo_2);
		
		textFieldObjetosc_Do = new JTextField();
		textFieldObjetosc_Do.setForeground(Color.BLACK);
		textFieldObjetosc_Do.setBackground(new Color(204, 153, 255));
		textFieldObjetosc_Do.setBounds(168, 220, 34, 20);
		getContentPane().add(textFieldObjetosc_Do);
		textFieldObjetosc_Do.setColumns(10);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.setForeground(Color.BLACK);
		btnAnuluj.setBackground(new Color(153, 102, 204));
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnAnuluj.setBounds(260, 263, 89, 23);
		getContentPane().add(btnAnuluj);
		
		JButton btnSzukaj = new JButton("Szukaj");
		btnSzukaj.setForeground(Color.BLACK);
		btnSzukaj.setBackground(new Color(153, 102, 204));
		btnSzukaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(		chckbxElektroniczne.isSelected()
						||
						chckbxmeble.isSelected()
						||
						chckbxPrzemyslowe.isSelected()
						||
						chckbxSpozywcze.isSelected()
					)	
				{
				/////////////////////////////////////////////////////////Pozbieranie danych
				String nazwa =  textFieldNazwaZaaw.getText();
				
				Double cena_od=null;
				if(!textFieldCena_Od.getText().isEmpty())
					cena_od = Double.parseDouble(textFieldCena_Od.getText());
				
				Double cena_do=null;
				if(!textFieldCena_Do.getText().isEmpty())
					cena_do= Double.parseDouble(textFieldCena_Do.getText());
				
				Double ilosc_od=null;
				if(!textFieldIlosc_Od.getText().isEmpty())
					ilosc_od= Double.parseDouble(textFieldIlosc_Od.getText());
				
				Double ilosc_do=null;
				if(!textField_Do.getText().isEmpty())
					ilosc_do= Double.parseDouble(textField_Do.getText());
				
				
				Boolean czy_spozywcze=false;
				if(chckbxSpozywcze.isSelected())
					czy_spozywcze=true;
				
				Boolean czy_meble=false;
				if(chckbxmeble.isSelected())
					czy_meble=true;
				
				Boolean czy_przemyslowe=false;
				if(chckbxPrzemyslowe.isSelected())
					czy_przemyslowe=true;
				
				Boolean czy_elektroniczne=false;
				if(chckbxElektroniczne.isSelected())
					czy_elektroniczne=true;
				
				Double objetosc_od=null;
				if(!textFieldObjetosc_Od.getText().isEmpty())
					objetosc_od = Double.parseDouble(textFieldObjetosc_Od.getText());

				Double objetosc_do=null;
				if(!textFieldObjetosc_Do.getText().isEmpty())
					objetosc_do = Double.parseDouble(textFieldObjetosc_Do.getText());
				
				////////////////////////////////////////////////////////////////////////stworzenie i pobranie listy produkt�w
				
				List<Produkt> listaproduktow = new ArrayList<Produkt>();
				try {
					listaproduktow = funkcje.getAllProdukty();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				///////////////////////////////////////////////////////////////////stworzenie listy indexow
				
				List<Integer> indexy = new ArrayList<Integer>();
				
				///////////////////////////////////////////////////Sortowanie po poszczeg�lnych polach
				
				if (nazwa != null && nazwa.trim().length() > 0)
				{ 
					for(Produkt p : listaproduktow)
					{	
						if(!p.getNazwa().equals(nazwa))
						{
							if(!indexy.contains(listaproduktow.indexOf(p)))
							indexy.add(listaproduktow.indexOf(p));
						}
					}
				}
				
				
				
				if (cena_od != null ) 
				{ 
					for(Produkt p : listaproduktow)
					{	
						if(p.getCena() < cena_od)
						{
							if(!indexy.contains(listaproduktow.indexOf(p)))
							indexy.add(listaproduktow.indexOf(p));
						}
					}
				}
				
				
				
				if (cena_do != null ) 
				{ 
					for(Produkt p : listaproduktow)
					{	
						if(p.getCena() > cena_do)
						{
							if(!indexy.contains(listaproduktow.indexOf(p)))
							indexy.add(listaproduktow.indexOf(p));
						}
					}
				}
				
				
				
				if (ilosc_od != null ) 
				{ 
					for(Produkt p : listaproduktow)
					{	
						if(p.getIlosc() < ilosc_od)
						{
							if(!indexy.contains(listaproduktow.indexOf(p)))
							indexy.add(listaproduktow.indexOf(p));
						}
					}
				}
				
				
				
				if (ilosc_do != null ) 
				{ 
					for(Produkt p : listaproduktow)
					{	
						if(p.getIlosc() > ilosc_do)
						{
							if(!indexy.contains(listaproduktow.indexOf(p)))
							indexy.add(listaproduktow.indexOf(p));
						}
					}
				}
				
				
				
				
				if (czy_spozywcze == false ) 
				{ 
					for(Produkt p : listaproduktow)
					{	
						if(p.getKategoria().equals("spo�ywcze"))
						{
							if(!indexy.contains(listaproduktow.indexOf(p)))
							indexy.add(listaproduktow.indexOf(p));
						}
					}
				}
				
				if (czy_meble == false ) 
				{ 
					for(Produkt p : listaproduktow)
					{	
						if(p.getKategoria().equals("meble"))
						{
							if(!indexy.contains(listaproduktow.indexOf(p)))
							indexy.add(listaproduktow.indexOf(p));
						}
					}
				}
				
				if (czy_przemyslowe == false ) 
				{ 
					for(Produkt p : listaproduktow)
					{	
						if(p.getKategoria().equals("przemys�owe"))
						{
							if(!indexy.contains(listaproduktow.indexOf(p)))
							indexy.add(listaproduktow.indexOf(p));
						}
					}
				}
				
				if (czy_elektroniczne == false ) 
				{ 
					for(Produkt p : listaproduktow)
					{	
						if(p.getKategoria().equals("elektroniczne"))
						{
							if(!indexy.contains(listaproduktow.indexOf(p)))
							indexy.add(listaproduktow.indexOf(p));
						}
					}
				}
				
				
				
				
				
				if (objetosc_od != null ) 
				{ 
					for(Produkt p : listaproduktow)
					{	
						if(p.getObjetosc() < objetosc_od)
						{
							if(!indexy.contains(listaproduktow.indexOf(p)))
							indexy.add(listaproduktow.indexOf(p));
						}
					}
				}
				
				
				
				if (objetosc_do != null ) 
				{ 
					for(Produkt p : listaproduktow)
					{	
						if(p.getObjetosc() > objetosc_do)
						{
							if(!indexy.contains(listaproduktow.indexOf(p)))
							indexy.add(listaproduktow.indexOf(p));
						}
					}
				}
				
				////////////////////////////////////////////////////////Posortowanie index�w
				indexy.sort(null);
				
				
				////////////////////////////////////////////////////////Odwr�cenie kolejno��i index�w
				Collections.reverse(indexy);
				
				///////////////////////////////////////////////////////Usuni�cie niepasuj�cych produkt�w
				for(Integer i : indexy)
				{
					listaproduktow.remove(listaproduktow.get(i));
				}
				
				
				//////////////////////////////////////////////////////Utworzenie modelu i wypisanie go na JTable
				
				ModelTablicyProduktow model;
				try {
					model = new ModelTablicyProduktow(listaproduktow);
					table.setModel(model);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				setVisible(false);
				dispose();
				
				}//tu sie ko�czy if z czterema chkbxoami
				
				else
				{
					JOptionPane.showMessageDialog(null, "Prosz� zaznaczy� przynajmniej jedn� kategori�");
				}
				
			}
		});
		btnSzukaj.setBounds(161, 263, 89, 23);
		getContentPane().add(btnSzukaj);

	}
}
