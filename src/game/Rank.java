package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Rank {

	JFrame frmGuessWho;
	private DefaultListModel model;

	/**
	 * Create the application.
	 */
	public Rank() {
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
		ArrayList<GamerProfile> playersArray = rankFile.getRankFile();
		
		JButton BackButton = new JButton("Back\r\n");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGuessWho.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Mainframe window = new Mainframe();
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
		
		JList list = new JList();
		for(int i =0;i<playersArray.size();i++){
			model.addElement(playersArray.get(i).getName());
		}
		list.setModel(model);
		list.setBounds(107, 29, 101, 221);
		frmGuessWho.getContentPane().add(list);
		
		JLabel nameLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nameLabel.setBounds(122, 3, 100, 25);
		frmGuessWho.getContentPane().add(nameLabel);
		
		JLabel PointLabel = new JLabel("\u03A0\u03CC\u03BD\u03C4\u03BF\u03B9");
		PointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PointLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PointLabel.setBounds(234, 3, 100, 25);
		frmGuessWho.getContentPane().add(PointLabel);
		
		JList NameList = new JList();
		NameList.setBounds(125, 101, 1, 1);
		frmGuessWho.getContentPane().add(NameList);
		
		JList PointList = new JList();
		PointList.setBounds(272, 101, 1, 1);
		frmGuessWho.getContentPane().add(PointList);
		
		JList list_1 = new JList();		
		for(int i =0;i<playersArray.size();i++){
			model.addElement(playersArray.get(i).getPoints());
		}
		list_1.setModel(model);
		list_1.setBounds(238, 29, 101, 221);
		frmGuessWho.getContentPane().add(list_1);
		
		JLabel Background = new JLabel("New label");
		Background.setIcon(new ImageIcon("C:\\Users\\kostas\\workspace\\game\\question-mark-background-vector.jpg"));
		Background.setBounds(0, -5, 442, 268);
		frmGuessWho.getContentPane().add(Background);
	}
}
