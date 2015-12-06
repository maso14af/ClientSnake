package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * This class contains the Screen, this class contains all the other panels and all traffic is gathered and goes
 * through this class.
 *extends JFrame
 */
//Start of class
public class Screen extends JFrame
{
    //Setting ID's to the panels
    public static final String LOGINSCREEN = "name_1";
    public static final String MENUSCREEN = "name_2";
    public static final String CREATEGAMESCREEN = "name_3";
    public static final String DELETEGAMESCREEN = "name_4";
    public static final String HIGHSCORESCREEN = "name_5";
    public static final String JOINGAMESCREEN = "name_6";


    //Declaring variables used in this class
    public LoginScreen loginScreen;
    private MenuScreen menuScreen;
    private DeleteGameScreen deleteGameScreen;
    private HighScoreScreen highScoreScreen;
    private CreateGameScreen createGameScreen;
    private JoinGameScreen joinGameScreen;

    private CardLayout cardLayout;
    private JPanel contentPane;

    /**
     * Creating the frame
     */
    public Screen()
    {
        //Adding attributes for the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 529, 475);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(62, 77, 86));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //Setting layout to card layout
        contentPane.setLayout(new CardLayout(0, 0));

        //Adding all the panels to this contentPane

        loginScreen = new LoginScreen();
        contentPane.add(loginScreen, LOGINSCREEN);

        menuScreen = new MenuScreen();
        contentPane.add(menuScreen,MENUSCREEN);

        createGameScreen = new CreateGameScreen();
        contentPane.add(createGameScreen,CREATEGAMESCREEN);

        highScoreScreen = new HighScoreScreen();
        contentPane.add(highScoreScreen,HIGHSCORESCREEN);

        joinGameScreen = new JoinGameScreen();
        contentPane.add(joinGameScreen,JOINGAMESCREEN);

        deleteGameScreen = new DeleteGameScreen();
        contentPane.add(deleteGameScreen,DELETEGAMESCREEN);

        cardLayout = (CardLayout) getContentPane().getLayout();

    }//End of method

    /**
     * Getter for createGameScreen
     * @return createGameScreen
     */
    public CreateGameScreen getCreateGameScreen() {
        return createGameScreen;
    }

    /**
     * Getter for loginScreen
     * @return loginScreen
     */
    public LoginScreen getLoginScreen()
    {
        return loginScreen;
    }//

    /**
     * Getter for menuScreen
     * @return menuScreen
     */
    public MenuScreen getMenuScreen()
    {
        return menuScreen;
    }//

    /**
     * Getter for joinGameScreen
     * @return joinGameScreen
     */
    public JoinGameScreen getJoinGameScreen() {
        return joinGameScreen;
    }

    /**
     * Getter for highScoreScreen
     * @return highScoreScreen
     */
    public HighScoreScreen getHighScoreScreen() {

        return highScoreScreen;
    }

    /**
     * Getter for deleteGame
     * @return deleteGameScreen
     */
    public DeleteGameScreen getDeleteGameScreen()
    {
        return deleteGameScreen;
    }//


    /**
     * This method sends the individual cards to the frame
     * @param card
     */
    public void show(String card)
    {
        cardLayout.show(this.getContentPane(), card);
    }//End of method



}//End of class Screen