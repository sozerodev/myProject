package miniProject.mine.guidemo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JFrame {
	public static void main(String[] args) {
		new LogIn();
		
	}
	
	public LogIn() {
		setTitle("Save the Hang Man");
		

		JPanel panel = new JPanel();
		JLabel label = new JLabel("You're ID?");
		JLabel pswrd = new JLabel("Password Plz");
		
		JTextField txtID = new JTextField(10); // 10글자까지 받기 
		JPasswordField txtPass = new JPasswordField(10); // TextField이지만 암호화된다. 
		
		JButton logBtn = new JButton("Go!");
		
		Font font = new Font("Press Start K", Font.BOLD, 30);
		label.setFont(font);
		txtID.setFont(font);
		pswrd.setFont(font);
		txtPass.setFont(font);
		logBtn.setFont(font);
		
		// ID의 라벨과 텍스트필드를 패널에 추가 
		panel.add(label);
		panel.add(txtID);
		
		// password의 라벨과 텍스트필드를 패널에 추가 
		panel.add(pswrd);
		panel.add(txtPass);
		
		// 로그인 버튼 추가 
		panel.add(logBtn);
		
		logBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "hello"; // id 설정
				String pass = "world"; // password 설정 
				
				if(id.equals(txtID.getText()) && pass.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "So you..! are the one who i've been waiting for!", "hello my dear", JOptionPane.DEFAULT_OPTION);
				
				} else {
					JOptionPane.showMessageDialog(null, "You're not the one i'm looking for...", "goodbye my dear", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		
				
		add(panel);
		
		setVisible(true);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
