package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 * @author Martin Lusty Sørensen
 *Panel for view balance
 *extends JPanel
 */
public class HighScoreScreen extends JPanel 
{
	//Instantierer variabler
	private JLabel lblHighScore;
	private JButton btnHome;
	private JTable table;

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
		try 
		{
			Image imgHome = ImageIO.read(getClass().getResource("/res/btnHome.png"));
			btnHome.setIcon(new ImageIcon(imgHome));
		} 
		catch (IOException ex) 
		{
		}
		btnHome.setBounds(16, 10, 42, 38);
		add(btnHome);
		
		table = new JTable();
		table.setBounds(57, 72, 359, 184);
		add(table);
	}//metode slut	


	



	
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