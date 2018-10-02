import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HouseX here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HouseX extends Text
{
    /**
     * Act - do whatever the HouseX wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        House house=(House) getWorld();
        super.display("X",""+house.x);
    }    
}
