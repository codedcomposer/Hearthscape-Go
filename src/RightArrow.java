import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RightArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RightArrow extends Actor
{
    /**
     * Act - do whatever the RightArrow wants to do. This method is called whenever
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
            field.craftPageCount++;
            field.craftPage();
            
        }
    }
}
