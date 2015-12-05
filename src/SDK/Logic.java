package SDK;

/**
 * Created by Martin on 18/11/15.
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Logic {

    User currentUser = new User();
    ServerConnection serverConnection = new ServerConnection();




    public int login(User user)
    {
        int json = serverConnection.post(new Gson().toJson(user), "login/");

        return json;
    }

    public ArrayList<User> getUsers() {
        String jsonData = serverConnection.get("users/");
        ArrayList<User> users = new Gson().fromJson(jsonData, new TypeToken<ArrayList<User>>() {
        }.getType());
        return users;
    }

    public int createGame(Game game)
    {
        int json = serverConnection.post(new Gson().toJson(game), "games/");
        return json;
    }

    /*public boolean createGame(String name, String moves){

        ServerConnection serverConnection = new ServerConnection();


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

    }*/

    public ArrayList<Game> openGames()
    {
        ServerConnection serverConnection = new ServerConnection();

        String json = serverConnection.get("games/open/");

        ArrayList<Game> openGames = new Gson().fromJson(json, new TypeToken<ArrayList<Game>>() {
        }.getType());

        return openGames;
    }
}