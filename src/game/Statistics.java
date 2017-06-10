package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Statistics {

	//Variables' declarations
	private String playersName;
	JFrame frmGuessWho;
	private JLabel win_label_easy;
	private JLabel lose_label_easy;
	private JLabel easy_level_label;
	private JLabel games_label_easy;
	private JLabel wins_label_hard;
	private JLabel lose_label_hard;
	private JLabel games_label_hard;
	private JLabel hard_level_label;
	private JLabel background;
	private JLabel Name;
	private JLabel Points;
	private JLabel WinsEasy;
	private JLabel LoseEasy;
	private JLabel GamesEasy;
	private JLabel WinsHard;
	private JLabel LoseHard;
	private JLabel GamesHard;
	private JLabel lblNewLabel;
	

	/**
	 * Create the application.
	 */
	public Statistics(String playersName) {
		this.playersName = playersName;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Panel's Creation
		String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path + "\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		frmGuessWho.setTitle("Guess Who?\r\n");
		frmGuessWho.setBounds(100, 100, 512, 355);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		frmGuessWho.setResizable(false);
		
		//Button which goes back in the previous window or action
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGuessWho.dispose();
				Mainframe window = new Mainframe(playersName);
				window.frmGuessWho.setVisible(true);
			}
		});
		btnBack.setBounds(201, 276, 97, 25);
		frmGuessWho.getContentPane().add(btnBack);
		
		//Create a file , where the rank is saved
		FileEditor rankFile = new FileEditor();
		int nameIndex = rankFile.searchEditor(playersName);
		ArrayList<GamerProfile> playersArray = rankFile.getRankFile();
		Name = new JLabel(playersArray.get(nameIndex).getName());
		Name.setFont(new Font("Tahoma", Font.BOLD, 13));
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setForeground(Color.BLACK);
		Name.setBackground(Color.LIGHT_GRAY);
		Name.setBounds(31, 127, 102, 39);
		frmGuessWho.getContentPane().add(Name);
		
		//The function which calculates the points and add them to the player's profile
		Points = new JLabel(Integer.toString(playersArray.get(nameIndex).getPoints()));
		Points.setForeground(Color.BLACK);
		Points.setFont(new Font("Tahoma", Font.BOLD, 13));
		Points.setHorizontalAlignment(SwingConstants.CENTER);
		Points.setBackground(Color.LIGHT_GRAY);
		Points.setBounds(153, 127, 46, 39);
		frmGuessWho.getContentPane().add(Points);
		
		//The function that counts the player's wins at easy level
		WinsEasy = new JLabel(Integer.toString(playersArray.get(nameIndex).getWinsEasy()));
		WinsEasy.setForeground(Color.BLACK);
		WinsEasy.setFont(new Font("Tahoma", Font.BOLD, 13));
		WinsEasy.setHorizontalAlignment(SwingConstants.CENTER);
		WinsEasy.setBackground(Color.LIGHT_GRAY);
		WinsEasy.setBounds(232, 77, 70, 39);
		frmGuessWho.getContentPane().add(WinsEasy);
		
		//The function that counts the player's loses at easy level
		LoseEasy = new JLabel(Integer.toString(playersArray.get(nameIndex).getLosesEasy()));
		LoseEasy.setForeground(Color.BLACK);
		LoseEasy.setFont(new Font("Tahoma", Font.BOLD, 13));
		LoseEasy.setHorizontalAlignment(SwingConstants.CENTER);
		LoseEasy.setBackground(Color.LIGHT_GRAY);
		LoseEasy.setBounds(311, 77, 70, 39);
		frmGuessWho.getContentPane().add(LoseEasy);
		
		//The function that counts the player's games at easy level
		GamesEasy = new JLabel(Integer.toString(playersArray.get(nameIndex).getNumberOfEasy()));
		GamesEasy.setForeground(Color.BLACK);
		GamesEasy.setFont(new Font("Tahoma", Font.BOLD, 13));
		GamesEasy.setHorizontalAlignment(SwingConstants.CENTER);
		GamesEasy.setBackground(Color.LIGHT_GRAY);
		GamesEasy.setBounds(391, 77, 70, 39);
		frmGuessWho.getContentPane().add(GamesEasy);
		
		//The function that counts the player's wins at hard level
		WinsHard = new JLabel(Integer.toString(playersArray.get(nameIndex).getWinsHard()));
		WinsHard.setForeground(Color.BLACK);
		WinsHard.setFont(new Font("Tahoma", Font.BOLD, 13));
		WinsHard.setHorizontalAlignment(SwingConstants.CENTER);
		WinsHard.setBackground(Color.LIGHT_GRAY);
		WinsHard.setBounds(232, 206, 70, 33);
		frmGuessWho.getContentPane().add(WinsHard);
		
		//The function that counts the player's loses at hard level
		LoseHard = new JLabel(Integer.toString(playersArray.get(nameIndex).getLosesHard()));
		LoseHard.setForeground(Color.BLACK);
		LoseHard.setFont(new Font("Tahoma", Font.BOLD, 13));
		LoseHard.setHorizontalAlignment(SwingConstants.CENTER);
		LoseHard.setBackground(Color.LIGHT_GRAY);
		LoseHard.setBounds(311, 206, 70, 33);
		frmGuessWho.getContentPane().add(LoseHard);
		
		//The function that counts the player's games at hard level
		GamesHard = new JLabel(Integer.toString(playersArray.get(nameIndex).getNumberOfHard()));
		GamesHard.setForeground(Color.BLACK);
		GamesHard.setFont(new Font("Tahoma", Font.BOLD, 13));
		GamesHard.setHorizontalAlignment(SwingConstants.CENTER);
		GamesHard.setBackground(Color.LIGHT_GRAY);
		GamesHard.setBounds(391, 206, 70, 33);
		frmGuessWho.getContentPane().add(GamesHard);
		
		//The label shows the player's username
		JLabel name_label = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		name_label.setForeground(Color.BLACK);
		name_label.setHorizontalAlignment(SwingConstants.CENTER);
		name_label.setFont(new Font("Tahoma", Font.BOLD, 20));
		name_label.setBounds(31, 91, 102, 25);
		frmGuessWho.getContentPane().add(name_label);
		
		//The label shows the player's points
		JLabel points_label = new JLabel("\u03A0\u03CC\u03BD\u03C4\u03BF\u03B9");
		points_label.setForeground(Color.BLACK);
		points_label.setHorizontalAlignment(SwingConstants.CENTER);
		points_label.setFont(new Font("Tahoma", Font.BOLD, 20));
		points_label.setBounds(143, 91, 68, 25);
		frmGuessWho.getContentPane().add(points_label);
		
		//The label shows the player's wins at easy level
		win_label_easy = new JLabel("\u039D\u03AF\u03BA\u03B5\u03C2");
		win_label_easy.setForeground(Color.BLACK);
		win_label_easy.setHorizontalAlignment(SwingConstants.CENTER);
		win_label_easy.setFont(new Font("Tahoma", Font.BOLD, 20));
		win_label_easy.setBounds(232, 41, 69, 25);
		frmGuessWho.getContentPane().add(win_label_easy);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(20, 87, 202, 95);
		frmGuessWho.getContentPane().add(lblNewLabel);
		
		//The label shows the player's loses at easy level
		lose_label_easy = new JLabel("\u0389\u03C4\u03C4\u03B5\u03C2");
		lose_label_easy.setForeground(Color.BLACK);
		lose_label_easy.setHorizontalAlignment(SwingConstants.CENTER);
		lose_label_easy.setFont(new Font("Tahoma", Font.BOLD, 20));
		lose_label_easy.setBounds(311, 41, 70, 25);
		frmGuessWho.getContentPane().add(lose_label_easy);
		
		//The label for the title "Easy Level"
		easy_level_label = new JLabel("\u0395\u03C0\u03AF\u03C0\u03B5\u03B4\u03BF \u0395\u03CD\u03BA\u03BF\u03BB\u03BF");
		easy_level_label.setForeground(Color.BLACK);
		easy_level_label.setBackground(Color.WHITE);
		easy_level_label.setHorizontalAlignment(SwingConstants.CENTER);
		easy_level_label.setFont(new Font("Tahoma", Font.BOLD, 20));
		easy_level_label.setBounds(242, 11, 230, 33);
		frmGuessWho.getContentPane().add(easy_level_label);
		
		//The label shows the player's games at easy level
		games_label_easy = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2");
		games_label_easy.setForeground(Color.BLACK);
		games_label_easy.setHorizontalAlignment(SwingConstants.CENTER);
		games_label_easy.setFont(new Font("Tahoma", Font.BOLD, 20));
		games_label_easy.setBounds(391, 41, 83, 25);
		frmGuessWho.getContentPane().add(games_label_easy);
		
		//The label shows the player's loses at hard level
		lose_label_hard = new JLabel("\u0389\u03C4\u03C4\u03B5\u03C2");
		lose_label_hard.setForeground(Color.BLACK);
		lose_label_hard.setHorizontalAlignment(SwingConstants.CENTER);
		lose_label_hard.setFont(new Font("Tahoma", Font.BOLD, 20));
		lose_label_hard.setBounds(311, 170, 70, 25);
		frmGuessWho.getContentPane().add(lose_label_hard);
		
		//The label shows the player's wins at hard level
		wins_label_hard = new JLabel("\u039D\u03AF\u03BA\u03B5\u03C2");
		wins_label_hard.setForeground(Color.BLACK);
		wins_label_hard.setHorizontalAlignment(SwingConstants.CENTER);
		wins_label_hard.setFont(new Font("Tahoma", Font.BOLD, 20));
		wins_label_hard.setBounds(232, 170, 69, 25);
		frmGuessWho.getContentPane().add(wins_label_hard);
		
		//The label shows the player's games at hard level
		games_label_hard = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2");
		games_label_hard.setForeground(Color.BLACK);
		games_label_hard.setHorizontalAlignment(SwingConstants.CENTER);
		games_label_hard.setFont(new Font("Tahoma", Font.BOLD, 20));
		games_label_hard.setBounds(391, 170, 83, 25);
		frmGuessWho.getContentPane().add(games_label_hard);
		
		//The label for the title "Hard Level"
		hard_level_label = new JLabel("\u0395\u03C0\u03AF\u03C0\u03B5\u03B4\u03BF \u0394\u03CD\u03C3\u03BA\u03BF\u03BB\u03BF");
		hard_level_label.setForeground(Color.BLACK);
		hard_level_label.setBackground(Color.LIGHT_GRAY);
		hard_level_label.setHorizontalAlignment(SwingConstants.CENTER);
		hard_level_label.setFont(new Font("Tahoma", Font.BOLD, 20));
		hard_level_label.setBounds(244, 138, 230, 33);
		frmGuessWho.getContentPane().add(hard_level_label);
		
		//Background's Creation
		background = new JLabel("");
		background.setIcon(new ImageIcon(path + "//background4.jpg"));
		background.setBounds(0, 0, 506, 327);
		frmGuessWho.getContentPane().add(background);
	}
}
