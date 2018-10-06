import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VaultCity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VaultCity extends Actor
{
    int x=-612;
    int y=-65;
    int shrink=0;
    int timer=0;
    /**
     * Act - do whatever the VaultCity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        shrink();
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

    public void shrink(){
        City city=(City) getWorld();

        if(!city.init3){
            if(city.x<=-612 && city.y>=-65){
                GreenfootImage image=new GreenfootImage("vault.png");
                if(shrink<image.getWidth()-2){

                    shrink+=2;
                    image.scale(image.getWidth()-shrink,image.getHeight()-shrink);
                    setImage(image);
                }
                else{

                    getImage().setTransparency(0);

                    if(timer==300){
                        Greenfoot.setWorld(new Field());
                    }
                    else{
                        timer++;
                    }
                }
            }
        }
    }
}
