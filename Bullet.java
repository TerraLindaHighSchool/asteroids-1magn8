import greenfoot.*;

/**
 * A bullet that can hit enemies.
 * 
 * @author Zachary Chiu
 */
public class Bullet extends SmoothMover
{
    /** The damage this bullet will deal */
    private static final int damage = 20;
    
    /** A bullet looses one life each act, and will disappear when life = 0 */
    private int life = 30;
    
    /**
     * Default constructor for testing.
     */
    public Bullet()
    {
    }
    
    /**
     * Create a bullet with given speed and direction of movement.
     */
    public Bullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 15));
        Greenfoot.playSound("EnergyGun.wav");
    }
    
    /**
     * The bullet will damage Blades if it hits them.
     */
    public void act()
    {
        
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();
            checkBladeHit();
        }
           
    }
    
    /**
     * Check whether we have hit a Blade
     */
    private void checkBladeHit()
    {
        Blade blade = (Blade) getOneIntersectingObject(Blade.class);
        if (blade != null)
        {
            ((Space)getWorld()).updateScore(10);
            getWorld().removeObject(this);
            blade.hit(damage);
        }
    }
}