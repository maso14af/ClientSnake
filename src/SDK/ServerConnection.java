package SDK;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Martin on 18/11/15.
 * This class handles the connection to the server. In this class there are getters for
 * various server attributes as well as post, get, put and delete requests.
 * The requests are made with Json.
 */
//Start of class
public class ServerConnection
{
    //Declaring variables used in this class
    private String hostAddress;
    private int port;

    /**
     * Constructor for the serverConnection Class
     */
    public ServerConnection()
    {
        //Initializing of the variables used in the constructor
        this.hostAddress = "http://localhost";
        this.port = 8882;
    }

    /**
     * Getter for hostAddress
     * @return hostAddress
     */
    public String getHostAddress()
    {
        return hostAddress;
    }

    /**
     * Getter for port
     * @return port
     */
    public int getPort()
    {
        return port;
    }


    /**
     * Method for getting something from the server
     * @param path is the path of what we want off of the server
     * @return message
     */
    public String get(String path)
    {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        String message = response.getEntity(String.class);

        return message;
    }

    /**
     * Method for posting something to the server
     * @param json is the object we send to the server as json format
     * @param path is the path of where we want to post something to the server
     * @return responser
     */
    public int post(String json, String path)
    {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);
        String output = response.getEntity(String.class);
        System.out.println(output);

        int responser = response.getStatus();

        return responser;
    }

    /**
     * Method when putting something to the server
     * @param json is the object we send to the server as json format
     * @param path is the path of where we want to put something to the server
     * @return responser
     */
    public int put(String json, String path)
    {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);
        String output = response.getEntity(String.class);
        System.out.println(output);

        int responser = response.getStatus();

        return responser;
    }

    /**
     * Method when deleting something from the server
     * @param path the path of where we want to delete something from the server
     * @return responser
     */
    public int delete(String path)
    {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);
        String output = response.getEntity(String.class);
        System.out.println(output);

        int responser = response.getStatus();

        return responser;
    }
}//End of class