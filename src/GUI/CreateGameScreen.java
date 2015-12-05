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
 *extends JPanel
 */
public class CreateGameScreen extends JPanel 
{
	//Instanisierer variabler
	private JLabel lblCreateGame;
	private JLabel lblControls;
	private JTextField txtGameName;
	private JButton btnHome;
	private JLabel lblGameName;
	private JTextField txtControls;
	private JButton btnCreateGame;
	private JLabel lblErrorNoName;
	private JLabel lblGameCreated;

	public JLabel getLblGameCreated() {
		return lblGameCreated;
	}

	public JLabel getLblErrorNoName() {
		return lblErrorNoName;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public JButton getBtnCreateGame() {
		return btnCreateGame;
	}

	public CreateGameScreen()
	{
		setLayout(null);
		setBackground(new Color(102, 153, 204));
		setBounds(100, 100, 529, 475);

		//opretter og giver attributter og adder Create Game label
		lblCreateGame = new JLabel("Create Game");
		lblCreateGame.setForeground(Color.WHITE);
		lblCreateGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateGame.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblCreateGame.setBounds(196, 94, 200, 50);
		add(lblCreateGame);

		//opretter,giver attributter og adder Control label
		lblControls = new JLabel("Enter controls:");
		lblControls.setForeground(Color.WHITE);
		lblControls.setBounds(60, 238, 131, 16);
		add(lblControls);

		//opretter,giver attributter og adder GameName textfield
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


		//opretter,giver attributter og adder error label
		lblErrorNoName = new JLabel("Please type a name and controls");
		lblErrorNoName.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorNoName.setForeground(Color.RED);
		lblErrorNoName.setBounds(157, 290, 267, 28);
		lblErrorNoName.setVisible(false);
		add(lblErrorNoName);

		//opretter,giver attributter og adder error label
		lblGameCreated = new JLabel("Game created");
		lblGameCreated.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameCreated.setForeground(Color.RED);
		lblGameCreated.setBounds(157, 290, 267, 28);
		lblGameCreated.setVisible(false);
		add(lblGameCreated);


		//opretter,giver attributter og adder GameName label
		lblGameName = new JLabel("Game name:");
		lblGameName.setForeground(Color.WHITE);
		lblGameName.setBounds(60, 198, 118, 16);
		add(lblGameName);

		//opretter,giver attributter og adder txtControls textfield
		txtControls = new JTextField();
		txtControls.setColumns(10);
		txtControls.setBounds(196, 230, 200, 28);
		add(txtControls);
		
		btnCreateGame = new JButton("Create Game");
		btnCreateGame.setBounds(196, 265, 200, 29);
		add(btnCreateGame);

	}//metode slut
	
	
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
	 * opretter actionlisternes for dette panel
	 * @param l
	 */
	public void addActionListener(ActionListener l) 
	{
		btnHome.addActionListener(l);
		btnCreateGame.addActionListener(l);

	}//metode slut
}//klasse slut