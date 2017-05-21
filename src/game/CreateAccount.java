package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccount {

	public JFrame frmGuessWho;
	private JTextField AccountName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
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
	public CreateAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuessWho = new JFrame();
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kostas\\workspace\\game\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		frmGuessWho.setTitle("Guess Who ?");
		frmGuessWho.setBounds(100, 100, 450, 300);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGuessWho.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							StartMenu window = new StartMenu();
							window.frmGuessWho.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		BackButton.setBounds(182, 179, 99, 25);
		frmGuessWho.getContentPane().add(BackButton);
		
		JButton CreateButton = new JButton("\u0394\u03B7\u03BC\u03B9\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1");
		CreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGuessWho.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LogIn window = new LogIn();
							window.frmGuessWho.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			
		});
		CreateButton.setBounds(182, 141, 99, 25);
		frmGuessWho.getContentPane().add(CreateButton);
		
		JLabel label = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label.setBounds(121, 96, 87, 32);
		frmGuessWho.getContentPane().add(label);
		
		AccountName = new JTextField();
		label.setLabelFor(AccountName);
		AccountName.setBounds(196, 104, 116, 22);
		frmGuessWho.getContentPane().add(AccountName);
		AccountName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\kostas\\workspace\\game\\question-mark-background-vector.jpg"));
		lblNewLabel.setBounds(0, 0, 442, 268);
		frmGuessWho.getContentPane().add(lblNewLabel);
	}
}
