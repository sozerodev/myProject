package miniProject.mine.hangman;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * @author Soyoung Kim
 * when 2020-04-05
 * @version 1.0
 */

public class PlayFrame extends JFrame {
	

	// GUI 필드 편수 ===================
	private JTextField userAnswer;
	private JTextField answeredField;
	private JTextField missedField;
	private JTextField countField;
	public JButton btnQuit = new JButton("Quit");
	private JPanel mainPanel = new JPanel();

	// 사용자가 miss할때마다 그림이 바뀌는 라벨 
	public JPanel humanPanel = new JPanel();
	private JLabel humanDieLabel = new JLabel("");
	// JLabel을 setIcon()할때마다 다른 패널이 프레임에서 사라지는 문제 때문에 JButton으로 대체한다.
	//	private JButton humanDiePicture = new JButton();
	//	 JButton으로 바꿔도 문제가 발생한다...ㅠ 



	// ===============================

	// 게임용 필드 변수 --------------------------------------------------------------------------------------------------------------------

		private String[] wordArr = {"interface", "default", "extends", "serialized",  
				"abstract", "continue", "package", "assert", "private", "throw", "boolean", 
				"protected", "public", "throws", "break",
				"double", "import", "public", "transient", "blueberry",
				"return", "extends", "void", "catch", "final", "interface", "static", "finally", 
				"super","class", "float", "native", "switch", "while" };
	
	// 테스트용 
//	private String[] wordArr = {"serialized"};


	// 게임횟수 카운트 
	private int cnt = 7;

	// wordArr중에 어떤 것을 뽑을지 선택하기 위한 point
	int point = (int)(Math.random()*wordArr.length);

	// 컴퓨터가 제시한 정답 단어 
	String computerAnswer = wordArr[point].toLowerCase(); // 소문자로 바꿔주기 
	char[] computerAnswerArr = computerAnswer.toCharArray();
	ArrayList<Character> computerAnswerList = new ArrayList<>();



	// 사용자가 입력한 값을 배열/리스트로 초기화 
	ArrayList<Character> userAnswerList = new ArrayList<>();

	// 사용자가 미스한 값을 저장하기 위한 리스트 선언 
	ArrayList<Character> userMissedList = new ArrayList<>();


	// ------------------------------------------------------------------------------------------------------------------------------

