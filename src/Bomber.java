import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomber extends Mobs
{
    int frame=0;
    int deadFrame=1;
    double getX=0;
    double getY=0;
    int factor=0;
    double exactX=0;
    double exactY=0;
    boolean dead=false;
    public Bomber(){
        Field field=(Field) getWorld();

    }

    /**
     * Act - do whatever the Bomber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        Field field=(Field) getWorld();

        povMove(); 
        if(dead){
            deadAnimate();
        }
        else{
            checkHit();
            checkDamage();
        }
    }    

    public void checkDamage(){
        if(isTouching(Graves.class) && !dead){
            Field field=(Field) getWorld();

            die();
        }
    }

    public void checkHit(){
        if(Greenfoot.mousePressed(this)&&!dead){

            dead=true;
        }
        else if(isTouching(Fireball.class)) {

            dead=true;
        }
        else {
            chase();

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

        if(field.style.equals("chop")){

            field.hitpointsXP+=10;
            field.attackXP+=10;
            field.defenceXP+=10;
        }
        else if(field.style.equals("lunge")){
            field.attackXP+=25;
        }
        else if(field.style.equals("block")){
            field.defenceXP+=25;
        }
        field.checkXP();
        field.removeObject(this);
    }

    public void chase(){
        if(!dead){
            Graves graves = (Graves) getWorld().getObjects(Graves.class).get(0);
            turnTowards(graves.getX(), graves.getY());
            move(3);
            setRotation(0);
            if(getX()>300 && getY()>300){

                animate("walk","upleft");
            }
            else if(getX()>300 && getY()<300){

                animate("walk","downleft");
            }
            else if(getX()<300 && getY()>300){

                animate("walk","upright");
            }
            else if(getX()<300 && getY()<300){

                animate("walk","downright");
            }
            else if(getX()>300){

                animate("walk","left");
            }
            else if(getX()<300){

                animate("walk","right");
            }
            else if(getY()>300){

                animate("walk","up");

            }
            else if(getY()<300){

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
