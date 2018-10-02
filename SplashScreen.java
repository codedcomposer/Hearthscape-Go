import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SplashScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SplashScreen extends World //actually to World
{

    /**
     * Constructor for objects of class SplashScreen.
     * 
     */
    public SplashScreen()
    {    
        super(800, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        

        addObject(new Start(),590,520);
        addObject(new StartButton(),450,500);
        addObject(new Hearthscape(),400,65);
        addObject(new Kappa(),645,475);
        addObject(new Keepo(),705,500);
    }
}
