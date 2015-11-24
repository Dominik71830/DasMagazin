package GUIe;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pakiet.*;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TempOkno {

	private JFrame frame;
	private JTable table;
	private static Funkcje funkcje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TempOkno window = new TempOkno();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TempOkno() {
		initialize();
		try
		{
		funkcje= new Funkcje();
		}
		catch(Exception exc)
		{
			JOptionPane.showMessageDialog(null,"B³¹d przy inicjalizacji okna " + exc);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0,500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Wy\u015Bwietl");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				String _nazwa = "";
				
				List<Produkt> produkty = null;
				
				if (_nazwa != null && _nazwa.trim().length() > 0) { 
					produkty = funkcje.searchProdukt(_nazwa);
				} else {
					produkty = funkcje.getAllProdukty();
				}
				
				ModelTablicyProduktow model = new ModelTablicyProduktow(produkty);
				
				table.setModel(model);
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null,"B³¹d wyszukiwania " + exc); 
					
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(21, 10, 91, 23);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 44, 446, 370);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ProduktOkienko produktokienko = new ProduktOkienko(TempOkno.this,funkcje);
				
				produktokienko.setVisible(true);
			}
		});
		btnDodaj.setBounds(376, 439, 91, 23);
		frame.getContentPane().add(btnDodaj);
		
		JButton btnEdytuj = new JButton("Edytuj");
		btnEdytuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int row = table.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz produkt");				
					return;
				}
				
				Produkt tempprodukt = (Produkt) table.getValueAt(row, ModelTablicyProduktow.OBJECT_COL);
				
				ProduktOkienko produktokienko = new ProduktOkienko(TempOkno.this,funkcje,tempprodukt,true);//tu wróciæ z uderid
				
				produktokienko.setVisible(true);
				
			}
		});
		btnEdytuj.setBounds(122, 10, 91, 23);
		frame.getContentPane().add(btnEdytuj);
		
		JButton btnWyzeruj = new JButton("Wyzeruj");
		btnWyzeruj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					wyzeruj();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}

			private void wyzeruj() throws Exception {
				int row = table.getSelectedRow();
				
				if (row < 0) {
					JOptionPane.showMessageDialog(null,"Wybierz produkt");				
					return;
				}
				
				Produkt tempprodukt = (Produkt) table.getValueAt(row, ModelTablicyProduktow.OBJECT_COL);
				int _id = tempprodukt.getId();
				funkcje.ustawiloscnazero(tempprodukt);
				funkcje.deleteProdukt(_id);
				funkcje.addProdukt(tempprodukt);
				odswiez();
				
			}
		});
		btnWyzeruj.setBounds(223, 10, 91, 23);
		frame.getContentPane().add(btnWyzeruj);
	}
	
	

	public void odswiez() {
		
		try{
			List<Produkt> produkty = funkcje.getAllProdukty();
			
			ModelTablicyProduktow model = new ModelTablicyProduktow(produkty);
			
			table.setModel(model);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(null,"Blad przy odswiezaniu " + exc);
		}
		
	}
}
