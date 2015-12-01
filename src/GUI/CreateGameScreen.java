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
		txtGameName.setEditable(false);
		add(txtGameName);
		txtGameName.setColumns(10);

		//opretter,giver attributter og adder home knap
		btnHome = new JButton();
		try 
		{
			Image imgHome = ImageIO.read(getClass().getResource("/btnHome.png"));
			btnHome.setIcon(new ImageIcon(imgHome));
		} 
		catch (IOException ex) 
		{
		}
		btnHome.setBounds(16, 10, 42, 38);
		add(btnHome);

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
		
		JButton btnCreateGame = new JButton("Create Game");
		btnCreateGame.setBounds(196, 265, 200, 29);
		add(btnCreateGame);

	}//metode slut
	
	
	/**
	 * Getter for txtUserToTransfer
	 * @return txtUserToTransfer
	 */
	public JTextField getTxtControls() 
	{
		return txtControls;
	}//metode slut
	
	/**
	 * Getter for txtUserToTransfer
	 * @return txtUserToTransfer
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
		
	}//metode slut
}//klasse slut