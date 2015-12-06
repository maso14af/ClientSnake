package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

/**
 * This class contains the LoginScreen GUI, this class has the getters for all
 * the textFields and confirm/ error labels used in the Login menu. The logic for the class is in the
 * controller class in the Logic package.
 *extends JPanel
 */
public class LoginScreen extends JPanel 
{
	//Declaring of variables used in this class
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JLabel lblLogo;
	private JLabel lblError;

	/**
	 * Creation of the Login Screen panel
	 */
	public LoginScreen() 
	{
		setBackground(new Color(102, 153, 204));
		setLayout(null);
		setBounds(100, 100, 529, 475);

		//Creating user name text field and adding attributes
		txtUser = new JTextField();
		txtUser.setBounds(153, 237, 266, 28);
		add(txtUser);
		txtUser.setColumns(10);

		//Creating password password field and adding attributes
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(153, 277, 266, 28);
		add(txtPassword);

		//Creating login label and adding attributes
		lblLogin = new JLabel("Username:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(67, 234, 85, 34);
		add(lblLogin);

		//Creating password label and adding attributes
		lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(67, 274, 85, 34);
		add(lblPassword);

		//Creating login button and adding attributes
		btnLogin = new JButton("Login");
		btnLogin.setBounds(222, 332, 117, 29);
		add(btnLogin);

		//Creating logo label and adding attributes as well as image
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(LoginScreen.class.getResource("/res/Snake.jpg")));
		lblLogo.setBounds(94, 33, 325, 158);
		add(lblLogo);

		//Creating hidden error label and adding attributes
		lblError = new JLabel("Incorrect combination, try again.");
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(175, 306, 230, 16);
		lblError.setVisible(false);
		add(lblError);

	}//End of method


	/**
	 * Getters for txtUser
	 * @return txtUser
	 */
	public JTextField getTxtUser() 
	{
		return txtUser;
	}

	/**
	 * Getters for txtPassword
	 * @return txtPassword
	 */
	public JTextField getTxtPassword()
	{
		return txtPassword;
	}

	/**
	 * Getter for lblError
	 * @return lblError
	 */
	public JLabel getLblError() {
		return lblError;
	}

	/**
	 * Getters for btnLogin
	 * @return btnLogin
	 */
	public JButton getBtnLogin()
	{
		return btnLogin;
	}

	/**
	 * Creating actions listeners used in this screen
	 * @param l object of action listener
	 */

	public void addActionListener(ActionListener l) 
	{
		btnLogin.addActionListener(l);
	}//End of method
}//End of class LoginScreen