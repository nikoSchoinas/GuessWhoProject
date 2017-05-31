package game;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class Rank {

	JFrame frmGuessWho;
	private DefaultListModel model_Names = new DefaultListModel();
	private String playersName;

	/**
	 * Create the application.
	 */
	public Rank(String playerName) {
		this.playersName=playerName;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path + "\\game\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		frmGuessWho.setTitle("Guess Who ?\r\n");
		frmGuessWho.setBounds(100, 100, 450, 300);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		FileEditor rankFile = new FileEditor();
		rankFile.sortList();
		ArrayList<GamerProfile> playersArray = rankFile.getRankFile();
		
		JButton BackButton = new JButton("Back\r\n");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGuessWho.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Mainframe window = new Mainframe(playersName);
							window.frmGuessWho.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		BackButton.setBounds(349, 117, 71, 25);
		frmGuessWho.getContentPane().add(BackButton);
		
		JList list_Name = new JList();
		for(int i =0;i<playersArray.size();i++){
			model_Names.addElement(playersArray.get(i).getName());
		}
		list_Name.setModel(model_Names);
		list_Name.setBounds(107, 29, 101, 221);
		frmGuessWho.getContentPane().add(list_Name);
		
		JLabel nameLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nameLabel.setBounds(122, 3, 100, 25);
		frmGuessWho.getContentPane().add(nameLabel);
		
		JLabel PointLabel = new JLabel("\u03A0\u03CC\u03BD\u03C4\u03BF\u03B9");
		PointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PointLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PointLabel.setBounds(234, 3, 100, 25);
		frmGuessWho.getContentPane().add(PointLabel);
			
		//JList list_1 = new JList();		
		
		/*list_1.setBounds(238, 29, 101, 221);
		frmGuessWho.getContentPane().add(list_1);*/
		
		JList list_Points = new JList();
		list_Points.setBounds(234, 29, 101, 221);
		DefaultListModel model_Points = new DefaultListModel();
		for(int i =0;i<playersArray.size();i++){
			model_Points.addElement(playersArray.get(i).getPoints());
		}
		list_Points.setModel(model_Points);
		frmGuessWho.getContentPane().add(list_Points);
		
		JLabel Background = new JLabel("New label");
		Background.setIcon(new ImageIcon(path + "\\Game\\18789887_10203173268287916_772035473_o.jpg"));
		Background.setBounds(0, -5, 442, 268);
		frmGuessWho.getContentPane().add(Background);
	}
}
