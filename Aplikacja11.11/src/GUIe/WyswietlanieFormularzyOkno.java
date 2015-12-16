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
		funkcje = new Funkcje();
		setTitle("Formularze");
		setBounds(100, 100, 710, 480);
		  setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneFormularzy = new JScrollPane();
		scrollPaneFormularzy.setBounds(10, 11, 636, 386);
		getContentPane().add(scrollPaneFormularzy);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPaneFormularzy.setViewportView(textArea);
		
		JButton btnNewPowrt = new JButton("Powr\u00F3t");
		btnNewPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			dispose();
			}
		});
		btnNewPowrt.setBounds(556, 408, 128, 23);
		getContentPane().add(btnNewPowrt);
		
		if(formularzwysylka==null){
		textArea.setText(
				"\t\tFormularz"+
				"\n\n\n"+
				"Imiê: "+
				formularzdetal.getImie()+
				'\n'+
				"Nazwisko: "+
				formularzdetal.getNazwisko()+
				"\n\n"+
				"\t\t\tLista produktów: "+
				'\n'+
				"Nazwa\t\t\tIloœæ\tCena"+
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
		
		if(formularzdetal==null){
			textArea.setText(
					"\t\tFormularz"+
					"\n\n\n"+
					"Miejsce docelowe: "+
					formularzwysylka.getMiejsce_docelowe()+
					"\n\n"+
					"\t\t\tLista produktów: "+
					'\n'+
					"Nazwa\t\t\tIloœæ\tCena"+
					'\n'+
					formularzwysylka.getProdukty()+
					'\n'+
					"Samochód: "+
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
