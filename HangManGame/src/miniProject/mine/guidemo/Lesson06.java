package miniProject.mine.guidemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class Lesson06 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson06 window = new Lesson06();
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
	public Lesson06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Lesson06");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null); // 화면이 가운데에 뜨도록 
		frame.setResizable(false); // 사이즈 변경 불가하도록 설정 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel endPage = new JPanel();
		endPage.setBounds(0, 0, 800, 578);
		frame.getContentPane().add(endPage);
		endPage.setLayout(null);
		
		JButton btnBefore = new JButton("Go to Previous Page");
		btnBefore.setFont(new Font("Press Start K", Font.PLAIN, 13));
		btnBefore.setBounds(429, 205, 331, 123);
		endPage.add(btnBefore);
		
		JPanel startPage = new JPanel();
		startPage.setBounds(0, 0, 800, 578);
		
		

		
		
		frame.getContentPane().add(startPage);
		startPage.setLayout(null);
		
		JButton btnNext = new JButton("Go to Next Page");
		btnNext.setBounds(0, 0, 260, 142);
		startPage.add(btnNext);
		btnNext.setFont(new Font("Press Start K", Font.PLAIN, 13));
		
		JLabel startLabel = new JLabel(new ImageIcon("/Users/SO/Desktop/khAcademy/upload/Workspace/TeamCode/img/BackGroundImg.png"));
		startPage.add(startLabel);
		
		
		// btnNext버튼 클릭시 시행될 액션 
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				endPage.setVisible(true);
				startPage.setVisible(false);
				
				
			}
		});
		
		
		// btnBefore버튼 클릭시 시행될 액션 
		btnBefore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(false);
				startPage.setVisible(true);
			}
			
		});
		
		
		
	}
}
