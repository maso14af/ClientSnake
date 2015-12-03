package SDK;

/**
 * Created by Martin on 18/11/15.
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Logic {

    User currentUser = new User ();


    public boolean login(String username, String password){

        ServerConnection serverConnection = new ServerConnection();

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        String json = new Gson().toJson(user);

        serverConnection.post(json, "login/");

        System.out.printf(json);

        if(serverConnection.post(json, "login/")==200){

            for (User users : SDK.Logic.getUser()){

                if (users.getUsername().equals(username))
                {
                    currentUser = users;
                }

            }


            return true;
        }else {
            return false;
        }
    }
    public static void createUser(User user){

    }
    public static void deleteUser(int userId){

    }
    public static ArrayList<User> getUser(){

        ServerConnection serverConnection = new ServerConnection();

        String json = serverConnection.get("users/");

        //henyer users ned i en arrayList
        ArrayList<User> users = new Gson().fromJson(json, new TypeToken<ArrayList<User>>(){}.getType());

        return users;


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
        game.setMapSize(15);


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