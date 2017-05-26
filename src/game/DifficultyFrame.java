package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class DifficultyFrame {

	JFrame frmGuessWho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DifficultyFrame window = new DifficultyFrame();
					window.frmGuessWho.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DifficultyFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setTitle("Guess Who ?");
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		frmGuessWho.setBounds(100, 100, 450, 300);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		
		JButton button_1 = new JButton("\u0394\u03CD\u03C3\u03BA\u03BF\u03BB\u03BF");
		button_1.setBounds(171, 148, 99, 25);
		frmGuessWho.getContentPane().add(button_1);
		
		JButton button = new JButton("\u0395\u03CD\u03BA\u03BF\u03BB\u03BF");
		button.setBounds(171, 85, 99, 25);
		frmGuessWho.getContentPane().add(button);
		
		JLabel label = new JLabel("\u0395\u03C0\u03AD\u03BB\u03B5\u03BE\u03B5 \u03B5\u03C0\u03AF\u03C0\u03B5\u03B4\u03BF:");
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.BOLD, 23));
		label.setBounds(140, 36, 172, 27);
		frmGuessWho.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(path+"\\question-mark-background-vector.jpg"));
		lblNewLabel.setBounds(0, 0, 442, 268);
		frmGuessWho.getContentPane().add(lblNewLabel);
	}
}
