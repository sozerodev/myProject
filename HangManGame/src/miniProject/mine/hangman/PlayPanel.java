package miniProject.mine.hangman;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayPanel extends JPanel {
	
	public PlayPanel() {
		
		setBackground(Color.BLUE);
		setBounds(60, 85, 401, 248);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(97, 70, 198, 108);
		add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setIcon(new ImageIcon("./img/succeed.png"));
		
	}

}
