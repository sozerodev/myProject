package miniProject.mine.hangman;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


// 현재 수정/추가해야할 부분 
//   1. play패널에서 userAnswer Field()에 입력 안하고 btnGo를 누를 경우 오류가 나는 부분 수정하기 



public class PlayPanel extends JPanel {

	
	// GUI 필드 편수 ===================
	private JTextField userAnswer;
	private JTextField answeredField;
	private JTextField missedField;
	private JTextField countField;
	public JButton btnGo = new JButton("Go!");
	// ===============================
	
	// 게임용 필드 변수 --------------------------------------------------------------------------------------------------------------------
	
//	private String[] wordArr = {"implements", "interface", "default", "extends", "synchronized", "serialized", "arrayindexoutofbounds",  
//			"abstract", "continue", "package", "assert", "private", "throw", "boolean", 
//			"protected", "public", "throws", "break", "filenotfoundexception", "eofexception",
//			"double", "import", "public", "transient", "blueberry", "instanceof", "nullpointerexception",
//			"return", "extends", "void", "catch", "final", "interface", "static", "finally", 
//			"super","class", "float", "native", "switch", "while", "synchronized", };
	// 테스트용 
	private String[] wordArr = {"NullPointerException", "boolean"};
	
	
	// 게임횟수 카운트 
	private int cnt = 8;

	// wordArr중에 어떤 것을 뽑을지 선택하기 위한 point
	int point = (int)(Math.random()*wordArr.length);
	
	// 컴퓨터가 제시한 정답 단어 
	String computerAnswer = wordArr[point];
	
	// ------------------------------------------------------------------------------------------------------------------------------

	public void playGame(char userInput) {
		
		System.out.println("패널에서 playGame()메소드가 호출되었습니다. "); 
		
		
		
	}
	
	
	
	
	
