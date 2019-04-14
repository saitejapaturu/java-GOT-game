package Model;

public abstract class Piece
{
    private int health;
    private boolean special;

    private final int MAX_MOVE;
    private final int RANGE;
    private final int DAMAGE;

    private final String ID;
    private final int PLAYER;
    private final int SPECIALTURN;

    // Initially, i.e turn 1, specials are turned off.
    public Piece(int health, int MAX_MOVE, int RANGE, int DAMAGE, String ID, int PLAYER, int SPECIALTURN)
    {
    	this.health = health;
        this.MAX_MOVE = MAX_MOVE;
        this.RANGE = RANGE;
        this.DAMAGE = DAMAGE;
        this.ID = ID;
       
        this.PLAYER = PLAYER;
        this.SPECIALTURN = SPECIALTURN;

        this.special = false;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getMAX_MOVE()
    {
        return MAX_MOVE;
    }

    public int getRANGE()
    {
        return RANGE;
    }

    public int getDAMAGE()
    {
        return DAMAGE;
    }

    public String getID()
    {
        return ID;
    }

    public int getPLAYER()
    {
        return PLAYER;
    }

    public boolean getSpecial()
    {
        return special;
    }

    public void setSpecial(boolean special)
    {
        this.special = special;
    }

    public int getSPECIALTURN()
    {
        return SPECIALTURN;
    }

    public void takeDamage(int damage)
    {
        this.health -= damage;
    }

    public abstract void special();
}
