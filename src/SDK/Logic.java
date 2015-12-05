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

    public int joinGame (Game game)
    {
        int json = serverConnection.put(new Gson().toJson(game), "games/join/");
        return json;
    }

    public int startGame (Game game)
    {
        int json = serverConnection.put(new Gson().toJson(game), "games/start/");
        return json;
    }

    public ArrayList<Game> openGames()
    {
        ServerConnection serverConnection = new ServerConnection();

        String json = serverConnection.get("games/open/");

        ArrayList<Game> openGames = new Gson().fromJson(json, new TypeToken<ArrayList<Game>>() {
        }.getType());

        return openGames;
    }

    public int deleteGame (int gameId)
    {
        int json = serverConnection.delete("games/" +gameId+ "/");
        return json;
    }
}