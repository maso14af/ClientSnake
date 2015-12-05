package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * This class contains the CreateGameScreen GUI, this class has the setters and getters for all
 * the textFields and confirm/ error labels used in the CreateGame menu. The logic for the class is in the
 * controller class in the Logic package.
 *extends JPanel
 */
public class CreateGameScreen extends JPanel
{
	//Initializing of local variables
	private JLabel lblCreateGame;
	private JLabel lblControls;
	private JTextField txtGameName;
	private JButton btnHome;
	private JLabel lblGameName;
	private JTextField txtControls;
	private JButton btnCreateGame;
	private JLabel lblErrorNoName;
	private JLabel lblGameCreated;

	/**
	 * Creation of the CreateGame panel
	 */
	public CreateGameScreen()
	{
		setLayout(null);
		setBackground(new Color(102, 153, 204));
		setBounds(100, 100, 529, 475);

		//Creating CreateGame label and adding attributes
		lblCreateGame = new JLabel("Create Game");
		lblCreateGame.setForeground(Color.WHITE);
		lblCreateGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateGame.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblCreateGame.setBounds(196, 94, 200, 50);
		add(lblCreateGame);

		//Creating Controls label and adding attributes
		lblControls = new JLabel("Enter controls:");
		lblControls.setForeground(Color.WHITE);
		lblControls.setBounds(60, 238, 131, 16);
		add(lblControls);

		//Creating Game name text field and adding attributes
		txtGameName = new JTextField();
		txtGameName.setBounds(196, 192, 200, 28);
		add(txtGameName);
		txtGameName.setColumns(10);

		//Creating Home button and adding attributes aswell as image
		btnHome = new JButton();
		Image imgHome = new ImageIcon(this.getClass().getResource("/res/btnHome.png")).getImage();
		btnHome.setIcon(new ImageIcon(imgHome));
		btnHome.setBounds(16, 10, 42, 38);
		add(btnHome);


		//Creating hidden error label and adding attributes
		lblErrorNoName = new JLabel("Please type a name and controls");
		lblErrorNoName.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorNoName.setForeground(Color.RED);
		lblErrorNoName.setBounds(157, 290, 267, 28);
		lblErrorNoName.setVisible(false);
		add(lblErrorNoName);

		//Creating hidden game created label and adding attributes
		lblGameCreated = new JLabel("Game created");
		lblGameCreated.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameCreated.setForeground(Color.RED);
		lblGameCreated.setBounds(157, 290, 267, 28);
		lblGameCreated.setVisible(false);
		add(lblGameCreated);


		//Creating game name label and adding attributes
		lblGameName = new JLabel("Game name:");
		lblGameName.setForeground(Color.WHITE);
		lblGameName.setBounds(60, 198, 118, 16);
		add(lblGameName);

		//Creating controls text field and adding attributes
		txtControls = new JTextField();
		txtControls.setColumns(10);
		txtControls.setBounds(196, 230, 200, 28);
		add(txtControls);

		//Creating create game button and adding attributes
		btnCreateGame = new JButton("Create Game");
		btnCreateGame.setBounds(196, 265, 200, 29);
		add(btnCreateGame);

	}//End of method

	/**
	 * Getter for lblGameCreated
	 * @return lblGameCreated
	 */
	public JLabel getLblGameCreated() {
		return lblGameCreated;
	}

	/**
	 * Getter for lblErrorNoName
	 * @return lblErrorNoName
	 */
	public JLabel getLblErrorNoName() {
		return lblErrorNoName;
	}

	/**
	 * getter for btnHome
	 * @return btnHome;
	 */
	public JButton getBtnHome() {
		return btnHome;
	}

	/**
	 * Getter for btnCreateGame
	 * @return btnCreateGame
	 */
	public JButton getBtnCreateGame() {
		return btnCreateGame;
	}

	/**
	 * Getter for txtControls
	 * @return txtControls
	 */
	public JTextField getTxtControls()
	{
		return txtControls;
	}//metode slut

	/**
	 * Getter for txtGameName
	 * @return txtGameName
	 */
	public JTextField getTxtGameName()
	{
		return txtGameName;
	}//metode slut


	/**
	 * Creates actionListeners for this panel
	 * @param l
	 */
	public void addActionListener(ActionListener l)
	{
		btnHome.addActionListener(l);
		btnCreateGame.addActionListener(l);

	}//End of method
}//End of class CreateGameScreen