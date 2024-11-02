import java.util.Random;

public class RPS_Player {
    private int numberOfGamesWon;
    private int numberOfGamesPlayed;
    private int choice;
    private String name;

    public RPS_Player(String name){
        this.name = name;
        this.numberOfGamesPlayed = 0;
        this.numberOfGamesWon = 0;
    }

    public String getName(){
        return name;
        // TODO: replace this line with your code.
    }

    /**
     * Returns the number of games played since a clear() was issued.
     * @return returns the number of games played.
     */
    public int getNumberOfGamesPlayed(){
       return numberOfGamesPlayed;
       // TODO: replace this line with your code.
    }

    /**
     * Returns the number of games won since a clear() was issued.
     * @return returns the number of games won.
     */
    public int getNumberOfGamesWon(){

        return numberOfGamesWon;

    }

    /**
     * Returns the win percentage as number between 0 and 1.
     * @return win percentage as a double.
     */
    public double getWinPercentage(){

        if(numberOfGamesPlayed == 0 ) {return 0;}
        else{
        return numberOfGamesWon/numberOfGamesPlayed;}
    }

    /**
     * Starts a new game.
     */
    public void clear(){
        name = null;
        choice = 0;
        numberOfGamesPlayed = 0;
        numberOfGamesWon = 0;

    }

    /**
     * This player challenges anotherPlayer whereby both players make a
     * random choice of rock, paper, scissors.  A reference to the winning
     * player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player challenge(RPS_Player anotherPlayer) {
        Random rand = new Random();
        anotherPlayer.choice = rand.nextInt(3);
        choice = rand.nextInt(3);

        if(anotherPlayer.choice == choice){ numberOfGamesPlayed++; return null;} else if ((anotherPlayer.choice == 0 && choice == 1 ) || (anotherPlayer.choice == 2 && choice == 0) || (anotherPlayer.choice == 1 && choice == 2)){numberOfGamesWon++; numberOfGamesPlayed++;return this;
            
        }else{anotherPlayer.numberOfGamesWon++; numberOfGamesPlayed++; return anotherPlayer;}


    }

    /**
     * This player challenges anotherPlayer whereby this player uses the previous
     * choice made and anotherPlayer makes a random choice of rock, paper, scissors.
     * A reference to the winning player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player keepAndChallenge(RPS_Player anotherPlayer){
        Random rand = new Random();
        anotherPlayer.choice = rand.nextInt(3);


        if(anotherPlayer.choice == choice){numberOfGamesPlayed++; return null;} else if ((anotherPlayer.choice == 0 && choice == 1 ) || (anotherPlayer.choice == 2 && choice == 0) || (anotherPlayer.choice == 1 && choice == 2)){numberOfGamesPlayed++; numberOfGamesWon++; return this;

        }else{ anotherPlayer.numberOfGamesWon++; numberOfGamesPlayed++;return anotherPlayer;}

    }

}
