package Model;

public class GameEngine {

    private Player player1;
    private Player player2;
    //player turn set to 1 for player 1 and 2 for player 2
    private int playerTurn = 1;
    private Board board;

    public GameEngine()
    {
    	//create new board here
    	
        this.board = new Board();
    }
    
    public Board getBoard()
    {
    	return this.board;
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
    
    public int getPlayerTurn() 
    {
    	return this.playerTurn;
    }
    
    public void setPlayeturn(int player)
    {
    	this.playerTurn = player;
    }
    
    public boolean validMove(Board gameBoard, int pieceX, int pieceY, int moveX, int moveY, int player)
    {
    	return true;
    }
    		
    public void movePiece(Board gameBoard, int pieceX, int pieceY, int moveX, int moveY)
    {
    	Piece movingPiece = gameBoard.getSquarePiece(pieceX, pieceY);
    	gameBoard.setSquarePiece(moveX, moveY, movingPiece);
    	gameBoard.setSquarePiece(pieceX, pieceY, null);
    }

	public void pieceAttack(Piece piece, int x, int y) {
		// TODO Auto-generated method stub
		
	}
   
}
