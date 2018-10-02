
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barricade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barricade extends Actor
{
    int x;
    int y;
    String dir;
    public Barricade(int xCo, int yCo,String direction){
        x=xCo;
        y=yCo;
        dir=direction;
    }

    /**
     * Act - do whatever the Barricade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        close();
    }    

    public void move(){
        City city=(City) getWorld();
        if(x<city.x+300 && x>city.x-300 && y>city.y-200 && y<city.y+200){
            setLocation(city.x-x+300,city.y-y+200);
            getImage().setTransparency(255);
        }
        else{
            getImage().setTransparency(0);
        }
    }

    public void close(){
        City city=(City) getWorld();
        if(city.y>-222 && city.x<-480){
            if(dir.equals("left")){
                if(x<-589){
                    x++;
                }
            }
            else if(dir.equals("right")){
                if(x>-557){
                    x--;
                }
            }
        }
    }
}
