import greenfoot.*;

/**
 * Write a description of class ValueBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ValueBar extends Actor
{
    /**
     * Act - do whatever the ValueBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public void draw(){
        GreenfootImage img=new GreenfootImage(151,26);
        img.setColor(java.awt.Color.WHITE);
        img.fillRect(0,0,150,25);
        img.setColor(java.awt.Color.BLACK);
        img.drawRect(0,0,150,25);
        img.setColor(java.awt.Color.GREEN);
        img.fillRect(3,3,145,20);
        setImage(img);
    }
}
