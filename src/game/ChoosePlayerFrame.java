package game;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ChoosePlayerFrame {

	JFrame choiceFrame;
	private int p1 = 1;
	private int p2 = 1;
	private int p3 = 1;
	private int p4 = 1;
	private int p5 = 1;
	private int p6 = 1;
	private int p7 = 1;
	private int p8 = 1;
	private int p9 = 1;
	private int p10 = 1;	/*	variables show if a card has been covered or not--->values 0=backside 1=frontside  */
	private int p11 = 1;
	private int p12 = 1;
	private int p13 = 1;
	private int p14 = 1;
	private int p15 = 1;
	private int p16 = 1;
	private int p17 = 1;
	private int p18 = 1;
	private int p19 = 1;
	private int p20 = 1;
	private int p21= 1;
	private int p22 = 1;
	private int p23 = 1;
	private int p24 = 1;
	private int selectedFaceCode;
	private static int levelSelection;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoosePlayerFrame window = new ChoosePlayerFrame(levelSelection);
					window.choiceFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChoosePlayerFrame(int levelSelection) {
		this.levelSelection = levelSelection;
		initialize();
		//System.out.println(levelSelection);
	}

	/**
	 * Initialize the contents of the choiceFrame.
	 */
	private void initialize() {
		
		String path = System.getProperty("user.home") + "/Desktop/Game";
		choiceFrame = new JFrame();
		choiceFrame.setTitle("Guess Who");
		choiceFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\game\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		choiceFrame.setBounds(100, 100, 642, 729);
		choiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		choiceFrame.getContentPane().setLayout(null);
		choiceFrame.setLocationRelativeTo(null);
	
		
		JLabel label = new JLabel("\u0395\u03C0\u03AF\u03BB\u03B5\u03BE\u03B5 \u03C4\u03BF \u03C0\u03C1\u03CC\u03C3\u03C9\u03C0\u03BF \u03C4\u03BF\u03C5 \u03C0\u03B1\u03AF\u03BA\u03C4\u03B7 \u03C3\u03BF\u03C5!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(61, 22, 346, 54);
		choiceFrame.getContentPane().add(label);

		JLabel player4 = new JLabel("New label");
		player4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 7;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player4.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03C5\u03B3\u03BF\u03C5\u03C3\u03C4\u03AF\u03BD\u03BF\u03C2.jpg"));
		player4.setBounds(319, 135, 74, 104);
		choiceFrame.getContentPane().add(player4);

		JLabel player3 = new JLabel("New label");
		player3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 7;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player3.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03B4\u03C1\u03B9\u03B1\u03BD\u03CC\u03C2.jpg"));
		player3.setBounds(233, 135, 74, 104);
		choiceFrame.getContentPane().add(player3);

		JLabel player2 = new JLabel("New label");
		player2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 7;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player2.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03B3\u03BD\u03B7.jpg"));
		player2.setBounds(147, 135, 74, 104);
		choiceFrame.getContentPane().add(player2);

		JLabel player5 = new JLabel("New label");
		player5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 7;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player5.setIcon(new ImageIcon(path + "\\players_icon\\\u0392\u03B1\u03C1\u03B8\u03BF\u03BB\u03BF\u03BC\u03B1\u03AF\u03BF\u03C2.jpg"));
		player5.setBounds(405, 135, 74, 104);
		choiceFrame.getContentPane().add(player5);

		JLabel player6 = new JLabel("New label");
		player6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 7;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player6.setIcon(new ImageIcon(path + "\\players_icon\\\u0392\u03AF\u03BA\u03C4\u03C9\u03C1.jpg"));
		player6.setBounds(491, 135, 74, 104);
		choiceFrame.getContentPane().add(player6);

		JLabel player1 = new JLabel("New label");
		player1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 7;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player1.setIcon(new ImageIcon(path + "\\players_icon\\\u0391\u03B3\u03B1\u03B8\u03AE.jpg"));
		player1.setBounds(61, 135, 74, 104);
		choiceFrame.getContentPane().add(player1);

		JLabel player7 = new JLabel("New label");
		player7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 7;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player7.setIcon(new ImageIcon(path + "\\players_icon\\\u0393\u03B5\u03CE\u03C1\u03B3\u03B9\u03BF\u03C2.jpg"));
		player7.setBounds(61, 250, 74, 104);
		choiceFrame.getContentPane().add(player7);

		JLabel player8 = new JLabel("New label");
		player8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 8;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player8.setIcon(new ImageIcon(path + "\\players_icon\\\u0393\u03C1\u03B7\u03B3\u03CC\u03C1\u03B9\u03BF\u03C2.jpg"));
		player8.setBounds(147, 250, 74, 104);
		choiceFrame.getContentPane().add(player8);

		JLabel player9 = new JLabel("");
		player9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 9;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player9.setIcon(new ImageIcon(path + "\\players_icon\\\u0394\u03B1\u03BC\u03B9\u03B1\u03BD\u03CC\u03C2.jpg"));
		player9.setForeground(Color.WHITE);
		player9.setBackground(Color.WHITE);
		player9.setBounds(233, 250, 74, 104);
		choiceFrame.getContentPane().add(player9);

		JLabel player10 = new JLabel("");
		player10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 10;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player10.setIcon(new ImageIcon(path + "\\players_icon\\\u0394\u03B7\u03BC\u03AE\u03C4\u03C1\u03B9\u03BF\u03C2.jpg"));
		player10.setForeground(Color.WHITE);
		player10.setBackground(Color.WHITE);
		player10.setBounds(319, 250, 74, 104);
		choiceFrame.getContentPane().add(player10);

		JLabel player11 = new JLabel("");
		player11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 11;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player11.setIcon(new ImageIcon(path + "\\players_icon\\\u0395\u03BB\u03B9\u03C3\u03AC\u03B2\u03B5\u03C4.jpg"));
		player11.setForeground(Color.WHITE);
		player11.setBackground(Color.WHITE);
		player11.setBounds(405, 250, 74, 104);
		choiceFrame.getContentPane().add(player11);

		JLabel player12 = new JLabel("");
		player12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 12;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player12.setIcon(new ImageIcon(path + "\\players_icon\\\u0395\u03BC\u03BC\u03B1\u03BD\u03BF\u03C5\u03AE\u03BB.jpg"));
		player12.setForeground(Color.WHITE);
		player12.setBackground(Color.WHITE);
		player12.setBounds(491, 250, 74, 104);
		choiceFrame.getContentPane().add(player12);

		JLabel player13 = new JLabel("new");
		player13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 13;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player13.setIcon(new ImageIcon(path + "\\players_icon\\\u0395\u03C5\u03B3\u03AD\u03BD\u03B9\u03BF\u03C2.jpg"));
		player13.setForeground(Color.WHITE);
		player13.setBackground(Color.WHITE);
		player13.setBounds(61, 367, 74, 104);
		choiceFrame.getContentPane().add(player13);

		JLabel player14 = new JLabel("new");
		player14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 14;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player14.setIcon(new ImageIcon(path + "\\players_icon\\\u0397\u03BB\u03AF\u03B1\u03C2.jpg"));
		player14.setForeground(Color.WHITE);
		player14.setBackground(Color.WHITE);
		player14.setBounds(147, 367, 74, 104);
		choiceFrame.getContentPane().add(player14);

		JLabel player15 = new JLabel("new");
		player15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 15;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player15.setIcon(new ImageIcon(path + "\\players_icon\\\u0398\u03C9\u03BC\u03AC\u03C2.jpg"));
		player15.setForeground(Color.WHITE);
		player15.setBackground(Color.WHITE);
		player15.setBounds(233, 367, 74, 104);
		choiceFrame.getContentPane().add(player15);

		JLabel player16 = new JLabel("new");
		player16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 16;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player16.setIcon(new ImageIcon(path + "\\players_icon\\\u0399\u03AC\u03C3\u03C9\u03BD.jpg"));
		player16.setForeground(Color.WHITE);
		player16.setBackground(Color.WHITE);
		player16.setBounds(319, 367, 74, 104);
		choiceFrame.getContentPane().add(player16);

		JLabel player17 = new JLabel("new");
		player17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 17;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player17.setIcon(new ImageIcon(path + "\\players_icon\\\u0399\u03BF\u03C1\u03B4\u03AC\u03BD\u03B7\u03C2.jpg"));
		player17.setForeground(Color.WHITE);
		player17.setBackground(Color.WHITE);
		player17.setBounds(405, 367, 74, 104);
		choiceFrame.getContentPane().add(player17);

		JLabel player18 = new JLabel("new");
		player18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 18;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player18.setIcon(new ImageIcon(path + "\\players_icon\\\u0399\u03C9\u03B1\u03BA\u03B5\u03AF\u03BC.jpg"));
		player18.setHorizontalAlignment(SwingConstants.LEFT);
		player18.setForeground(Color.WHITE);
		player18.setBackground(Color.WHITE);
		player18.setBounds(491, 367, 74, 104);
		choiceFrame.getContentPane().add(player18);

		JLabel player19 = new JLabel("new");
		player19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 19;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player19.setIcon(new ImageIcon(path + "\\players_icon\\\u039B\u03C5\u03B4\u03AF\u03B1.jpg"));
		player19.setForeground(Color.WHITE);
		player19.setBackground(Color.WHITE);
		player19.setBounds(61, 480, 74, 104);
		choiceFrame.getContentPane().add(player19);

		JLabel player20 = new JLabel("new");
		player20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 20;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player20.setIcon(new ImageIcon(path + "\\players_icon\\\u039C\u03B1\u03B3\u03B4\u03B1\u03BB\u03B7\u03BD\u03AE.jpg"));
		player20.setForeground(Color.WHITE);
		player20.setBackground(Color.WHITE);
		player20.setBounds(147, 480, 74, 104);
		choiceFrame.getContentPane().add(player20);

		JLabel player21 = new JLabel("new");
		player21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 21;choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player21.setIcon(new ImageIcon(path + "\\players_icon\\\u039C\u03AC\u03BE\u03B9\u03BC\u03BF\u03C2.jpg"));
		player21.setForeground(Color.WHITE);
		player21.setBackground(Color.WHITE);
		player21.setBounds(233, 480, 74, 104);
		choiceFrame.getContentPane().add(player21);

		JLabel player22 = new JLabel("new");
		player22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 22;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player22.setIcon(new ImageIcon(path + "\\players_icon\\\u039C\u03B9\u03C7\u03B1\u03AE\u03BB.jpg"));
		player22.setForeground(Color.WHITE);
		player22.setBackground(Color.WHITE);
		player22.setBounds(319, 480, 74, 104);
		choiceFrame.getContentPane().add(player22);

		JLabel player23 = new JLabel("new");
		player23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 23;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player23.setIcon(new ImageIcon(path + "\\players_icon\\\u03A1\u03B5\u03B2\u03AD\u03BA\u03BA\u03B1.jpg"));
		player23.setForeground(Color.WHITE);
		player23.setBackground(Color.WHITE);
		player23.setBounds(405, 480, 74, 104);
		choiceFrame.getContentPane().add(player23);

		JLabel player24 = new JLabel("new");
		player24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFaceCode = 24;
				choiceFrame.dispose();
				EventQueue.invokeLater(new Runnable(){
					public void run(){
						try{
							MainGamePanel window = new MainGamePanel(levelSelection,selectedFaceCode);
							window.frmGuessWho.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		player24.setIcon(new ImageIcon(path + "\\players_icon\\\u03A4\u03B1\u03C4\u03B9\u03B1\u03BD\u03AE.jpg"));
		player24.setForeground(Color.WHITE);
		player24.setBackground(Color.WHITE);
		player24.setBounds(491, 480, 74, 104);
		choiceFrame.getContentPane().add(player24);
				
	}

	public int getSelectedFaceCode() {
		return selectedFaceCode;
	}
}
