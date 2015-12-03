package SDK;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by Martin on 03/12/2015.
 */
public class Api {

    private ServerConnection serverConnection;

    public Api()
    {
        serverConnection = new ServerConnection();
    }

    public static ArrayList<User> getUsers () {
        ServerConnection serverConnection = new ServerConnection();

        String jsonData = serverConnection.get("users/");

        ArrayList<User> users = new Gson().fromJson(jsonData, new TypeToken<ArrayList<User>>() {
        }.getType());

        return users;
    }


}