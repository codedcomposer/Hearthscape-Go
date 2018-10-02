import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExplodeCity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExplodeCity extends Actor
{
    int frame=0;
    /**
     * Act - do whatever the ExplodeCity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        City city=(City) getWorld();
        if(frame>=80){
            setImage("explode16.png");
        }
        else if(frame>=75){
            setImage("explode15.png");
        }
        else if(frame>=70){
            setImage("explode14.png");
        }
        else if(frame>=65){
            setImage("explode13.png");
        }
        else if(frame>=60){
            setImage("explode12.png");
        }
        else if(frame>=55){
            setImage("explode11.png");
        }
        else if(frame>=50){
            setImage("explode10.png");
        }
        else if(frame>=45){
            setImage("explode9.png");
        }
        else if(frame>=40){
            setImage("explode8.png");
        }
        else if(frame>=35){
            setImage("explode7.png");
        }
        else if(frame>=30){
            setImage("explode6.png");
        }
        else if(frame>=25){
            setImage("explode5.png");
        }
        else if(frame>=20){
            setImage("explode4.png");
        }
        else if(frame>=15){
            setImage("explode3.png");
        }
        else if(frame>=10){
            setImage("explode2.png");
        }
        else {
            setImage("explode1.png");
        }
        frame++;
        if(frame>85){
            city.removeObject(this);
        }
    }
}
