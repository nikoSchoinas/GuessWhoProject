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

import com.ibm.icu.impl.duration.TimeUnit;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MainGamePanel {

	static JFrame frmGuessWho;


	private ArrayList<Integer> facesCover;
	private int uncoveredFacesCounter;

	private boolean playerTurn; /*when this variables are false opponent cannot push buttons*/
	private boolean enemyTurn;
	private boolean wizardTurn;

	private String text;

	private ArrayList<Face> faceslist;
	private ArrayList<Question> questionList;
	private DefaultListModel<String> model;

	private ArrayList<Face> enemyFacesList;
	private ArrayList<Question> enemyQuestionList;
	private boolean playerResponse;

	private Question playerQuestion;
	private Face selectedFace;

	private int selectedFaceCode;
	private int difficultyLevel;
	private int selectedQuestionIndex;//enemy's


	private int playerQuestionIndex;
	private Enemy enemy;
	private Face enemyFace;
	private int lastFaceCode;
	private static String path = System.getProperty("user.home") + "/Desktop/Game";
	
	private Wizard wizard;
	private JList questionJList;


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

	public MainGamePanel(int levelSelection, int selectedFaceCode) {
		difficultyLevel = levelSelection;
		this.selectedFaceCode = selectedFaceCode;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		faceslist = new ArrayList<Face>();
		questionList = new ArrayList<Question>();
		enemyFacesList = new ArrayList<Face>();
		enemyQuestionList = new ArrayList<Question>();
		facesCover = new ArrayList<Integer>();
		model = new DefaultListModel<String>();
		playerTurn = true;
		enemyTurn = false;
		wizardTurn = true;
		playerQuestion = null;
		questionJList = new JList();
		

		
		facesCover.add(null);
		for(int i=1;i<25;i++)
			facesCover.add(i, 1);
		Initialization.setFaces();//initialize faces of the game
		faceslist = Initialization.getFaceslist();//save faces into arraylist
		for(Face face : faceslist){
			if(face.getCodeFace()==selectedFaceCode){
				selectedFace = face;
			}
		}
		Initialization.setQuestion();
		questionList = Initialization.getQuestionlist();//save questions into arraylist
		enemyFacesList.addAll(faceslist);
		enemyQuestionList.addAll(questionList);


		frmGuessWho = new JFrame();
		frmGuessWho.setTitle("Guess Who");
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\game\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		frmGuessWho.setBounds(100, 100, 1068, 738);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);

		enemy = new Enemy(enemyFacesList);
		enemyFace = enemy.selectFace();
		wizard = new Wizard(faceslist);

		text = "Επιλέξτε Ερώτηση";
		JTextArea textArea = new JTextArea(text);
		textArea.setEditable(false);
		textArea.setBounds(658, 40, 191, 72);
		frmGuessWho.getContentPane().add(textArea);

		JLabel player1 = new JLabel("New label");
		player1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(1)==1){
					player1.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(1, 0);
				}else{
					player1.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03B3\u03B1\u03B8\u03AE.jpg"));
					facesCover.set(1, 1);}
			}
		});
		player1.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03B3\u03B1\u03B8\u03AE.jpg"));
		player1.setBounds(330, 221, 74, 104);
		frmGuessWho.getContentPane().add(player1);

		JLabel player2 = new JLabel("New label");
		player2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(2)==1){
					player2.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(2, 0);
				}else{
					player2.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03B3\u03BD\u03B7.jpg"));
					facesCover.set(2, 1);}
			}
		});
		player2.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03B3\u03BD\u03B7.jpg"));
		player2.setBounds(416, 221, 74, 104);
		frmGuessWho.getContentPane().add(player2);

		JLabel player3 = new JLabel("New label");
		player3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(3)==1){
					player3.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(3, 0);
				}else{
					player3.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03B4\u03C1\u03B9\u03B1\u03BD\u03CC\u03C2.jpg"));
					facesCover.set(3, 1);}
			}
		});
		player3.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03B4\u03C1\u03B9\u03B1\u03BD\u03CC\u03C2.jpg"));
		player3.setBounds(502, 221, 74, 104);
		frmGuessWho.getContentPane().add(player3);

		JLabel player4 = new JLabel("New label");
		player4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(4)==1){
					player4.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(4, 0);
				}else{
					player4.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03C5\u03B3\u03BF\u03C5\u03C3\u03C4\u03AF\u03BD\u03BF\u03C2.jpg"));
					facesCover.set(4, 1);}
			}
		});
		player4.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03C5\u03B3\u03BF\u03C5\u03C3\u03C4\u03AF\u03BD\u03BF\u03C2.jpg"));
		player4.setBounds(588, 221, 74, 104);
		frmGuessWho.getContentPane().add(player4);

		JLabel player5 = new JLabel("New label");
		player5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(5)==1){
					player5.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(5, 0);
				}else{
					player5.setIcon(new ImageIcon(path + "\\players_icon\\\u0392\u03B1\u03C1\u03B8\u03BF\u03BB\u03BF\u03BC\u03B1\u03AF\u03BF\u03C2.jpg"));
					facesCover.set(5, 1);}
			}
		});
		player5.setIcon(new ImageIcon(path + "\\players_icon\\\u0392\u03B1\u03C1\u03B8\u03BF\u03BB\u03BF\u03BC\u03B1\u03AF\u03BF\u03C2.jpg"));
		player5.setBounds(674, 221, 74, 104);
		frmGuessWho.getContentPane().add(player5);

		JLabel player6 = new JLabel("New label");
		player6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(6)==1){
					player6.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(6, 0);
				}else{
					player6.setIcon(new ImageIcon(path + "\\players_icon\\\u0392\u03AF\u03BA\u03C4\u03C9\u03C1.jpg"));
					facesCover.set(6, 1);}
			}
		});
		player6.setIcon(new ImageIcon(path + "\\players_icon\\\u0392\u03AF\u03BA\u03C4\u03C9\u03C1.jpg"));
		player6.setBounds(760, 221, 74, 104);
		frmGuessWho.getContentPane().add(player6);

		JLabel player7 = new JLabel("New label");
		player7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(7)==1){
					player7.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(7, 0);
				}else{
					player7.setIcon(new ImageIcon(path + "\\players_icon\\\u0393\u03B5\u03CE\u03C1\u03B3\u03B9\u03BF\u03C2.jpg"));
					facesCover.set(7, 1);}
			}
		});
		player7.setIcon(new ImageIcon(path + "\\players_icon\\\u0393\u03B5\u03CE\u03C1\u03B3\u03B9\u03BF\u03C2.jpg"));
		player7.setBounds(330, 338, 74, 104);
		frmGuessWho.getContentPane().add(player7);

		JLabel player8 = new JLabel("New label");
		player8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(8)==1){
					player8.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(8, 0);
				}else{
					player8.setIcon(new ImageIcon(path + "\\players_icon\\\u0393\u03C1\u03B7\u03B3\u03CC\u03C1\u03B9\u03BF\u03C2.jpg"));
					facesCover.set(8, 1);}
			}
		});
		player8.setIcon(new ImageIcon(path + "\\players_icon\\\u0393\u03C1\u03B7\u03B3\u03CC\u03C1\u03B9\u03BF\u03C2.jpg"));
		player8.setBounds(416, 338, 74, 104);
		frmGuessWho.getContentPane().add(player8);

		JLabel player9 = new JLabel("");
		player9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(9)==1){
					player9.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(9, 0);
				}else{
					player9.setIcon(new ImageIcon(path + "\\players_icon\\\u0394\u03B1\u03BC\u03B9\u03B1\u03BD\u03CC\u03C2.jpg"));
					facesCover.set(9, 1);}
			}
		});
		player9.setIcon(new ImageIcon(path + "\\players_icon\\\u0394\u03B1\u03BC\u03B9\u03B1\u03BD\u03CC\u03C2.jpg"));
		player9.setForeground(Color.WHITE);
		player9.setBackground(Color.WHITE);
		player9.setBounds(502, 338, 74, 104);
		frmGuessWho.getContentPane().add(player9);

		JLabel player10 = new JLabel("");
		player10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(10)==1){
					player10.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(10, 0);
				}else{
					player10 .setIcon(new ImageIcon(path + "\\players_icon\\\u0394\u03B7\u03BC\u03AE\u03C4\u03C1\u03B9\u03BF\u03C2.jpg"));
					facesCover.set(10, 1);}
			}
		});
		player10.setIcon(new ImageIcon(path + "\\players_icon\\\u0394\u03B7\u03BC\u03AE\u03C4\u03C1\u03B9\u03BF\u03C2.jpg"));
		player10.setForeground(Color.WHITE);
		player10.setBackground(Color.WHITE);
		player10.setBounds(588, 338, 74, 104);
		frmGuessWho.getContentPane().add(player10);

		JLabel player11 = new JLabel("");
		player11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(11)==1){
					player11.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(11, 0);
				}else{
					player11.setIcon(new ImageIcon(path + "\\players_icon\\\u0395\u03BB\u03B9\u03C3\u03AC\u03B2\u03B5\u03C4.jpg"));
					facesCover.set(11, 1);}
			}
		});
		player11.setIcon(new ImageIcon(path + "\\players_icon\\\u0395\u03BB\u03B9\u03C3\u03AC\u03B2\u03B5\u03C4.jpg"));
		player11.setForeground(Color.WHITE);
		player11.setBackground(Color.WHITE);
		player11.setBounds(674, 338, 74, 104);
		frmGuessWho.getContentPane().add(player11);

		JLabel player12 = new JLabel("");
		player12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(12)==1){
					player12.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(12, 0);
				}else{
					player12.setIcon(new ImageIcon(path + "\\players_icon\\\u0395\u03BC\u03BC\u03B1\u03BD\u03BF\u03C5\u03AE\u03BB.jpg"));
					facesCover.set(12, 1);}
			}
		});
		player12.setIcon(new ImageIcon(path + "\\players_icon\\\u0395\u03BC\u03BC\u03B1\u03BD\u03BF\u03C5\u03AE\u03BB.jpg"));
		player12.setForeground(Color.WHITE);
		player12.setBackground(Color.WHITE);
		player12.setBounds(760, 338, 74, 104);
		frmGuessWho.getContentPane().add(player12);

		JLabel player13 = new JLabel("new");
		player13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(13)==1){
					player13.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(13, 0);
				}else{
					player13.setIcon(new ImageIcon(path + "\\players_icon\\\u0395\u03C5\u03B3\u03AD\u03BD\u03B9\u03BF\u03C2.jpg"));
					facesCover.set(13, 1);}
			}
		});
		player13.setIcon(new ImageIcon(path + "\\players_icon\\\u0395\u03C5\u03B3\u03AD\u03BD\u03B9\u03BF\u03C2.jpg"));
		player13.setForeground(Color.WHITE);
		player13.setBackground(Color.WHITE);
		player13.setBounds(330, 455, 74, 104);
		frmGuessWho.getContentPane().add(player13);

		JLabel player14 = new JLabel("new");
		player14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(14)==1){
					player14.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(14, 0);
				}else{
					player14.setIcon(new ImageIcon(path + "\\players_icon\\\u0397\u03BB\u03AF\u03B1\u03C2.jpg"));
					facesCover.set(14, 1);}
			}
		});
		player14.setIcon(new ImageIcon(path + "\\players_icon\\\u0397\u03BB\u03AF\u03B1\u03C2.jpg"));
		player14.setForeground(Color.WHITE);
		player14.setBackground(Color.WHITE);
		player14.setBounds(416, 455, 74, 104);
		frmGuessWho.getContentPane().add(player14);

		JLabel player15 = new JLabel("new");
		player15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(15)==1){
					player15.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(15, 0);
				}else{
					player15.setIcon(new ImageIcon(path + "\\players_icon\\\u0398\u03C9\u03BC\u03AC\u03C2.jpg"));
					facesCover.set(15, 1);}
			}
		});
		player15.setIcon(new ImageIcon(path + "\\players_icon\\\u0398\u03C9\u03BC\u03AC\u03C2.jpg"));
		player15.setForeground(Color.WHITE);
		player15.setBackground(Color.WHITE);
		player15.setBounds(502, 455, 74, 104);
		frmGuessWho.getContentPane().add(player15);

		JLabel player16 = new JLabel("new");
		player16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(16)==1){
					player16.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(16, 0);
				}else{
					player16.setIcon(new ImageIcon(path + "\\players_icon\\\u0399\u03AC\u03C3\u03C9\u03BD.jpg"));
					facesCover.set(16, 1);}
			}
		});
		player16.setIcon(new ImageIcon(path + "\\players_icon\\\u0399\u03AC\u03C3\u03C9\u03BD.jpg"));
		player16.setForeground(Color.WHITE);
		player16.setBackground(Color.WHITE);
		player16.setBounds(588, 455, 74, 104);
		frmGuessWho.getContentPane().add(player16);

		JLabel player17 = new JLabel("new");
		player17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(17)==1){
					player17.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(17, 0);
				}else{
					player17.setIcon(new ImageIcon(path + "\\players_icon\\\u0399\u03BF\u03C1\u03B4\u03AC\u03BD\u03B7\u03C2.jpg"));
					facesCover.set(17, 1);}
			}
		});
		player17.setIcon(new ImageIcon(path + "\\players_icon\\\u0399\u03BF\u03C1\u03B4\u03AC\u03BD\u03B7\u03C2.jpg"));
		player17.setForeground(Color.WHITE);
		player17.setBackground(Color.WHITE);
		player17.setBounds(674, 455, 74, 104);
		frmGuessWho.getContentPane().add(player17);

		JLabel player18 = new JLabel("new");
		player18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(18)==1){
					player18.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(18, 0);
				}else{
					player18.setIcon(new ImageIcon(path + "\\players_icon\\\u0399\u03C9\u03B1\u03BA\u03B5\u03AF\u03BC.jpg"));
					facesCover.set(18, 1);}
			}
		});
		player18.setIcon(new ImageIcon(path + "\\players_icon\\\u0399\u03C9\u03B1\u03BA\u03B5\u03AF\u03BC.jpg"));
		player18.setHorizontalAlignment(SwingConstants.LEFT);
		player18.setForeground(Color.WHITE);
		player18.setBackground(Color.WHITE);
		player18.setBounds(760, 455, 74, 104);
		frmGuessWho.getContentPane().add(player18);

		JLabel player19 = new JLabel("new");
		player19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(19)==1){
					player19.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(19, 0);
				}else{
					player19.setIcon(new ImageIcon(path + "\\players_icon\\\u039B\u03C5\u03B4\u03AF\u03B1.jpg"));
					facesCover.set(19, 1);}
			}
		});
		player19.setIcon(new ImageIcon(path + "\\players_icon\\\u039B\u03C5\u03B4\u03AF\u03B1.jpg"));
		player19.setForeground(Color.WHITE);
		player19.setBackground(Color.WHITE);
		player19.setBounds(330, 568, 74, 104);
		frmGuessWho.getContentPane().add(player19);

		JLabel player20 = new JLabel("new");
		player20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(20)==1){
					player20.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(20, 0);
				}else{
					player20.setIcon(new ImageIcon(path + "\\players_icon\\\u039C\u03B1\u03B3\u03B4\u03B1\u03BB\u03B7\u03BD\u03AE.jpg"));
					facesCover.set(20, 1);}
			}
		});
		player20.setIcon(new ImageIcon(path + "\\players_icon\\\u039C\u03B1\u03B3\u03B4\u03B1\u03BB\u03B7\u03BD\u03AE.jpg"));
		player20.setForeground(Color.WHITE);
		player20.setBackground(Color.WHITE);
		player20.setBounds(416, 568, 74, 104);
		frmGuessWho.getContentPane().add(player20);

		JLabel player21 = new JLabel("new");
		player21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(21)==1){
					player21.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(21, 0);
				}else{
					player21.setIcon(new ImageIcon(path + "\\players_icon\\\u039C\u03AC\u03BE\u03B9\u03BC\u03BF\u03C2.jpg"));
					facesCover.set(21, 1);}
			}
		});
		player21.setIcon(new ImageIcon(path + "\\players_icon\\\u039C\u03AC\u03BE\u03B9\u03BC\u03BF\u03C2.jpg"));
		player21.setForeground(Color.WHITE);
		player21.setBackground(Color.WHITE);
		player21.setBounds(502, 568, 74, 104);
		frmGuessWho.getContentPane().add(player21);

		JLabel player22 = new JLabel("new");
		player22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(22)==1){
					player22.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(22, 0);
				}else{
					player22.setIcon(new ImageIcon(path + "\\players_icon\\\u039C\u03B9\u03C7\u03B1\u03AE\u03BB.jpg"));
					facesCover.set(22, 1);}
			}
		});
		player22.setIcon(new ImageIcon(path + "\\players_icon\\\u039C\u03B9\u03C7\u03B1\u03AE\u03BB.jpg"));
		player22.setForeground(Color.WHITE);
		player22.setBackground(Color.WHITE);
		player22.setBounds(588, 568, 74, 104);
		frmGuessWho.getContentPane().add(player22);

		JLabel player23 = new JLabel("new");
		player23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(23)==1){
					player23.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(23, 0);
				}else{
					player23.setIcon(new ImageIcon(path + "\\players_icon\\\u03A1\u03B5\u03B2\u03AD\u03BA\u03BA\u03B1.jpg"));
					facesCover.set(23, 1);}
			}
		});
		player23.setIcon(new ImageIcon(path + "\\players_icon\\\u03A1\u03B5\u03B2\u03AD\u03BA\u03BA\u03B1.jpg"));
		player23.setForeground(Color.WHITE);
		player23.setBackground(Color.WHITE);
		player23.setBounds(674, 568, 74, 104);
		frmGuessWho.getContentPane().add(player23);

		JLabel player24 = new JLabel("new");
		player24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(facesCover.get(24)==1){
					player24.setIcon(new ImageIcon(path + "\\backofcards.png"));
					facesCover.set(24, 0);
				}else{
					player24.setIcon(new ImageIcon(path + "\\players_icon\\\u03A4\u03B1\u03C4\u03B9\u03B1\u03BD\u03AE.jpg"));
					facesCover.set(24, 1);}
			}
		});
		player24.setIcon(new ImageIcon(path + "\\players_icon\\\u03A4\u03B1\u03C4\u03B9\u03B1\u03BD\u03AE.jpg"));
		player24.setForeground(Color.WHITE);
		player24.setBackground(Color.WHITE);
		player24.setBounds(760, 568, 74, 104);
		frmGuessWho.getContentPane().add(player24);

		
		for(Question q : questionList){
			model.addElement(q.getCharacteristic());
		}
		
		questionJList.setModel(model);
		questionJList.setFont(new Font("Tahoma", Font.BOLD, 12));
		questionJList.setFixedCellHeight(25);
		questionJList.setBounds(10, 83, 284, 307);
		frmGuessWho.getContentPane().add(questionJList);

		

		JLabel PlayersLeftForMe = new JLabel();
		PlayersLeftForMe.setText(String.valueOf(enemyFacesList.size()));
		PlayersLeftForMe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PlayersLeftForMe.setBounds(883, 433, 32, 25);
		frmGuessWho.getContentPane().add(PlayersLeftForMe);

		JLabel NumberOfPlayers = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03C0\u03B1\u03B9\u03BA\u03C4\u03CE\u03BD \u03C3\u03C4\u03BF \u03C4\u03B1\u03BC\u03C0\u03BB\u03CC:\r\n");
		NumberOfPlayers.setFont(new Font("Tahoma", Font.BOLD, 14));
		NumberOfPlayers.setBounds(844, 348, 206, 25);
		frmGuessWho.getContentPane().add(NumberOfPlayers);


		JLabel PlayersLeftForEnemy = new JLabel(String.valueOf(faceslist.size()));
		PlayersLeftForEnemy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PlayersLeftForEnemy.setBounds(981, 433, 32, 25);
		frmGuessWho.getContentPane().add(PlayersLeftForEnemy);

		JLabel BackgroundForPlayer = new JLabel("New label");
		BackgroundForPlayer.setIcon(new ImageIcon(path + "\\questionbackground1.png"));
		BackgroundForPlayer.setBounds(864, 410, 66, 72);
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
		Options.setIcon(new ImageIcon(path + "\\settingsbutton.png"));
		Options.setBounds(34, 617, 74, 63);
		frmGuessWho.getContentPane().add(Options);

		JLabel PlayerTitleForNumberLeft = new JLabel("\u03A0\u03C1\u03BF\u03C3\u03C9\u03C0\u03B9\u03BA\u03CC");
		PlayerTitleForNumberLeft.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PlayerTitleForNumberLeft.setBounds(854, 384, 107, 16);
		frmGuessWho.getContentPane().add(PlayerTitleForNumberLeft);

		JLabel BckgroundForEnemy = new JLabel("New label");
		BckgroundForEnemy.setIcon(new ImageIcon(path + "\\questionbackground1.png"));
		BckgroundForEnemy.setBounds(961, 410, 66, 72);
		frmGuessWho.getContentPane().add(BckgroundForEnemy);

		JLabel EnemyTitleForNumberLeft = new JLabel("\u0391\u03BD\u03C4\u03B9\u03C0\u03AC\u03BB\u03BF\u03C5");
		EnemyTitleForNumberLeft.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EnemyTitleForNumberLeft.setBounds(961, 384, 77, 16);
		frmGuessWho.getContentPane().add(EnemyTitleForNumberLeft);

		JLabel question_title = new JLabel("\u0388\u03BB\u03B5\u03B3\u03BE\u03B5 \u03C4\u03BF \u03C0\u03C1\u03CC\u03C3\u03C9\u03C0\u03BF \u03C4\u03BF\u03C5 \u03B1\u03BD\u03C4\u03B9\u03C0\u03AC\u03BB\u03BF\u03C5 \u03B3\u03B9\u03B1:");
		question_title.setForeground(new Color(255, 255, 255));
		question_title.setFont(new Font("Tahoma", Font.PLAIN, 16));
		question_title.setBounds(10, 18, 284, 54);
		frmGuessWho.getContentPane().add(question_title);

		JLabel enemy_photo = new JLabel("New label");
		enemy_photo.setIcon(new ImageIcon(path + "\\question_face2.png"));
		enemy_photo.setBounds(487, 37, 74, 104);
		frmGuessWho.getContentPane().add(enemy_photo);

		JLabel background_photo_enemy = new JLabel("New label");
		background_photo_enemy.setIcon(new ImageIcon(path + "\\questionbackground1.png"));
		background_photo_enemy.setBounds(475, 18, 101, 143);
		frmGuessWho.getContentPane().add(background_photo_enemy);

		JLabel playersicon = new JLabel("New label");
		String photoName = setFace(selectedFaceCode);
		playersicon.setIcon(new ImageIcon(path + photoName));
		playersicon.setBounds(906, 553, 74, 104);
		frmGuessWho.getContentPane().add(playersicon);
		//setFaceIcon(906,553,74,104,selectedFaceCode);

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
		
		JLabel lblWizard = new JLabel("Wizard");
		lblWizard.setBackground(Color.DARK_GRAY);
		lblWizard.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(playerTurn && !enemyTurn && wizardTurn){
				int questionListIndex = wizard.selectQuestionCode(1, enemyFace, faceslist, questionList);
				text = "Κάντε ερώτηση \nγια το χαρακτηριστικό \n" + questionList.get(questionListIndex).getCharacteristic();
				textArea.setText(text);
				wizardTurn=false;
				}
			}
		});
		lblWizard.setBounds(97, 470, 97, 104);
		frmGuessWho.getContentPane().add(lblWizard);

		JButton button = new JButton("\u03A4\u03AD\u03BB\u03BF\u03C2 \u0393\u03CD\u03C1\u03BF\u03C5");
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button.setBounds(848, 169, 108, 23);
		frmGuessWho.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(playerTurn==false && enemyTurn==false){
					uncoveredFacesCounter=0;
					for(int i=1;i<25;i++){
						if(facesCover.get(i)==1){
							uncoveredFacesCounter++;
							lastFaceCode = i;
						}
					}
					if(uncoveredFacesCounter>1){
						selectedQuestionIndex =enemy.selectQuestionCode(difficultyLevel, selectedFace, enemyFacesList, enemyQuestionList);
						if(enemyQuestionList.get(selectedQuestionIndex).getCodeQuestion()!=11)
							text = "Έχει " + enemyQuestionList.get(selectedQuestionIndex).getCharacteristic()+";";
						else
							text = "Είναι " + enemyQuestionList.get(selectedQuestionIndex).getCharacteristic()+";";
						textArea.setText(text);

						enemyTurn=true;
						playerTurn=true;

						PlayersLeftForMe.setText(String.valueOf(uncoveredFacesCounter));
					}
					else if(uncoveredFacesCounter==1){//1 card left
						String photoName;
						photoName = setFace(enemyFace.getCodeFace());
						enemy_photo.setIcon(new ImageIcon(path + photoName));
						//enemy_photo.setVisible(false);
						//setFaceIcon(487,37,102,132,enemyFace.getCodeFace());
						PlayersLeftForMe.setText(String.valueOf(uncoveredFacesCounter));
						if(lastFaceCode==enemyFace.getCodeFace()){//we win
							text = "Συγχαρητήρια Κερδίσατε!!! \nΒρήκατε το πρόσωπο \nπου είχα επιλέξει.";
							if(difficultyLevel==1){
								text = text + "\n8 πόντοι είναι δικοί σας!";
							}
							else{
								text = text + "\n4 πόντοι είναι δικοί σας!";
							}
						}
						else{
							text = "Δυστυχώς χάσατε! \nΔε βρήκατε τη σωστή κάρτα.";
							if(difficultyLevel==1){
								text = text + "\n2 πόντοι θα σας αφαιρεθούν.";
							}
							else{
								text = text + "\n3 πόντοι θα σας αφαιρεθούν.";
							}
						}
						
						enemyTurn=true;
						playerTurn=false;
						textArea.setText(text);
					}
					else{
						PlayersLeftForMe.setText(String.valueOf(uncoveredFacesCounter));
						text = "Δεν γίνεται να κερδίσετε αν έχετε \nκλείσει όλες τις κάρτες";
						textArea.setText(text);
					}

				}
				else{
					if(uncoveredFacesCounter > 1 && enemyFacesList.size()>1)
						textArea.setText("Πρέπει να επιλέξετε ερώτηση!");
				}
			}
		});
		
		JButton yesButton = new JButton("\u039D\u03B1\u03B9");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(playerTurn && enemyTurn){
					playerResponse=true;
					if(enemyQuestionList.get(selectedQuestionIndex).checkQuestion(selectedFace, playerResponse)){
						enemyQuestionList.get(selectedQuestionIndex).facesForDelete(enemyFacesList, selectedFace);
						enemyQuestionList.get(selectedQuestionIndex).deleteFaces(enemyFacesList);
						enemyQuestionList.remove(selectedQuestionIndex);
						PlayersLeftForEnemy.setText(String.valueOf(enemyFacesList.size()));
						if(enemyFacesList.size()==1){
							String photoName = setFace(selectedFace.getCodeFace());
							enemy_photo.setIcon(new ImageIcon(path + photoName));
							text = "Δυστυχώς χάσατε! \nΔε βρήκατε τη σωστή κάρτα.";
							
							if(difficultyLevel==1){
								text = text + "\n2 πόντοι θα σας αφαιρεθούν";
							}
							else{
								text = text + "\n3 πόντοι θα σας αφαιρεθούν";
							}
							playerTurn=false;
							textArea.setText(text);
						}
						else{
							text = "Επιλέξτε ερώτηση";
							textArea.setText(text);
							enemyTurn=false;
						}
					}
					else{
						text = "Ξανά σκεφτείτε το!";
						textArea.setText(text);
					}
				}
			}
		});
		yesButton.setBounds(632, 168, 97, 25);
		frmGuessWho.getContentPane().add(yesButton);

		JButton noButton = new JButton("\u039F\u03C7\u03B9");
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(playerTurn && enemyTurn){
					playerResponse=false;
					if(enemyQuestionList.get(selectedQuestionIndex).checkQuestion(selectedFace, playerResponse)){
						enemyQuestionList.get(selectedQuestionIndex).facesForDelete(enemyFacesList, selectedFace);
						enemyQuestionList.get(selectedQuestionIndex).deleteFaces(enemyFacesList);
						enemyQuestionList.remove(selectedQuestionIndex);
						PlayersLeftForEnemy.setText(String.valueOf(enemyFacesList.size()));
						if(enemyFacesList.size()==1){
							String photoName = setFace(selectedFace.getCodeFace());
							enemy_photo.setIcon(new ImageIcon(path + photoName));
							text = "Δυστυχώς χάσατε! \nΔε βρήκατε τη σωστή κάρτα.";
							if(difficultyLevel==1){
								text = text + "\n2 πόντοι θα σας αφαιρεθούν";
							}
							else{
								text = text + "\n3 πόντοι θα σας αφαιρεθούν";
							}
							playerTurn=false;
							textArea.setText(text);
						}
						else{
							text = "Επιλέξτε ερώτηση";
							textArea.setText(text);
							enemyTurn=false;
						}

					}
					else{
						text = "Ξανά σκεφτείτε το!";
						textArea.setText(text);
					}
				}
			}
		});
		noButton.setBounds(741, 168, 97, 25);
		frmGuessWho.getContentPane().add(noButton);
		
		JButton okButton = new JButton("\u039F\u039A");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(playerTurn && !enemyTurn){
					if(questionJList.getSelectedValue()!=null){
						String selectedQuestion = (String)questionJList.getSelectedValue();
						//Question playerQuestion = null ;
						for (Question q : questionList){
							if (q.getCharacteristic().equals(selectedQuestion))
								playerQuestion = q;
						}
						playerQuestionIndex = -1;
						for(int i=0;i<questionList.size();i++){
							if(playerQuestion==questionList.get(i)){
								playerQuestionIndex=i;
							}
						}
						if(playerQuestionIndex != -1){
						questionList.get(playerQuestionIndex).facesForDelete(faceslist, enemyFace);
						questionList.get(playerQuestionIndex).deleteFaces(faceslist);
						questionList.remove(playerQuestionIndex);
						}
						if(playerQuestion.questionResponse(enemyFace)){
							text = "Ναι!";
							model.remove(playerQuestion.getCodeQuestion());
							model.insertElementAt(playerQuestion.getCharacteristic() + ": Ναι", playerQuestion.getCodeQuestion());
						}
						else{
							text = "Όχι!";
							model.remove(playerQuestion.getCodeQuestion());
							model.insertElementAt(playerQuestion.getCharacteristic() + ": Όχι", playerQuestion.getCodeQuestion());
						}
						textArea.setText(text);

						playerTurn = false;
					}
				}

			}
		});
		okButton.setBounds(97, 410, 97, 25);
		frmGuessWho.getContentPane().add(okButton);



		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(path + "\\MainBackround.jpg"));
		background.setBounds(0, 0, 1050, 693);
		frmGuessWho.getContentPane().add(background);

	}
	
