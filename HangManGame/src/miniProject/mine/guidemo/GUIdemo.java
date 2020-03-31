package miniProject.mine.guidemo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextArea;

public class GUIdemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("my miniProject");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Some text");
		JButton btn1 = new JButton("Why don't you\ntry...?");
		JButton btn2 = new JButton("Exit");
		
		// 둘다 같은 기능이지만... 
		JTextArea txtArea = new JTextArea();   // 많은 양의 글을 쓸 때 
		JTextField txtField = new JTextField(200); // 적은 양의 글을 쓸 때
		
		JPanel btnPanel = new JPanel();
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		
		
		
		panel.setLayout(new BorderLayout()); // 내가 원하는 방식대로 페널 레이블, 위치를 놔두는 기능 
		
//		panel.add(new JLabel("Hello my gui program!")); // 패러미터의 내용은 창의 줄에다가 표시된다. 
		
		
		
		panel.add(label, BorderLayout.NORTH); // 북쪽에 위치하도록. 
		panel.add(btnPanel, BorderLayout.WEST);
		
		
		panel.add(txtArea, BorderLayout.CENTER);
		
		
		
		// 버튼을 눌렀을때 어떠하게 행동해라~
		// btn1 버튼을 클릭하는 순간 txtArea.append()의 패러미터 안의 문자열이 뜨게 된다. 
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				txtArea.append("Are you the one who would save me..?\n");
				label.setText(txtArea.getText());
			}
			
		});
		
		// btn2 버튼을 클릭하는 순간 종료 
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		frame.add(panel);
		
		frame.setResizable(true); // 사이즈조절을 맘대로 할 수 있도록.
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(840, 840/12*9));
		frame.setSize(840, 840/12*9);
		frame.setLocationRelativeTo(null); // 프로그램 실행햇을때 창이 가운데에 뜨도록.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램을 끄면 다 종료되도록. 
		
		Font font = new Font("Press Start K", Font.BOLD, 30);
		label.setFont(font);
		btn1.setFont(font); 
		btn2.setFont(font); 
		txtArea.setFont(font);
		
		
		
		
		

	}

}
