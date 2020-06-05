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
    private int maxShotDelay = 100;
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
        private void breakUp() 
    {
        Greenfoot.playSound("Explosion.wav");
        int r = getVelocity().getDirection() + Greenfoot.getRandomNumber(45);
        double l = getVelocity().getLength();
        Vector speed1 = new Vector(r + 60, l * 1.2);       
        Spaceman a1 = new Spaceman(size/2, speed1);
        getWorld().addObject(a1, getX(), getY());
         a1.move();
        getWorld().removeObject(this);
        
    }
      public void dead() 
    {
        if (stability <= 0) 
        {
            breakUp();
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
    