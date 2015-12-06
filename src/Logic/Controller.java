package Logic;


import GUI.Screen;
import SDK.*;

import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



//Start of class
public class Controller
{
    //Declaring variables used in this class
    private Screen screen;
    private Logic logic;
    private User currentUser;


    /**
     * Creating constructor and making object of Screen.
     */
    public Controller()
    {
        screen = new Screen();
        logic = new Logic();
        screen.setVisible(true);

        currentUser = new User();
    }//End of constructor

    /**
     * Method run() is called from the Main class to start the program
     */
    public void run()
    {
        //Injection of listeners to the panels
        screen.loginScreen.addActionListener(new LoginActionListener());
        screen.getMenuScreen().addActionListener(new MenuScreenActionListener());
        screen.getCreateGameScreen().addActionListener(new CreateGameActionListener());
        screen.getJoinGameScreen().addActionListener(new JoinGameActionListener());
        screen.getDeleteGameScreen().addActionListener(new DeleteGameActionListener());
        screen.getHighScoreScreen().addActionListener(new HighScoreActionListener());
        //Login Screen is shown after injections are done
        screen.show(Screen.LOGINSCREEN);
    }

    /**
     * Inner class LoginActionListener is used to login.
     */
    private class LoginActionListener implements ActionListener
    {
        /**
         * The method activates when the login button is pressed, when it is pressed it checks whether or not
         * the username and password in the text and password fields
         * matches something in the database. If it does the user is sent to the menu screen,
         * if it doesn't an error label is made visible telling the user that username or password is wrong
         * @param e is an object of ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {

            //When the login button is pressed
            if (e.getSource() == screen.getLoginScreen().getBtnLogin())
            {
                String username = screen.getLoginScreen().getTxtUser().getText();
                String password = screen.getLoginScreen().getTxtPassword().getText();

                //Sets currentUser to the text in the text and password fields
                currentUser.setUsername(username);
                currentUser.setPassword(password);

                int response = logic.login(currentUser);

                if(response == 200)
                {
                    for (User user : logic.getUsers())
                    {   //Checks if the username and password typed exists
                        if (user.getUsername().equals(screen.getLoginScreen().getTxtUser().getText()))
                        {
                            currentUser = user;
                        }
                    }
                    //If user exists and password is correct the menu screen is shown
                    screen.show(Screen.MENUSCREEN);
                }
                else
                    //If incorrect logon the error label is made visible
                    screen.getLoginScreen().getLblError().setVisible(true);


            }//End of if listener
        }//End of actionPerformed
    }//End of inner class

    /**
     * Inner class
     * MenuScreen panel actionListener
     * Controls menu screen
     */
    //Start of class
    private class MenuScreenActionListener implements ActionListener
    {
        /**
         * Method which listens to all the buttons on the menu screen.
         * When a specific button is pressed the method sends the user to that screen by using
         * screen.show(). All the if statements work the same way, except the logout which also clears the
         * text that the user has previously typed as well as making any error labels hidden again. The high score
         * button also runs a method called showHighScores()
         * @param e is an object of ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //If the user presses the create game button
            if (e.getSource() == screen.getMenuScreen().getBtnCreateGame())
            {
                screen.show(Screen.CREATEGAMESCREEN);
                System.out.print(currentUser.getId());
            }
            //If the user presses the delete game button
            if (e.getSource() == screen.getMenuScreen().getBtnDeleteGame())
            {
                screen.show(Screen.DELETEGAMESCREEN);
            }
            //If the user presses the high score button
            if (e.getSource() == screen.getMenuScreen().getBtnHighScore())
            {
                screen.show(Screen.HIGHSCORESCREEN);
                showHighScores();
            }

            //If the user presses the join game button
            if (e.getSource() == screen.getMenuScreen().getBtnJoinGame())
            {
                screen.show(Screen.JOINGAMESCREEN);
            }
            //If the user presses the logout button
            if (e.getSource() == screen.getMenuScreen().getBtnLogout())
            {
                screen.show(Screen.LOGINSCREEN);
                //Resets text and password fields and making error hidden.
                screen.getLoginScreen().getTxtUser().setText("");
                screen.getLoginScreen().getTxtPassword().setText("");
                screen.getLoginScreen().getLblError().setVisible(false);
            }
        }//End of actionPerformed
    }//End of inner class.

    /**
     * Inner class CreateGameActionListener is used to create a game.
     */
    private class CreateGameActionListener implements ActionListener
    {
        /**
         * Method which listens to buttons in the Create Game menu. If the user presses the home button, he is
         * returned to the menu and all the text fields are reset and the labels are made hidden.
         * When the user presses the create game button a check is made whether or not the user has
         * actually typed a name and controls. If one of these are empty an error label will show.
         * If the user enters correctly a confirm label will show.
         * When the game is created the user is set as the host and the game is set to open to allow
         * a opponent to later join the game.
         *
         * @param e is an object of ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //If the user presses the home button
            if (e.getSource() == screen.getCreateGameScreen().getBtnHome())
            {
                //Resets text fields and labels
                screen.getCreateGameScreen().getTxtGameName().setText("");
                screen.getCreateGameScreen().getTxtControls().setText("");
                screen.getCreateGameScreen().getLblErrorNoName().setVisible(false);
                screen.getCreateGameScreen().getLblGameCreated().setVisible(false);
                screen.show(Screen.MENUSCREEN);
            }
            //If the create game button is pressed
            if (e.getSource() == screen.getCreateGameScreen().getBtnCreateGame())
            {
                if(screen.getCreateGameScreen().getTxtGameName().getText().equals("")
                        ||screen.getCreateGameScreen().getTxtControls().getText().equals(""))
                {
                    //If one or more text fields are empty error label will show.
                    screen.getCreateGameScreen().getLblErrorNoName().setVisible(true);
                    screen.getCreateGameScreen().getLblGameCreated().setVisible(false);
                }
                else
                {
                    //GameName and moves are set to what the user has typed in the fields
                    String gameName = screen.getCreateGameScreen().getTxtGameName().getText();
                    String moves = screen.getCreateGameScreen().getTxtControls().getText();

                    //A gamer is created and the host is set to currentUser and controls are saved
                    Gamer host = new Gamer();
                    host.setId(currentUser.getId());
                    host.setControls(moves);

                    //A game is created and the host, gameName and map size are set.
                    Game game = new Game();
                    game.setName(gameName);
                    game.setHost(host);
                    game.setMapSize(20);

                    int response = logic.createGame(game);

                    //If statement that checks the response code from the server
                    if (response == 201)
                    {
                        //If game is created game created label will show
                        screen.getCreateGameScreen().getLblGameCreated().setVisible(true);
                        screen.getCreateGameScreen().getLblErrorNoName().setVisible(false);
                    }
                    else if (response == 400)
                    {
                        //If game not created an error label will show
                        screen.getCreateGameScreen().getLblErrorNoName().setVisible(true);
                        screen.getCreateGameScreen().getLblGameCreated().setVisible(false);
                    }
                }
            }

        }//End of actionPerformed
    }//End of inner class

    /**
     * Inner class JoinGameActionListener is used to join a game
     */
    private class JoinGameActionListener implements ActionListener
    {
        /**
         * Method which listens to the buttons in the Join Game Menu. If the Home Button is pressed the user
         * is returned to the menu screen and all the fields and labels are reset. When the join game button is
         * pressed with correct information a confirm label will show.
         * The controls entered by the user are set to the opponent controls and put on the game object which
         * is send to the server.
         * @param e is an object of ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //If the user presses the home button
            if (e.getSource() == screen.getJoinGameScreen().getBtnHome())
            {
                //Reset of text fields and labels
                screen.getJoinGameScreen().getLblNoControls().setVisible(false);
                screen.getJoinGameScreen().getLblErrorNoGame().setVisible(false);
                screen.getJoinGameScreen().getLblGameJoined().setVisible(false);
                screen.getJoinGameScreen().getTxtControls().setText("");
                screen.getJoinGameScreen().getTxtGameName().setText("");
                screen.show(Screen.MENUSCREEN);
            }

            //If the join game button is pressed
            if (e.getSource() == screen.getJoinGameScreen().getBtnJoinGame())
            {
                //If statement to check if there is an empty text field
                if(screen.getJoinGameScreen().getTxtGameName().getText().equals("")
                        ||screen.getJoinGameScreen().getTxtControls().getText().equals(""))
                {
                    //If there is an empty field an error label will show
                    screen.getJoinGameScreen().getLblNoControls().setVisible(true);
                    screen.getJoinGameScreen().getLblErrorNoGame().setVisible(false);
                    screen.getJoinGameScreen().getLblGameJoined().setVisible(false);
                }
                else
                {
                    //Saves the moves of the user
                    String moves = screen.getJoinGameScreen().getTxtControls().getText();

                    //Creates a gamer opponent with id and controls of the currentUser
                    Gamer opponent = new Gamer();
                    opponent.setId(currentUser.getId());
                    opponent.setControls(moves);

                    //Creates an object of game and sets the opponent and his controls.
                    Game game = new Game();
                    game.setOpponent(opponent);

                    //Searches for a game by the game name typed by the user
                    for (Game g : logic.openGames())
                    {
                        //For loop for finding an open game with the name that the user has entered
                        if (g.getName().equals(screen.getJoinGameScreen().getTxtGameName().getText()))
                        {
                            game.setGameId(g.getGameId());
                        }
                    }
                    int response = logic.joinGame(game);
                    //If statement to check the response code from the server
                    if (response == 201)
                    {
                        //Starts the game
                        logic.startGame(game);
                        //If the game has been joined a confirm label will show
                        screen.getJoinGameScreen().getLblGameJoined().setVisible(true);
                        screen.getJoinGameScreen().getLblErrorNoGame().setVisible(false);
                        screen.getJoinGameScreen().getLblNoControls().setVisible(false);
                    } else if (response == 400)
                    {
                        //If the game was not joined an error label will show
                        screen.getJoinGameScreen().getLblErrorNoGame().setVisible(true);
                        screen.getJoinGameScreen().getLblGameJoined().setVisible(false);
                        screen.getJoinGameScreen().getLblNoControls().setVisible(false);
                    }
                }
            }
        }//End of actionPerformed
    }//End of inner class

    /**
     * Inner class DeleteGameActionListener is used to delete a game
     */
    private class DeleteGameActionListener implements ActionListener
    {
        /**
         * Method which listens to the buttons in the Delete Game menu.
         * If the home button is pressed the user is sent back to the menu and all the text fields and labels reset
         * If the user types an game id of an existing game a confirm label will show.
         * This happens by a delete request to the server that returns the response code 200 from the server.
         * If the game id didn't exist an error label will show. Because the game id is an int, a try catch
         * is made to ensure that the program does not crash if the user doesn't enter an int
         * @param e is an object of ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //If the user presses the home button
            if (e.getSource() == screen.getDeleteGameScreen().getBtnHome())
            {
                //Menu Screen is shown and text fields and labels are reset
                screen.show(Screen.MENUSCREEN);
                screen.getDeleteGameScreen().getLblWrongInput().setVisible(false);
                screen.getDeleteGameScreen().getLblErrorNoGame().setVisible(false);
                screen.getDeleteGameScreen().getLblGameDeleted().setVisible(false);
                screen.getDeleteGameScreen().getTxtGameName().setText("");
            }
            //Try catch to prevent crashing from incorrect input
            try
            {
                //If the user presses the delete game button
                if (e.getSource() == screen.getDeleteGameScreen().getBtnDeleteGame())
                {
                    //Gets the text from gameId text field and parses it to an int so it can be used to delete a game
                    int gameId=Integer.parseInt(screen.getDeleteGameScreen().getTxtGameName().getText());
                    //Delete request is sent to the server based on the int parsed from the text field
                    int response = logic.deleteGame(gameId);
                    //If response from server is 200
                    if  (response == 200)
                    {
                        //If the game is deleted a confirm label will show
                        screen.getDeleteGameScreen().getLblGameDeleted().setVisible(true);
                        screen.getDeleteGameScreen().getLblErrorNoGame().setVisible(false);
                        screen.getDeleteGameScreen().getLblWrongInput().setVisible(false);
                    }
                    //If response from server is 400
                    else if (response == 400)
                    {
                        //If the game was not deleted an error label will show
                        screen.getDeleteGameScreen().getLblWrongInput().setVisible(false);
                        screen.getDeleteGameScreen().getLblErrorNoGame().setVisible(true);
                        screen.getDeleteGameScreen().getLblGameDeleted().setVisible(false);
                    }
                }
            }
            //Catch if the user submitted incorrect input
            catch (Exception e1)
            {
                //If the user doesn't type an int a error label will show
                screen.getDeleteGameScreen().getLblWrongInput().setVisible(true);
                screen.getDeleteGameScreen().getLblErrorNoGame().setVisible(false);
                screen.getDeleteGameScreen().getLblGameDeleted().setVisible(false);
            }

        }//End of actionPerformed
    }//End of inner class

    /**
     * Innerclass HighScoreActionListener is used to show High Scores
     */
    private class HighScoreActionListener implements ActionListener
    {
        /**
         * Method which listens to the home button, if this button is pressed the user is sent back to the menu
         * @param e is an object of ActionListener
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //If the user presses the home button
            if (e.getSource() == screen.getHighScoreScreen().getBtnHome())
            {
                //The user is sent back to the menu screen
                screen.show(Screen.MENUSCREEN);
            }
        }//End of actionPerformed
    }//End of inner class

    /**
     * Inner class HighScoreTableModel is used to retrieve the top 10 scores from the server.
     * Class is used to get the variables that are needed to form the JTable with the high scores.
     * In this class it is also set which attributes are to be shown in the JTable, here Username and Score are
     * shown.
     * Extends AbstractTableModel
     */
    public class HighScoreTableModel extends AbstractTableModel
    {
        //Initializing of variables used
        private static final long serialVersionUID = 1L;
        private ArrayList<Score> highScores;
        private String[] columns = {"Username", "Score"};
        private int numberOfRows;

