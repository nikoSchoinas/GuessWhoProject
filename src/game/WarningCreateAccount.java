package game;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class WarningCreateAccount {

	public JFrame frmGuessWho;
	private String output;


	/**
	 * Create the application.
	 */
	public WarningCreateAccount(String output) {
		this.output = output;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setTitle("Guess Who?");
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path +"\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		frmGuessWho.setBounds(100, 100, 553, 207);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		frmGuessWho.setResizable(false);
		
		//ok button that dispose the window and return to account creation window
		JButton OkButton = new JButton("OK");
		OkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGuessWho.dispose();
			}
		});
		OkButton.setBounds(208, 96, 123, 37);
		frmGuessWho.getContentPane().add(OkButton);
		
		JLabel WarningMessage = new JLabel(output);
		WarningMessage.setFont(new Font("Times New Roman", Font.BOLD, 21));
		WarningMessage.setHorizontalAlignment(SwingConstants.CENTER);
		WarningMessage.setBounds(22, 41, 501, 42);
		frmGuessWho.getContentPane().add(WarningMessage);
	}
}
