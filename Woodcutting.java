import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Woodcutting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Woodcutting extends Skills
{
    /**
     * Act - do whatever the Woodcutting wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkDeletion();
    }    
    public void checkDeletion(){
        Field field=(Field) getWorld(); 
        if(!field.window.equals("skills")){
            field.removeObject(this);
        }
    }    
}
