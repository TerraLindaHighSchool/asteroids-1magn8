import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BadBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadBullet extends SmoothMover
{
    private static final int damage = 10000;

    private int life = 30;
    /**
     * Act - do whatever the BadBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
            if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move(15);
            checkAlienHit();
        }
    }    

    private void checkAlienHit()
    {
        Alien alien = (Alien) getOneIntersectingObject(Alien.class);
        if (alien != null)
        { 
            getWorld().removeObject(this);
          }
    }
}