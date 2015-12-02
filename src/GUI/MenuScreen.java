package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;

/**
 *extends JPanel
 */
public class MenuScreen extends JPanel 
{
	//Instantierer variabler
	private JLabel lblMenu;
	private JButton btnCreateGame;
	private JButton btnHighScore;
	private JButton btnDeleteGame;
	private JButton btnJoinGame;
	private JButton btnLogout;




	public JButton getBtnCreateGame() {
		return btnCreateGame;
	}

	public JButton getBtnHighScore() {
		return btnHighScore;
	}

	public JButton getBtnDeleteGame() {
		return btnDeleteGame;
	}

	public JButton getBtnJoinGame() {return btnJoinGame;}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	/**
	 * Create the panel.
	 */
	public MenuScreen() 
	{
		setLayout(null);
		setBackground(new Color(102, 153, 204));

		//opretter,giver attributter og adder deposit label
		lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		setBounds(100, 100, 529, 475);
		add(lblMenu);

		//opretter,giver attributter og adder knap 
		btnCreateGame = new JButton("Create Game");
		btnCreateGame.setBounds(210, 103, 117, 29);
		add(btnCreateGame);
		
		btnHighScore = new JButton("High Score");
		btnHighScore.setBounds(210, 185, 117, 29);
		add(btnHighScore);
		
		btnDeleteGame = new JButton("Delete game");
		btnDeleteGame.setBounds(210, 226, 117, 29);
		add(btnDeleteGame);
		
		btnLogout = new JButton("Log out");
		btnLogout.setBounds(210, 267, 117, 29);
		add(btnLogout);
		
		btnJoinGame = new JButton("Join Game");
		btnJoinGame.setBounds(210, 144, 117, 29);
		add(btnJoinGame);

	}//metode slut




	/**
	 * opretter actionlisternes for dette panel
	 * @param l
	 */
	public void addActionListener(ActionListener l) 
	{
		btnCreateGame.addActionListener(l);
		btnDeleteGame.addActionListener(l);
		btnHighScore.addActionListener(l);
		btnJoinGame.addActionListener(l);
		btnLogout.addActionListener(l);
	
		
	}//metode slut
}//klasse slut