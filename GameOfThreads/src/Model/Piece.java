package Model;

public abstract class Piece
{
    private int health;             // Health of the piece.
    private boolean special;        // To check weather the special is activated.
    private  int range;             // The range within which the piece can move or attack.
    private  int damage;            // How much damage can this piece do when it attacks enemy's piece.

    private final String ID;
    private final int PLAYER;
    private final int SPECIALTURN;

    // Initially, i.e turn 1, specials are turned off.
    public Piece(int health, int range, int damage, String ID, int PLAYER, int SPECIALTURN)
    {
    	this.health = health;
        this.range = range;
        this.damage = damage;
        this.ID = ID;
       
        this.PLAYER = PLAYER;
        this.SPECIALTURN = SPECIALTURN;

        this.special = false;
    }

    //getter and setter methods
    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getRange()
    {
        return range;
    }

    public int getDamage()
    {
        return damage;
    }

    public void setRange(int range)
    {
        this.range = range;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
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

    // Takes damage from enemy and health decreases accordingly.
    public void takeDamage(int damage)
    {
        this.health -= damage;
    }

    //Each piece has a special attribute which will be activated when this method is called.
    public abstract void special();

    //The special attribute is deactivated.
    public abstract void deactivateSpecial();
}
