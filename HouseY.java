import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HouseY here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HouseY extends Text
{
    /**
     * Act - do whatever the HouseY wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         House house=(House) getWorld();
        super.display("Y",""+house.y);
    }    
}
