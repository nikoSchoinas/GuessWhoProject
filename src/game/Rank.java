package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class Rank {

	JFrame frmGuessWho;
	private DefaultListModel model_Names = new DefaultListModel();//model for the jlist
	private String playersName;//the players name

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
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage(path + "\\logo2.jpg"));
		frmGuessWho.setTitle("Guess Who ?\r\n");
		frmGuessWho.setBounds(100, 100, 445, 300);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		frmGuessWho.setResizable(false);
		
		FileEditor rankFile = new FileEditor();//use the file with the users
		rankFile.sortList();//sort it 
		ArrayList<GamerProfile> playersArray = rankFile.getRankFile();//and make an array of the players with their statistics
		
		JButton BackButton = new JButton("Back\r\n");//back button
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
		
		JList list_Name = new JList();//list with the name of the players
		for(int i =0;i<playersArray.size();i++){
			model_Names.addElement(playersArray.get(i).getName());
		}
		
		
		list_Name.setModel(model_Names);
		list_Name.setBounds(107, 29, 101, 221);
		//list_Name.setBackground(Color.WHITE);
		frmGuessWho.getContentPane().add(list_Name);
		list_Name.setCellRenderer(new TransparentListCellRenderer());//make jlist transparent
        list_Name.setOpaque(false);
        
        
		JLabel nameLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nameLabel.setBounds(107, 3, 100, 25);
		frmGuessWho.getContentPane().add(nameLabel);
		
		
		JLabel PointLabel = new JLabel("\u03A0\u03CC\u03BD\u03C4\u03BF\u03B9");
		PointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PointLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PointLabel.setBounds(219, 3, 100, 25);
		frmGuessWho.getContentPane().add(PointLabel);
			

		
		JList list_Points = new JList();//list with the points of the players
		list_Points.setBounds(258, 29, 33, 221);
		DefaultListModel model_Points = new DefaultListModel();
		for(int i =0;i<playersArray.size();i++){
			model_Points.addElement(playersArray.get(i).getPoints());
		}
		list_Points.setModel(model_Points);
		list_Points.setCellRenderer(new TransparentListCellRenderer());//make jlist transparent
        list_Points.setOpaque(false);
		frmGuessWho.getContentPane().add(list_Points);
		
		JLabel Background = new JLabel("New label");//background
		Background.setIcon(new ImageIcon(path + "//background4.jpg"));
		Background.setBounds(0, 0, 444, 271);
		frmGuessWho.getContentPane().add(Background);
		
		
	}
	
	   public class TransparentListCellRenderer extends DefaultListCellRenderer {//creating a class that make jlist transparent

		      
	        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	            setForeground(Color.WHITE);
	            setOpaque(isSelected);
	            return this;
	        }

	    }
}
