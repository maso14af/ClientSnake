package Logic;

import SDK.Logic;
import SDK.ServerConnection;

/**
 * Created by Martin on 09/11/2015.
 */


public class Main {
  public static void main(String[] args)
  {

    Logic lg=new Logic();
    ServerConnection sc=new ServerConnection();

    lg.login("HeinHero","321");

    sc.get("users");

  }





}
