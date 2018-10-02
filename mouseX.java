import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;
/**
 * Write a description of class mouseX here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mouseX extends Text
{
    /**
     * Act - do whatever the mouseX wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Field field=(Field) getWorld();
        MouseInfo mouse=Greenfoot.getMouseInfo();
        if(mouse!=null){
            super.display("X",""+mouse.getX());
        }
    }    
}
