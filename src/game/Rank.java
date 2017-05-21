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
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rank {

	JFrame frmGuessWho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rank window = new Rank();
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
	public Rank() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuessWho = new JFrame();
		frmGuessWho.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kostas\\workspace\\game\\533038-guess-who-windows-screenshot-the-game-s-title-screen.png"));
		frmGuessWho.setTitle("Guess Who ?\r\n");
		frmGuessWho.setBounds(100, 100, 450, 300);
		frmGuessWho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessWho.getContentPane().setLayout(null);
		frmGuessWho.setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("Back\r\n");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(349, 117, 71, 25);
		frmGuessWho.getContentPane().add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(75, 32, 118, 212);
		frmGuessWho.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(Color.LIGHT_GRAY);
		textPane_1.setBounds(220, 31, 118, 212);
		frmGuessWho.getContentPane().add(textPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kostas\\Desktop\\Black.jpg"));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(205, 3, 3, 252);
		frmGuessWho.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label.setBounds(122, 3, 100, 25);
		frmGuessWho.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u03A0\u03CC\u03BD\u03C4\u03BF\u03B9");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_1.setBounds(234, 3, 100, 25);
		frmGuessWho.getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\kostas\\workspace\\game\\question-mark-background-vector.jpg"));
		lblNewLabel.setBounds(0, 3, 442, 268);
		frmGuessWho.getContentPane().add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(125, 101, 1, 1);
		frmGuessWho.getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(272, 101, 1, 1);
		frmGuessWho.getContentPane().add(list_1);
	}
}
