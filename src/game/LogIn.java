package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LogIn {

	public JFrame frmGuessWho;
	private JTextField AccountName;
	private int find=0;
	private String playersName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setTitle("Guess Who ?\r\n");
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\logo2.jpg"));
		frmGuessWho.setBounds(100, 100, 450, 300);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		frmGuessWho.setResizable(false);
		
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
		
		JLabel label = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label.setBounds(121, 96, 87, 32);
		frmGuessWho.getContentPane().add(label);
		
		AccountName = new JTextField();//text field for the account name
		label.setLabelFor(AccountName);
		AccountName.setBounds(196, 104, 116, 22);
		frmGuessWho.getContentPane().add(AccountName);
		AccountName.setColumns(10);
		
	
	
		JButton LogInButton = new JButton("\u0395\u03AF\u03C3\u03BF\u03B4\u03BF\u03C2\r\n");
		LogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playersName = AccountName.getText();	
				FileEditor rankFile = new FileEditor();
				find = rankFile.searchEditor(playersName);//checking file for the given user name
				if(find==-1){							 //if the file doesn't contain this name
					WarningLogIn window = new WarningLogIn();//creates a warning window
					window.frmGuessWho.setVisible(true);
				}
				else
				{
					frmGuessWho.dispose();
					Mainframe window = new Mainframe(playersName);//the user was found and the main menu is opening
					window.frmGuessWho.setVisible(true);
				}
			}
		});
		LogInButton.setBounds(182, 141, 99, 25);
		frmGuessWho.getContentPane().add(LogInButton);
		frmGuessWho.getRootPane().setDefaultButton(LogInButton);//set enter default button so it can be use by pressing enter
		
		JLabel Background = new JLabel("New label");//background label
		Background.setIcon(new ImageIcon(path + "//background4.jpg"));
		Background.setBounds(0, 0, 444, 272);
		frmGuessWho.getContentPane().add(Background);
		frmGuessWho.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmGuessWho.getContentPane(), Background}));
		
	}


	
	
	

}
