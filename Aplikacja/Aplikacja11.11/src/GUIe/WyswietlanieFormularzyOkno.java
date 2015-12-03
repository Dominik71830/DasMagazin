package GUIe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;

import pakiet.FormularzDetal;
import pakiet.Funkcje;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WyswietlanieFormularzyOkno extends JDialog {

	Funkcje funkcje;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WyswietlanieFormularzyOkno dialog = new WyswietlanieFormularzyOkno(null);
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
	 * @throws Exception 
	 */
	public WyswietlanieFormularzyOkno(FormularzDetal tempformularz) throws Exception {
		funkcje = new Funkcje();
		setTitle("Formularze");
		setBounds(100, 100, 552, 400);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneFormularzy = new JScrollPane();
		scrollPaneFormularzy.setBounds(10, 11, 516, 298);
		getContentPane().add(scrollPaneFormularzy);
		
		JTextArea textArea = new JTextArea();
		scrollPaneFormularzy.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnNewPowrt = new JButton("Powr\u00F3t");
		btnNewPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			dispose();
			}
		});
		btnNewPowrt.setBounds(437, 328, 89, 23);
		getContentPane().add(btnNewPowrt);
		
		textArea.setText(
				tempformularz.getImie() 
				+'\n'+
				tempformularz.getNazwisko()
				+'\n'+
				tempformularz.getProdukty());
	
	}
}
