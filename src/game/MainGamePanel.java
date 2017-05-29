package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGamePanel {

	JFrame frmGuessWho;
	private int p7 = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGamePanel window = new MainGamePanel();
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
	public MainGamePanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ArrayList<Face> faceslist = new ArrayList<Face>();
		ArrayList<Question> questionlist = new ArrayList<Question>();

		Initialization.setFaces();//initialize faces of the game
		faceslist = Initialization.getFaceslist();//save faces into arraylist
		Initialization.setQuestion();
		questionlist = Initialization.getQuestionlist();//save questions into arraylist
		Question playerQuestion = null ;

		String path = System.getProperty("user.home") + "/Desktop/Game";
		frmGuessWho = new JFrame();
		frmGuessWho.setTitle("Guess Who");
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\game\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		frmGuessWho.setBounds(100, 100, 1068, 738);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);

		JLabel player1 = new JLabel("New label");
		player1.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03C5\u03B3\u03BF\u03C5\u03C3\u03C4\u03AF\u03BD\u03BF\u03C2.jpg"));
		player1.setBounds(588, 221, 74, 104);
		frmGuessWho.getContentPane().add(player1);

		JLabel player2 = new JLabel("New label");
		player2.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03B4\u03C1\u03B9\u03B1\u03BD\u03CC\u03C2.jpg"));
		player2.setBounds(502, 221, 74, 104);
		frmGuessWho.getContentPane().add(player2);

		JLabel player3 = new JLabel("New label");
		player3.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03B3\u03BD\u03B7.jpg"));
		player3.setBounds(416, 221, 74, 104);
		frmGuessWho.getContentPane().add(player3);

		JLabel player4 = new JLabel("New label");
		player4.setIcon(new ImageIcon(path + "\\players_icon\\\u0392\u03B1\u03C1\u03B8\u03BF\u03BB\u03BF\u03BC\u03B1\u03AF\u03BF\u03C2.jpg"));
		player4.setBounds(674, 221, 74, 104);
		frmGuessWho.getContentPane().add(player4);

		JLabel player5 = new JLabel("New label");
		player5.setIcon(new ImageIcon(path + "\\players_icon\\\u0392\u03AF\u03BA\u03C4\u03C9\u03C1.jpg"));
		player5.setBounds(760, 221, 74, 104);
		frmGuessWho.getContentPane().add(player5);

		JLabel player6 = new JLabel("New label");
		player6.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03B3\u03B1\u03B8\u03AE.jpg"));
		player6.setBounds(330, 221, 74, 104);
		frmGuessWho.getContentPane().add(player6);

		JLabel player7 = new JLabel("New label");

		player7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(p7==1){
					player7.setIcon(new ImageIcon(path + "\\backofcards.png"));
					p7=0;
				}else{
					player7.setIcon(new ImageIcon(path + "\\players_icon\\\u0393\u03B5\u03CE\u03C1\u03B3\u03B9\u03BF\u03C2.jpg"));
					p7=1;}
			}
		});
		player7.setIcon(new ImageIcon(path + "\\players_icon\\\u0393\u03B5\u03CE\u03C1\u03B3\u03B9\u03BF\u03C2.jpg"));
		player7.setBounds(330, 338, 74, 104);
		frmGuessWho.getContentPane().add(player7);

		JLabel player8 = new JLabel("New label");
		player8.setIcon(new ImageIcon(path + "\\players_icon\\\u0393\u03C1\u03B7\u03B3\u03CC\u03C1\u03B9\u03BF\u03C2.jpg"));
		player8.setBounds(416, 338, 74, 104);
		frmGuessWho.getContentPane().add(player8);

		JLabel player9 = new JLabel("");
		player9.setIcon(new ImageIcon(path + "\\players_icon\\\u0394\u03B1\u03BC\u03B9\u03B1\u03BD\u03CC\u03C2.jpg"));
		player9.setForeground(Color.WHITE);
		player9.setBackground(Color.WHITE);
		player9.setBounds(502, 338, 74, 104);
		frmGuessWho.getContentPane().add(player9);

		JLabel player10 = new JLabel("");
		player10.setIcon(new ImageIcon(path + "\\players_icon\\\u0394\u03B7\u03BC\u03AE\u03C4\u03C1\u03B9\u03BF\u03C2.jpg"));
		player10.setForeground(Color.WHITE);
		player10.setBackground(Color.WHITE);
		player10.setBounds(588, 338, 74, 104);
		frmGuessWho.getContentPane().add(player10);

		JLabel player11 = new JLabel("");
		player11.setIcon(new ImageIcon(path + "\\players_icon\\\u0395\u03BB\u03B9\u03C3\u03AC\u03B2\u03B5\u03C4.jpg"));
		player11.setForeground(Color.WHITE);
		player11.setBackground(Color.WHITE);
		player11.setBounds(674, 338, 74, 104);
		frmGuessWho.getContentPane().add(player11);

		JLabel player12 = new JLabel("");
		player12.setIcon(new ImageIcon(path + "\\players_icon\\\u0395\u03BC\u03BC\u03B1\u03BD\u03BF\u03C5\u03AE\u03BB.jpg"));
		player12.setForeground(Color.WHITE);
		player12.setBackground(Color.WHITE);
		player12.setBounds(760, 338, 74, 104);
		frmGuessWho.getContentPane().add(player12);

		JLabel player13 = new JLabel("new");
		player13.setIcon(new ImageIcon(path + "\\players_icon\\\u0395\u03C5\u03B3\u03AD\u03BD\u03B9\u03BF\u03C2.jpg"));
		player13.setForeground(Color.WHITE);
		player13.setBackground(Color.WHITE);
		player13.setBounds(330, 455, 74, 104);
		frmGuessWho.getContentPane().add(player13);

		JLabel player14 = new JLabel("new");
		player14.setIcon(new ImageIcon(path + "\\players_icon\\\u0397\u03BB\u03AF\u03B1\u03C2.jpg"));
		player14.setForeground(Color.WHITE);
		player14.setBackground(Color.WHITE);
		player14.setBounds(416, 455, 74, 104);
		frmGuessWho.getContentPane().add(player14);

		JLabel player15 = new JLabel("new");
		player15.setIcon(new ImageIcon(path + "\\players_icon\\\u0398\u03C9\u03BC\u03AC\u03C2.jpg"));
		player15.setForeground(Color.WHITE);
		player15.setBackground(Color.WHITE);
		player15.setBounds(502, 455, 74, 104);
		frmGuessWho.getContentPane().add(player15);

		JLabel player16 = new JLabel("new");
		player16.setIcon(new ImageIcon(path + "\\players_icon\\\u0399\u03AC\u03C3\u03C9\u03BD.jpg"));
		player16.setForeground(Color.WHITE);
		player16.setBackground(Color.WHITE);
		player16.setBounds(588, 455, 74, 104);
		frmGuessWho.getContentPane().add(player16);

		JLabel player17 = new JLabel("new");
		player17.setIcon(new ImageIcon(path + "\\players_icon\\\u0399\u03BF\u03C1\u03B4\u03AC\u03BD\u03B7\u03C2.jpg"));
		player17.setForeground(Color.WHITE);
		player17.setBackground(Color.WHITE);
		player17.setBounds(674, 455, 74, 104);
		frmGuessWho.getContentPane().add(player17);

		JLabel player18 = new JLabel("new");
		player18.setIcon(new ImageIcon(path + "\\players_icon\\\u0399\u03C9\u03B1\u03BA\u03B5\u03AF\u03BC.jpg"));
		player18.setHorizontalAlignment(SwingConstants.LEFT);
		player18.setForeground(Color.WHITE);
		player18.setBackground(Color.WHITE);
		player18.setBounds(760, 455, 74, 104);
		frmGuessWho.getContentPane().add(player18);

		JLabel player19 = new JLabel("new");
		player19.setIcon(new ImageIcon(path + "\\players_icon\\\u039B\u03C5\u03B4\u03AF\u03B1.jpg"));
		player19.setForeground(Color.WHITE);
		player19.setBackground(Color.WHITE);
		player19.setBounds(330, 568, 74, 104);
		frmGuessWho.getContentPane().add(player19);

		JLabel player20 = new JLabel("new");
		player20.setIcon(new ImageIcon(path + "\\players_icon\\\u039C\u03B1\u03B3\u03B4\u03B1\u03BB\u03B7\u03BD\u03AE.jpg"));
		player20.setForeground(Color.WHITE);
		player20.setBackground(Color.WHITE);
		player20.setBounds(416, 568, 74, 104);
		frmGuessWho.getContentPane().add(player20);

		JLabel player21 = new JLabel("new");
		player21.setIcon(new ImageIcon(path + "\\players_icon\\\u039C\u03AC\u03BE\u03B9\u03BC\u03BF\u03C2.jpg"));
		player21.setForeground(Color.WHITE);
		player21.setBackground(Color.WHITE);
		player21.setBounds(502, 568, 74, 104);
		frmGuessWho.getContentPane().add(player21);

		JLabel player22 = new JLabel("new");
		player22.setIcon(new ImageIcon(path + "\\players_icon\\\u039C\u03B9\u03C7\u03B1\u03AE\u03BB.jpg"));
		player22.setForeground(Color.WHITE);
		player22.setBackground(Color.WHITE);
		player22.setBounds(588, 568, 74, 104);
		frmGuessWho.getContentPane().add(player22);

		JLabel player23 = new JLabel("new");
		player23.setIcon(new ImageIcon(path + "\\players_icon\\\u03A1\u03B5\u03B2\u03AD\u03BA\u03BA\u03B1.jpg"));
		player23.setForeground(Color.WHITE);
		player23.setBackground(Color.WHITE);
		player23.setBounds(674, 568, 74, 104);
		frmGuessWho.getContentPane().add(player23);

		JLabel player24 = new JLabel("new");
		player24.setIcon(new ImageIcon(path + "\\players_icon\\\u03A4\u03B1\u03C4\u03B9\u03B1\u03BD\u03AE.jpg"));
		player24.setForeground(Color.WHITE);
		player24.setBackground(Color.WHITE);
		player24.setBounds(760, 568, 74, 104);
		frmGuessWho.getContentPane().add(player24);

		JButton yesButton = new JButton("\u039D\u03B1\u03B9");
		yesButton.setBounds(632, 168, 97, 25);
		frmGuessWho.getContentPane().add(yesButton);

		JButton noButton = new JButton("\u039F\u03C7\u03B9");
		noButton.setBounds(741, 168, 97, 25);
		frmGuessWho.getContentPane().add(noButton);

		JButton okButton = new JButton("\u039F\u039A");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		okButton.setBounds(97, 410, 97, 25);
		frmGuessWho.getContentPane().add(okButton);

		JLabel PlayersLeftForMe = new JLabel("7");
		PlayersLeftForMe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PlayersLeftForMe.setBounds(872, 433, 56, 25);
		frmGuessWho.getContentPane().add(PlayersLeftForMe);

		JLabel NumberOfPlayers = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03C0\u03B1\u03B9\u03BA\u03C4\u03CE\u03BD:\r\n");
		NumberOfPlayers.setFont(new Font("Tahoma", Font.BOLD, 16));
		NumberOfPlayers.setBounds(871, 357, 149, 25);
		frmGuessWho.getContentPane().add(NumberOfPlayers);

		JLabel PlayersLeftForEnemy = new JLabel("10");
		PlayersLeftForEnemy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PlayersLeftForEnemy.setBounds(982, 433, 56, 25);
		frmGuessWho.getContentPane().add(PlayersLeftForEnemy);

		JLabel BackgroundForPlayer = new JLabel("New label");
		BackgroundForPlayer.setIcon(new ImageIcon(path + "\\questionbackground1.png"));
		BackgroundForPlayer.setBounds(846, 410, 66, 72);
		frmGuessWho.getContentPane().add(BackgroundForPlayer);

		JLabel Options = new JLabel("");
		Options.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {

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
		});
		Options.setIcon(new ImageIcon(path + "\\options1 - \u0391\u03BD\u03C4\u03AF\u03B3\u03C1\u03B1\u03C6\u03BF.png"));
		Options.setBounds(34, 617, 74, 63);
		frmGuessWho.getContentPane().add(Options);

		JLabel PlayerTitleForNumberLeft = new JLabel("\u03A0\u03B1\u03AF\u03BA\u03C4\u03B7\u03C2:");
		PlayerTitleForNumberLeft.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PlayerTitleForNumberLeft.setBounds(856, 381, 56, 16);
		frmGuessWho.getContentPane().add(PlayerTitleForNumberLeft);

		JLabel BckgroundForEnemy = new JLabel("New label");
		BckgroundForEnemy.setIcon(new ImageIcon(path + "\\questionbackground1.png"));
		BckgroundForEnemy.setBounds(961, 410, 66, 72);
		frmGuessWho.getContentPane().add(BckgroundForEnemy);

		JLabel EnemyTitleForNumberLeft = new JLabel("\u0391\u03BD\u03C4\u03AF\u03C0\u03B1\u03BB\u03BF\u03C2:");
		EnemyTitleForNumberLeft.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EnemyTitleForNumberLeft.setBounds(961, 381, 77, 16);
		frmGuessWho.getContentPane().add(EnemyTitleForNumberLeft);

		JLabel question_title = new JLabel("\u0395\u03C1\u03C9\u03C4\u03AE\u03C3\u03B5\u03B9\u03C2:");
		question_title.setFont(new Font("Tahoma", Font.PLAIN, 16));
		question_title.setBounds(97, 47, 127, 25);
		frmGuessWho.getContentPane().add(question_title);

		JLabel enemy_photo = new JLabel("New label");
		enemy_photo.setIcon(new ImageIcon(path + "\\question_face1.png"));
		enemy_photo.setBounds(487, 37, 102, 132);
		frmGuessWho.getContentPane().add(enemy_photo);

		JLabel background_photo_enemy = new JLabel("New label");
		background_photo_enemy.setIcon(new ImageIcon(path + "\\questionbackground1.png"));
		background_photo_enemy.setBounds(474, 18, 127, 170);
		frmGuessWho.getContentPane().add(background_photo_enemy);

		JLabel playersicon = new JLabel("New label");
		playersicon.setIcon(new ImageIcon(path + "\\players_icon\\\u0393\u03B5\u03CE\u03C1\u03B3\u03B9\u03BF\u03C2.jpg"));
		playersicon.setBounds(906, 553, 74, 104);
		frmGuessWho.getContentPane().add(playersicon);

		JLabel playersbackground = new JLabel("New label");
		playersbackground.setIcon(new ImageIcon(path + "\\questionbackground1.png"));
		playersbackground.setBounds(890, 537, 102, 132);
		frmGuessWho.getContentPane().add(playersbackground);

		JLabel labelplayersicon = new JLabel("\u039F \u03C0\u03B1\u03AF\u03BA\u03C4\u03B7\u03C2 \u03C3\u03BF\u03C5:");
		labelplayersicon.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelplayersicon.setBounds(875, 499, 133, 46);
		frmGuessWho.getContentPane().add(labelplayersicon);

		/*JLabel cloud = new JLabel("");
		cloud.setIcon(new ImageIcon(path + "\\cloud1.png"));
		cloud.setBounds(572, 18, 320, 149);
		frmGuessWho.getContentPane().add(cloud);*/

		DefaultListModel<String> model = new DefaultListModel<String>();
		for(Question q : questionlist){
			if (q.getCodeQuestion()== 11)
				model.addElement("Is your player a " +q.getCharacteristic() + " ?");
			model.addElement("Does your player have " +q.getCharacteristic() + " ?");
		}

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(path + "\\MainBackround.jpg"));
		background.setBounds(0, 0, 1050, 693);
		frmGuessWho.getContentPane().add(background);
		JList<String> questionList = new JList<String>(model);
		questionList.setFont(new Font("Tahoma", Font.BOLD, 12));
		questionList.setFixedCellHeight(25);
		questionList.setBounds(10, 83, 284, 307);
		frmGuessWho.getContentPane().add(questionList);


	}
}
