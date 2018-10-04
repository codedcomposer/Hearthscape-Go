import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VaultHoleCity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VaultHoleCity extends Actor
{
    int x=-613;
    int y=-66;
    /**
     * Act - do whatever the VaultHoleCity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move();
       
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
}
