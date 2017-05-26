package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PauseMenu {

	static JFrame frmGuessWho;
	static JFrame MainGamePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PauseMenu window = new PauseMenu(frmGuessWho);
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
	public PauseMenu(JFrame MainGamePanel) {
		PauseMenu.MainGamePanel = MainGamePanel;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setTitle("Guess Who?\r\n");
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		frmGuessWho.setBounds(100, 100, 450, 300);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		JLabel lblGamePaused = new JLabel("GAME PAUSED");
		lblGamePaused.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		lblGamePaused.setBounds(133, 44, 198, 36);
		frmGuessWho.getContentPane().add(lblGamePaused);
		
		JButton ContinueButton = new JButton("\u03A3\u03C5\u03BD\u03AD\u03C7\u03B5\u03B9\u03B1");
		ContinueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGuessWho.setVisible(false);
			}
		});
		ContinueButton.setBounds(166, 107, 97, 25);
		frmGuessWho.getContentPane().add(ContinueButton);
		
		JButton ExitButton = new JButton("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGuessWho.dispose();
				MainGamePanel.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							Mainframe window = new Mainframe();
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		ExitButton.setBounds(166, 145, 97, 25);
		frmGuessWho.getContentPane().add(ExitButton);
		
		JLabel Background = new JLabel("\r\n");
		Background.setIcon(new ImageIcon(path+"\\background_main.jpg"));
		Background.setBounds(0, 0, 444, 267);
		frmGuessWho.getContentPane().add(Background);
	}
}
