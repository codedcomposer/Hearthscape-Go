import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chest extends Actor
{
    int frame=0;
    boolean hovering=false;
    /**
     * Act - do whatever the Chest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkHover();
        checkFrame();
        animate();
        
    }   

    public void checkHover(){
        Field field=(Field) getWorld();
        MouseInfo mouse=Greenfoot.getMouseInfo();
        if(Greenfoot.mouseMoved(null)){
            if(Greenfoot.mouseMoved(this)){
                hovering=true;
            }
            else{
                hovering=false;
            }
        }
        
    }
    public void checkFrame(){
        if(hovering && frame<18){
            frame++;
        }
        else if(!hovering && frame>0){
            frame--;
        }
    }
    public void animate(){
        if(frame>=12){
            setImage("treasurechest3.png");
        }
        else if(frame>=6){
            setImage("treasurechest2.png");
        }
        else if(frame>=0){
            setImage("treasurechest1.png");
        }
    }
}
