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
import java.awt.event.ActionEvent;

public class Statistics {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String path = System.getProperty("user.home") + "/Desktop/Game";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics window = new Statistics();
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
	public Statistics() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\student\\Desktop\\Game\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		frmGuessWho.setTitle("Guess Who?\r\n");
		frmGuessWho.setBounds(100, 100, 512, 379);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBack.setBounds(201, 276, 97, 25);
		frmGuessWho.getContentPane().add(btnBack);
		
		Name = new JLabel("New label");
		Name.setBounds(31, 127, 102, 39);
		frmGuessWho.getContentPane().add(Name);
		
		Points = new JLabel("New label");
		Points.setBounds(153, 130, 70, 33);
		frmGuessWho.getContentPane().add(Points);
		
		WinsEasy = new JLabel("New label");
		WinsEasy.setBounds(244, 77, 70, 39);
		frmGuessWho.getContentPane().add(WinsEasy);
		
		LoseEasy = new JLabel("New label");
		LoseEasy.setBounds(323, 77, 70, 39);
		frmGuessWho.getContentPane().add(LoseEasy);
		
		GamesEasy = new JLabel("New label");
		GamesEasy.setBounds(404, 77, 70, 39);
		frmGuessWho.getContentPane().add(GamesEasy);
		
		WinsHard = new JLabel("New label");
		WinsHard.setBounds(244, 206, 70, 33);
		frmGuessWho.getContentPane().add(WinsHard);
		
		LoseHard = new JLabel("New label");
		LoseHard.setBounds(323, 206, 70, 33);
		frmGuessWho.getContentPane().add(LoseHard);
		
		GamesHard = new JLabel("New label");
		GamesHard.setBounds(404, 206, 71, 33);
		frmGuessWho.getContentPane().add(GamesHard);
		
		JLabel name_label = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		name_label.setHorizontalAlignment(SwingConstants.CENTER);
		name_label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		name_label.setBounds(31, 91, 102, 25);
		frmGuessWho.getContentPane().add(name_label);
		
		JLabel points_label = new JLabel("\u03A0\u03CC\u03BD\u03C4\u03BF\u03B9");
		points_label.setHorizontalAlignment(SwingConstants.CENTER);
		points_label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		points_label.setBounds(143, 91, 68, 25);
		frmGuessWho.getContentPane().add(points_label);
		
		win_label_easy = new JLabel("\u039D\u03AF\u03BA\u03B5\u03C2");
		win_label_easy.setHorizontalAlignment(SwingConstants.CENTER);
		win_label_easy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		win_label_easy.setBounds(244, 41, 69, 25);
		frmGuessWho.getContentPane().add(win_label_easy);
		
		lose_label_easy = new JLabel("\u0389\u03C4\u03C4\u03B5\u03C2");
		lose_label_easy.setHorizontalAlignment(SwingConstants.CENTER);
		lose_label_easy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lose_label_easy.setBounds(323, 41, 70, 25);
		frmGuessWho.getContentPane().add(lose_label_easy);
		
		easy_level_label = new JLabel("\u0395\u03CD\u03BA\u03BF\u03BB\u03BF \u0395\u03C0\u03AF\u03C0\u03B5\u03B4\u03BF");
		easy_level_label.setHorizontalAlignment(SwingConstants.CENTER);
		easy_level_label.setFont(new Font("Times New Roman", Font.BOLD, 19));
		easy_level_label.setBounds(244, 11, 221, 33);
		frmGuessWho.getContentPane().add(easy_level_label);
		
		games_label_easy = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2");
		games_label_easy.setHorizontalAlignment(SwingConstants.CENTER);
		games_label_easy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		games_label_easy.setBounds(403, 41, 70, 25);
		frmGuessWho.getContentPane().add(games_label_easy);
		
		lose_label_hard = new JLabel("\u0389\u03C4\u03C4\u03B5\u03C2");
		lose_label_hard.setHorizontalAlignment(SwingConstants.CENTER);
		lose_label_hard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lose_label_hard.setBounds(323, 171, 70, 25);
		frmGuessWho.getContentPane().add(lose_label_hard);
		
		wins_label_hard = new JLabel("\u039D\u03AF\u03BA\u03B5\u03C2");
		wins_label_hard.setHorizontalAlignment(SwingConstants.CENTER);
		wins_label_hard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		wins_label_hard.setBounds(244, 171, 69, 25);
		frmGuessWho.getContentPane().add(wins_label_hard);
		
		games_label_hard = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2");
		games_label_hard.setHorizontalAlignment(SwingConstants.CENTER);
		games_label_hard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		games_label_hard.setBounds(403, 171, 70, 25);
		frmGuessWho.getContentPane().add(games_label_hard);
		
		hard_level_label = new JLabel("\u0394\u03CD\u03C3\u03BA\u03BF\u03BB\u03BF \u0395\u03C0\u03AF\u03C0\u03B5\u03B4\u03BF");
		hard_level_label.setHorizontalAlignment(SwingConstants.CENTER);
		hard_level_label.setFont(new Font("Times New Roman", Font.BOLD, 19));
		hard_level_label.setBounds(244, 127, 230, 33);
		frmGuessWho.getContentPane().add(hard_level_label);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\student\\Desktop\\Game\\background_main.jpg"));
		background.setBounds(0, 0, 625, 405);
		frmGuessWho.getContentPane().add(background);
	}
}
