package Logic;


import GUI.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class MenuScreenController
{
    public Screen screen;
    CreateGameController cgc;


    /**
     * Opretter konstruktur. Laver objekt af screen.
     */
    public MenuScreenController(Screen screen)
    {
        this.screen = screen;
        screen = new Screen();
        cgc = new CreateGameController(screen);



        screen.setVisible(true);
    }//konstruktør slut

    public void run()
    {
        screen.getMenuScreen().addActionListener(new MenuScreenActionListener());
        cgc.run();
    }


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


}//Klasse slut
