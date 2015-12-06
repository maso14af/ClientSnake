package SDK;

/**
 * This class contains the same as the Gamer class on the server side
 * This class represents an object of a Gamer with all the attributes of a Gamer
 */

//Start of class
public class Gamer extends User
{

    //Declaring the variables used in this class
    private int score;
    private int totalScore;
    private int kills;
    private String controls;
    private boolean winner;

    /**
     * Getter winner
     * @return winner
     */
    public boolean isWinner()
    {
        return winner;
    }

    /**
     * Setter for winner
     * @param winner sets the winner
     */
    public void setWinner(boolean winner)
    {
        this.winner = winner;
    }

    /**
     * Getter for totalScore
     * @return totalScore
     */
    public int getTotalScore()
    {
        return totalScore;
    }

    /**
     * Setter for totalScore
     * @param totalScore sets the total score
     */
    public void setTotalScore(int totalScore)
    {
        this.totalScore = totalScore;
    }

    /**
     * Getter for kills
     * @return kills
     */
    public int getKills() {
        return kills;
    }

    /**
     * Setter for kills
     * @param kills sets the kills
     */
    public void setKills(int kills)
    {
        this.kills = kills;
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

    /**
     * Getter for controls
     * @return controls
     */
    public String getControls()
    {
        return controls;
    }

    /**
     * Setter for controls
     * @param controls sets the controls
     */
    public void setControls(String controls)
    {
        this.controls = controls;
    }
}//End of class Gamer
