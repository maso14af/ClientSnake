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

    private class CreateGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Hvis brugeren trykker på Home knap
            if (e.getSource() == screen.getCreateGameScreen().getBtnHome())
            {
                screen.getCreateGameScreen().getTxtGameName().setText("");
                screen.getCreateGameScreen().getTxtControls().setText("");
                screen.getCreateGameScreen().getLblErrorNoName().setVisible(false);
                screen.getCreateGameScreen().getLblGameCreated().setVisible(false);
                screen.show(Screen.MENUSCREEN);
                //Resetter tekst felter

            }//if slut




            if (e.getSource() == screen.getCreateGameScreen().getBtnCreateGame()){
                if(screen.getCreateGameScreen().getTxtGameName().getText().equals("")
                        ||screen.getCreateGameScreen().getTxtControls().getText().equals(""))
                {
                    System.out.print("Can't be empty name");
                    screen.getCreateGameScreen().getLblErrorNoName().setVisible(true);
                    screen.getCreateGameScreen().getLblGameCreated().setVisible(false);
                }
                else
                {


                    String gameName = screen.getCreateGameScreen().getTxtGameName().getText();
                    String moves = screen.getCreateGameScreen().getTxtControls().getText();

                    Gamer host = new Gamer();
                    host.setId(currentUser.getId());
                    host.setControls(moves);

                    Game game = new Game();
                    game.setName(gameName);
                    game.setHost(host);
                    game.setMapSize(20);

                    int response = logic.createGame(game);

                    if (response == 201)
                    {
                        System.out.print("Game has been created");
                        screen.getCreateGameScreen().getLblGameCreated().setVisible(true);
                        screen.getCreateGameScreen().getLblErrorNoName().setVisible(false);
                    }
                    else if (response == 400) {
                        System.out.print("Game was not created");
                        screen.getCreateGameScreen().getLblErrorNoName().setVisible(true);
                        screen.getCreateGameScreen().getLblGameCreated().setVisible(false);
                    }



                }}

        }//actionPerformed slut
    }//inner class slut

    private class JoinGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Hvis brugeren trykker på Home knap
            if (e.getSource() == screen.getJoinGameScreen().getBtnHome())
            {
                screen.getJoinGameScreen().getLblNoControls().setVisible(false);
                screen.getJoinGameScreen().getLblErrorNoGame().setVisible(false);
                screen.getJoinGameScreen().getLblGameJoined().setVisible(false);
                screen.getJoinGameScreen().getTxtControls().setText("");
                screen.getJoinGameScreen().getTxtGameName().setText("");
                screen.show(Screen.MENUSCREEN);
            }//if slut
            if (e.getSource() == screen.getJoinGameScreen().getBtnJoinGame())
            {
                if(screen.getJoinGameScreen().getTxtGameName().getText().equals("")
                        ||screen.getJoinGameScreen().getTxtControls().getText().equals(""))
                {
                    System.out.print("Enter controls and game name");
                    screen.getJoinGameScreen().getLblNoControls().setVisible(true);
                    screen.getJoinGameScreen().getLblErrorNoGame().setVisible(false);
                    screen.getJoinGameScreen().getLblGameJoined().setVisible(false);
                }
                else
                {
                    String moves = screen.getJoinGameScreen().getTxtControls().getText();

                    Gamer opponent = new Gamer();
                    opponent.setId(currentUser.getId());
                    opponent.setControls(moves);


                    Game game = new Game();
                    game.setOpponent(opponent);

                    for (Game g : logic.openGames())
                    {
                        if (g.getName().equals(screen.getJoinGameScreen().getTxtGameName().getText()))
                        {
                            game.setGameId(g.getGameId());
                        }
                    }
                    int response = logic.joinGame(game);
                    if (response == 201)
                    {
                        logic.startGame(game);
                        System.out.println("Game has been joined and started");
                        screen.getJoinGameScreen().getLblGameJoined().setVisible(true);
                        screen.getJoinGameScreen().getLblErrorNoGame().setVisible(false);
                        screen.getJoinGameScreen().getLblNoControls().setVisible(false);
                    } else if (response == 400){
                        screen.getJoinGameScreen().getLblErrorNoGame().setVisible(true);
                        screen.getJoinGameScreen().getLblGameJoined().setVisible(false);
                        screen.getJoinGameScreen().getLblNoControls().setVisible(false);
                        System.out.println("Game was not joined");
                    }
                }
            }
        }//actionPerformed slut
    }//inner class slut

    private class DeleteGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Hvis brugeren trykker på Home knap
            if (e.getSource() == screen.getDeleteGameScreen().getBtnHome())
            {
                screen.show(Screen.MENUSCREEN);
                screen.getDeleteGameScreen().getLblWrongInput().setVisible(false);
                screen.getDeleteGameScreen().getLblErrorNoGame().setVisible(false);
                screen.getDeleteGameScreen().getLblGameDeleted().setVisible(false);
                screen.getDeleteGameScreen().getTxtGameName().setText("");
            }//if slut
            //Hvis brugeren trykker på delete Game
            try
            {
                if (e.getSource() == screen.getDeleteGameScreen().getBtnDeleteGame())
                {
                    int gameId=Integer.parseInt(screen.getDeleteGameScreen().getTxtGameName().getText());
                    int response = logic.deleteGame(gameId);
                    if  (response == 200) {
                        System.out.print("Game was deleted");
                        screen.getDeleteGameScreen().getLblGameDeleted().setVisible(true);
                        screen.getDeleteGameScreen().getLblErrorNoGame().setVisible(false);
                        screen.getDeleteGameScreen().getLblWrongInput().setVisible(false);
                    }
                    else if (response == 400) {

                        System.out.print("Game was not deleted, try again");
                        screen.getDeleteGameScreen().getLblWrongInput().setVisible(false);
                        screen.getDeleteGameScreen().getLblErrorNoGame().setVisible(true);
                        screen.getDeleteGameScreen().getLblGameDeleted().setVisible(false);
                    }
                }
            } catch (Exception e1)
            {
                System.out.print("To delete a game type the ID with int");
                screen.getDeleteGameScreen().getLblWrongInput().setVisible(true);
                screen.getDeleteGameScreen().getLblErrorNoGame().setVisible(false);
                screen.getDeleteGameScreen().getLblGameDeleted().setVisible(false);
            }

        }//actionPerformed slut
    }//inner class slut

    private class HighScoreActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Hvis brugeren trykker på Home knap
            if (e.getSource() == screen.getHighScoreScreen().getBtnHome())
            {
                screen.show(Screen.MENUSCREEN);
            }//if slut

        }//actionPerformed slut
    }//inner class slut

    public class HighScoreTableModel extends AbstractTableModel
    {
        private static final long serialVersionUID = 1L;

        private ArrayList<Score> highScores;
        private String[] columns = {"Username", "Score"};
        private int numberOfRows;

        public HighScoreTableModel(ArrayList<Score> highScores)
        {
            this.highScores = highScores;
            fireTableStructureChanged();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return super.getColumnClass(columnIndex);
        }

        @Override
        public int getRowCount() {
            numberOfRows = highScores.size();
            return numberOfRows;
        }

        public String getColumnName(int columnIndex) {

            return columns[columnIndex];

        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {

                case 0:
                    return highScores.get(rowIndex).getGame().getWinner().getUsername();
                case 1:
                    return highScores.get(rowIndex).getScore();
            }

            return null;
        }
    }

    public void showHighScores()
    {
        ArrayList<Score> highScores = logic.getHighScores();
        HighScoreTableModel highScoreTableModel = new HighScoreTableModel(highScores);
        screen.getHighScoreScreen().getTable().setModel(highScoreTableModel);
    }
}//End of class Controller