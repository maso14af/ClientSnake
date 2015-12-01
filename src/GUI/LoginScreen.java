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
 *Panel for login screen
 *extends JPanel
 */
public class LoginScreen extends JPanel 
{
	//instantiere variabler
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JLabel lblLogo;
	private JLabel lblError;

	/**
	 * Create the panel.
	 */
	public LoginScreen() 
	{
		setBackground(new Color(102, 153, 204));
		setLayout(null);
		setBounds(100, 100, 529, 475);

		//opretter,giver attributter og adder username textfield
		txtUser = new JTextField();
		txtUser.setBounds(153, 237, 266, 28);
		add(txtUser);
		txtUser.setColumns(10);

		//opretter,giver attributter og adder password textfield
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(153, 277, 266, 28);
		add(txtPassword);

		//opretter,giver attributter og adder login label
		lblLogin = new JLabel("Username:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(67, 234, 85, 34);
		add(lblLogin);

		//opretter,giver attributter og adder password label
		lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(67, 274, 85, 34);
		add(lblPassword);

		//opretter,giver attributter og adder login knap
		btnLogin = new JButton("Login");
		btnLogin.setBounds(222, 332, 117, 29);
		add(btnLogin);

		//opretter,giver attributter og adder logoet 
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(LoginScreen.class.getResource("/Snake.jpg")));
		lblLogo.setBounds(94, 33, 325, 158);
		add(lblLogo);

		//opretter,giver attributter og adder error label
		lblError = new JLabel("Incorrect combination, try again.");
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(175, 306, 230, 16);
		lblError.setVisible(false);
		add(lblError);

	}//metode slut


	/**
	 * Getters for txtUser
	 * @return txtUser
	 */
	public JTextField getTxtUser() 
	{
		return txtUser;
	}//metode slut

	/**
	 * Getters for txtPassword
	 * @return txtPassword
	 */
	public JTextField getTxtPassword() 
	{
		return txtPassword;
	}//metode slut

	public void setLblError(JLabel lblError) {
		this.lblError = lblError;
	}

	/**
	 * opretter actionlistener for dette panel
	 * @param l
	 */
	public void addActionListener(ActionListener l) 
	{
		btnLogin.addActionListener(l);
	}//metode slut
}//klasse slut