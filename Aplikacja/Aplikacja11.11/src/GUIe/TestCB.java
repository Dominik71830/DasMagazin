package GUIe;

import pakiet.*;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JComboBox;

public class TestCB extends JDialog {

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestCB dialog = new TestCB();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TestCB() throws Exception {
		Funkcje funkcje = new Funkcje();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JComboBox<Produkt> comboBox = new JComboBox<Produkt>();
		comboBox.setBounds(24, 11, 264, 22);
		getContentPane().add(comboBox);
		
		funkcje.wypelnijComboboxaProduktami(comboBox);

		
	}
}
