import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DefenceLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DefenceLevel extends Text
{
    /**
     * Act - do whatever the DefenceLevel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        display();
        checkDeletion();
    }    
    public void display(){
        Field field=(Field) getWorld();        
        super.display("",""+field.defenceLevel,"white");
    }   
    public void checkDeletion(){
        Field field=(Field) getWorld(); 
        if(!field.window.equals("skills")){
            field.removeObject(this);
        }
    }
}
