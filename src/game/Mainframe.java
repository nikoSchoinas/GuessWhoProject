package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mainframe {

	JFrame frmGuessWho;
	private String playersName;
	/**
	 * Create the application.
	 */
	public Mainframe(String playersName) {
		this.playersName = playersName;
		initialize();
		
	}
	public Mainframe() {
		initialize();
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setTitle("Guess Who?\r\n");
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\logo2.jpg"));
		frmGuessWho.setBounds(100, 100, 450, 300);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		frmGuessWho.setResizable(false);
		
		JButton NewGameButton = new JButton("\u039D\u03AD\u03BF \u03A0\u03B1\u03B9\u03C7\u03BD\u03AF\u03B4\u03B9");
		NewGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGuessWho.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DifficultyFrame window = new DifficultyFrame(playersName);
							window.frmGuessWho.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		NewGameButton.setBounds(159, 49, 123, 25);
		frmGuessWho.getContentPane().add(NewGameButton);
		
		JButton button = new JButton("\u03A3\u03C4\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03AC");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGuessWho.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Statistics window = new Statistics(playersName);
							window.frmGuessWho.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button.setBounds(159, 99, 123, 25);
		frmGuessWho.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u039A\u03B1\u03C4\u03AC\u03C4\u03B1\u03BE\u03B7\r\n");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGuessWho.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Rank window = new Rank(playersName);
							window.frmGuessWho.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button_1.setBounds(159, 151, 123, 25);
		frmGuessWho.getContentPane().add(button_1);
		
		JButton LogOutButton = new JButton("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		LogOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGuessWho.dispose();
				StartMenu window = new StartMenu();
				window.frmGuessWho.setVisible(true);
			}
		});
		LogOutButton.setBounds(159, 198, 123, 25);
		frmGuessWho.getContentPane().add(LogOutButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(path + "//background4.jpg"));
		lblNewLabel.setBounds(0, 0, 452, 271);
		frmGuessWho.getContentPane().add(lblNewLabel);
	}
	
	public String getPlayersName() {
		return playersName;
	}
}
