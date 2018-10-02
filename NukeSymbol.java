import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nuke here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NukeSymbol extends Actor
{

    int nukeCounter = 0;
    boolean nukeRemoval = false;
    public void act() 
    {
        checkRemoval();
        nuking();
    }

    public void checkRemoval () {

        if(nukeCounter<=130){
            nukeCounter++;
        }else{
            nukeRemoval=true;
        }

        if (nukeRemoval == true) {
            Field field=(Field) getWorld(); 
            field.removeObject(this);
        }    
    }

    public void nuking() {
        
    }
}
