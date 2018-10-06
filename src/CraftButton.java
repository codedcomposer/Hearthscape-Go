import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CraftButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CraftButton extends Actor
{
    /**
     * Act - do whatever the CraftButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkPressed();
        checkWindow();
    }    
    public void checkWindow(){
        Field field=(Field) getWorld();
        if(!field.window.equals("backpack")){
            field.removeObject(this);
        }
    }
    public void checkPressed(){
        if(Greenfoot.mouseClicked(this)){
            Field field=(Field) getWorld();
            field.windowDetail="craftinginterface";
            field.craftPage="craftoptionplank1";
            field.craftPageCount=0;
            field.addObject(new CraftingInterface(),280,300);
            field.addObject(new CraftOption(),148,308);
            field.addObject(new LeftArrow(),68,312);
            field.addObject(new RightArrow(),225,312);
            field.addObject(new CraftingItem(0),297,306);
            field.addObject(new CraftingItem(1),327,306);
            field.addObject(new CraftingItem(2),367,306);
            field.addObject(new CraftingItem(3),397,306);
            field.addObject(new DynamicCraft(),368,199);
        }
    }
}
