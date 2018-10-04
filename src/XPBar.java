import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class XPBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class XPBar extends Actor
{
    String type="";
    int value=0;
    public XPBar(String t){
        type=t;
    }

    /**
     * Act - do whatever the XPBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        draw();
        checkDeletion();
    }    

    public void draw(){
        Field field=(Field) getWorld();
        GreenfootImage img=new GreenfootImage(108,26);
        
        img.setColor(java.awt.Color.WHITE);
        img.fillRect(0,0,107,25);
        img.setColor(java.awt.Color.BLACK);
        img.drawRect(0,0,107,25);

        img.setColor(java.awt.Color.GREEN);
        if(type.equals("hitpoints")){
            value=field.hitpointsXP*100/(60+(int)Math.pow(field.hitpointsLevel,1.3));
        }
        else if(type.equals("attack")){
            value=field.attackXP*100/(60+(int)Math.pow(field.attackLevel,1.3));
        }
        else if(type.equals("defence")){
            value=field.defenceXP*100/(60+(int)Math.pow(field.defenceLevel,1.3));
        }
        else if(type.equals("mining")){
            value=field.miningXP*100/(60+(int)Math.pow(field.miningLevel,1.3));
        }
        else if(type.equals("crafting")){
            value=field.craftingXP*100/(60+(int)Math.pow(field.craftingLevel,1.3));
        }
        else if(type.equals("woodcutting")){
            value=field.woodcuttingXP*100/(60+(int)Math.pow(field.woodcuttingLevel,1.3));
        }
       
        if(value>=100){
            value=99;
        }
        
        img.fillRect(3,3,value,20);
        GreenfootImage text=new GreenfootImage(value+"%", 25, Color.black, new Color(0, 0, 0, 0));
        img.drawImage(text,40,0);
        setImage(img);
    }

    public void checkDeletion(){
        Field field=(Field) getWorld();
        MouseInfo mouse=Greenfoot.getMouseInfo();
        if(field.window.equals("skills") && field.windowDetail.equals(type)){

        }
        else{
            field.removeObject(this);

        }
    }
}