public  String setFace(int code){//x,y,z,w are coordinates of JLabel in MainGamePanel
		
		String photoName = null;
		switch (code){
		case 1: photoName = "\\players_icon\\\u0391\u03B3\u03B1\u03B8\u03AE.jpg";
		break;
		case 2: photoName = "\\players_icon\\\u0391\u03B3\u03BD\u03B7.jpg";
		break;
		case 3: photoName = "\\players_icon\\\u0391\u03B4\u03C1\u03B9\u03B1\u03BD\u03CC\u03C2.jpg";
		break;
		case 4: photoName = "\\players_icon\\\u0391\u03C5\u03B3\u03BF\u03C5\u03C3\u03C4\u03AF\u03BD\u03BF\u03C2.jpg";
		break;
		case 5: photoName = "\\players_icon\\\u0392\u03B1\u03C1\u03B8\u03BF\u03BB\u03BF\u03BC\u03B1\u03AF\u03BF\u03C2.jpg";
		break;
		case 6: photoName = "\\players_icon\\\u0391\u03B3\u03B1\u03B8\u03AE.jpg";
		break;
		case 7: photoName = "\\players_icon\\\u0393\u03B5\u03CE\u03C1\u03B3\u03B9\u03BF\u03C2.jpg";
		break;
		case 8: photoName = "\\players_icon\\\u0393\u03C1\u03B7\u03B3\u03CC\u03C1\u03B9\u03BF\u03C2.jpg";
		break;
		case 9: photoName = "\\players_icon\\\u0394\u03B1\u03BC\u03B9\u03B1\u03BD\u03CC\u03C2.jpg";
		break;
		case 10: photoName = "\\players_icon\\\u0394\u03B7\u03BC\u03AE\u03C4\u03C1\u03B9\u03BF\u03C2.jpg";
		break;
		case 11: photoName = "\\players_icon\\\u0395\u03BB\u03B9\u03C3\u03AC\u03B2\u03B5\u03C4.jpg";
		break;
		case 12: photoName = "\\players_icon\\\u0395\u03BC\u03BC\u03B1\u03BD\u03BF\u03C5\u03AE\u03BB.jpg";
		break;
		case 13: photoName = "\\players_icon\\\u0395\u03C5\u03B3\u03AD\u03BD\u03B9\u03BF\u03C2.jpg";
		break;
		case 14: photoName = "\\players_icon\\\u0397\u03BB\u03AF\u03B1\u03C2.jpg";
		break;
		case 15: photoName = "\\players_icon\\\u0398\u03C9\u03BC\u03AC\u03C2.jpg";
		break;
		case 16: photoName = "\\players_icon\\\u0399\u03AC\u03C3\u03C9\u03BD.jpg";
		break;
		case 17: photoName = "\\players_icon\\\u0399\u03BF\u03C1\u03B4\u03AC\u03BD\u03B7\u03C2.jpg";
		break;
		case 18: photoName = "\\players_icon\\\u0399\u03C9\u03B1\u03BA\u03B5\u03AF\u03BC.jpg";
		break;
		case 19: photoName = "\\players_icon\\\u039B\u03C5\u03B4\u03AF\u03B1.jpg";
		break;
		case 20: photoName = "\\players_icon\\\u039C\u03B1\u03B3\u03B4\u03B1\u03BB\u03B7\u03BD\u03AE.jpg";
		break;
		case 21: photoName = "\\players_icon\\\u039C\u03AC\u03BE\u03B9\u03BC\u03BF\u03C2.jpg";
		break;
		case 22: photoName = "\\players_icon\\\u039C\u03B9\u03C7\u03B1\u03AE\u03BB.jpg";
		break;
		case 23: photoName = "\\players_icon\\\u03A1\u03B5\u03B2\u03AD\u03BA\u03BA\u03B1.jpg";
		break;
		case 24: photoName = "\\players_icon\\\u03A4\u03B1\u03C4\u03B9\u03B1\u03BD\u03AE.jpg";
		break;
		}
		return photoName;
	}
}
