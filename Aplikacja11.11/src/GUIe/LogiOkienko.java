package GUIe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import pakiet.*;
import pakiet.ModelTablicyLogow;
import pakiet.Produkt;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class LogiOkienko extends JDialog {
	private JTable tableLogi;

	
	public LogiOkienko() {
		setBackground(new Color(153, 0, 153));
		getContentPane().setBackground(new Color(102, 0, 102));
		setTitle("Ostatnie zmiany");
		setBounds(100, 100, 500, 340);
		  setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblOstatnieZmiany = new JLabel("Ostatnie zmiany");
		lblOstatnieZmiany.setBounds(10, 11, 121, 14);
		getContentPane().add(lblOstatnieZmiany);
		
		JScrollPane scrollPaneLogi = new JScrollPane();
		scrollPaneLogi.setBounds(20, 36, 454, 221);
		getContentPane().add(scrollPaneLogi);
		
		tableLogi = new JTable();
		tableLogi.setBackground(new Color(204, 153, 255));
		scrollPaneLogi.setViewportView(tableLogi);
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		btnPowrt.setForeground(Color.BLACK);
		btnPowrt.setBackground(new Color(153, 102, 204));
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnPowrt.setBounds(385, 268, 89, 23);
		getContentPane().add(btnPowrt);

	}


		public void populate(Produkt tempprodukt, List<Log> listalogi) {
			
			//wypelnianie tablicy logami
			ModelTablicyLogow model = new ModelTablicyLogow(listalogi);
			
			tableLogi.setModel(model);
			
				
		}
	
}
