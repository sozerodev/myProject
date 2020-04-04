package miniProject.mine.hangman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


/*
 * @author Soyoung Kim
 * when 2020-04-05
 * @version 1.0
 */

public class MainFrame extends JFrame {
	public static JFormattedTextField userNameInput = new JFormattedTextField("Name Your Self");
	public static String userName;
	
	private JPanel panel;
	private boolean check;
	private JButton btnStart; // startGame()메소드를 사용하기위해 필드변수로.
	
	public MainFrame() {
		super("Save the Hang Man");
		setBounds(0, 0, 780, 650);
		setLocationRelativeTo(null); // 가운데 정렬 
		setResizable(false); // 창 크기조절 못하도록 
		
		// -----------
		
		getContentPane().setLayout(null);
		
		panel = new JPanel();  
		panel.setFont(new Font("Press Start K", Font.PLAIN, 20)); // 폰트 설정 
		panel.setBounds(0, 0, 780, 650);
		getContentPane().add(panel);
		panel.setLayout(null);
		

//		JFormattedTextField userNameInput = new JFormattedTextField("Name Your Self");
		userNameInput.setText(">>Name Your Self<<");
		userNameInput.setForeground(Color.LIGHT_GRAY);
		userNameInput.setBackground(Color.RED);
		userNameInput.setHorizontalAlignment(SwingConstants.CENTER);
		userNameInput.setFont(new Font("Press Start K", Font.PLAIN, 17));
		userNameInput.setBounds(191, 351, 359, 61);
		userNameInput.addMouseListener(new MouseAdapter() {   // 입력창을 클릭하면 디폴트로 입력된 글자들을 싹 사라지게 해주는 코드 
			@Override
			public void mouseClicked(MouseEvent e) {
//				check = true;
				userNameInput.setText("");
			}
		});
		panel.add(userNameInput);
		
		btnStart = new JButton("PRESS START");

		btnStart.setForeground(Color.RED);
		btnStart.setBackground(Color.BLACK);
		btnStart.setFont(new Font("Press Start K", Font.PLAIN, 26));
		btnStart.setBounds(207, 581, 340, 46);
		
		JLabel msg = new JLabel("Input your name!");
		msg.setFont(new Font("Press Start K", Font.BOLD, 25));
	
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(userNameInput.getText().equals(">>Name Your Self<<") || userNameInput.getText().equals("")) {
//				if (check == false) {
					JOptionPane.showMessageDialog(null, msg, "Name yourself!!", JOptionPane.ERROR_MESSAGE);
					
//					System.out.println("false인 경우 ");
				} else { // nameChk가 true인 경우 
					// 버튼 클릭 시 패널 교체 
//					System.out.println("true인 경우 ");
					dispose();
//					new PlayFrame(userNameInput.getText());
					new PlayFrame(userNameInput.getText()).setLocationRelativeTo(null); // 가운데 정렬 ;
				}
			}
			
		});
		
		panel.add(btnStart);
		
		JButton btnNewButton = new JButton("Go back to Main");
		btnNewButton.setForeground(UIManager.getColor("InternalFrame.borderDarkShadow"));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Press Start K", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(500, 199, 274, 54);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					dispose();
//					new GameSelectView(); // 메인화면으로 돌아가기
					System.exit(0);
				
			}
			
		});

		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Press Start K", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 0, 780, 627);
		panel.add(lblNewLabel);
		Image myImg = new ImageIcon("./img/BackGroundImg.png").getImage().getScaledInstance(780, 650, 0); // 상대경로 설정하기 
		lblNewLabel.setIcon(new ImageIcon(myImg));
		
		
		add(panel);
		setVisible(true);
//		new PlayMusic("Blues.wav"); // 음악 재생 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	
//	public void startGame() { // 게임 실행을 위한 패널 교체 메소드 
//		this.remove(panel);
//		
//		// start버튼 클릭했을때 사용자가 userNameInput에 입력한 것을 set해주기
//		userName = userNameInput.getText();		
//		
////		if (check == true)  // 어차피 check가 true인 경우에만 실행되는 메소드니까.
////		panel = new game.hang.PlayPanel(userName);	// PlayPanel로 전환. 
//		
//		
//		this.add(panel);
//		repaint();
//	}


}
