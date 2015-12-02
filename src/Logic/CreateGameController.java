package Logic;


import GUI.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class CreateGameController
{
    public GUI.Screen screen;


    /**
     * Opretter konstruktur. Laver objekt af screen.
     */
    public CreateGameController()
    {
        screen = new Screen();



        screen.setVisible(true);
    }//konstruktør slut


    /**
     * inner class
     * UserMenu panel actionlistener
     * Styrer menu screen
     */
    private class UserMenuActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Hvis brugeren trykker på Create Game
            if (e.getSource() == screen.getMenuScreen().getBtnCreateGame())
            {
            System.out.print("Input detected");

            }//if slut


        }//actionPerformed slut
    }//inner class slut



}//klasse slut