	public void playGame(char userInput) {
		System.out.println("패널에서 playGame()메소드가 호출되었습니다. "); 

		if (computerAnswerList.contains(userInput)) {  // 사용자가 입력한 단어가 정답에 있는 경우 -----------------------------
			System.out.println("사용자가 입력한 단어가 답에 있는 경우 ");
			for (int i = 0; i < computerAnswer.length(); i++) {
				if (userAnswer.getText().charAt(0) == computerAnswerArr[i]) {
					userAnswerList.set(i, computerAnswerArr[i]);
				}
			} 
			// 단어가 맞았을 경우 추가된 userAnswerList를 answeredField에 갱신해주기 
			answeredField.setText(userAnswerList.toString());
			System.out.println("사용자가 입력한 단어가 맞아서 userAnswerList가 갱신됨 : " + userAnswerList.toString());



		} else { // 사용자가 입력한 단어가 정답에 없는 경우 -----------------------------
			System.out.println("사용자가 입력한 단어가 답에 없는 경우");
			countField.setText(Integer.toString(--cnt)); // 카운트다운을 줄이면서 countField값 수정하기 

			changeLabelOfHuman(cnt); // 사람 그림 바꾸기 (인간이 죽어간다..ㅠ) 

			userMissedList.add(userInput);
			missedField.setText(userMissedList.toString());

		}

		int response = -1;
		// 사용자가 승리한 경우 
		if (userAnswerList.equals(computerAnswerList)) { 
			System.out.println("사용자 모두 맞춤!");

			humanPanel.remove(humanDieLabel);

			humanDieLabel.setBounds(108, 67, 120, 108);
			humanPanel.add(humanDieLabel);
			humanDieLabel.setForeground(Color.RED);
			humanDieLabel.setBackground(new Color(255, 204, 51));

			humanDieLabel.setIcon(new ImageIcon("./img/8_winner.png"));
			repaint();
			humanDieLabel.setBounds(108, 67, 120, 108);

			JDialog.setDefaultLookAndFeelDecorated(true);
			response = JOptionPane.showConfirmDialog(null, "답을 맞췄습니다! 게임을 계속하시겠습니까?", "Congratulation!",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (response == JOptionPane.NO_OPTION) {
				System.out.println("No button clicked");
//				new GameSelectView();
				dispose();
				System.exit(0);
				
			} else if (response == JOptionPane.YES_OPTION) {
				System.out.println("Yes button clicked");
				dispose();
				new MainFrame();
				
			} else if (response == JOptionPane.CLOSED_OPTION) {
				System.out.println("JOptionPane closed");
			}




			// 
		}


		// 사용자가 패배한 경우 
		if (cnt < 1) { // 카운트다운 끝. 인간이 죽은 경우 
			System.out.println("카운트다운 끝. 유저의 패배.");

			JDialog.setDefaultLookAndFeelDecorated(true);
			response = JOptionPane.showConfirmDialog(null, "답은 "+ computerAnswer +"입니다.ㅠㅠ 게임을 계속 하시겠습니까?", "Ooops...",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (response == JOptionPane.NO_OPTION) {
				System.out.println("No button clicked");
				dispose();
				System.exit(0);
				
			} else if (response == JOptionPane.YES_OPTION) {
				System.out.println("Yes button clicked");
				dispose();
				new MainFrame();
				
			} else if (response == JOptionPane.CLOSED_OPTION) {
				System.out.println("JOptionPane closed");
			}
		}


	}


	public PlayFrame(String userName) {  // PlayPanel의 메인패널. 가장 큰 패널. 
		super("Save the Hang Man! or else....!");
		System.out.println("정답 : " + computerAnswer);


		// GUI 셋팅 ============================\		super("Save the Hang Man");
		
		// 프레임 셋팅 
		setBounds(0, 0, 780, 650);
		setLocationRelativeTo(null); // 가운데 정렬 
		setResizable(false); // 창 크기조절 못하도록 
		setBackground(new Color(0, 0, 204));
		setBounds(0, 0, 780, 650);
		
		getContentPane().setLayout(null);
		
		// mainPanel 셋팅 
		mainPanel.setFont(new Font("Press Start K", Font.PLAIN, 20)); // 폰트 설정 
		mainPanel.setBounds(0, 0, 780, 650);
		mainPanel.setBackground(new Color(0, 0, 204));
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		// ====================================

		// 게임 세팅 ============================
		// inputedPanel에 들어갈 값 초기화
		// 카운트다운동안 사용자가 입력할 userAnswerList에 대한 초기화 
		for (int i = 0; i < computerAnswer.length(); i++) {
			userAnswerList.add('ㅡ');
		}

		// 
		for (char c : computerAnswerArr) {
			computerAnswerList.add(c);
		}
		// ====================================


		// 1. humanPanel 시작 ====================================================================

		//		JPanel humanPanel = new JPanel();
		humanPanel.setBackground(new Color(255, 204, 51));
		humanPanel.setBounds(46, 40, 351, 248);
		mainPanel.add(humanPanel);
		humanPanel.setLayout(null);

		// 그림 바뀌는 라벨 ------------------------------------------------------------------------------------- 
		//		JLabel humanDieLabel = new JLabel(""); // changeLabelOfHuman()메소드에서 그림을 바꿔야하니까 필드변수로 옮긴다.
		humanDieLabel.setBounds(108, 67, 120, 108);
		humanPanel.add(humanDieLabel);
		humanDieLabel.setForeground(Color.RED);
		humanDieLabel.setBackground(new Color(255, 204, 51));
		humanDieLabel.setIcon(new ImageIcon("./img/1_turn.png"));
		//		humanDiePicture.setIcon(new ImageIcon("./img/2_turn.png"));// 두번해도 패널이 안넘어가는데 왜... 
		// ---------------------------------------------------------------------------------------------------

		JPanel userInputPanel = new JPanel();
		userInputPanel.setBackground(new Color(0, 0, 204));
		userInputPanel.setBounds(409, 23, 365, 282);
		mainPanel.add(userInputPanel);
		userInputPanel.setLayout(null);

		// humanPanel 끝 ====================================================================




		// 2. userInputPanel 시작 ====================================================================
		// 사용자가 단어를 입력하는 필드 -----------------------------------------

		JLabel label = new JLabel(userName + "'s GAME\n");
		label.setForeground(new Color(255, 204, 0));
		label.setFont(new Font("Press Start K", Font.BOLD, 23));
		label.setBounds(6, 6, 326, 60);
		userInputPanel.add(label);

		JLabel lblNewLabel_2 = new JLabel("CountDown :");
		lblNewLabel_2.setBounds(6, 65, 258, 60);
		userInputPanel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 204, 0));
		lblNewLabel_2.setFont(new Font("Press Start K", Font.BOLD, 23));

		// 카운트다운 필드 
		countField = new JTextField();
		countField.setFont(new Font("Press Start K", Font.PLAIN, 26));
		countField.setHorizontalAlignment(SwingConstants.CENTER);
		countField.setText(Integer.toString(cnt));
		countField.setForeground(new Color(255, 51, 0));
		countField.setBackground(new Color(0, 0, 204));
		countField.setBounds(258, 70, 82, 55);
		userInputPanel.add(countField);
		countField.setColumns(10);

		// 사용자가 단어 하나를 입력하는 창 
		
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
		
		
		// -------------------------------
		userAnswer.setFocusable(true);
		userAnswer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode() ==KeyEvent.VK_ENTER){ 
					System.out.println("엔터키 이벤트 실행 ");
					playGame(userAnswer.getText().charAt(0));
					userAnswer.setText("");
					
				}
			}
		});
		
		// -------------------------------

		btnQuit.setBackground(new Color(255, 204, 0));
		btnQuit.setForeground(new Color(0, 0, 153));
		btnQuit.setFont(new Font("Press Start K", Font.PLAIN, 20));
		btnQuit.setBounds(87, 209, 144, 67);
		userInputPanel.add(btnQuit);

		// -----------------------------------------------------------------

		// userInputPanel 끝 ====================================================================

		// 3. inputedPanel 시작 ====================================================================

		JPanel inputedPanel = new JPanel();
		inputedPanel.setBackground(new Color(0, 0, 204));
		inputedPanel.setBounds(6, 338, 743, 254);
		mainPanel.add(inputedPanel);
		inputedPanel.setLayout(null);
		

		//  맞는 단어 입력되는 라벨/필드 ----------------------------------------------------------------------------
		JLabel countLabel = new JLabel(computerAnswer.length() + "chars:");
		countLabel.setBounds(260, 16, 230, 37);
		inputedPanel.add(countLabel);
		countLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countLabel.setForeground(new Color(255, 204, 0));
		countLabel.setFont(new Font("Press Start K", Font.BOLD, 28));

		
		answeredField = new JTextField(userAnswerList.toString());
		answeredField.setFont(new Font("Press Start K", Font.PLAIN, 20));
		answeredField.setHorizontalAlignment(SwingConstants.CENTER);
		//		answeredField.setText("nullpointerexception");
		answeredField.setForeground(new Color(255, 204, 0));
		answeredField.setBackground(new Color(0, 0, 204));
		answeredField.setBounds(6, 72, 731, 90);
		inputedPanel.add(answeredField);
		answeredField.setColumns(10);
		// ----------------------------------------------------------------------------


		// 틀린 단어 입력되는 라벨/필드 ----------------------------------------------------------------------------
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


		// playPanel()에서 playGame()메소드 호출하기 ------------------------------------------------
		btnQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JDialog.setDefaultLookAndFeelDecorated(true);
				int response = JOptionPane.showConfirmDialog(null, "게임을 그만하고 메인으로 가시겠습니까?", "what's wrong?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (response == JOptionPane.NO_OPTION) {
					System.out.println("No button clicked");
					
				} else if (response == JOptionPane.YES_OPTION) {
					System.out.println("Yes button clicked");
					dispose();
//					new GameSelectView();  // 게임 셀렉뷰로 넘어가기
					System.exit(0);
					
				} else if (response == JOptionPane.CLOSED_OPTION) {
					System.out.println("JOptionPane closed");
				}
			


			}
		});
		
		
		
		// ----------------------------------------------------------------------------------------

		// 입력창을 클릭하면 이전에 입력된 글자들을 싹 사라지게 해주는 코드 -------------------------------
		userAnswer.addMouseListener(new MouseAdapter() {    
			@Override
			public void mouseClicked(MouseEvent e) {
				//				check = true;
				userAnswer.setText("");
			}
		});
		// ----------------------------------------------------------------------------------------

		
		add(mainPanel);
		setVisible(true);
