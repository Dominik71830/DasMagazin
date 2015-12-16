package GUIe;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;
import java.util.Set;

import javax.swing.JFrame;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class GlowneOkno {

	private JFrame frmTytuwiczebny;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlowneOkno window = new GlowneOkno();
					window.frmTytuwiczebny.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GlowneOkno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTytuwiczebny = new JFrame();
		frmTytuwiczebny.getContentPane().setBackground(new Color(102, 0, 102));
		frmTytuwiczebny.setForeground(new Color(102, 0, 102));
		frmTytuwiczebny.setBackground(new Color(102, 0, 102));
		frmTytuwiczebny.setTitle("Hurtownia");
		frmTytuwiczebny.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		frmTytuwiczebny.setBounds(0, 0, 1065, 600);
		frmTytuwiczebny.setLocationRelativeTo(null);
		frmTytuwiczebny.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton Przycisk1 = new JButton("Dzia\u0142 magazynowy");
		Przycisk1.setBackground(new Color(153, 102, 204));
		Przycisk1.setBounds(80, 40, 300, 275);
		Przycisk1.setIcon(new ImageIcon(GlowneOkno.class.getResource("/GUIe/grafiki/magazyn_button_off.jpg")));
		Przycisk1.setRolloverIcon(new ImageIcon(GlowneOkno.class.getResource("/GUIe/grafiki/magazyn_button_on.jpg")));
		Przycisk1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MagazynOkno magazynokno = new MagazynOkno();
				magazynokno.setVisible(true);
			}
		});
		frmTytuwiczebny.getContentPane().setLayout(null);
		frmTytuwiczebny.getContentPane().add(Przycisk1);
		
		JButton btnNewButton_1 = new JButton("Sprzeda\u017C detaliczna");
		btnNewButton_1.setIcon(new ImageIcon(GlowneOkno.class.getResource("/GUIe/grafiki/detal_button_off.jpg")));
		btnNewButton_1.setRolloverIcon(new ImageIcon(GlowneOkno.class.getResource("/GUIe/grafiki/detal_button_on.jpg")));
		btnNewButton_1.setBounds(980, 40, 300, 275);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SprzedazDetalicznaOkno okno = new SprzedazDetalicznaOkno();
				okno.setVisible(true);
			}
		});
		frmTytuwiczebny.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Dystrybucja");
		btnNewButton_2.setIcon(new ImageIcon(GlowneOkno.class.getResource("/GUIe/grafiki/dystrybucja_button_off.jpg")));
		btnNewButton_2.setRolloverIcon(new ImageIcon(GlowneOkno.class.getResource("/GUIe/grafiki/dystrybucja_button_on.jpg")));
		btnNewButton_2.setBounds(430, 40, 500, 275);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SprzedazMagazynowaOkno okno;
				try {
					okno = new SprzedazMagazynowaOkno();
					okno.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		frmTytuwiczebny.getContentPane().add(btnNewButton_2);
		
		JButton btnWyloguj = new JButton("Wyjd\u017A");
		btnWyloguj.setIcon(new ImageIcon(GlowneOkno.class.getResource("/GUIe/grafiki/wyjdz_button_off.jpg")));
		btnWyloguj.setRolloverIcon(new ImageIcon(GlowneOkno.class.getResource("/GUIe/grafiki/wyjdz_button_on.jpg")));
		btnWyloguj.setBounds(450, 390, 460, 100);
		btnWyloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      System.exit(0); 
			}
		});
		frmTytuwiczebny.getContentPane().add(btnWyloguj);
	}
}
