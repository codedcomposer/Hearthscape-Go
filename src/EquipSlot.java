import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EquipSlot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EquipSlot extends Actor
{
    String type;
    
    public EquipSlot(String t){
        type=t;
       
        setImage(type+".png");
    }
    /**
     * Act - do whatever the EquipSlot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        checkWindow();
    }    
    public void checkWindow(){
        Field field=(Field) getWorld();
        if(!field.window.equals("equip")){
            field.removeObject(this);
        }
    }
    
}