//		new PlayMusic("Blues.wav"); // 음악 재생 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

	public void changeLabelOfHuman(int cnt) {
		// human패널의 사람그림을 바꾸는 메소드 
		System.out.println(">>사람그림바꾸기!<<");
		System.out.println(cnt);

		int num = 8;

		if (cnt == 0) { 
			humanPanel.remove(humanDieLabel);

			humanDieLabel.setBounds(108, 67, 120, 108);
			humanPanel.add(humanDieLabel);
			humanDieLabel.setForeground(Color.RED);
			humanDieLabel.setBackground(new Color(255, 204, 51));
			humanDieLabel.setBounds(108, 67, 120, 108);

			if (userAnswerList.equals(computerAnswerList)) { // 이겼을 때 
				humanDieLabel.setIcon(new ImageIcon("./img/8_winner"));

			} else { // 졌을 때 
				humanDieLabel.setIcon(new ImageIcon("./img/8_lost.png"));

			}


		}else { // 목숨이 하나 남았을 때 

			humanPanel.remove(humanDieLabel);

			humanDieLabel.setBounds(108, 67, 120, 108);
			humanPanel.add(humanDieLabel);
			humanDieLabel.setForeground(Color.RED);
			humanDieLabel.setBackground(new Color(255, 204, 51));

			humanDieLabel.setIcon(new ImageIcon("./img/" + (num - cnt) + "_turn.png"));
			repaint();
			humanDieLabel.setBounds(108, 67, 120, 108);

		}
		repaint();
	}
	
	
	
	

}
