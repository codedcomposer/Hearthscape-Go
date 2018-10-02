import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoIt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoIt extends Actor
{
    GifImage gifImage=new GifImage("dewit.gif");
    
    /**
     * Act - do whatever the DoIt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        checkKey();  
    }    

    public void checkKey(){
        Field field=(Field) getWorld();
         setImage(gifImage.getCurrentImage());
        field.done=true;
         if(!Greenfoot.isKeyDown(" ") || !field.closeTree ){
            field.removeObject(this);
            field.done=false;
            
        }
        
           
        
    }
}
