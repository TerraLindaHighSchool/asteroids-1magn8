import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The enemy breakdown
 * 
 * @Zachary Chiu
 */
public class Enemy extends World
{

    /**
     * Constructor for objects of class Enemy.
     * 
     */
    public Enemy()
    {    
       super(1150, 800, 1); 
        prepare();
    }

    private void prepare()
    {
        TitleLetters titleLetters = new TitleLetters();
        addObject(titleLetters,575,400);
    }

     public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        Greenfoot.setWorld(new Space());
    }
}
