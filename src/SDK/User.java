package SDK;

import java.sql.Date;

/**
 * This class contains the same as the User class on the server side
 * This class represents an object of a user with all the attributes of a user
 */
public class User
{

    //Declaring variables used in this class
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Date created;
    private String status;
    private String email;
    private int type;
    public User () {}

    //Creating get and setter methods for all variables, so they can be accessed by other classes

    /**
     * Getter for
     * @return id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Setter for id
     * @param id sets the id for a user object
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Getter for firstName
     * @return firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Setter for firstName
     * @param firstName sets the first name for a user object
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Getter for lastName
     * @return lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Setter for lastName
     * @param lastName sets the last name for a user object
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Getter for username
     * @return username;
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Setter for username
     * @param username sets the username for a user object
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * Getter for password
     * @return password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Setter for password
     * @param password sets the password for a user object
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Getter for created
     * @return created
     */
    public Date getCreated()
    {
        return created;
    }

    /**
     * Setter for created
     * @param created sets the created for a user object
     */
    public void setCreated(Date created)
    {
        this.created = created;
    }

    /**
     * Getter for status
     * @return status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * Setter for status
     * @param status sets the status for a user object
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * Getter for email
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Setter for email
     * @param email sets the email for a user object
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Getter for type
     * @return type
     */
    public int getType()
    {
        return type;
    }

    /**
     * Setter for type
     * @param type sets the type for a user object
     */
    public void setType(int type)
    {
        this.type = type;
    }
}//End of class User