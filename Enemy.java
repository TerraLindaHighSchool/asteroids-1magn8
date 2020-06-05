import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        EnemyBreakdown enemybreakdown = new EnemyBreakdown();
        addObject(enemybreakdown,575,400);
    }
     public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        Greenfoot.setWorld(new Space());
    }
}
