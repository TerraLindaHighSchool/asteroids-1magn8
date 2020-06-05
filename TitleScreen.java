    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @Zachary Chiu
 * @6-2-20
 */
public class TitleScreen extends World
{
   
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
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
        if (Greenfoot.isKeyDown("space"))
        Greenfoot.setWorld(new Enemy());
    }
}
