package Logic;


import GUI.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class LoginController
{
    public GUI.Screen screen;


    /**
     * Opretter konstruktur. Laver objekt af screen.
     */
    public LoginController()
    {
        screen = new Screen();



        screen.setVisible(true);
    }//konstruktør slut

    /**
     * metoden Main klassen kalder for at starte programmet
     */
    public void run()
    {


        // Injection af listeners i panels
        screen.loginScreen.addActionListener(new LoginActionListener());
        screen.getMenuScreen().addActionListener(new UserMenuActionListener());


        // vis startskaerm
        screen.show(Screen.LOGINSCREEN);
    }


    private class LoginActionListener implements ActionListener
    {
        SDK.Logic logic = new SDK.Logic();
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //der trykked på login knap
            if (e.getSource() == screen.getLoginScreen().getBtnLogin())
            {
                String username = screen.getLoginScreen().getTxtUser().getText();
                String password = screen.getLoginScreen().getTxtPassword().getText();


                if(logic.login(username,password)) {

                    screen.show(screen.USERMENU);

                }else {
                    screen.getLogin().getLblError().setVisible(true);
                }




            }//if listener slut
        }//actionPerformed slut
    }//inner class slit

    /**
     * inner class
     * UserMenu panel actionlistener
     * Styre user menu
     */
    private class UserMenuActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //hvis brugeren trykker view belance knap
            if (e.getSource() == screen.getUserMenu().getBtnCreateGame())
            {


            }//if slut

            //hvis brugeren trykker withdraw knap
            if (e.getSource() == screen.getUserMenu().getBtnDeleteGame())
            {

            }//if slut

            //hvis brugeren trykker deposit knap
            if (e.getSource() == screen.getUserMenu().getBtnHighscores())
            {


            }//if slut

            //hvis brugeren trykker transfer knap
            if (e.getSource() == screen.getUserMenu().getBtnLogout())
            {

            }//if slut

            //hvis brugeren trykker log af knap
            if (e.getSource() == screen.getUserMenu().getBtnHome())
            {
                //sender videre til valgte panel
                screen.show(Screen.LOGIN);

                //resetter felterne
                screen.getLogin().getTxtUser().setText("");
                screen.getLogin().getTxtPassword().setText("");
                screen.getLogin().getLblError().setVisible(false);
            }

        }//actionPerformed slut
    }//inner class slut



}//klasse slut