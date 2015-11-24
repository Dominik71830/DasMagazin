package GUIe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import pakiet.Funkcje;
import pakiet.Produkt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProduktOkienko extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField NazwaTextField;
	private JTextField CenaTextField;
	private JTextField IloscTextField;
	private JTextField KategriaTextField;
	private JTextField VatTextField;
	
	private Funkcje funkcje = null;
	
	private TempOkno tempokno= null;
	
	private Produkt poprzedniprodukt = null;// to dla edycji
	private boolean updatemode = false;
	// tu b�dzie co� odpowiedzialne za id uzytkoinika zalogowanego

	
	public  ProduktOkienko(TempOkno _tempokno,Funkcje _funkcje, Produkt _poprzedniprodukt,boolean _updatemode){
		this();
		funkcje = _funkcje;
		tempokno = _tempokno;
		poprzedniprodukt = _poprzedniprodukt;
		updatemode = _updatemode;
		//tu user id b�dzie
		
		if (updatemode) {
			setTitle("Aktualizuj produkt");
			
			wypelnijOkno(poprzedniprodukt);
		}
		
	}
		

	private void wypelnijOkno(Produkt _poprzedniprodukt) {
		NazwaTextField.setText(_poprzedniprodukt.getNazwa());
		CenaTextField.setText(Double.toString(_poprzedniprodukt.getCena()));
		IloscTextField.setText(Integer.toString(_poprzedniprodukt.getIlosc()));
		KategriaTextField.setText(_poprzedniprodukt.getKategoria());
		VatTextField.setText(Double.toString(_poprzedniprodukt.getVat()));
	}

	
	public ProduktOkienko(TempOkno _tempokno,
			Funkcje _funkcje) {
		this(_tempokno, _funkcje, null, false);
	}

	/**
	 * Create the dialog.
	 */
	public ProduktOkienko() {
		setTitle("Dodaj Produkt");
		setBounds(100, 100, 412, 216);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNazwa = new JLabel("Nazwa:");
		lblNazwa.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNazwa);
		
		JLabel lblCena = new JLabel("Cena:");
		lblCena.setBounds(10, 36, 46, 14);
		contentPanel.add(lblCena);
		
		JLabel lblNewLabel = new JLabel("Ilo\u015B\u0107:");
		lblNewLabel.setBounds(10, 61, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblKategoria = new JLabel("Kategoria:");
		lblKategoria.setBounds(10, 86, 73, 14);
		contentPanel.add(lblKategoria);
		
		JLabel lblVat = new JLabel("Vat:");
		lblVat.setBounds(10, 111, 46, 14);
		contentPanel.add(lblVat);
		
		NazwaTextField = new JTextField();
		NazwaTextField.setBounds(80, 8, 300, 20);
		contentPanel.add(NazwaTextField);
		NazwaTextField.setColumns(10);
		
		CenaTextField = new JTextField();
		CenaTextField.setBounds(80, 33, 300, 20);
		contentPanel.add(CenaTextField);
		CenaTextField.setColumns(10);
		
		IloscTextField = new JTextField();
		IloscTextField.setBounds(80, 58, 300, 20);
		contentPanel.add(IloscTextField);
		IloscTextField.setColumns(10);
		
		KategriaTextField = new JTextField();
		KategriaTextField.setBounds(80, 83, 300, 20);
		contentPanel.add(KategriaTextField);
		KategriaTextField.setColumns(10);
		
		VatTextField = new JTextField();
		VatTextField.setBounds(80, 108, 300, 20);
		contentPanel.add(VatTextField);
		VatTextField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Zapisz");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						zapiszProdukt();
					}

					private void zapiszProdukt() {
						
						String nazwa = NazwaTextField.getText();
						Double cena = Double.parseDouble(CenaTextField.getText());
						int ilosc = Integer.parseInt(IloscTextField.getText());
						String kategoria = KategriaTextField.getText();
						Double vat = Double.parseDouble(VatTextField.getText());
						
						Produkt tempprodukt = null;
						
						if(updatemode){
							tempprodukt = poprzedniprodukt;
							
							tempprodukt.setNazwa(nazwa);;
							tempprodukt.setCena(cena);
							tempprodukt.setIlosc(ilosc);
							tempprodukt.setKategoria(kategoria);
							tempprodukt.setVat(vat);
							
						}else{
						tempprodukt = new Produkt(nazwa, ilosc, vat, cena, kategoria); // tu trzeba wr�ci� przy updacie
						}
						
						try {
							if(updatemode){
								funkcje.updateProdukt(tempprodukt);
							}else{
								funkcje.addProdukt(tempprodukt);
							}
							
							
							
							setVisible(false);
							dispose();
							
						
							tempokno.odswiez();
							
							if(updatemode){
								JOptionPane.showMessageDialog(null,"Zaktualizowano");
							}else{
								JOptionPane.showMessageDialog(null,"Produkt dodany");
							}
						} catch (Exception exc) {
							JOptionPane.showMessageDialog(null,"Blad przy zapisywaniu lub updacie " + exc);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Anuluj");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
