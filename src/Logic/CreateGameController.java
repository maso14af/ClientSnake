package Logic;


import GUI.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class CreateGameController
{
    public GUI.Screen screen;

    public CreateGameController(Screen screen)
    {
        this.screen = screen;
        screen = new Screen();



        screen.setVisible(true);
    }//konstruktør slut

    public void run()
    {
        screen.getCreateGameScreen().addActionListener(new CreateGameActionListener());
    }

    /**
     * inner class
     * UserMenu panel actionlistener
     * Styrer menu screen
     */
    private class CreateGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Hvis brugeren trykker på Create Game
            if (e.getSource() == screen.getCreateGameScreen().getBtnCreateGame());
            {
            System.out.print("Input detected");

            }//if slut


        }//actionPerformed slut
    }//inner class slut



}//klasse slut