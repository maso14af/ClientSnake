package SDK;

import com.google.gson.Gson;


/**
 * Created by Martin on 18/11/15.
 */
public class Logic {

    User currentUser = new User();
    Api api;

    ServerConnection serverConnection = new ServerConnection();

    public boolean login(String username, String password){


        ServerConnection serverConnection = new ServerConnection();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);


        String json = new Gson().toJson(user);
        System.out.println(json);

       if (serverConnection.post(json, "login/")==200){

          for(User users:   SDK.Api.getUsers() ){

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
    public boolean createGame(String name, String moves){

        ServerConnection serverConnection = new ServerConnection();

        Gamer host = new Gamer();
        host.setId(currentUser.getId());
        host.setControls(moves);


        Game game = new Game();

        game.setName(name);
        game.setHost(host);
        game.setMapSize(25);

        String json = new Gson().toJson(game);

        int response = serverConnection.post(json,"games/");

        if(response==201){
            return true;
        }

        return false;

    }
    public static void deleteGame(int gameId){



    }




}