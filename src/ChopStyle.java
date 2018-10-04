import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChopStyle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChopStyle extends Styles
{
    /**
     * Act - do whatever the ChopStyle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.checkClicked("chop");
        super.checkSelected("chop");
        super.checkDeletion();
    }    
}
