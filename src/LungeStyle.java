import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LungeStyle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LungeStyle extends Styles
{
    /**
     * Act - do whatever the LungeStyle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.checkClicked("lunge");
        super.checkSelected("lunge");
        super.checkDeletion();
    }    
}
