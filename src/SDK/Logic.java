package SDK;

import GUI.LoginScreen;
import com.google.gson.Gson;

/**
 * Created by Martin on 18/11/15.
 */
public class Logic {

    User currentUser = new User();
    Api api;

    public boolean login(String username, String password){


        ServerConnection serverConnection = new ServerConnection();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);


        String json = new Gson().toJson(user);
        System.out.println(json);

       if (serverConnection.post(json, "login/")==200){

          for(User users: api.getUsers() ){

              if(users.getUsername().equals(username)){

                  currentUser = users;
              }

          }


           return true;
       }else {
           System.out.println("login failed in logic.login");

           return false;
       }




    }
    public static void createUser(User user){

    }
    public static void deleteUser(int userId){

    }
    public static void getUser(int userId){

    }
    public static void getGame(int gameId){

    }
    public static void joinGame(int gameId, User opponent, String controls){

    }
    public static void startGame(int gameId){

    }
    /*public static void createGame(String name, int status){

        ServerConnection serverConnection = new ServerConnection();

        Game game = new Game();
        game.setName(name);
        //game.setHost();
        game.setStatus(status);

        String json = new Gson().toJson(game);

        serverConnection.post(json, "create");

    }*/
    public static void deleteGame(int gameId){



    }


}