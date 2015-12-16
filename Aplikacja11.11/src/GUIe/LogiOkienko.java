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

public class LogiOkienko extends JDialog {
	private JTable tableLogi;

	
	public LogiOkienko() {
		setTitle("Ostatnie zmiany");
		setBounds(100, 100, 500, 340);
		  setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblOstatnieZmiany = new JLabel("Ostatnie zmiany");
		lblOstatnieZmiany.setBounds(10, 11, 89, 14);
		getContentPane().add(lblOstatnieZmiany);
		
		JScrollPane scrollPaneLogi = new JScrollPane();
		scrollPaneLogi.setBounds(20, 36, 404, 188);
		getContentPane().add(scrollPaneLogi);
		
		tableLogi = new JTable();
		scrollPaneLogi.setViewportView(tableLogi);
		
		JButton btnPowrt = new JButton("Powr\u00F3t");
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnPowrt.setBounds(335, 228, 89, 23);
		getContentPane().add(btnPowrt);

	}


		public void populate(Produkt tempprodukt, List<Log> listalogi) {
			//employeeAuditHistoryLabel.setText(tempEmployee.getFirstName() + " " + tempEmployee.getLastName());
			
			ModelTablicyLogow model = new ModelTablicyLogow(listalogi);
			
			tableLogi.setModel(model);
			
			//TableCellRenderer tableCellRenderer = new DateTimeCellRenderer();
			//table.getColumnModel().getColumn(AuditHistoryTableModel.DATE_TIME_COL).setCellRenderer(tableCellRenderer);	
		}
	
}
