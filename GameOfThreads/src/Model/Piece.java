package Model;

public abstract class Piece
{
    private int health;
    private boolean special;
    private  int range;
    private  int damage;

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

    public void takeDamage(int damage)
    {
        this.health -= damage;
    }

    public abstract void special();
    public abstract void deactivateSpecial();
}
