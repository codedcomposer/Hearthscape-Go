import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DynamicCraft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DynamicCraft extends Text
{
    /**
     * Act - do whatever the DynamicCraft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkName();
        checkDeletion();
    } 

    public void checkName(){
        Field field=(Field) getWorld(); 
        if(field.craftPageCount==0){
            super.display("","Plank x1","white");
        }
        else if(field.craftPageCount==1){
            super.display("","Plank x2","white");
        }
        else if(field.craftPageCount==2){
            super.display("","Metal x1","white");
        }
        else if(field.craftPageCount==3){
            super.display("","Metal x2","white");           
        }
        else if(field.craftPageCount==4){
            super.display("","Metal x3","white");
        }
        else if(field.craftPageCount==5 ){
            super.display("","Reward Chest x1","white");
        }
        else if(field.craftPageCount==6){
            super.display("","Reward Pack x1","white");
        }
    }
    public void checkDeletion(){
        Field field=(Field) getWorld();
        if(!field.windowDetail.equals("craftinginterface")){
            field.removeObject(this);
        }
    }
}
