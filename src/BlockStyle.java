import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlockStyle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlockStyle extends Styles
{
    /**
     * Act - do whatever the BlockStyle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.checkClicked("block");
        super.checkSelected("block");
        super.checkDeletion();
    }    
    
}
