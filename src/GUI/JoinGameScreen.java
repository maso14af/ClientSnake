package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class contains the JoinGameScreen GUI, this class has the getters for all
 * the textFields and confirm/ error labels used in the Join Game menu as well as listeners for the buttons.
 * The logic for the class is in the
 * controller class in the Logic package.
 *extends JPanel
 */
public class JoinGameScreen extends JPanel
{
	//Declaring of variables used in this class
	private JLabel lblJoinGame;
	private JTextField txtControls;
	private JButton btnHome;
	private JLabel lblControls;
	private JLabel lblErrorNoGame;
	private JButton btnJoinGame;
	private JTextField txtGameName;
	private JLabel lblGameJoined;
	private JLabel lblNoControls;
	private JLabel lblGameName;

	/**
	 * Creation of the Join Game panel
	 */
	public JoinGameScreen()
	{
		setLayout(null);
		setBackground(new Color(102, 153, 204));
		setBounds(100, 100, 529, 475);

		//Creating join game label and adding attributes
		lblJoinGame = new JLabel("Join Game");
		lblJoinGame.setForeground(Color.WHITE);
		lblJoinGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoinGame.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblJoinGame.setBounds(196, 47, 200, 50);
		add(lblJoinGame);

		//Creating controls text field and adding attributes
		txtControls = new JTextField();
		txtControls.setBounds(196, 192, 200, 28);
		add(txtControls);
		txtControls.setColumns(10);

		//Creating home button and adding attributes
		btnHome = new JButton();
		Image imgHome = new ImageIcon(this.getClass().getResource("/res/btnHome.png")).getImage();
		btnHome.setIcon(new ImageIcon(imgHome));
		btnHome.setBounds(16, 10, 42, 38);
		add(btnHome);


		//Creating controls label and adding attributes
		lblControls = new JLabel("Controls:");
		lblControls.setForeground(Color.WHITE);
		lblControls.setBounds(60, 198, 118, 16);
		add(lblControls);

		//Creating hidden no game error label and adding attributes
		lblErrorNoGame = new JLabel("No game by that name");
		lblErrorNoGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorNoGame.setForeground(Color.RED);
		lblErrorNoGame.setBounds(157, 252, 267, 28);
		lblErrorNoGame.setVisible(false);
		add(lblErrorNoGame);

		//Creating hidden game joined confirm label and adding attributes
		lblGameJoined = new JLabel("Game joined");
		lblGameJoined.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameJoined.setForeground(Color.GREEN);
		lblGameJoined.setBounds(157, 252, 267, 28);
		lblGameJoined.setVisible(false);
		add(lblGameJoined);

		//Creating hidden no controls error label and adding attributes
		lblNoControls = new JLabel("Controls and/ or game name are needed");
		lblNoControls.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoControls.setForeground(Color.RED);
		lblNoControls.setBounds(157, 252, 267, 28);
		lblNoControls.setVisible(false);
		add(lblNoControls);

		//Creating join game button and adding attributes
		btnJoinGame = new JButton("Join Game");
		btnJoinGame.setBounds(241, 232, 117, 29);
		add(btnJoinGame);

		//Creating game name text field and adding attributes
		txtGameName = new JTextField();
		txtGameName.setColumns(10);
		txtGameName.setBounds(196, 152, 200, 28);
		add(txtGameName);

		//Creating game name label and adding attributes
		lblGameName = new JLabel("Game name:");
		lblGameName.setForeground(Color.WHITE);
		lblGameName.setBounds(60, 158, 118, 16);
		add(lblGameName);

	}//End of method

	/**
	 * Getter for lblNoControls
	 * @return lblNoControls
	 */
	public JLabel getLblNoControls() {
		return lblNoControls;
	}

	/**
	 * Getter for lblGameJoined
	 * @return lblGameJoined
	 */
	public JLabel getLblGameJoined() {
		return lblGameJoined;
	}

	/**
	 * Getter for btnJoinGame
	 * @return btnJoinGame
	 */
	public JButton getBtnJoinGame() {
		return btnJoinGame;
	}

	/**
	 * getBtnHome
	 * @return btnHome
	 */
	public JButton getBtnHome() {
		return btnHome;
	}

	/**
	 * Getter for txtGameName
	 * @return txtGameName
	 */
	public JTextField getTxtGameName()
	{
		return txtGameName;
	}

	/**
	 * Getter for txtControls
	 * @return txtControls
	 */
	public JTextField getTxtControls()
	{
		return txtControls;
	}

	/**
	 * Getter for lblErrorNoGame
	 * @return lblErrorNoGame
	 */
	public JLabel getLblErrorNoGame()
	{
		return lblErrorNoGame;
	}

	/**
	 * Creating action listeners for this panel
	 * @param l object of action listener
	 */
	public void addActionListener(ActionListener l)
	{
		btnHome.addActionListener(l);
		btnJoinGame.addActionListener(l);
	}
}//End of class JoinGameScreen