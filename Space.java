import greenfoot.*;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Zachary Chiu
 * @version 1.1
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startBlades = 3;
    private int startProngs = 4;
    private boolean hasAddedProng;
    /**
     * Create the space and all objects within it.
     */
    public Space() 
    {
        super(1150, 800, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        Alien alien = new Alien();
        addObject(alien, getWidth()/2 + 100, getHeight()/2);
        
        addBlades(startBlades);
       
        
      
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 780);
        
        
        Explosion.initializeImages();
        ProtonWave.initializeImages();
        paintStars(300);
       
    }
    public void act()
    {
        if(getObjects(Blade.class).size() == 0 && 
        getObjects(Spaceman.class).size() == 0 &&
        getObjects(Prong.class).size() ==0)
        {
            win();
        }
        if(getObjects(Blade.class).size() == 1 && hasAddedProng == false)
        {
            addProng(startProngs);
            hasAddedProng = true;
        }
    }
    
    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addBlades(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Blade(), x, y);

    }
    }
    private void paintStars(int count)
    {
    GreenfootImage background = getBackground();
    for (int i=0; i < count + 1; i++)
        {
        int x = Greenfoot.getRandomNumber ( getWidth() );
        int y = Greenfoot.getRandomNumber ( getHeight() );
        int color1 = 150 - Greenfoot.getRandomNumber (120);
        int color2 = color1 - Greenfoot.getRandomNumber (20);
        int color3 = color1 + Greenfoot.getRandomNumber (20);
        background.setColorAt(x,y, new Color(color1,color2,color3));
        int size1 = 3 - Greenfoot.getRandomNumber(2);
        int size2 = 3 - Greenfoot.getRandomNumber(2);
        background.fillOval(x, y, size1, size2);
         }
    }
    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        int x=getWidth()/2;
        int y=getHeight()/2;
        int currentScore=scoreCounter.getValue();
        addObject(new ScoreBoard(currentScore),x,y);
     
    }
    public void win()
    {
        int x=getWidth()/2;
        int y=getHeight()/2;
        int currentScore=scoreCounter.getValue();
        addObject(new ScoreBoardVictory(currentScore),x,y);
    }
    public void updateScore(int addToScore)
    {
        scoreCounter.add(addToScore);
    }
    private void addProng(int count) 
    {
        int x = Greenfoot.getRandomNumber(getWidth()*2);
        int y = Greenfoot.getRandomNumber(getHeight()*2);
        addObject(new Prong(), x, y);
        addObject(new Prong(), x, y);
    }
}


