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
public class DeleteGameScreen extends JPanel 
{
	//Instantierer variabler
	private JLabel lblDeleteGame;
	private JTextField txtGameName;
	private JButton btnHome;
	private JLabel lblGameName;
	private JLabel lblErrorNoGame;
	private JButton btnDeleteGame;

	public JButton getBtnHome() {
		return btnHome;
	}

	public DeleteGameScreen()
	{
		setLayout(null);
		setBackground(new Color(102, 153, 204));
		setBounds(100, 100, 529, 475);

		//opretter,giver attributter og adder delete game label
		lblDeleteGame = new JLabel("Delete Game");
		lblDeleteGame.setForeground(Color.WHITE);
		lblDeleteGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteGame.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblDeleteGame.setBounds(196, 47, 200, 50);
		add(lblDeleteGame);

		//opretter,giver attributter og adder game name textfield
		txtGameName = new JTextField();
		txtGameName.setBounds(196, 192, 200, 28);
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

		
		btnDeleteGame = new JButton("Delete Game");
		btnDeleteGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteGame.setBounds(241, 224, 117, 29);
		add(btnDeleteGame);

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
		btnDeleteGame.addActionListener(l);
	}//metode slut
}//klasse slut