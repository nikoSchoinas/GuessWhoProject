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
	private int find =0;//using this variable to find the user in the file

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
		String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\logo2.jpg"));
		frmGuessWho.setTitle("Guess Who ?");
		frmGuessWho.setBounds(100, 100, 450, 300);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		frmGuessWho.setResizable(false);
		
		
		JButton BackButton = new JButton("Back");//back button that dispose window 
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
		
		JButton CreateButton = new JButton("\u0394\u03B7\u03BC\u03B9\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1");//account creation button
		CreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
						String playersName = AccountName.getText();	
						FileEditor rankFile = new FileEditor();
						find = rankFile.searchEditor(playersName);// searching the file for the given account name.
						AccountName.setText("");
						try {
							if(find==-1){//if the file doesn't contain the account name
								if(playersName.contains(" ")){//check if the given name has spaces.
									EventQueue.invokeLater(new Runnable() {
										public void run() {
											try {
												WarningCreateAccount window = new WarningCreateAccount("\u03A4\u03BF \u03CC\u03BD\u03BF\u03BC\u03B1 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7 \u03B4\u03B5\u03BD \u03B5\u03C0\u03B9\u03C4\u03C1\u03AD\u03C0\u03B5\u03C4\u03B1\u03B9 \u03BD\u03B1 \u03C0\u03B5\u03C1\u03B9\u03AD\u03C7\u03B5\u03B9 \u03BA\u03B5\u03BD\u03AC ! ");
												window.frmGuessWho.setVisible(true);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									});
								}
								else{
									rankFile.createProfile(playersName);//Create account and  write it in the file.
									rankFile.writeFile("statistics.txt");
									frmGuessWho.dispose();
									Mainframe window = new Mainframe(playersName);
									window.frmGuessWho.setVisible(true);
								}
							}
							else {//If the name is already in used
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											WarningCreateAccount window = new WarningCreateAccount("\u03A4\u03BF \u03CC\u03BD\u03BF\u03BC\u03B1 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7 \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 \u03AE\u03B4\u03B7 ! ");
											window.frmGuessWho.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			
			

		
	
		CreateButton.setBounds(182, 141, 99, 25);
		frmGuessWho.getContentPane().add(CreateButton);
		frmGuessWho.getRootPane().setDefaultButton(CreateButton);
		
		JLabel Name_Label = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1:");
		Name_Label.setFont(new Font("Times New Roman", Font.BOLD, 21));
		Name_Label.setBounds(121, 96, 87, 32);
		frmGuessWho.getContentPane().add(Name_Label);
		
		AccountName = new JTextField();//text field for the account name of the user
		Name_Label.setLabelFor(AccountName);
		AccountName.setBounds(196, 104, 116, 22);
		frmGuessWho.getContentPane().add(AccountName);
		AccountName.setColumns(10);
		
		
		JLabel Background = new JLabel("New label");//background label
		Background.setIcon(new ImageIcon(path + "//background4.jpg"));
		Background.setBounds(0, 0, 442, 268);
		frmGuessWho.getContentPane().add(Background);
	}
	
	
}
