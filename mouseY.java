import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mouseY here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mouseY extends Text
{
    /**
     * Act - do whatever the mouseY wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Field field=(Field) getWorld();
        MouseInfo mouse=Greenfoot.getMouseInfo();
        if(mouse!=null){
            super.display("Y",""+mouse.getY());
        }
    }    
}
