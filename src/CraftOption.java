import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CraftOption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CraftOption extends Actor
{
    String type;
    
    /**
     * Act - do whatever the CraftOption wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkType();
       checkDeletion();
    }    
    public void checkDeletion(){
        Field field=(Field) getWorld();
        if(!field.windowDetail.equals("craftinginterface")){
            field.removeObject(this);
        }
    }
    public void checkType(){
        Field field=(Field) getWorld();
        if(!field.craftPage.equals(type)){
            type=field.craftPage;
        }
        setImage(type+".png");
    }
}
