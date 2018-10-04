import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class quickdrawFlash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuickdrawAnimation extends Actor
{
    String dir="left";
    double timer = 0.0;
    public QuickdrawAnimation(String dir){
        this.dir=dir; 
    }

    public void act() 
    {
        directionDetermination();
        animation();
    }

    public void directionDetermination() {
        if (dir.equals("up")) {
            setLocation(getX(),getY()-10);
        } else if(dir.equals("down")){
            setLocation(getX(),getY()+10);
        } else if(dir.equals("left")){
            setLocation(getX()-10,getY());
        } else if(dir.equals("right")){
            setLocation(getX()+10,getY());
        } else if(dir.equals("upleft")){
            setLocation(getX()-5,getY()-5);
        } else if (dir.equals("upright")) {
            setLocation(getX()+5,getY()-5);
        } else if(dir.equals("downleft")){
            setLocation(getX()-5,getY()+5);
        } else if(dir.equals("downright")){
            setLocation(getX()+5,getY()+5);
        }
    }

    public void move() {

    }

    public void animation() {
        timer= timer+0.3;
        Field field=(Field) getWorld();     
        if (timer == 0.5) {
            setImage("quickdraw1.png");
            
        } else if (timer == 1.0) {
            
            setImage("quickdraw3.png");
        } else if (timer == 1.5 ) {
            
            setImage("quickdraw5.png");
        } else if (timer >= 2.0) {
            
            field.removeObject(this);
            timer = 0.000;
        }
    }
}