	public PlayPanel(String userName) {

		// GUI 셋팅 ============================
		setBackground(new Color(0, 0, 204));
		setBounds(0, 0, 780, 650);
		// ====================================
		
		
		

		// 1. humanPanel 시작 ====================================================================

		JPanel humanPanel = new JPanel();
		humanPanel.setBackground(new Color(255, 204, 51));
		humanPanel.setBounds(46, 40, 351, 248);
		this.add(humanPanel);
		humanPanel.setLayout(null);

		// 그림 바뀌는 라벨 ------------------------------------------------------------------------------------- 
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(108, 67, 120, 108);
		humanPanel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setIcon(new ImageIcon("/Users/SO/Desktop/HangManImg/120px-Hangman-0 복사본.png"));
		// ---------------------------------------------------------------------------------------------------
		
		JPanel userInputPanel = new JPanel();
		userInputPanel.setBackground(new Color(0, 0, 204));
		userInputPanel.setBounds(409, 23, 365, 282);
		this.add(userInputPanel);
		userInputPanel.setLayout(null);

		// humanPanel 끝 ====================================================================


		
		
		// 2. userInputPanel 시작 ====================================================================

		JLabel lblNewLabel_1 = new JLabel("Input :\n");
		lblNewLabel_1.setForeground(new Color(255, 204, 0));
		lblNewLabel_1.setBounds(25, 130, 160, 79);
		userInputPanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Press Start K", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);

		
		// 사용자가 단어를 입력하는 필드 -----------------------------------------
		userAnswer = new JTextField();
		userAnswer.setForeground(new Color(0, 0, 255));
		userAnswer.setBackground(new Color(255, 204, 0));
		userAnswer.setBounds(185, 137, 108, 67);
		userInputPanel.add(userAnswer);
		userAnswer.setFont(new Font("Press Start K", Font.PLAIN, 18));
		userAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		userAnswer.setColumns(10);
		// -----------------------------------------------------------------

//		JButton btnGo = new JButton("Go!"); // playGame()메소드에서도 쓰기 위해서 필드변수로 옮겨준다.
		btnGo.setBackground(new Color(255, 204, 0));
		btnGo.setForeground(new Color(0, 0, 153));
		btnGo.setFont(new Font("Press Start K", Font.PLAIN, 20));
		btnGo.setBounds(87, 209, 144, 67);
		userInputPanel.add(btnGo);

		JLabel lblNewLabel_2 = new JLabel("CountDown :");
		lblNewLabel_2.setBounds(6, 65, 258, 60);
		userInputPanel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 204, 0));
		lblNewLabel_2.setFont(new Font("Press Start K", Font.BOLD, 23));

		countField = new JTextField();
		countField.setFont(new Font("Press Start K", Font.PLAIN, 26));
		countField.setHorizontalAlignment(SwingConstants.CENTER);
		countField.setText("8");
		countField.setForeground(new Color(255, 51, 0));
		countField.setBackground(new Color(0, 0, 204));
		countField.setBounds(258, 70, 82, 55);
		userInputPanel.add(countField);
		countField.setColumns(10);

		JLabel label = new JLabel(userName + "'s GAME\n");
		label.setForeground(new Color(255, 204, 0));
		label.setFont(new Font("Press Start K", Font.BOLD, 23));
		label.setBounds(6, 6, 326, 60);
		userInputPanel.add(label);

		// userInputPanel 끝 ====================================================================

		// 3. inputedPanel 시작 ====================================================================
		
		JPanel inputedPanel = new JPanel();
		inputedPanel.setBackground(new Color(0, 0, 204));
		inputedPanel.setBounds(6, 338, 743, 254);
		this.add(inputedPanel);
		inputedPanel.setLayout(null);



		//  맞는 단어 입력되는 라벨 ----------------------------------------------------------------------------
		JLabel countLabel = new JLabel(computerAnswer.length() + "chars:");
		countLabel.setBounds(6, 49, 240, 37);
		inputedPanel.add(countLabel);
		countLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countLabel.setForeground(new Color(255, 204, 0));
		countLabel.setFont(new Font("Press Start K", Font.BOLD, 28));
		
		answeredField = new JTextField();
		answeredField.setFont(new Font("Press Start K", Font.PLAIN, 21));
		answeredField.setHorizontalAlignment(SwingConstants.CENTER);
//		answeredField.setText("nullpointerexception");
		answeredField.setForeground(new Color(255, 204, 0));
		answeredField.setBackground(new Color(0, 0, 204));
		answeredField.setBounds(248, 25, 489, 90);
		inputedPanel.add(answeredField);
		answeredField.setColumns(10);
		// ----------------------------------------------------------------------------

		
		// 틀린 단어 입력되는 라벨 ----------------------------------------------------------------------------
		JLabel userHistory = new JLabel("Missed :");
		userHistory.setBounds(6, 185, 254, 37);
		inputedPanel.add(userHistory);
		userHistory.setForeground(new Color(255, 204, 0));
		userHistory.setHorizontalAlignment(SwingConstants.CENTER);
		userHistory.setFont(new Font("Press Start K", Font.BOLD, 28));
		
		missedField = new JTextField();
		missedField.setFont(new Font("Press Start K", Font.PLAIN, 21));
		missedField.setHorizontalAlignment(SwingConstants.CENTER);
//		missedField.setText("dddd");
		missedField.setForeground(new Color(255, 204, 0));
		missedField.setBackground(new Color(0, 0, 204));
		missedField.setBounds(245, 174, 492, 71);
		inputedPanel.add(missedField);
		missedField.setColumns(10);
		
		// ----------------------------------------------------------------------------
		// inputedPanel 끝 ====================================================================

		
		// GUI에서 playGame()메소드 호출하기 =======================================
		btnGo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("PlayPanel()에서 playGame()메소드를 호출했습니다.");
				playGame(userAnswer.getText().charAt(0));
				
			}
		});
		
		
		
		
		
		
	}
	


}
