package Logic;


import GUI.Screen;
import SDK.Game;
import SDK.Logic;
import SDK.User;
import SDK.Gamer;
import SDK.Score;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Controller
{
    private Screen screen;
    private Logic logic;
    private User currentUser;


    /**
     * Opretter konstruktur. Laver objekt af screen.
     */
    public Controller()
    {
        screen = new Screen();
        logic = new Logic();
        screen.setVisible(true);

        currentUser = new User();
    }//konstruktør slut

    /**
     * metoden Main klassen kaldes for at starte programmet
     */
    public void run()
    {


        // Injection af listeners i panels
        screen.loginScreen.addActionListener(new LoginActionListener());
        screen.getMenuScreen().addActionListener(new MenuScreenActionListener());
        screen.getCreateGameScreen().addActionListener(new CreateGameActionListener());
        screen.getJoinGameScreen().addActionListener(new JoinGameActionListener());
        screen.getDeleteGameScreen().addActionListener(new DeleteGameActionListener());
        screen.getHighScoreScreen().addActionListener(new HighScoreActionListener());
        // vis startskaerm
        screen.show(Screen.LOGINSCREEN);



    }


    private class LoginActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Når der trykkes på login
            if (e.getSource() == screen.getLoginScreen().getBtnLogin())
            {
                String username = screen.getLoginScreen().getTxtUser().getText();
                String password = screen.getLoginScreen().getTxtPassword().getText();

                currentUser.setUsername(username);
                currentUser.setPassword(password);

                int response = logic.login(currentUser);

                if(response == 200)
                {
                    for (User user : logic.getUsers())
                    {
                        if (user.getUsername().equals(screen.getLoginScreen().getTxtUser().getText()))
                        {
                            currentUser = user;
                        }
                    }

                    screen.show(screen.MENUSCREEN);
                }
                else
                    screen.getLoginScreen().getLblError().setVisible(true);


            }//if listener slut
        }//actionPerformed slut
    }//inner class slut

    /**
     * inner class
     * UserMenu panel actionlistener
     * Styrer menu screen
     */
    private class MenuScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Hvis brugeren trykker på Create Game
            if (e.getSource() == screen.getMenuScreen().getBtnCreateGame())
            {
                screen.show(Screen.CREATEGAMESCREEN);
                System.out.print(currentUser.getId());
            }//if slut
            //Hvis brugeren trykker på delete game
            if (e.getSource() == screen.getMenuScreen().getBtnDeleteGame())
            {
            screen.show(Screen.DELETEGAMESCREEN);
            }//if slut
            //Hvis brugeren trykker på High Scores
            if (e.getSource() == screen.getMenuScreen().getBtnHighScore())
            {
              screen.show(Screen.HIGHSCORESCREEN);
                showHighScores();
            }//if slut


            //Hvis brugeren trykker på Join Game .
            if (e.getSource() == screen.getMenuScreen().getBtnJoinGame())
            {
            screen.show(Screen.JOINGAMESCREEN);
               //Resetter evt. tekst i felterne.
               // screen.getJoinGameScreen().getTxtGameName().setText("");
            }//if slut
            //hvis brugeren trykker log af knap
            if (e.getSource() == screen.getMenuScreen().getBtnLogout())
            {
                //sender videre til valgte panel
                screen.show(Screen.LOGINSCREEN);
                //Resetter felterne
                screen.getLoginScreen().getTxtUser().setText("");
                screen.getLoginScreen().getTxtPassword().setText("");
                screen.getLoginScreen().getLblError().setVisible(false);
            }
        }//actionPerformed slut
    }//inner class slut

    private class CreateGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Hvis brugeren trykker på Home knap
            if (e.getSource() == screen.getCreateGameScreen().getBtnHome())
            {
                screen.show(Screen.MENUSCREEN);

            }//if slut

            if (e.getSource() == screen.getCreateGameScreen().getBtnCreateGame()){


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
                }
                else
                    System.out.print("Game was not created");
                    screen.getCreateGameScreen().getLblErrorNoGame().setVisible(true);

                /*if(logic.createGame(gamename, moves)){

                    System.out.println("Game has been created");

                }*/


            }

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
                screen.show(Screen.MENUSCREEN);
            }//if slut
            if (e.getSource() == screen.getJoinGameScreen().getBtnJoinGame())
            {
               // String gameName = screen.getJoinGameScreen().getTxtGameName().getText();
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
                } else
                    screen.getJoinGameScreen().getLblErrorNoGame().setVisible(true);
                    System.out.println("Game was not joined");
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
            }//if slut
            //Hvis brugeren trykker på delete Game
            try
            {
            if (e.getSource() == screen.getDeleteGameScreen().getBtnDeleteGame())
            {
                int gameId=Integer.parseInt(screen.getDeleteGameScreen().getTxtGameName().getText());
                int response = logic.deleteGame(gameId);
                if  (response == 200)
                {
                    System.out.print("Game was deleted");
                }
                else

                    System.out.print("Game was not deleted, try again");

            }
            } catch (Exception e1)
            {
                System.out.print("To delete a game type the ID with int");
                screen.getDeleteGameScreen().getLblWrongInput().setVisible(true);
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



}//klasse slut