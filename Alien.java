
import greenfoot.*;

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Zachary Chiu
 * 
 * 2.11.20
 */
public class Alien extends SmoothMover
{
    private static final int gunReloadTime = 5;         // The minimum delay between firing the gun.

    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    private int waveCount;
    
    private GreenfootImage Alien = new GreenfootImage("Alien.png");    
    private GreenfootImage Alienmove = new GreenfootImage("AlienMove.png");

    /**
     * Initialise this rocket.
     */
    public Alien()
    {
        reloadDelayCount = 5;
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        checkKeys();
        reloadDelayCount++;
        move();
        checkCollision();
        
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
        if (Greenfoot.isKeyDown("left"))
        {
            turn(-3);
        }
        if (Greenfoot.isKeyDown("right"))
        {  
            turn(3);
        }
        if (Greenfoot.isKeyDown("up"))
        {
            move(2);
        }
        ignite(Greenfoot.isKeyDown("up"));
    

    }
    public void ignite (boolean boosterOn)
    {
        if (boosterOn)
        {
           setImage ("AlienMove.png");  
           addToVelocity(new Vector(getRotation(), 0.3));
        }
        else
        {
            setImage ("Alien.png");
        }
    }
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet (getVelocity(), getRotation());
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = 2;
        }
    } 
    private void checkCollision()
    {
       if( getOneIntersectingObject(Asteroid.class) != null) 
       {
           Space space = (Space) getWorld();
           space.addObject(new Explosion(),getX(),getY());
           space.removeObject(this);
           space.gameOver();
       }
    }


}