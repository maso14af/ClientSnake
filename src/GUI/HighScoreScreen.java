package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class contains the HighScoreScreen GUI, this class has the getters for all
 * the home Button and JTable as well as listeners for the buttons.
 * The logic for the class is in the controller class in the Logic package.
 *extends JPanel
 */
public class HighScoreScreen extends JPanel 
{
	//Declaring variables used in this class
	private JLabel lblHighScore;
	private JButton btnHome;
	private JTable table;
	private JScrollPane scrollPane;



	/**
	 * Creation of the High Score panel
	 */
	public HighScoreScreen() 
	{
		setLayout(null);
		setBackground(new Color(102, 153, 204));
		setBounds(100, 100, 529, 475);

		//Creating high score label and adding attributes
		lblHighScore = new JLabel("High Scores");
		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighScore.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblHighScore.setBounds(120, 10, 200, 50);
		add(lblHighScore);

		//Creating home button and adding attributes as well as image
		btnHome = new JButton();
		Image imgHome = new ImageIcon(this.getClass().getResource("/res/btnHome.png")).getImage();
		btnHome.setIcon(new ImageIcon(imgHome));
		btnHome.setBounds(16, 10, 42, 38);
		add(btnHome);

		//Creating JTable and adding attributes
		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(57, 72, 359, 184);
		add(scrollPane);
		//add(table);

	}//End of method


	/**
	 * Getter for table
	 * @return table;
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * Getter for scrollPane
	 * @return scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	
	/**
	 * Getter for btnHome
	 * @return btnHome
	 */
	public JButton getBtnHome() 
	{
		return btnHome;
	}//

	/**
	 * Creating action listeners for this panel
	 * @param l object of action listener
	 */
	public void addActionListener(ActionListener l) 
	{
		btnHome.addActionListener(l);
	}//End of method
}//End of class HighScoreScreen