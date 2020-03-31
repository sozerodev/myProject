// 메인패널을 분리한 것. 
package miniProject.mine.hangman;

import java.awt.Color;
import java.awt.Component; // startGame()때문에 생겻는데.. 
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JOptionPane;

public class mainPanel extends JPanel {
	
	private static final Component mainPanel = null;
	boolean nameChk = false; // 필드변수이니 false로 초기화되어있을 것 
	
	public mainPanel() {
		new PlayMusic("Blues.wav");
		this.setFont(new Font("Press Start K", Font.PLAIN, 20)); // 폰트 설정 
		setBounds(0, 0, 780, 650);
		setLayout(null);
		
		JFormattedTextField userNameInput = new JFormattedTextField("Name Your Self");
		userNameInput.setText(">>Name Your Self<<");
		userNameInput.setForeground(Color.LIGHT_GRAY);
		userNameInput.setBackground(Color.RED);
		userNameInput.setHorizontalAlignment(SwingConstants.CENTER);
		userNameInput.setFont(new Font("Press Start K", Font.PLAIN, 17));
		userNameInput.setBounds(191, 351, 359, 61);
		userNameInput.addMouseListener(new MouseAdapter() {   // 입력창을 클릭하면 디폴트로 입력된 글자들을 싹 사라지게 해주는 코드 
			@Override
			public void mouseClicked(MouseEvent e) {
				nameChk = true;
				userNameInput.setText("");
			}
		});
		
		add(userNameInput);
		
		JButton btnStart = new JButton("PRESS START");
		btnStart.setForeground(Color.RED);
		btnStart.setBackground(Color.BLACK);
		btnStart.setFont(new Font("Press Start K", Font.PLAIN, 26));
		btnStart.setBounds(207, 581, 340, 46);
		
		JLabel msg = new JLabel("Input your name!");
		msg.setFont(new Font("Press Start K", Font.BOLD, 25));
		
		
		btnStart.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (nameChk == false) {
					btnStart.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null, msg, "Name yourself!!", JOptionPane.ERROR_MESSAGE);
							
						}
					});
					System.out.println("false인 경우 ");
				} else { // nameChk가 true인 경우 
					// 버튼 클릭 시 패널 교체 
					new MainFrame().startGame();
					System.out.println("true인 경우 ");
				}
			}
			
		});
		add(btnStart);
		
		JButton btnNewButton = new JButton("RANK");
		btnNewButton.setForeground(UIManager.getColor("InternalFrame.borderDarkShadow"));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Press Start K", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(594, 213, 128, 40);
		add(btnNewButton);
		

		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Press Start K", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 0, 780, 627);
		add(lblNewLabel);
		Image myImg = new ImageIcon("./img/BackGroundImg.png").getImage().getScaledInstance(780, 650, 0); // 상대경로 설정하기 
		lblNewLabel.setIcon(new ImageIcon(myImg));
	}
	
	
}
