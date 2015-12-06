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
import java.awt.event.ActionEvent;

/**
 * This class contains the DeleteGameScreen GUI, this class has the getters for all
 * the textFields and confirm/ error labels used in the Delete Game menu. The logic for the class is in the
 * controller class in the Logic package.
 *extends JPanel
 */
public class DeleteGameScreen extends JPanel 
{
	//Initializing of variables used in this class
	private JLabel lblDeleteGame;
	private JTextField txtGameName;
	private JButton btnHome;
	private JLabel lblGameName;
	private JLabel lblErrorNoGame;
	private JButton btnDeleteGame;
	private JLabel lblWrongInput;
    private JLabel lblGameDeleted;


    /**
     * Creation of the Delete Game panel
     */
	public DeleteGameScreen()
	{
		setLayout(null);
		setBackground(new Color(102, 153, 204));
		setBounds(100, 100, 529, 475);

		//Creating delete game label and adding attributes
		lblDeleteGame = new JLabel("Delete Game");
		lblDeleteGame.setForeground(Color.WHITE);
		lblDeleteGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteGame.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblDeleteGame.setBounds(196, 47, 200, 50);
		add(lblDeleteGame);

		//Creating game name text field and adding attributes
		txtGameName = new JTextField();
		txtGameName.setBounds(196, 192, 200, 28);
		add(txtGameName);
		txtGameName.setColumns(10);

		//Creating home button and adding attributes as well as image
		btnHome = new JButton();
		Image imgHome = new ImageIcon(this.getClass().getResource("/res/btnHome.png")).getImage();
		btnHome.setIcon(new ImageIcon(imgHome));
		btnHome.setBounds(16, 10, 42, 38);
		add(btnHome);

		//Creating game name label and adding attributes
		lblGameName = new JLabel("Game ID:");
		lblGameName.setForeground(Color.WHITE);
		lblGameName.setBounds(60, 198, 118, 16);
		add(lblGameName);

		//Creating hidden no game error label and adding attributes
		lblErrorNoGame = new JLabel("No game by that name");
		lblErrorNoGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorNoGame.setForeground(Color.RED);
		lblErrorNoGame.setBounds(157, 252, 267, 28);
		lblErrorNoGame.setVisible(false);
		add(lblErrorNoGame);

        //Creating hidden wrong input label and adding attributes
        lblWrongInput = new JLabel("Input must be an int");
        lblWrongInput.setHorizontalAlignment(SwingConstants.CENTER);
        lblWrongInput.setForeground(Color.RED);
        lblWrongInput.setBounds(157, 252, 267, 28);
        lblWrongInput.setVisible(false);
        add(lblWrongInput);

        //Creating game deleted confirm label and adding attributes
        lblGameDeleted = new JLabel("Game deleted");
        lblGameDeleted.setHorizontalAlignment(SwingConstants.CENTER);
        lblGameDeleted.setForeground(Color.RED);
        lblGameDeleted.setBounds(157, 252, 267, 28);
        lblGameDeleted.setVisible(false);
        add(lblGameDeleted);

		//Creating delete game button and adding attributes
		btnDeleteGame = new JButton("Delete Game");
		btnDeleteGame.setBounds(241, 224, 117, 29);
		add(btnDeleteGame);

	}//End of method


    /**
     * Getter for lblGameDeleted
     * @return lblGameDeleted
     */
    public JLabel getLblGameDeleted() {
        return lblGameDeleted;
    }

    /**
     * Getter for btnHome
     * @return btnHome
     */
    public JButton getBtnHome() {
		return btnHome;
	}

    /**
     * Getter for lblWrongInput
     * @return lblWrongInput
     */
	public JLabel getLblWrongInput() {
		return lblWrongInput;
	}

	/**
	 * Getter for txtGameName
	 * @return txtGameName
	 */
	public JTextField getTxtGameName() 
	{
		return txtGameName;
	}//metode slut
	
	/**
	 * Getter for lblErrorNoGame
	 * @return lblErrorNoGame
	 */
	public JLabel getLblErrorNoGame() 
	{
		return lblErrorNoGame;
	}//metode slut

    /**
     * Getter for btnDeleteGame
     * @return btnDeleteGame
     */
	public JButton getBtnDeleteGame() {
		return btnDeleteGame;
	}

	/**
	 * Creating action listeners for this panel
	 * @param l
	 */
	public void addActionListener(ActionListener l) 
	{
		btnHome.addActionListener(l);
		btnDeleteGame.addActionListener(l);
	}//End of method
}//End of class DeleteGameScreen