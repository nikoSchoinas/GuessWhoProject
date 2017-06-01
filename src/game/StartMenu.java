package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartMenu {

	JFrame frmGuessWho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public StartMenu() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Panel's creation
		String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setTitle("Guess Who ?");
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		frmGuessWho.setBounds(100, 100, 450, 300);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		
		//Login Button
		JButton login_button = new JButton("\u0395\u03AF\u03C3\u03BF\u03B4\u03BF\u03C2");
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		login_button.setBounds(170, 73, 110, 31);
		frmGuessWho.getContentPane().add(login_button);
	
		//Create account button
		JButton Create_account_button = new JButton("\u0394\u03B7\u03BC\u03B9\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1\r\n");
		Create_account_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGuessWho.setVisible(false);
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
				
			
		});
		Create_account_button.setBounds(170, 139, 110, 31);
		frmGuessWho.getContentPane().add(Create_account_button);
		
		//Background's Creation
		JLabel Background = new JLabel("New label");
		Background.setIcon(new ImageIcon(path+"\\question-mark-background-vector.jpg"));
		Background.setBounds(0, 0, 442, 268);
		frmGuessWho.getContentPane().add(Background);
		
		
	
	}
}
