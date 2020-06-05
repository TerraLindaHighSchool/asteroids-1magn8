import greenfoot.*;

/**
 * An enemy who fires at you
 * 
 * @author Zachary Chiu
 */
public class Spaceman extends SmoothMover
{
    /** Size of this asteroid */
    private int size;

    /** When the stability reaches 0 the asteroid will explode */
    private int stability;
    private GreenfootImage Spaceman = new GreenfootImage ("Spaceman.png");
    private int minShotDelay = 40;
    private int maxShotDelay = 160;
    private int shotTimer = minShotDelay;
    /**
     * Create an asteroid with default size and random direction of movement.
     */
    public Spaceman()
    {
        this(50);
    }
    
    /**
     * Create an asteroid with a given size and random direction of movement.
     */
    public Spaceman(int size)
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
        setSize(size);
    }
    
    /**
     * Create an asteroid with a given size and direction of movement.
     */
    public Spaceman(int size, Vector velocity)
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
     * Set the size of this asteroid. Note that stability is directly
     * related to size. Smaller asteroids are less stable.
     */
    public void setSize(int size) 
    {
        stability = size;
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(15, 30);
    }

    /**
     * Return the current stability of this asteroid. (If it goes down to 
     * zero, it breaks up.)
     */
    public int getStability() 
    {
        return stability;
    }
  /**
     * Hit this spaceman dealing the given amount of damage.
     */
    public void hit(int damage) 
    {
        stability = stability - damage;
        if (stability <= 0) 
        {
            
        }
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
        if( getOneIntersectingObject(Bullet.class) != null)  
        {
            ((Space)getWorld()).updateScore(10);
            Greenfoot.playSound("Pain.mp3");
            getWorld().removeObject(this);
      
        }
    }
}
    