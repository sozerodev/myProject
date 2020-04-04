package miniProject.mine.demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class PlayPanel {

	private JFrame frame;
	private JTextField userAnswer;
	private JTextField answeredField;
	private JTextField missedField;
	private JTextField countField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayPanel window = new PlayPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 204));
		frame.setBounds(100, 100, 780, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel humanPanel = new JPanel();
		humanPanel.setBackground(new Color(255, 204, 51));
		humanPanel.setBounds(46, 40, 351, 248);
		frame.getContentPane().add(humanPanel);
		humanPanel.setLayout(null);
		
		// 그림 바뀌는 라벨 
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(119, 59, 120, 108);
		humanPanel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setIcon(new ImageIcon("/Users/SO/Desktop/HangManImg/120px-Hangman-0 복사본.png"));
		
		JPanel userInputPanel = new JPanel();
		userInputPanel.setBackground(new Color(0, 0, 204));
		userInputPanel.setBounds(409, 23, 365, 282);
		frame.getContentPane().add(userInputPanel);
		userInputPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Input :\n");
		lblNewLabel_1.setForeground(new Color(255, 204, 0));
		lblNewLabel_1.setBounds(25, 130, 160, 79);
		userInputPanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Press Start K", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		userAnswer = new JTextField();
		userAnswer.setForeground(new Color(0, 0, 255));
		userAnswer.setBackground(new Color(255, 204, 0));
		userAnswer.setBounds(185, 137, 108, 67);
		userInputPanel.add(userAnswer);
		userAnswer.setFont(new Font("Press Start K", Font.PLAIN, 18));
		userAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		userAnswer.setColumns(10);
		
		JButton btnNewButton = new JButton("Go!");
		btnNewButton.setBackground(new Color(255, 204, 0));
		btnNewButton.setForeground(new Color(0, 0, 153));
		btnNewButton.setFont(new Font("Press Start K", Font.PLAIN, 20));
		btnNewButton.setBounds(87, 209, 144, 67);
		userInputPanel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("CountDown :");
		lblNewLabel_2.setBounds(6, 65, 258, 60);
		userInputPanel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 204, 0));
		lblNewLabel_2.setFont(new Font("Press Start K", Font.BOLD, 23));
		
		countField = new JTextField();
		countField.setFont(new Font("Press Start K", Font.PLAIN, 26));
		countField.setHorizontalAlignment(SwingConstants.CENTER);
		countField.setText("7");
		countField.setForeground(new Color(255, 51, 0));
		countField.setBackground(new Color(0, 0, 204));
		countField.setBounds(258, 70, 82, 55);
		userInputPanel.add(countField);
		countField.setColumns(10);
		
		JLabel label = new JLabel("UN'S GAME\n");
		label.setForeground(new Color(255, 204, 0));
		label.setFont(new Font("Press Start K", Font.BOLD, 23));
		label.setBounds(6, 6, 326, 60);
		userInputPanel.add(label);
		
		JPanel inputedPanel = new JPanel();
		inputedPanel.setBackground(new Color(0, 0, 204));
		inputedPanel.setBounds(9, 309, 743, 254);
		frame.getContentPane().add(inputedPanel);
		inputedPanel.setLayout(null);
		
		JLabel userHistory = new JLabel("Missed :");
		userHistory.setBounds(6, 185, 254, 37);
		inputedPanel.add(userHistory);
		userHistory.setForeground(new Color(255, 204, 0));
		userHistory.setHorizontalAlignment(SwingConstants.CENTER);
		userHistory.setFont(new Font("Press Start K", Font.BOLD, 28));
		
		answeredField = new JTextField();
		answeredField.setFont(new Font("Press Start K", Font.PLAIN, 17));
		answeredField.setHorizontalAlignment(SwingConstants.CENTER);
		answeredField.setText("[ㅡ, ㅡ, ㅡ, ㅡ, ㅡ, ㅡ]");
		answeredField.setForeground(new Color(255, 204, 0));
		answeredField.setBackground(new Color(0, 0, 204));
		answeredField.setBounds(247, 72, 490, 90);
		inputedPanel.add(answeredField);
		answeredField.setColumns(10);
		
		missedField = new JTextField();
		missedField.setFont(new Font("Press Start K", Font.PLAIN, 21));
		missedField.setHorizontalAlignment(SwingConstants.CENTER);
		missedField.setText("dddd");
		missedField.setForeground(new Color(255, 204, 0));
		missedField.setBackground(new Color(0, 0, 204));
		missedField.setBounds(245, 174, 492, 71);
		inputedPanel.add(missedField);
		missedField.setColumns(10);
		
		JLabel countLabel = new JLabel("nn chars");
		countLabel.setBounds(12, 94, 230, 37);
		inputedPanel.add(countLabel);
		countLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countLabel.setForeground(new Color(255, 204, 0));
		countLabel.setFont(new Font("Press Start K", Font.BOLD, 28));
	}
}
