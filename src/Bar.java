import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Bar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bar extends Actor
{
    int value=0;
    /**
     * Act - do whatever the Bar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKey();

    }

    public void draw(){
        GreenfootImage img=new GreenfootImage(201,26);
        img.setColor(java.awt.Color.WHITE);
        img.fillRect(0,0,200,25);
        img.setColor(java.awt.Color.BLACK);
        img.drawRect(0,0,200,25);
        if(value>=125){
            img.setColor(java.awt.Color.GREEN);
        }
        else if(value>=95){
            img.setColor(java.awt.Color.YELLOW);
        }
        else if(value>=55){
            img.setColor(java.awt.Color.ORANGE);
        }
        else{
            img.setColor(java.awt.Color.RED);
        }
        img.fillRect(3,3,value,20);
        setImage(img);
    }

    public void checkKey(){
        Field field=(Field) getWorld();
        if(value<=195){
            draw();
        }
        else if(value>=195){
            field.treeDrop=true;
        }
        if(Greenfoot.isKeyDown(" ")&&value<195){
            value+=2;
            field.checkDoing=true;
        }
        else{
            value=0;
            field.checkDoing=false;
            field.removeObject(this);
        }
        
        
    }
}
