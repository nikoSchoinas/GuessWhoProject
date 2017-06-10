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

	//Declaratons
	static JFrame frmGuessWho;
	static JFrame MainGamePanel;
	
	private String playersName;

	/**
	 * Create the application.
	 */
	public PauseMenu(JFrame MainGamePanel,String playersName) {
		this.playersName = playersName;
		PauseMenu.MainGamePanel = MainGamePanel;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		//Panel's creation
		String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setTitle("Guess Who?\r\n");
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\logo2.jpg"));
		frmGuessWho.setBounds(100, 100, 450, 300);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		frmGuessWho.setResizable(false);
		
		//Labels shows tha the game is paused
		JLabel lblGamePaused = new JLabel("GAME PAUSED");
		lblGamePaused.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		lblGamePaused.setBounds(133, 44, 198, 36);
		frmGuessWho.getContentPane().add(lblGamePaused);
		
		//The button which continues the game
		JButton ContinueButton = new JButton("\u03A3\u03C5\u03BD\u03AD\u03C7\u03B5\u03B9\u03B1");
		ContinueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGuessWho.setVisible(false);
			}
		});
		ContinueButton.setBounds(166, 107, 97, 25);
		frmGuessWho.getContentPane().add(ContinueButton);
		
		//The button with whom you exit the game
		JButton ExitButton = new JButton("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGamePanel.dispose();
				frmGuessWho.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							Mainframe window = new Mainframe(playersName);
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
		
		//Background's Creation
		JLabel Background = new JLabel("\r\n");
		Background.setIcon(new ImageIcon(path+"\\background4.jpg"));
		Background.setBounds(0, 0, 444, 267);
		frmGuessWho.getContentPane().add(Background);
	}
}
