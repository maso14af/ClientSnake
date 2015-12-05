package Logic;


import GUI.Screen;
import SDK.Game;
import SDK.Logic;
import SDK.User;
import SDK.Gamer;


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
                else System.out.print("Game was not created");

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


                /*if(logic.createGame(gamename, moves)){

                    System.out.println("Game has been created");

                }*/




        }//actionPerformed slut
    }//inner class slut


}//klasse slut