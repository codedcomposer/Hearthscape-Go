import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Giant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Giant extends Mobs
{
    int frame=0;
    int deadFrame=1;
    double getX=0;
    double getY=0;
    int factor=0;
    double exactX=0;
    double exactY=0;
    boolean dead=false;

    int giantHealth = 99;
    /**
     * Act - do whatever the Bomber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        Field field=(Field) getWorld();
        field.paintOrder(Bomber.class);
        checkHit();
        checkDamage();
        if(dead){
            deadAnimate();
        }
    }    

    public void checkDamage(){
        if(isTouching(Graves.class) && !dead){
            Field field=(Field) getWorld();
            field.removeObject(this);
            if(field.style.equals("chop")){
                field.hitpointsXP+=20;
                field.attackXP+=20;
                field.defenceXP+=20;
            }
            else if(field.style.equals("lunge")){
                field.attackXP+=60;
            }
            else if(field.style.equals("block")){
                field.defenceXP+=60;
            }
        }
    }

    public void checkHit(){
        if(Greenfoot.mousePressed(this)&&!dead){
            giantHealth-= 33;
            if (giantHealth <= 0) {
                dead=true;
            }

        }
        else if(isTouching(Fireball.class)) {
            //             Actor bomber = getOneIntersectingObject(Bomber.class);
            //             Field field=(Field) getWorld();        
            //             field.removeObject(bomber);
            giantHealth-= 66;
            if (giantHealth <= 0) {
                dead=true;
            }
            dead=true;
        }
        else{
            chase();
            povMove(); 
        }
    }

    public void deadAnimate(){
        if(deadFrame<=29){
            String placeholder=Integer.toString(deadFrame);
            if(deadFrame>=20){
                setImage("die3.png");
            }
            else if(deadFrame>=10){
                setImage("die2.png");
            }
            else {
                setImage("die1.png");
            }
            deadFrame++;
        }
        else if(deadFrame==30){
            die();
            deadFrame=1;
        }
    }

    public void die(){
        Field field=(Field) getWorld();        
        field.removeObject(this);
        field.hitpointsXP+=20;
        field.attackXP+=20;
        field.defenceXP+=20;
    }

    public void chase(){
        if(!dead){
            if(getX()>300 && getY()>300){
                setLocation(getX()-1,getY()-2);
                animate("walk","upleft");
            }
            else if(getX()>300 && getY()<300){
                setLocation(getX()-1,getY()+2);
                animate("walk","downleft");
            }
            else if(getX()<300 && getY()>300){
                setLocation(getX()+2,getY()-1);
                animate("walk","upright");
            }
            else if(getX()<300 && getY()<300){
                setLocation(getX()+2,getY()+1);
                animate("walk","downright");
            }
            else if(getX()>300){
                setLocation(getX()-3,getY());
                animate("walk","left");
            }
            else if(getX()<300){
                setLocation(getX()+3,getY());
                animate("walk","right");
            }
            else if(getY()>300){
                setLocation(getX(),getY()-3);
                animate("walk","up");

            }
            else if(getY()<300){
                setLocation(getX(),getY()+3);
                animate("walk","down");
            }
        }

    }

    public void animate(String action, String direction){
        String check="normal"+action+direction;

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

    public void povMove(){
        Field field=(Field) getWorld();
        if(getX()==300 || getY()==300){
            if(getY()==300){
                setLocation(getX()-field.xMove,getY());
            }
            if(getX()==300){
                setLocation(getX(),getY()-field.yMove);
            }
        }
        else{
            setLocation(getX()-field.xMove,getY()-field.yMove);
        }
        if(getX()>=296 && getX()<=304){
            setLocation(300,getY());
        }
        if(getY()>=296 && getY()<=304){
            setLocation(getX(),300);
        }
    }
}
