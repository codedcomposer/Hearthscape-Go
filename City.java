import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class City here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class City extends World
{
    int x=100;
    int y=80;
    boolean init3=true;
    private GreenfootImage bgImage = new GreenfootImage("city.png");
    private GreenfootImage bgImage2 = new GreenfootImage("fieldcity.png");
    /**
     * Constructor for objects of class City.
     * 
     */
    public City()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new GravesCity(),300,200);
        getBackground().drawImage(bgImage,x,y);
        getBackground().drawImage(bgImage2, x + 1000,y);
        getBackground().drawImage(bgImage2, x- 1000, y);
        getBackground().drawImage(bgImage2,x, y-656);
        getBackground().drawImage(bgImage2, x, y+656);
        getBackground().drawImage(bgImage2,x+1000 ,y-656);
        getBackground().drawImage(bgImage2,x-1000 , y-656);
        getBackground().drawImage(bgImage2,x+1000 , y+656);
        getBackground().drawImage(bgImage2,x-1000 , y+656);
        addObject(new Barricade(-530,-215,"right"),0,0);
        addObject(new Barricade(-616,-215,"left"),0,0);
        addObject(new VaultHoleCity(),0,0);
        addObject(new VaultCity(),0,0);
        setPaintOrder(VaultHoleCity.class);
        setPaintOrder(VaultCity.class);
        setPaintOrder(Barricade.class);
        setPaintOrder(GravesCity.class);
    }
    public void backMove(int xIncrease, int yIncrease){
        getBackground().fill();
        getBackground().drawImage(bgImage,x,y);
        getBackground().drawImage(bgImage2, x + 1000,y);
        getBackground().drawImage(bgImage2, x- 1000, y);
        getBackground().drawImage(bgImage2,x, y-656);
        getBackground().drawImage(bgImage2, x, y+656);
        getBackground().drawImage(bgImage2,x+1000 ,y-656);
        getBackground().drawImage(bgImage2,x-1000 , y-656);
        getBackground().drawImage(bgImage2,x+1000 , y+656);
        getBackground().drawImage(bgImage2,x-1000 , y+656);
    }
}
