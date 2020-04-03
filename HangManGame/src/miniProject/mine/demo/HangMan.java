package miniProject.mine.demo;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.SystemColor;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class HangMan {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangMan window = new HangMan();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	/**
	 * Create the application.
	 */
	public HangMan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Save the Hang Man!!");
		frame.setBounds(0, 0, 780, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Press Start K", Font.PLAIN, 20)); // 폰트 설정 
		panel.setBounds(0, 0, 780, 650);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		

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
				userNameInput.setText("");
			}
		});
		panel.add(userNameInput);
		
		JButton btnStart = new JButton("PRESS START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStart.setForeground(Color.RED);
		btnStart.setBackground(Color.BLACK);
		btnStart.setFont(new Font("Press Start K", Font.PLAIN, 26));
		btnStart.setBounds(207, 581, 340, 46);
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(panel, "Dear " + userNameInput.getText() + ".\nyou sure want to start?");
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
		

		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Press Start K", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 0, 780, 650);
		panel.add(lblNewLabel);
		Image myImg = new ImageIcon("./img/BackGroundImg.png").getImage().getScaledInstance(780, 650, 0); // 상대경로 설정하기 
		lblNewLabel.setIcon(new ImageIcon("/Users/SO/Desktop/myProject/HangManGame/img/BackGroundImg.png"));
		play("POL-evil-throne-short.wav");
		
	}
	
	
	
	// 음악재생 
	// 출처 : https://stackoverflow.com/questions/2416935/how-to-play-wav-files-with-java
	public static void play(String filename)
	{
	    try
	    {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(filename)));
	        clip.start();
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}
	
}
