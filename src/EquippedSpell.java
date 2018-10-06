import greenfoot.*;

/**
 * Write a description of class EquippedSpell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EquippedSpell extends Actor
{
    int index;
    String type="trans";
    public EquippedSpell(int i){
        index=i;
    }
    /**
     * Act - do whatever the EquippedSpell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkClicked();
        checkType();
        checkDeletion();
    }    
    public void checkType(){
        Field field=(Field) getWorld();
        if(!field.spellequips[index].equals(type)){
            type=field.spellequips[index];
            setImage(type+".png");
        }
    }
    public void checkDeletion(){
        Field field=(Field) getWorld();
        if(!field.window.equals("spells")){
            field.removeObject(this);
        }
    }
    public void checkClicked(){
        Field field=(Field) getWorld();
        if(Greenfoot.mousePressed(this)){
            field.unequipSpell(index);
        }
    }
}
