import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CityX here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CityX extends Text
{
    /**
     * Act - do whatever the CityX wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       City city=(City) getWorld();
       super.display("X"," "+city.x);
    }    
}