        /**
         * Setter for highScores, sets the high scores to the Array the high scores
         * @param highScores is an ArrayList of Score
         */
        public HighScoreTableModel(ArrayList<Score> highScores)
        {
            this.highScores = highScores;
            fireTableStructureChanged();
        }

        /**
         * Getter for columns.length, the method returns the number of columns
         * @return columns.length
         */
        @Override
        public int getColumnCount()
        {
            return columns.length;
        }

        /**
         * Method that returns the columnIndex
         * @param columnIndex returns the ColumnIndex
         * @return super.getColumnClass(columnIndex);
         */
        @Override
        public Class<?> getColumnClass(int columnIndex)
        {
            return super.getColumnClass(columnIndex);
        }

        /**
         * getter for numberOfRows, this method returns the number of rows
         * @return numberOfRows
         */
        @Override
        public int getRowCount()
        {
            numberOfRows = highScores.size();
            return numberOfRows;
        }

        /**
         * Method that returns the number of columns.
         * @param columnIndex Number of columns
         * @return columns[columnIndex]
         */
        public String getColumnName(int columnIndex)
        {
            return columns[columnIndex];
        }

        /**
         * Method to get the username and belonging scores, this is done by using the rowIndex and columnIndex
         * gotten from the get methods.
         * @param rowIndex is the rowIndex from the previous getter
         * @param columnIndex is the columnIndex from the previous getter
         * @return null
         */
        @Override
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            switch (columnIndex)
            {

                case 0:
                    return highScores.get(rowIndex).getGame().getWinner().getUsername();
                case 1:
                    return highScores.get(rowIndex).getScore();
            }

            return null;
        }
    }//End of inner class

    /**
     * Method used to show the high scores
     */
    public void showHighScores()
    {
        //Retrieves the ArrayList of highScores from the logic class in the SDK package
        ArrayList<Score> highScores = logic.getHighScores();
        //Creates an object of HighScoreTableModel
        HighScoreTableModel highScoreTableModel = new HighScoreTableModel(highScores);
        //Sets the high score in the JTable.
        screen.getHighScoreScreen().getTable().setModel(highScoreTableModel);
    }
}//End of class Controller