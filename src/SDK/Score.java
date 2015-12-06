package SDK;

/**
 * This class contains the same as the User class on the server side
 * This class represents an object of a score with all the attributes of a score
 */


// Creation of class score
public class Score
{

    // Declaring of variables used in this class
    private int id;
    private Gamer user;
    private Gamer opponent;
    private Game game;
    private int score;

    // Constructor for Score
    public Score(int id, Gamer user, Game game, Gamer opponent, int score)
    {
        this.id = id;
        this.user = user;
        this.game = game;
        this.opponent = opponent;
        this.score = score;
    }

    public Score(){}

    // Creates get method which returns the highScore

    /**
     * get opponent
     * @return opponent
     */
    public Gamer getOpponent()
    {
        return opponent;
    }

    /**
     * Setter for opponent
     * @param opponent sets the opponent
     */
    public void setOpponent(Gamer opponent)
    {
        this.opponent = opponent;
    }

    /**
     * Getter for id
     * @return id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Setter for id
     * @param id sets the id for a score
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Getter for user
     * @return user
     */
    public Gamer getUser()
    {
        return user;
    }

    /**
     * Setter for user
     * @param user sets the user for a score
     */
    public void setUser(Gamer user)
    {
        this.user = user;
    }

    /**
     * Getter for game
     * @return game
     */
    public Game getGame()
    {
        return game;
    }

    /**
     * Setter for game
     * @param game sets the game for a score
     */
    public void setGame(Game game)
    {
        this.game = game;
    }

    /**
     * Getter for score
     * @return score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Setter for score
     * @param score sets the score
     */
    public void setScore(int score)
    {
        this.score = score;
    }
}//End of class Score
