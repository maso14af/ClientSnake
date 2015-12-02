package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Jframe klasse som indeholder alle de andre panels, alt trafikken samles og går igennem denne klasse.nnem denne klasse
 */
public class Screen extends JFrame 
{
	//Tilegener ID
	public static final String LOGINSCREEN = "name_1";
	public static final String MENUSCREEN = "name_2";
	public static final String CREATEGAMESCREEN = "name_3";
	public static final String DELETEGAMESCREEN = "name_4";
	public static final String HIGHSCORESCREEN = "name_5";
	public static final String JOINGAMESCREEN = "name_6";


	//Instantierer variabler
	public LoginScreen loginScreen;
	private MenuScreen menuScreen;
	private DeleteGameScreen DeleteGameScreen;
	private HighScoreScreen HighScoreScreen;
	private CreateGameScreen CreateGameScreen;
	private JoinGameScreen JoinGameScreen;

	
	
	private CardLayout c;  

	private JPanel contentPane;

	/**
	 * create the frame
	 */
	public Screen() 
	{
		//setter attributter 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(62, 77, 86));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		//layout sættes til cardlayout
		contentPane.setLayout(new CardLayout(0, 0));

		//adder alle panels til dette contentpane

		loginScreen = new LoginScreen();
		contentPane.add(loginScreen, LOGINSCREEN);

		menuScreen = new MenuScreen();
		contentPane.add(menuScreen,MENUSCREEN);
		
		CreateGameScreen = new CreateGameScreen();
		contentPane.add(CreateGameScreen,CREATEGAMESCREEN);
		
		HighScoreScreen = new HighScoreScreen();
		contentPane.add(HighScoreScreen,HIGHSCORESCREEN);
		
		JoinGameScreen = new JoinGameScreen();
		contentPane.add(JoinGameScreen,JOINGAMESCREEN);

		DeleteGameScreen = new DeleteGameScreen();
		contentPane.add(DeleteGameScreen,DELETEGAMESCREEN);

		c = (CardLayout) getContentPane().getLayout();
		
	}//metode slut


	public GUI.CreateGameScreen getCreateGameScreen() {
		return CreateGameScreen;
	}

	/**
	 * Getter for loginScreen

	 * @return loginScreen
	 */
	public LoginScreen getLoginScreen() 
	{
		return loginScreen;
	}//metode slut
	
	/**
	 * Getter for menuScreen
	 * @return menuScreen
	 */
	public MenuScreen getMenuScreen() 
	{
		return menuScreen;
	}//metode slut
	
	/**
	 * Getter for deleteGame
	 * @return DeleteGameScreen
	 */
	public DeleteGameScreen getDeleteGameScreen() 
	{
		return DeleteGameScreen;
	}//metode slut


	/**
	 * denne metode sender de forskellige cards til framet.
	 * @param card
	 */
	public void show(String card) 
	{
		c.show(this.getContentPane(), card);
	}//metode slut


	
}//klasse slut