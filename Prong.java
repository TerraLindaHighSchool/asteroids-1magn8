import greenfoot.*;

/**
 * An enemy ship that can shoot
 * 
 * @author Zachary Chiu 
 */
public class Prong extends SmoothMover
{
    /** Size of this prong */
    private int size;

    /** When the stability reaches 0 the prong will explode */
    private int stability;
    private GreenfootImage Spaceman = new GreenfootImage ("Spaceman.png");
    private int minShotDelay = 40;
    private int maxShotDelay = 130;
    private int shotTimer = minShotDelay;
    /**
     * Create a prongd with default size and random direction of movement.
     */
    public Prong()
    {
        this(50);
    }
    
    /**
     * Create a prongwith a given size and random direction of movement.
     */
    public Prong(int size)
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
        setSize(size);
    }
    
    /**
     * Create a prong with a given size and direction of movement.
     */
    public Prong(int size, Vector velocity)
    {
        super(velocity);
        setSize(size);
    }
    public void act()
    {         
        move();
        shootRandomly();
        dead();
        
    }
    /**
     * Set the size of this prong. 
     */
    public void setSize(int size) 
    {
        stability = 10;
    }
    /**
     * Return the current stability of this prong. (If it goes down to 
     * zero, it breaks up.)
     */
    public int getStability() 
    {
        return stability;
    }
     public void shootRandomly()
    {
      if (shotTimer == 0)
        {
            getWorld().addObject(new BadBullet(), getX(), getY());
            shotTimer = minShotDelay+Greenfoot.getRandomNumber(1+maxShotDelay-minShotDelay);
        }
        else shotTimer--;
    }
      public void dead() 
    {
        if (stability <= 0) 
        {
            Greenfoot.playSound("Explosion.wav");
            getWorld().removeObject(this);
        }
        else
        {
            hit();
        }
    }
     public void hit()
    {
        if( getOneIntersectingObject(Bullet.class) != null)  
        {
            ((Space)getWorld()).updateScore(15); 
            Greenfoot.playSound("Hitting_Metal-Douglas_Vicente-1756278897.mp3");
            stability--;
        }
    }
}
    