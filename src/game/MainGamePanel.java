/*Class MainGamePanel. It's the Main Frame that gamer interacts with the computer.*/
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
import javax.swing.JScrollPane;
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
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class MainGamePanel {

	static JFrame frmGuessWho;

	/*If a face is covered (eg. face with number 6 - Βικτωρ-) then at 6st position in ArrayList facesCover will be a zero (0).
	Else if face is uncovered at this position in ArrayList will be an one (1)*/
	private ArrayList<Integer> facesCover; 
	private int uncoveredFacesCounter;

	private boolean playerTurn; /*the combination of those boolean variable let gamer push a specific button*/
	private boolean enemyTurn;
	private boolean wizardTurn;

	private String text;

	private ArrayList<Face> faceslist; /*ArrayLists with faces and questions that wizard uses.*/
	private ArrayList<Question> questionList;
	
	private DefaultListModel<String> model;

	private ArrayList<Face> enemyFacesList; /*ArrayLists with faces and questions that Enemy uses.*/
	private ArrayList<Question> enemyQuestionList;
	private boolean playerResponse;

	private Question playerQuestion;
	private Face selectedFace;

	private int selectedFaceCode;
	private int difficultyLevel;
	private int selectedQuestionIndex;/*reffered to Enemy*/


	private int playerQuestionIndex;
	private Enemy enemy;
	private Face enemyFace;
	private int lastFaceCode; /*The code of  the last one uncovered face. It's been to check if gamer/player won or lost. */
	private static String path = System.getProperty("user.home") + "/Desktop/Game";
	
	private Wizard wizard;
	boolean win=true;
	private JList<String> questionJList;


	private String playersName;


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

	public MainGamePanel(int levelSelection, int selectedFaceCode, String playersName) {
		this.playersName = playersName;
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
		questionJList = new JList<String>();
		questionJList.setBackground(Color.PINK);
		

		/*This block call Initialization static method to fill facesList and questionList.*/
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
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\logo2.jpg"));
		frmGuessWho.setBounds(100, 100, 1068, 725);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		frmGuessWho.setResizable(false);

		enemy = new Enemy(enemyFacesList); /*Create Enemy and Wizard. Enemy picks a face.*/
		enemyFace = enemy.selectFace();
		wizard = new Wizard(faceslist);

		text = "Επιλέξτε Ερώτηση";
		JTextArea textArea = new JTextArea(text);
		textArea.setEditable(false);
        textArea.setBounds(658, 40, 191, 72);
		frmGuessWho.getContentPane().add(textArea);

		/*JLabels from 1 to 24 are use for 24 faces. This block ends at line 582*/
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

		/*Add questions to model*/
		for(Question q : questionList){
			model.addElement(q.getCharacteristic());
		}
		
		questionJList.setModel(model);
		questionJList.setFont(new Font("Tahoma", Font.BOLD, 12));
		questionJList.setFixedCellHeight(25);
        questionJList.setBounds(10, 83, 284, 307);
		frmGuessWho.getContentPane().add(questionJList);

		
		/*JLabels for images on the MainGamePanel. This block ends at line 717*/
		JLabel PlayersLeftForMe = new JLabel();
		PlayersLeftForMe.setText(String.valueOf(enemyFacesList.size()));
		PlayersLeftForMe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PlayersLeftForMe.setBounds(883, 433, 32, 25);
		frmGuessWho.getContentPane().add(PlayersLeftForMe);

		JLabel NumberOfPlayers = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03C0\u03B1\u03B9\u03BA\u03C4\u03CE\u03BD \u03C3\u03C4\u03BF \u03C4\u03B1\u03BC\u03C0\u03BB\u03CC:\r\n");
		NumberOfPlayers.setForeground(SystemColor.text);
		NumberOfPlayers.setFont(new Font("Tahoma", Font.BOLD, 14));
		NumberOfPlayers.setBounds(844, 348, 206, 25);
		frmGuessWho.getContentPane().add(NumberOfPlayers);


		JLabel PlayersLeftForEnemy = new JLabel(String.valueOf(faceslist.size()));
		PlayersLeftForEnemy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PlayersLeftForEnemy.setBounds(981, 433, 32, 25);
		frmGuessWho.getContentPane().add(PlayersLeftForEnemy);

		JLabel BackgroundForPlayer = new JLabel("");
		BackgroundForPlayer.setOpaque(true);
		BackgroundForPlayer.setBackground(new Color(255, 255, 255, 200));
		BackgroundForPlayer.setBounds(864, 410, 66, 72);
		frmGuessWho.getContentPane().add(BackgroundForPlayer);

		

		JLabel Options = new JLabel("");
		Options.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PauseMenu window = new PauseMenu(frmGuessWho,playersName);
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
		PlayerTitleForNumberLeft.setForeground(SystemColor.controlLtHighlight);
		PlayerTitleForNumberLeft.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PlayerTitleForNumberLeft.setBounds(854, 384, 107, 16);
		frmGuessWho.getContentPane().add(PlayerTitleForNumberLeft);

		JLabel BckgroundForEnemy = new JLabel("");
		BckgroundForEnemy.setOpaque(true);
		BckgroundForEnemy.setBackground(new Color(255, 255, 255, 200));
		BckgroundForEnemy.setBounds(961, 410, 66, 72);
		frmGuessWho.getContentPane().add(BckgroundForEnemy);

		JLabel EnemyTitleForNumberLeft = new JLabel("\u0391\u03BD\u03C4\u03B9\u03C0\u03AC\u03BB\u03BF\u03C5");
		EnemyTitleForNumberLeft.setForeground(SystemColor.controlLtHighlight);
		EnemyTitleForNumberLeft.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EnemyTitleForNumberLeft.setBounds(961, 384, 77, 16);
		frmGuessWho.getContentPane().add(EnemyTitleForNumberLeft);

		JLabel question_title = new JLabel("\u0388\u03BB\u03B5\u03B3\u03BE\u03B5 \u03C4\u03BF \u03C0\u03C1\u03CC\u03C3\u03C9\u03C0\u03BF \u03C4\u03BF\u03C5 \u03B1\u03BD\u03C4\u03B9\u03C0\u03AC\u03BB\u03BF\u03C5 \u03B3\u03B9\u03B1:");
		question_title.setForeground(new Color(255, 255, 255));
		question_title.setFont(new Font("Tahoma", Font.PLAIN, 16));
		question_title.setBounds(10, 18, 284, 54);
		frmGuessWho.getContentPane().add(question_title);

		JLabel enemy_photo = new JLabel("New label");
		enemy_photo.setIcon(new ImageIcon(path + "\\backofcards.png"));
		enemy_photo.setBounds(487, 37, 74, 104);
		frmGuessWho.getContentPane().add(enemy_photo);

		JLabel background_photo_enemy = new JLabel("New label");
		background_photo_enemy.setIcon(new ImageIcon(path + "\\questionbackground1.png"));
		background_photo_enemy.setBounds(475, 18, 101, 143);
		frmGuessWho.getContentPane().add(background_photo_enemy);

		JLabel playersicon = new JLabel("");
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
		labelplayersicon.setForeground(SystemColor.controlLtHighlight);
		labelplayersicon.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelplayersicon.setBounds(875, 499, 133, 46);
		frmGuessWho.getContentPane().add(labelplayersicon);

		/*JLabel cloud = new JLabel("");
		cloud.setIcon(new ImageIcon(path + "\\cloud1.png"));
		cloud.setBounds(572, 18, 320, 149);
		frmGuessWho.getContentPane().add(cloud);*/		
		
		JLabel lblWizard = new JLabel("Wizard");
		lblWizard.setIcon(new ImageIcon(path + "\\WizardCorrectSize.png"));
		lblWizard.setBackground(Color.DARK_GRAY);
		lblWizard.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {/*wizard calls selectQuestionCode to pick best question*/
				if(playerTurn && !enemyTurn && wizardTurn){
				int questionListIndex = wizard.selectQuestionCode(1, enemyFace, faceslist, questionList);
				text = "Κάντε ερώτηση \nγια το χαρακτηριστικό \n" + questionList.get(questionListIndex).getCharacteristic();
				textArea.setText(text);
				wizardTurn=false;
				}
			}
		});
		lblWizard.setBounds(97, 472, 107, 134);
		frmGuessWho.getContentPane().add(lblWizard);

		JButton button = new JButton("\u03A4\u03AD\u03BB\u03BF\u03C2 \u0393\u03CD\u03C1\u03BF\u03C5"); /*Τέλος γύρου button*/
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(848, 168, 113, 25);
		frmGuessWho.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(playerTurn==false && enemyTurn==false){
					uncoveredFacesCounter=0;
					for(int i=1;i<25;i++){/*Counts how many uncovered faces, gamer left.*/
						if(facesCover.get(i)==1){
							uncoveredFacesCounter++;
							lastFaceCode = i;
						}
					}
					if(uncoveredFacesCounter>1){ /*If there are more than 1 uncovered faces, Enemy sets a question*/
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
					else if(uncoveredFacesCounter==1){/*if 1 card left, check if gamer won or lost.*/
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
							win=false;
							text = "Δυστυχώς χάσατε! \nΔε βρήκατε τη σωστή κάρτα.";
							if(difficultyLevel==1){
								text = text + "\n2 πόντοι θα σας αφαιρεθούν.";
							}
							else{
								text = text + "\n3 πόντοι θα σας αφαιρεθούν.";
							}
						}
						FileEditor FE = new FileEditor(); /*write results to file */
						if(win){//we won
							if(difficultyLevel==1){
								FE.calculatePoints(playersName, true, win);//true==hard level
								FE.writeFile("statistics.txt");
							}
							else{
								FE.calculatePoints(playersName, false, win);
								FE.writeFile("statistics.txt");
							}
						}
						else{//we lost
							if(difficultyLevel==1){
								FE.calculatePoints(playersName, true, win);//false==hard level
								FE.writeFile("statistics.txt");
							}
							else{
								FE.calculatePoints(playersName, false, win);
								FE.writeFile("statistics.txt");
							}
						}
						enemyTurn=true;
						playerTurn=false;
						textArea.setText(text);
					}
					else{ /*if all faces are covered*/
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
				if(playerTurn && enemyTurn){/*after player respone yes to a question, enemy checks for cheating and then deletes the correct faces.*/
					playerResponse=true;
					if(enemyQuestionList.get(selectedQuestionIndex).checkQuestion(selectedFace, playerResponse)){
						enemyQuestionList.get(selectedQuestionIndex).facesForDelete(enemyFacesList, selectedFace);
						enemyQuestionList.get(selectedQuestionIndex).deleteFaces(enemyFacesList);
						enemyQuestionList.remove(selectedQuestionIndex);
						PlayersLeftForEnemy.setText(String.valueOf(enemyFacesList.size()));
						if(enemyFacesList.size()==1){ /*If one face is left in Enemy's ArrayList of faces,Enemy won.*/
							String photoName = setFace(selectedFace.getCodeFace());
							enemy_photo.setIcon(new ImageIcon(path + photoName));
							text = "Δυστυχώς χάσατε! \nΔε βρήκατε τη σωστή κάρτα.";
							win = false;
							if(difficultyLevel==1){
								text = text + "\n2 πόντοι θα σας αφαιρεθούν";
							}
							else{
								text = text + "\n3 πόντοι θα σας αφαιρεθούν";
							}
							//commands for losing points. Write result to file statistics. 
							if(!win){
								FileEditor FE = new FileEditor();
								if(difficultyLevel==1){
									FE.calculatePoints(playersName, true, win);//false==hard level
									FE.writeFile("statistics.txt");
								}
								else{
									FE.calculatePoints(playersName, false, win);
									FE.writeFile("statistics.txt");
								}
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

		JButton noButton = new JButton("\u039F\u03C7\u03B9"); /*Same commands as above. This is block runs when player responds "Όχι" to a question*/
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
							win=false;
							if(difficultyLevel==1){
								text = text + "\n2 πόντοι θα σας αφαιρεθούν";
							}
							else{
								text = text + "\n3 πόντοι θα σας αφαιρεθούν";
							}
							if(!win){//commands for losing points. Write results to file.
								FileEditor FE = new FileEditor();
								if(difficultyLevel==1){
									FE.calculatePoints(playersName, true, win);//false==hard level
									FE.writeFile("statistics.txt");
								}
								else{
									FE.calculatePoints(playersName, false, win);
									FE.writeFile("statistics.txt");
								}
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
					else{ /*If player try to cheat Enemy giving a wrong answer.*/
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
					if(questionJList.getSelectedValue()!=null){ /*Player chooses a question*/
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
						if(playerQuestionIndex != -1){ /*Delete correct faces from questionList because wizard may use it.*/
						questionList.get(playerQuestionIndex).facesForDelete(faceslist, enemyFace);
						questionList.get(playerQuestionIndex).deleteFaces(faceslist);
						questionList.remove(playerQuestionIndex);
						}
						if(playerQuestion.questionResponse(enemyFace)){ /*Response at player's question*/
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
		background.setIcon(new ImageIcon(path + "\\MainBackround5.png"));
        background.setBounds(0, 0, 1062, 693);
		frmGuessWho.getContentPane().add(background);

	}
/*This function gets a face's code (1 to 24) and returns the path that face's image is located.*/	
public  String setFace(int code){
		
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
		case 6: photoName = "\\players_icon\\\u0392\u03AF\u03BA\u03C4\u03C9\u03C1.jpg";
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
