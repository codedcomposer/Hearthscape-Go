import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Y here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Y extends Text
{
    /**
     * Act - do whatever the Y wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Field field=(Field) getWorld();
        super.display("Y",""+field.getYCo());
    }    
}
