package GUIe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;

import pakiet.FormularzDetal;
import pakiet.FormularzWysylka;
import pakiet.Funkcje;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WyswietlanieFormularzyOkno extends JDialog {

	Funkcje funkcje;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WyswietlanieFormularzyOkno dialog = new WyswietlanieFormularzyOkno(null,null);
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
	 * @param tempformularz 
	 * @param object 
	 * @throws Exception 
	 */
	public WyswietlanieFormularzyOkno(FormularzDetal formularzdetal, FormularzWysylka formularzwysylka) throws Exception {
		getContentPane().setBackground(new Color(102, 0, 102));
		funkcje = new Funkcje();
		setTitle("Formularze");
		setBounds(100, 100, 710, 480);
		  setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneFormularzy = new JScrollPane();
		scrollPaneFormularzy.setBounds(10, 11, 636, 386);
		getContentPane().add(scrollPaneFormularzy);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setEditable(false);
		scrollPaneFormularzy.setViewportView(textArea);
		
		JButton btnNewPowrt = new JButton("Powr\u00F3t");
		btnNewPowrt.setForeground(Color.BLACK);
		btnNewPowrt.setBackground(new Color(153, 102, 153));
		btnNewPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			dispose();
			}
		});
		btnNewPowrt.setBounds(556, 408, 128, 23);
		getContentPane().add(btnNewPowrt);
		
		if(formularzwysylka==null){//sposob wyswietlania formularza wysylkowego
		textArea.setText(
				"\t\tFormularz"+
				"\n\n\n"+
				"Imi�: "+
				formularzdetal.getImie()+
				'\n'+
				"Nazwisko: "+
				formularzdetal.getNazwisko()+
				"\n\n"+
				"\t\t\tLista produkt�w: "+
				'\n'+
				"Nazwa\t\t\tIlo��\tCena"+
				'\n'+
				formularzdetal.getProdukty()+
				'\n'+
				"Cena: "+
				formularzdetal.getCena()+
				'\n'+
				"Data: "+
				formularzdetal.getData_dodania()
				);
		}
		
		if(formularzdetal==null){//sposob wyswietlania formularza detalicznego
			textArea.setText(
					"\t\tFormularz"+
					"\n\n\n"+
					"Miejsce docelowe: "+
					formularzwysylka.getMiejsce_docelowe()+
					"\n\n"+
					"\t\t\tLista produkt�w: "+
					'\n'+
					"Nazwa\t\t\tIlo��\tCena"+
					'\n'+
					formularzwysylka.getProdukty()+
					'\n'+
					"Samoch�d: "+
					formularzwysylka.getSamochod()+
					'\n'+
					"Cena: "+
					formularzwysylka.getCena()+
					'\n'+
					"Data: "+
					formularzwysylka.getData_dodania()
					);
			}
	}
}
