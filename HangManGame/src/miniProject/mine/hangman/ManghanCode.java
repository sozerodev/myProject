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


// 망한 코드... 스파게티처럼 짜버려서 가독성도 너무 안좋고 에러가 났을때 문제지점 파악하기가 너무 힘들다.
// 뒤엎자...뒤엎자...^-ㅠ.... 


public class ManghanCode extends JPanel {

	private JTextField userAnswer;
	private int cnt = 1; // 입력 실패한 횟수 
	private String txtO;
	private String txtX;

	public ManghanCode(String userName) {

		// 게임 준비 ======================================================================
		String[] wordList = {"implements", "interface", "default", "extends", "synchronized", "serialized", "arrayindexoutofbounds",  
				"abstract", "continue", "package", "assert", "private", "throw", "boolean", 
				"protected", "public", "throws", "break", "filenotfoundexception", "eofexception",
				"double", "import", "public", "transient", "blueberry", "instanceof", "nullpointerexception",
				"return", "extends", "void", "catch", "final", "interface", "static", "finally", 
				"super","class", "float", "native", "switch", "while", "synchronized", };



		int point = (int)(Math.random()*wordList.length);

		// 치트키 
		System.out.println(wordList[point]);

		// 제시된 정답 단어를 리스트로 넣어주기 
		char[] answerArr = wordList[point].toCharArray();
		ArrayList<Character> answerList = new ArrayList<>();

		for (char c : answerArr) {
			answerList.add(c);
		}



		// 사용자의 정답이 매번 갱신될때마다 기록해주기 위한 리스트 
		ArrayList<Character> userAnswerList = new ArrayList<>();
		for (int i = 0; i < answerList.size(); i++) {
			userAnswerList.add('ㅡ');
		}

		System.out.println(userAnswerList);



		StringBuilder showUserAns = new StringBuilder();
		for (int i = 0; i < userAnswerList.size(); i++) {
			showUserAns.append('ㅡ');
			showUserAns.append(' ');

		}



		// ===============================================================================


		setBackground(new Color(0, 0, 204));
		setBounds(0, 0, 780, 650);

		JPanel humanPanel = new JPanel();
		humanPanel.setBackground(new Color(255, 204, 51));
		humanPanel.setBounds(46, 53, 351, 248);
		humanPanel.setLayout(null);

		// 그림 바뀌는 라벨 
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(108, 67, 120, 108);
		humanPanel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setIcon(new ImageIcon("./img/8_winner.png"));

		JPanel userInputPanel = new JPanel();
		userInputPanel.setBackground(new Color(0, 0, 204));
		userInputPanel.setBounds(420, 107, 304, 194);
		userInputPanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Input :\n");
		lblNewLabel_1.setForeground(new Color(255, 204, 0));
		lblNewLabel_1.setBounds(18, 1, 160, 79);
		userInputPanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Press Start K", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);

		userAnswer = new JTextField();
		userAnswer.setForeground(new Color(0, 0, 255));
		userAnswer.setBackground(new Color(255, 204, 0));
		userAnswer.setBounds(179, 8, 108, 67);
		userAnswer.setFont(new Font("Press Start K", Font.PLAIN, 18));
		userAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		userAnswer.setColumns(10);
		userInputPanel.add(userAnswer);

		JButton btnGo = new JButton("Go!");
		btnGo.setBackground(new Color(255, 204, 0));
		btnGo.setForeground(new Color(0, 0, 153));
		btnGo.setFont(new Font("Press Start K", Font.PLAIN, 20));
		btnGo.setBounds(77, 108, 144, 100);
		userInputPanel.add(btnGo);

		JLabel lblNewLabel_2 = new JLabel(userName + "'s " + cnt + "th turn\n"); 

		lblNewLabel_2.setForeground(new Color(255, 204, 0));
		lblNewLabel_2.setFont(new Font("Press Start K", Font.BOLD, 15));
		lblNewLabel_2.setBounds(423, 35, 326, 60);
		this.add(lblNewLabel_2);

		
		JPanel inputed = new JPanel();
		inputed.setBackground(new Color(0, 0, 204));
		inputed.setBounds(20, 338, 729, 254);
		inputed.setLayout(null);
		this.add(inputed);
		
		JTextField lblNewLabel_3 = new JTextField();

		lblNewLabel_3.setText(showUserAns.toString());

		lblNewLabel_3.setForeground(new Color(255, 204, 0));
		lblNewLabel_3.setBackground(new Color(0, 0, 204));
		lblNewLabel_3.setFont(new Font("Press Start K", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(6, 39, 714, 18);
		inputed.add(lblNewLabel_3);
		
		JLabel userHistory = new JLabel("who are youuuuuuuuu");
		inputed.add(userHistory);
		userHistory.setForeground(new Color(255, 204, 0));
		userHistory.setHorizontalAlignment(SwingConstants.CENTER);
		userHistory.setFont(new Font("Press Start K", Font.BOLD, 28));
		userHistory.setBounds(90, 139, 534, 29);

		StringBuilder historyTxt = new StringBuilder();
		
		if (cnt == 10)
			return;
		
		lblNewLabel_2.setText(userName + "'s " + cnt + "th turn\n"); 

		  
		btnGo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(cnt);
				

				for (int i = 0; i < answerList.size(); i++ ) {
					System.out.println("여기까지 왓다!!");
					if (userAnswer.getText().charAt(0) == answerList.get(i)) {
						System.out.println("이거다 : " + userAnswer.getText().charAt(0));
						showUserAns.setCharAt(i, userAnswer.getText().charAt(0));
						
//						userAnswerList.set(i, userAnswer.getText().charAt(0));
						System.out.println(showUserAns.toString());
					} else {
						cnt++;
						historyTxt.append(userAnswer.getText().charAt(0));
						// break;
						
					}
				}
//				userHistory.setText(historyTxt.toString());
				System.out.println(cnt);

				StringBuilder answerTxt = new StringBuilder();
				for (int i = 0; i < userAnswerList.size(); i++) {
					if (userAnswerList.get(i) == 'ㅡ') {
						answerTxt.append('ㅡ');
						answerTxt.append(' ');
					} else {
						answerTxt.append(userAnswerList.get(i));
						answerTxt.append(' ');

					}


				}
//				lblNewLabel_3.setText(answerTxt.toString());
//				lblNewLabel_3.setText(userAnswerList.toString());
				System.out.println(showUserAns.toString());
				lblNewLabel_3.setText(showUserAns.toString());
				
				
				
			}
		});
		

		if (userAnswerList.equals(answerList)) {
			// 유저가 단어를 모두 맞췄을 때 

		}
		System.out.println("userAnswerList : " + userAnswerList);
		cnt++;


		this.add(humanPanel);
		this.add(userInputPanel);
		
	}

}




// play패널에서 입력 안하고 Go를 누를 경우 수정하기
