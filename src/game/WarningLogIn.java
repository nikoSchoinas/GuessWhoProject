package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WarningLogIn {

	JFrame frmGuessWho;

	/**
	 * Create the application.
	 */
	public WarningLogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setTitle("Warning");
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		frmGuessWho.setBounds(100, 100, 450, 168);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		frmGuessWho.setResizable(false);
		
		//jlabel for the warning message
		JLabel lblNewLabel = new JLabel("\u03A4\u03BF \u03CC\u03BD\u03BF\u03BC\u03B1 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7 \u03B4\u03B5\u03BD \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 !");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(72, 25, 314, 27);
		frmGuessWho.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u039F\u039A");//button that dispose the window
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGuessWho.dispose();
			}
		});
		btnNewButton.setBounds(162, 65, 99, 25);
		frmGuessWho.getContentPane().add(btnNewButton);
	}

}
