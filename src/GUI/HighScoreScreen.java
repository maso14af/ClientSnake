package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @author Martin Lusty Sørensen
 *extends JPanel
 */
public class HighScoreScreen extends JPanel 
{
	//Instantierer variabler
	private JLabel lblHighScore;
	private JButton btnHome;
	private JTable table;
	private JScrollPane scrollPane;




	/**
	 * Create the panel.
	 */
	public HighScoreScreen() 
	{
		setLayout(null);
		setBackground(new Color(102, 153, 204));
		setBounds(100, 100, 529, 475);

		//opretter,giver attributter og adder balance label
		lblHighScore = new JLabel("High Scores");
		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighScore.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblHighScore.setBounds(120, 10, 200, 50);
		add(lblHighScore);

		//opretter,giver attributter og adder home knap
		btnHome = new JButton();
		Image imgHome = new ImageIcon(this.getClass().getResource("/res/btnHome.png")).getImage();
		btnHome.setIcon(new ImageIcon(imgHome));
		btnHome.setBounds(16, 10, 42, 38);
		add(btnHome);
		
		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(57, 72, 359, 184);
		add(scrollPane);
		//add(table);

	}//metode slut	



	public JTable getTable() {
		return table;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	
	/**
	 * Getter for 
	 * @return 
	 */
	public JButton getBtnHome() 
	{
		return btnHome;
	}//metode slut	

	/**
	 * opretter actionListernes for dette panel
	 * @param l
	 */
	public void addActionListener(ActionListener l) 
	{
		btnHome.addActionListener(l);
	}//metode slut	
}//klasse slut