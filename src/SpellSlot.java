import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpellSlot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpellSlot extends Actor
{
    int index;
    String type="trans";
    public SpellSlot(int i){
        index=i;
    }

    /**
     * Act - do whatever the SpellSlot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkClicked();
        checkImage();
        checkWindow();
    } 

    public void checkImage(){
        Field field=(Field) getWorld();
        if(!type.equals(field.spells[index])){
            type=field.spells[index];
            setImage(type+".png");
        }
    }
    public void checkWindow(){
        Field field=(Field) getWorld();
        if(!field.window.equals("spells")){
            field.removeObject(this);
        }
    }
    public void checkClicked(){
        Field field=(Field) getWorld();
        if(Greenfoot.mousePressed(this)){
            field.equipSpell(index);
        }
    }
}
