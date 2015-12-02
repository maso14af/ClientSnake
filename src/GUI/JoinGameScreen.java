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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;

/**
 *
 *extends JPanel
 */
public class JoinGameScreen extends JPanel 
{
	//Instantierer variabler
	private JLabel lblJoinGame;
	private JTextField txtGameName;
	private JButton btnHome;
	private JLabel lblGameName;
	private JLabel lblErrorNoGame;
	private JButton btnJoinGame;

	public JoinGameScreen() 
	{
		setLayout(null);
		setBackground(new Color(102, 153, 204));
		setBounds(100, 100, 529, 475);

		//opretter,giver attributter og adder join game label
		lblJoinGame = new JLabel("Join Game");
		lblJoinGame.setForeground(Color.WHITE);
		lblJoinGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoinGame.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblJoinGame.setBounds(196, 47, 200, 50);
		add(lblJoinGame);

		//opretter,giver attributter og adder game name textfield
		txtGameName = new JTextField();
		txtGameName.setBounds(196, 192, 200, 28);
		txtGameName.setEditable(false);
		add(txtGameName);
		txtGameName.setColumns(10);

		//opretter,giver attributter og adder home knap
		btnHome = new JButton();
		Image imgHome = new ImageIcon(this.getClass().getResource("/res/btnHome.png")).getImage();
		btnHome.setIcon(new ImageIcon(imgHome));
		btnHome.setBounds(16, 10, 42, 38);
		add(btnHome);

		//opretter,giver attributter og adder GameName label
		lblGameName = new JLabel("Game name:");
		lblGameName.setForeground(Color.WHITE);
		lblGameName.setBounds(60, 198, 118, 16);
		add(lblGameName);

		//opretter,giver attributter og adder error label
		lblErrorNoGame = new JLabel("No game by that name");
		lblErrorNoGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorNoGame.setForeground(Color.RED);
		lblErrorNoGame.setBounds(157, 252, 267, 28);
		lblErrorNoGame.setVisible(false);
		add(lblErrorNoGame);
		
		btnJoinGame = new JButton("Join Game");
		btnJoinGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJoinGame.setBounds(241, 224, 117, 29);
		add(btnJoinGame);

	}//metode slut

	
	/**
	 * Getter for txtBalance
	 * @return txtBalance
	 */
	public JTextField getTxtGameName() 
	{
		return txtGameName;
	}//metode slut
	
	/**
	 * Getter forlblErrorNoGame 
	 * @return lblErrorNoGame
	 */
	public JLabel getLblErrorNoGame() 
	{
		return lblErrorNoGame;
	}//metode slut





	/**
	 * opretter actionlisternes for dette panel
	 * @param l
	 */
	public void addActionListener(ActionListener l) 
	{
		btnHome.addActionListener(l);
		btnJoinGame.addActionListener(l);
	}//metode slut
}//klasse slut