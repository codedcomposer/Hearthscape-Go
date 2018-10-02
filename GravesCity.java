import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GravesCity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GravesCity extends Actor
{
    boolean isNull=false;
    int frame=0;
    String dir="down";
    boolean init=true;
    boolean init2=false;
    boolean init2init=true;
    int timer=0;
    int shrink=0;

    /**
     * Act - do whatever the GravesCity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        City city=(City) getWorld();
        if(!city.init3){
            shrink();
        }
        if(init2init){

            if(city.y>-326 && city.x<-480){
                init2=true;
                init2init=false;
            }
        }
        if(init){

            if(city.y>=-10){
                checkKey("down");
            }
            else{
                init=false;
            }

        }
        else if(init2){

            if(city.y<-65){
                checkKey("up");
            }
            else{
                if(city.x>-612){
                    checkKey("right");

                }
                else{

                    dir="down";
                    stand();

                    if(timer==140){
                        init2=false;
                        city.init3=false;
                    }
                    else if(timer==120){
                        getWorld().addObject(new ExplodeCity(),290,70);
                        getWorld().addObject(new ExplodeCity(),260,180);
                        getWorld().addObject(new ExplodeCity(),250,230);
                        getWorld().addObject(new ExplodeCity(),280,300); 
                    }
                    else if(timer==60){
                        getWorld().addObject(new ExplodeCity(),80,50);
                        getWorld().addObject(new ExplodeCity(),150,150);

                        getWorld().addObject(new ExplodeCity(),100,330);  
                    }
                    else if(timer==0){

                        getWorld().addObject(new ExplodeCity(),50,250);
                    }
                    timer++;
                }
            }
        }
        else if(!isNull && city.init3){
            direction2();
            checkKey();
        }
    }

    public void shrink(){
        City city=(City) getWorld();
        if(city.x<=-612 && city.y>=-65){
            GreenfootImage image=new GreenfootImage("standdown.png");
            if(shrink<image.getWidth()-1){

                shrink++;
                image.scale(image.getWidth()-shrink,image.getHeight()-shrink);
                setImage(image);
            }
            else{
                getImage().setTransparency(0);
            }
        }
    }

    public void move(int n){

        if(!isNull){
            City city=(City) getWorld();
            int xCheck=getX();
            int yCheck=getY();
            if(getRotation()==0){
                city.x-=n;
                city.backMove(n,0);
            }
            else if(getRotation()==90){
                city.y-=n;
                city.backMove(0,n);
            }
            else if(getRotation()==180){
                city.x+=n;
                city.backMove(-n,0);
            }
            else if(getRotation()==270){
                city.y+=n;
                city.backMove(0,-n);
            }

            if(city.x>=282 || city.y>=181 || city.y<-436 || city.x<-683 || (city.y<-63 && city.x>-29)|| (city.y>-3 && city.x>-29)
            || (city.x<-88 && city.x>-529 && city.y>-377) || (city.x>-556 && city.x<-88 && city.y<-189 && city.y>-377) 
            || (city.y<-189 && city.y>-377 && city.x<-590) || (city.x<=-529 && city.y>-1)){

                if(getRotation()==0){
                    city.x+=n;
                    city.backMove(-n,0);
                }
                else if(getRotation()==90){
                    city.y+=n;
                    city.backMove(0,-n);
                }
                else if(getRotation()==180){
                    city.x-=n;
                    city.backMove(n,0);
                }
                else if(getRotation()==270){
                    city.y-=n;
                    city.backMove(0,n);
                }

            }
        }

    }

    public void move(int n, boolean ignoreCollide){

        if(!isNull){
            City city=(City) getWorld();
            int xCheck=getX();
            int yCheck=getY();
            if(getRotation()==0){
                city.x-=n;
                city.backMove(n,0);
            }
            else if(getRotation()==90){
                city.y-=n;
                city.backMove(0,n);
            }
            else if(getRotation()==180){
                city.x+=n;
                city.backMove(-n,0);
            }
            else if(getRotation()==270){
                city.y+=n;
                city.backMove(0,-n);
            }

            if(!ignoreCollide){
                if(city.x>=282 || city.y>=181 || city.y<-436 || city.x<-683 || (city.y<-63 && city.x>-29)|| (city.y>-3 && city.x>-29) 
                || (city.x<-88 && city.x>-529 && city.y>-381)){

                    if(getRotation()==0){
                        city.x+=n;
                        city.backMove(-n,0);
                    }
                    else if(getRotation()==90){
                        city.y+=n;
                        city.backMove(0,-n);
                    }
                    else if(getRotation()==180){
                        city.x-=n;
                        city.backMove(n,0);
                    }
                    else if(getRotation()==270){
                        city.y-=n;
                        city.backMove(0,n);
                    }

                }
            }
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
            move(2,true);
            setRotation(0);

        }
        else if(dir.equals("down") ){

            animate("walk","down");
            setRotation(90);
            move(2,true);
            setRotation(0);

        }
        else if (dir.equals("left")){

            animate("walk","left");
            setRotation(180);
            move(2,true);
            setRotation(0);

        }
        else if (dir.equals("right")){

            animate("walk","right");
            setRotation(0);
            move(2,true);
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
}
