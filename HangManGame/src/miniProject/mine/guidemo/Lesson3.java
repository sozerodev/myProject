package miniProject.mine.guidemo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Lesson3 {

	private JFrame frmMyHangMan;
	private JTextField txtYourName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson3 window = new Lesson3();
					window.frmMyHangMan.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lesson3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyHangMan = new JFrame();
		frmMyHangMan.getContentPane().setBackground(Color.PINK);
		frmMyHangMan.setFont(new Font("Press Start K", Font.PLAIN, 12));
		frmMyHangMan.setForeground(Color.GREEN);
		frmMyHangMan.setTitle("my Hang Man");
		frmMyHangMan.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmMyHangMan.setBounds(100, 100, 744, 520);
		frmMyHangMan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyHangMan.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Let's START!");
		Image img = new ImageIcon(this.getClass().getResource("/Hangman_main.png")).getImage();
		btnNewButton.setIcon(new ImageIcon("/Users/SO/Desktop/khAcademy/upload/Workspace/TeamCode/img/Hangman_main.png"));
		btnNewButton.setFont(new Font("Press Start K", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(185, 288, 432, 204);
		frmMyHangMan.getContentPane().add(btnNewButton);
		
		JLabel lblHelloWorld = new JLabel("hello world");
		lblHelloWorld.setFont(new Font("Press Start K", Font.PLAIN, 13));
		lblHelloWorld.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloWorld.setBounds(27, 106, 253, 60);
		frmMyHangMan.getContentPane().add(lblHelloWorld);
		
		txtYourName = new JTextField();
		txtYourName.setFont(new Font("Press Start K", Font.PLAIN, 13));
		txtYourName.setHorizontalAlignment(SwingConstants.CENTER);
		txtYourName.setText("what is your name?");
		txtYourName.setBounds(223, 226, 285, 39);
		frmMyHangMan.getContentPane().add(txtYourName);
		txtYourName.setColumns(10);
		
		JLabel lblHangman = DefaultComponentFactory.getInstance().createTitle("HangMan");
		lblHangman.setHorizontalAlignment(SwingConstants.CENTER);
		lblHangman.setBounds(295, 36, 122, 16);
		frmMyHangMan.getContentPane().add(lblHangman);
		
		
		
		JLabel lblNewLabel = new JLabel();
		Image img2 = new ImageIcon(this.getClass().getResource("/Hangman_icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		
		lblNewLabel.setBounds(268, -48, 253, 324);
		frmMyHangMan.getContentPane().add(lblNewLabel);
	}
}
