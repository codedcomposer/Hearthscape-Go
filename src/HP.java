import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP extends Actor
{
    /**
     * Act - do whatever the Bar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkHP();
    }

    public void draw(){
        Field field=(Field) getWorld();
        GreenfootImage img=new GreenfootImage(106,26);
        img.setColor(java.awt.Color.WHITE);
        img.fillRect(0,0,105,25);
        img.setColor(java.awt.Color.BLACK);
        img.drawRect(0,0,105,25);
        if(field.value>=80){
            img.setColor(java.awt.Color.GREEN);
        }
        else if(field.value>=50){
            img.setColor(java.awt.Color.YELLOW);
        }
        else if(field.value>=30){
            img.setColor(java.awt.Color.ORANGE);
        }
        else{
            img.setColor(java.awt.Color.RED);
        }
        img.fillRect(3,3,field.value,20);
        setImage(img);
    }

    public void checkHP(){
        Field field=(Field) getWorld();
        if(field.value>0){
            draw();
        }
        else if(field.value<=0){
            Greenfoot.setWorld(new Field());
        }
    }
    
    public void damage(boolean hit){
        Field field=(Field) getWorld();
        if (hit){
            field.value -= 10;
        }
    }
}
