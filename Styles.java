import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Styles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Styles extends Actor
{
    /**
     * Act - do whatever the Styles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
    public void checkSelected(String style){
        Field field=(Field) getWorld();
        if(field.style.equals(style)){
            String filename=style+"styleselected.png";
            setImage(filename);
        }
        else{
            String filename=style+"style.png";
            setImage(filename);
        }
    }
    public void checkDeletion(){
        Field field=(Field) getWorld();
        if(!field.window.equals("styles")){
           field.removeObject(this); 
        }
    }
    public void checkClicked(String style){
        Field field=(Field) getWorld();
        if(Greenfoot.mousePressed(this) && !field.style.equals(style)){
             
             field.style=style;
        }
    }
    
}
