    import greenfoot.*;
/**
 * An enemy ship
 * 
 * @author Zachary Chiu
 */
public class Blade extends SmoothMover
{
    /** Size of this asteroid */
    private int size;
    /** When the stability reaches 0 the asteroid will explode */
    private int stability;
    private GreenfootImage Spaceman = new GreenfootImage ("Spaceman.png");

    /**
     * Create a blade with default size and random direction of movement.
     */
    public Blade()
    {
      this(50);
    }
    
    /**
     * Create a blade with a given size and random direction of movement.
     */
    public Blade(int size)
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
        setSize(size);
    }
    
    /**
     * Create a blade with a given size and direction of movement.
     */
    public Blade(int size, Vector velocity)
    {
        super(velocity);
        setSize(size);
    }
    public void act()
    {         
        move();
    }
    /**
     * Set the size of this blade. Note that stability is directly
     * related to size. 
     */
    public void setSize(int size) 
    {
        stability = size;
        this.size = size;
        GreenfootImage image = getImage();
         image.scale(20, 70);
    }

    /**
     * Return the current stability of this blade. (If it goes down to 
     * zero, it breaks up.)
     */
    public int getStability() 
    {
        return stability;
    }
    
    /**
     * Hit this blade dealing the given amount of damage.
     */
    public void hit(int damage) 
    {
        stability = stability - damage;
        if (stability <= 0) 
        {
            breakUp();
        }
    }
    
    /**
     * Break up this blade. If we are still big enough, this will create two
     * smaller spacemen. If we are small already, just disappear.
     */
    private void breakUp() 
    {
        Greenfoot.playSound("Explosion.wav");
        
        if (size <= 16) {
            getWorld().removeObject(this);
        }
        else {
            int r = getVelocity().getDirection() + Greenfoot.getRandomNumber(45);
            double l = getVelocity().getLength();
            Vector speed1 = new Vector(r + 60, l * 1.2);
            Vector speed2 = new Vector(r - 60, l * 1.2);        
            Spaceman a1 = new Spaceman(size/2, speed1);
            Spaceman a2 = new Spaceman(size/2, speed2);
            getWorld().addObject(a1, getX(), getY());
            getWorld().addObject(a2, getX(), getY());        
            a1.move();
            a2.move();
        
            getWorld().removeObject(this);
        }
    }
}

