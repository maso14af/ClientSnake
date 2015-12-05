package SDK;

/**
 * Created by Martin on 18/11/15.
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Logic {

    private User currentUser;
    private ServerConnection serverConnection;

    public Logic()
    {
        currentUser = new User();
        serverConnection = new ServerConnection();
    }


    public boolean login(String username, String password){

        //ServerConnection serverConnection = new ServerConnection();

        currentUser.setUsername(username);
        currentUser.setPassword(password);


        String json = new Gson().toJson(currentUser);

        if(serverConnection.post(json, "login/")==200){

            for (User users : getUser()){

                if (users.getUsername().equals(currentUser.getUsername()))
                {
                    currentUser = users;
                }

            }

            System.out.print(currentUser.getUsername());

            return true;
        }else {
            return false;
        }
    }

    public ArrayList<User> getUser(){

        //ServerConnection serverConnection = new ServerConnection();

        String json = serverConnection.get("users/");

        //Henter users ned i en arrayList
        ArrayList<User> users = new Gson().fromJson(json, new TypeToken<ArrayList<User>>(){}.getType());

        return users;


    }

    public boolean createGame(String name, String moves){

        //ServerConnection serverConnection = new ServerConnection();

        Gamer host = new Gamer();
        host.setId(currentUser.getId());
        host.setControls(moves);


        Game game = new Game();
        game.setName(name);
        game.setHost(host);
        game.setMapSize(20);


        String json = new Gson().toJson(game);

        int response = serverConnection.post(json,"games/");

        for(Game g : openGames())
        {
            if(g.getName().equals(name))
            {
                game.setGameId(g.getGameId());
            }
        }

        if(response==201){

            System.out.print(game.getHost().getUsername());
            return true;
        }

        return false;

    }

    public ArrayList<Game> openGames()
    {
        //ServerConnection serverConnection = new ServerConnection();

        String json = serverConnection.get("games/open/");

        ArrayList<Game> openGames = new Gson().fromJson(json, new TypeToken<ArrayList<Game>>() {
        }.getType());

        return openGames;
    }
}