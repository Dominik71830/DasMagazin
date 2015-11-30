package GUIe;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frmTytuwiczebny.setTitle("tytu\u0142 \u0107wiczebny");
		frmTytuwiczebny.setBounds(0, 0, 1300, 700);
		frmTytuwiczebny.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTytuwiczebny.getContentPane().setLayout(null);
		
		JButton Przycisk1 = new JButton("Dzia\u0142 magazynowy");
		Przycisk1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MagazynOkno magazynokno = new MagazynOkno();
				magazynokno.setVisible(true);
			}
		});
		Przycisk1.setBounds(104, 39, 291, 378);
		frmTytuwiczebny.getContentPane().add(Przycisk1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(499, 39, 291, 378);
		frmTytuwiczebny.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(894, 39, 291, 378);
		frmTytuwiczebny.getContentPane().add(btnNewButton_2);
		
		JButton btnWyloguj = new JButton("wyloguj");
		btnWyloguj.setBounds(965, 447, 220, 91);
		frmTytuwiczebny.getContentPane().add(btnWyloguj);
	}
}
