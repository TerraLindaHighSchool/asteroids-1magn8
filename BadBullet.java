import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bullets Spaceman and Prongs fire at you
 * 
 * @Zachary Chiu
 */
public class BadBullet extends SmoothMover
{
    private static final int damage = 5;

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
        }
    }   
}