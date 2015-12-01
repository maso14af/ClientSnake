package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
	private JButton btnHome;
	private JButton btnCreateGame;
	private JButton btnHighScore;
	private JButton btnDeleteGame;
	private JButton btnJoinGame;
	private JButton btnLogout;



	public JButton getBtnHome() {
		return btnHome;
	}

	public JButton getBtnCreateGame() {
		return btnCreateGame;
	}

	public JButton getBtnHighScore() {
		return btnHighScore;
	}

	public JButton getBtnDeleteGame() {
		return btnDeleteGame;
	}

	public JButton getBtnJoinGame() {
		return btnJoinGame;
	}

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
		btnJoinGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJoinGame.setBounds(210, 144, 117, 29);
		add(btnJoinGame);

	}//metode slut




	/**
	 * opretter actionlisternes for dette panel
	 * @param l
	 */
	public void addActionListener(ActionListener l) 
	{
		btnHome.addActionListener(l);
		btnCreateGame.addActionListener(l);
		btnDeleteGame.addActionListener(l);
		btnHighScore.addActionListener(l);
		btnJoinGame.addActionListener(l);
		btnLogout.addActionListener(l);
	
		
	}//metode slut
}//klasse slut