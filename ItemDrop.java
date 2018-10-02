import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ItemDrop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemDrop extends Entities
{
    String item="";
    public ItemDrop(int x, int y,String i){
        super(x,y);
        item=i;
        if(!item.equals("")){
            setImage(item+"small.png");
        }

    }

    public void checkPicked(){
        Field field=(Field) getWorld();
        if(isTouching(Graves.class) && !field.full ){

            if(field.storeItem(item)){
                field.removeObject(this);
            }
        }
    }

    /**
     * Act - do whatever the ItemDrop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        move();
        checkPicked();
    }

    public void move(){
        Field field=(Field) getWorld();
        setLocation(xCo-field.xCo+300,yCo-field.yCo+300);
        if(!super.outOfBounds() && visible==false && getImage().getTransparency()!=255){
            getImage().setTransparency(255);   
            visible=true;

        }
        else if(outOfBounds() && getImage().getTransparency()!=0){
            getImage().setTransparency(0);   
            visible=false;
        }
        

    }
}
