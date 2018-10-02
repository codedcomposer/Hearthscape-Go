import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GravesHouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GravesHouse extends Actor
{
    int frame=0;
    String dir="down";
    boolean isNull=false;
    boolean init=true;
    /**
     * Act - do whatever the GravesHouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        House house=(House) getWorld();
        if(init){

            if(getY()<200){
                dir="down";
                checkKey("down");

            }
            else{
                if(getX()<200){
                    dir="right";
                    checkKey("right");

                }
                else{

                    init=false;
                    dir="right";
                    stand("right");
                    house.init=true;
                    house.chat("Good morning Stacy","graves");
                }
            }

        }
        if(!init && house.init){
            
        }
        if(!isNull && !init && !house.chatting && !house.init2 ){
            direction2();
            checkKey();
        }
    }

    public void move(int n){

        if(!isNull){
            super.move(n);
            House house=(House) getWorld();
            if(getRotation()==0){
                house.x+=n;
            }
            else if(getRotation()==90){
                house.y+=n;
            }
            else if(getRotation()==180){
                house.x-=n;
            }
            else if(getRotation()==270){
                house.y-=n;
            }
            if(getX()>432 || getX()<47 || (getX()<80 && getY()<130) || (getX()>142 && getY()<100) ||(getY()>304 && getX()<303)||(getY()>304 && getX()>337) || getY()<50 || isTouching(Piano.class) || isTouching(Sofa.class)){
                super.move(-n);
                if(getRotation()==0){
                    house.x-=n;
                }
                else if(getRotation()==90){
                    house.y-=n;
                }
                else if(getRotation()==180){
                    house.x+=n;
                }
                else if(getRotation()==270){
                    house.y+=n;
                }
            }
        }
        if(getY()>315){

             Greenfoot.setWorld(new City());
            isNull=true;
        }
    }

    public void checkKey(){

        if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("a")){
            animate("walk","upleft");
            //             setRotation(235);
            //             move(1);
            setRotation(270);
            move(1);
            setRotation(180);
            move(1);
            setRotation(0);

        }
        else if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d")){

            animate("walk","upright");
            setRotation(270);
            move(1);
            setRotation(0);
            move(1);
            setRotation(0);

        }
        else if(Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a") ){

            animate("walk","downleft");
            setRotation(90);
            move(1);
            setRotation(180);
            move(1);
            setRotation(0);

        }
        else if(Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("d")){

            animate("walk","downright");
            setRotation(90);
            move(1);
            setRotation(0);
            move(1);
            setRotation(0);

        }
        else if (Greenfoot.isKeyDown("w")){

            animate("walk","up");
            setRotation(270);
            move(2);
            setRotation(0);

        }
        else if(Greenfoot.isKeyDown("s") ){

            animate("walk","down");
            setRotation(90);
            move(2);
            setRotation(0);

        }
        else if (Greenfoot.isKeyDown("a")){

            animate("walk","left");
            setRotation(180);
            move(2);
            setRotation(0);

        }
        else if (Greenfoot.isKeyDown("d")){

            animate("walk","right");
            setRotation(0);
            move(2);
            setRotation(0);

        }
        else {
            stand();

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
            stand();

        }

    }

    public void animate(String action, String direction){
        String check=action+direction;
        if(frame>=75){
            setImage(check+"4"+".png");
        }
        else if(frame>=50){
            setImage(check+"3"+".png");
        }
        else if(frame>=25){
            setImage(check+"2"+".png");
        }
        else {
            setImage(check+"1"+".png");
        }
        frame+=2;
        if(frame>=100){
            frame=0;
        }

    }

    public void direction2(){
        if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("a")){
            dir="upleft";
        }
        else  if(Greenfoot.isKeyDown("w")&&Greenfoot.isKeyDown("d")){
            dir="upright";
        }
        else if(Greenfoot.isKeyDown("s")&&Greenfoot.isKeyDown("a")){
            dir="downleft";
        }
        else if(Greenfoot.isKeyDown("s")&&Greenfoot.isKeyDown("d")){
            dir="downright";
        }
        else if(Greenfoot.isKeyDown("w")){
            dir="up";
        }
        else if(Greenfoot.isKeyDown("s")){
            dir="down";
        }
        else if(Greenfoot.isKeyDown("a")){
            dir="left";
        }
        else if(Greenfoot.isKeyDown("d")){
            dir="right";
        }

    }

    public void stand(){
        direction2();
        setImage("stand"+dir+".png");
        frame=0;
    }

    public void stand(String direction){

        setImage("stand"+direction+".png");
        frame=0;
    }
}
