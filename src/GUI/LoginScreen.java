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
import java.awt.SystemColor;

/**
 *Panel for login screen
 *extends JPanel
 */
public class LoginScreen extends JPanel
{
    //instantierer variabler
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JLabel lblLogin;
    private JLabel lblPassword;
    private JButton btnLogin;
    private JLabel lblNewLabel;
    private JLabel lblError;

    /**
     * Create the panel.
     */
    public LoginScreen()
    {
        setBackground(new Color(102, 153, 204));
        setLayout(null);
        setBounds(100, 100, 529, 423);

        //opretter,giver attributter og adder username textfield
        txtUser = new JTextField();
        txtUser.setBounds(142, 171, 266, 28);
        add(txtUser);
        txtUser.setColumns(10);

        //opretter,giver attributter og adder password textfield
        txtPassword = new JPasswordField();
        txtPassword.setColumns(10);
        txtPassword.setBounds(142, 211, 266, 28);
        add(txtPassword);

        //opretter,giver attributter og adder lofin label
        lblLogin = new JLabel("Username:");
        lblLogin.setForeground(Color.WHITE);
        lblLogin.setBounds(56, 168, 85, 34);
        add(lblLogin);

        //opretter,giver attributter og adder password label
        lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBounds(56, 208, 85, 34);
        add(lblPassword);

        //opretter,giver attributter og adder login knap
        btnLogin = new JButton("Login");
        btnLogin.setBounds(211, 266, 117, 29);
        add(btnLogin);

        //opretter,giver attributter og adder logoet
        lblNewLabel = new JLabel("ikon");
        lblNewLabel.setIcon(new ImageIcon(LoginScreen
                .class.getResource("/Snake.jpg")));
        lblNewLabel.setBounds(99, 6, 320, 158);
        add(lblNewLabel);

        //opretter,giver attributter og adder error label
        lblError = new JLabel("Incorrect combination, try again.");
        lblError.setForeground(Color.RED);
        lblError.setHorizontalAlignment(SwingConstants.CENTER);
        lblError.setBounds(164, 240, 230, 16);
        lblError.setVisible(false);
        add(lblError);

    }//metode slut

    /**
     * Getters for btnLogin
     * @return btnLogin
     */
    public JButton getBtnLogin()
    {
        return btnLogin;
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

    /**
     * Getters for lblError
     * @return lblError
     */
    public JLabel getLblError()
    {
        return lblError;
    }//metode slut

    /**
     * opretter actionlistener for dette panel
     * @param l
     */
    public void addActionListener(ActionListener l)
    {
        btnLogin.addActionListener(l);
    }//metode slut
}//klasse slut