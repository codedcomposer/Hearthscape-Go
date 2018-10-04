import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeftArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftArrow extends Actor
{
    /**
     * Act - do whatever the LeftArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkClicked();
        checkDeletion();
    }   
    public void checkDeletion(){
        Field field=(Field) getWorld();
        if(!field.windowDetail.equals("craftinginterface")){
            field.removeObject(this);
        }
    }
    public void checkClicked(){
        
        if(Greenfoot.mouseClicked(this)){
            Field field=(Field) getWorld();
            field.craftPageCount--;
            field.craftPage();
        }
    }
}
