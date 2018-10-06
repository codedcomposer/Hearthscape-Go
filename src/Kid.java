import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kid extends Actor
{
    int frame=0;
    String dir="down";
    /**
     * Act - do whatever the Kid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        House house=(House) getWorld();
        if(house.chatCounter==1){
            dir="left";
            stand(dir);
        }
        if(house.init2){
            if(getY()<=315){
                checkKey("down");
            }
            else{
                house.init2=false;
            }
        }
        else if(getY()>315){
            getWorld().removeObject(this);
        }
    }  

    public void checkKey(String dir){

        if (dir.equals("up")){
            animate("walk","up");
            setRotation(270);
            move(2);
            setRotation(0);

        }
        else if(dir.equals("down") ){

            animate("walk","down");
            setRotation(90);
            move(2);
            setRotation(0);

        }
        else if (dir.equals("left")){

            animate("walk","left");
            setRotation(180);
            move(2);
            setRotation(0);

        }
        else if (dir.equals("right")){

            animate("walk","right");
            setRotation(0);
            move(2);
            setRotation(0);

        }
        else {
            stand(dir);

        }

    }

    public void animate(String action, String direction){
        String check="kid"+action+direction;
        
         if(frame>=25){
            setImage(check+"2"+".png");
        }
        else {
            setImage(check+"1"+".png");
        }
        frame+=2;
        if(frame>=50){
            frame=0;
        }

    }

    

    

    public void stand(String direction){

        setImage("kidstand"+direction+".png");
        frame=0;
    }
}
