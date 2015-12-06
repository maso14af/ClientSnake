package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This class contains the MenuScreen GUI, this class has the getter for log out
 * used in the menu as well as listeners for all the buttons.
 * The logic for the class is in the controller class in the Logic package.
 *extends JPanel
 */

//Start of class
public class MenuScreen extends JPanel
{
    //Declaring of variables used in this class.
    private JLabel lblMenu;
    private JButton btnCreateGame;
    private JButton btnHighScore;
    private JButton btnDeleteGame;
    private JButton btnJoinGame;
    private JButton btnLogout;




    /**
     * Creating the panel MenuScreen
     */
    public MenuScreen()
    {
        setLayout(null);
        setBackground(new Color(102, 153, 204));

        //Creating menu label and adding attributes
        lblMenu = new JLabel("Menu");
        lblMenu.setForeground(Color.WHITE);
        lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
        lblMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        setBounds(100, 100, 529, 475);
        add(lblMenu);

        //Creating create game button and adding attributes
        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setBounds(210, 103, 117, 29);
        add(btnCreateGame);

        //Creating high score button and adding attributes
        btnHighScore = new JButton("High Score");
        btnHighScore.setBounds(210, 185, 117, 29);
        add(btnHighScore);

        //Creating delete game button and adding attributes
        btnDeleteGame = new JButton("Delete game");
        btnDeleteGame.setBounds(210, 226, 117, 29);
        add(btnDeleteGame);

        //Creating log out button and adding attributes
        btnLogout = new JButton("Log out");
        btnLogout.setBounds(210, 267, 117, 29);
        add(btnLogout);

        //Creating join game button and adding attributes
        btnJoinGame = new JButton("Join Game");
        btnJoinGame.setBounds(210, 144, 117, 29);
        add(btnJoinGame);

    }//End of method

    /**
     * Getter for btnCreateGame
     * @return btnCreateGame
     */
    public JButton getBtnCreateGame()
    {
        return btnCreateGame;
    }

    /**
     * Getter for btnHighScore
     * @return btnHighScore
     */
    public JButton getBtnHighScore()
    {
        return btnHighScore;
    }

    /**
     * Getter for btnDeleteGame
     * @return btnDeleteGame
     */
    public JButton getBtnDeleteGame()
    {
        return btnDeleteGame;
    }

    /**
     * Getter for btnJoinGame
     * @return btnJoinGame
     */
    public JButton getBtnJoinGame()
    {
        return btnJoinGame;
    }

    /**
     * Getter for btnLogout
     * @return btnLogout
     */
    public JButton getBtnLogout()
    {
        return btnLogout;
    }

    /**
     * Creating action listeners for this panel
     * @param l object of action listener
     */
    public void addActionListener(ActionListener l)
    {
        btnCreateGame.addActionListener(l);
        btnDeleteGame.addActionListener(l);
        btnHighScore.addActionListener(l);
        btnJoinGame.addActionListener(l);
        btnLogout.addActionListener(l);
    }//End of method
}//End of class MenuScreen