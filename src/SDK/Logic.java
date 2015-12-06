package SDK;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * This class controls the different requests and paths that are sent to the server.
 * This class is used to connect to the Api class on the server.
 */

//Start of class
public class Logic
{

    ServerConnection serverConnection = new ServerConnection();


    /**
     * Method used to login to the server, the method posts an object of User in the gson format
     * which is parsed to json.
     * @param user posts an object of user
     * @return json
     */
    public int login(User user)
    {
        int json = serverConnection.post(new Gson().toJson(user), "login/");
        return json;
    }

    /**
     * Method using a get on the path users/ request to return all users and put them in an ArrayList.
     * @return users
     */
    public ArrayList<User> getUsers()
    {
        String jsonData = serverConnection.get("users/");
        ArrayList<User> users = new Gson().fromJson(jsonData, new TypeToken<ArrayList<User>>() {}.getType());
        return users;
    }

    /**
     * Method using a post request to create a new game. The game object is send as Gson parsed to Json
     * @param game object of game that is being posted.
     * @return json
     */
    public int createGame(Game game)
    {
        int json = serverConnection.post(new Gson().toJson(game), "games/");
        return json;
    }

    /**
     * Method using a put request to join an existing game. The game object is send as Gson parsed to Json
     * @param game object of game that is being putted.
     * @return json
     */
    public int joinGame (Game game)
    {
        int json = serverConnection.put(new Gson().toJson(game), "games/join/");
        return json;
    }

    /**
     * Method using a put request to start a game. The game object is send as Gson parsed to Json.
     * @param game object of game that is being putted.
     * @return json
     */
    public int startGame (Game game)
    {
        int json = serverConnection.put(new Gson().toJson(game), "games/start/");
        return json;
    }

    /**
     * Method using a get on the path games/open/ request to return all open games and put them in an ArrayList.
     * @return openGames
     */
    public ArrayList<Game> openGames()
    {

        String json = serverConnection.get("games/open/");

        ArrayList<Game> openGames = new Gson().fromJson(json, new TypeToken<ArrayList<Game>>(){}.getType());

        return openGames;
    }

    /**
     * Method using a delete request to delete a game from the server
     * @param gameId
     * @return json
     */
    public int deleteGame (int gameId)
    {
        int json = serverConnection.delete("games/" +gameId+ "/");
        return json;
    }

    /**
     * Getter for highScores, is done making a get request to the server and return all highScores and
     * putting them in an ArrayList so they can be used in the JTable to show it to the user.
     * @return highScores
     */
    public ArrayList<Score> getHighScores()
    {
        String json = serverConnection.get("highScores/");
        ArrayList<Score> highScores = new Gson().fromJson(json, new TypeToken<ArrayList<Score>>() {}.getType());

        return highScores;
    }
}//End of class Logic