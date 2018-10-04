import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Equip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equip extends Actor
{
    int position=99;
    String file="trans";
    boolean init=true;
    public Equip(int p){
        position=p;

    }
    /**
     * Act - do whatever the Equip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(init){
            Field field=(Field) getWorld();
          String file=field.equips[position];
                setImage(file+"equip.png");
                init=false;
        }
        type();
        checkDisarm();
        checkWindow();
    }    

    public void type(){
        Field field=(Field) getWorld();
        if(!field.equips[position].equals(file)){
            if(position<=3){
                
                setImage(field.equips[position]+"equip.png");
                file=field.equips[position];
            }
        }
    }

    public void checkWindow(){
        Field field=(Field) getWorld();
        if(!field.window.equals("equip")){
            field.removeObject(this);
        }
    }
    public void checkDisarm(){
        MouseInfo mouse=Greenfoot.getMouseInfo();
        Field field=(Field) getWorld();
        if(mouse!=null && mouse.getButton()==3){
            if(mouse.getX()>getX()-30 && mouse.getX()<getX()+30 && mouse.getY()>getY()-30 && mouse.getY()<getY()+30){
                field.unequipItem(file,position);
            }
        }
    }
}
