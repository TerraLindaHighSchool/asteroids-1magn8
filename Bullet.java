import greenfoot.*;

/**
 * A bullet that can hit asteroids.
 * 
 * @author Zachary Chiu
 */
public class Bullet extends SmoothMover
{
    /** The damage this bullet will deal */
    private static final int damage = 16;
    
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
     * The bullet will damage asteroids if it hits them.
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
            checkSpacemanHit();
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
    /**
     * Check whether we have hit a Spaceman
     */
    private void checkSpacemanHit()
    {
        Spaceman spaceman = (Spaceman) getOneIntersectingObject(Spaceman.class);
        if (spaceman != null)
        {
            ((Space)getWorld()).updateScore(10);
            getWorld().removeObject(this);
            spaceman.hit(damage);
        }
    }
}