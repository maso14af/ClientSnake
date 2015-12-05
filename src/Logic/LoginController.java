package Logic;


import GUI.Screen;
import SDK.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class LoginController
{
    public GUI.Screen screen;
    public MenuScreenController msc;
    public Logic logic;


    /**
     * Opretter konstruktur. Laver objekt af screen.
     */
    public LoginController()
    {
        screen = new Screen();
        logic = new Logic();
        //msc = new MenuScreenController(screen);



        screen.setVisible(true);
    }//konstruktør slut

    /**
     * metoden Main klassen kaldes for at starte programmet
     */
    public void run()
    {

        //msc = new MenuScreenController(screen);

        // Injection af listeners i panels
        screen.loginScreen.addActionListener(new LoginActionListener());
        screen.getMenuScreen().addActionListener(new MenuScreenActionListener());
        screen.getCreateGameScreen().addActionListener(new CreateGameActionListener());
        // vis startskaerm
        //msc.run();
        screen.show(Screen.LOGINSCREEN);


    }


    private class LoginActionListener implements ActionListener
    {
        SDK.Logic logic = new SDK.Logic();
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Når der trykkes på login
            if (e.getSource() == screen.getLoginScreen().getBtnLogin())
            {
                String username = screen.getLoginScreen().getTxtUser().getText();
                String password = screen.getLoginScreen().getTxtPassword().getText();

                if(logic.login(username, password)) {


                    screen.show(screen.MENUSCREEN);

                }else {
                    screen.getLoginScreen().getLblError().setVisible(true);
                }




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
                String gamename = screen.getCreateGameScreen().getTxtGameName().getText();
                String moves = screen.getCreateGameScreen().getTxtControls().getText();


                if(logic.createGame(gamename, moves)){

                    System.out.println("Game has been created");

                }


            }

        }//actionPerformed slut
    }//inner class slut



}//klasse slut