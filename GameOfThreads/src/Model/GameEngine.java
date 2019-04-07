package Model;

public class GameEngine {

    private Player player1;
    private Player player2;
    private Board board;

    public GameEngine(Board board)
    {
        this.board = board;
    }

    public void setPlayer(String name, int playerNumber)
    {
        // this code may be able to be refactored as the user can only input twice thus making it impossible
        // for incorrect player numbers
        if(playerNumber == 1)
        {
            player1 = new Player(name, 1);
        }
        else if(playerNumber == 2)
        {
            player2 = new Player(name, 2);
        }
    }
}
