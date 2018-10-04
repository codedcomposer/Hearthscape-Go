import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    Boolean hit = false;
    String dir="down";
    String type;
    int degree;
    int kappaDegree=0;
    public Fireball(String dir, String type,int degree){
        this.dir=dir; 
        this.type=type;
        this.degree=degree;
    }

    /**
     * Act - do whatever the fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(type.equals("firestrike")){
            moveFireball();
            povMove();
            firestrikeCollision();
            firestrikeCheckDeletion();
        }

        if (type.equals("buckshot")) {
            moveFireball();
            povMove();
            buckshotCollision();
            buckshotCheckDeletion();
        }
    }    

    public void povMove(){
        Field field=(Field) getWorld();
        setLocation(getX()-field.xMove,getY());
        setLocation(getX(),getY()-field.yMove);
    }

    public void moveFireball(){

        if(type.equals("buckshot")){
            setRotation(degree);
            move(3);
            setRotation(kappaDegree++);

        }
        else if(type.equals("firestrike")){
             setRotation(degree);
            move(3);
            degree++;
        }
    }

    public void firestrikeCollision () { //right fireball collides with bomber
        if (isTouching(Bomber.class)) {
            Actor bomber = getOneIntersectingObject(Bomber.class);
            Field field=(Field) getWorld();        
            field.removeObject(bomber); //removes bomber
            field.removeObject(this); //removes fireball
            hit = true;
        }

    }

    public void firestrikeCheckDeletion(){ //infinite range until fireball reaches border
        if (hit == false) { //deletes itself if already hit a target
            if(getX()>=596 || getX()<=4 || getY()<=4 || getY()>=596){ //if border is reached
                Field field=(Field) getWorld();        
                field.removeObject(this);
            }
        }
    }

    public void buckshotCollision() {
        if (isTouching(Bomber.class)) {
            Actor bomber = getOneIntersectingObject(Bomber.class);
            Field field=(Field) getWorld();        
            field.removeObject(bomber); //removes bomber
            field.removeObject(this); //removes fireball
            hit = true;
        }
    }
    int buckshotTimer = 28;

    public void buckshotCheckDeletion(){ //deletes itself after a short range
        if (hit == false) { //field.xCo,field.yCo+36)  xco = the field location, getX() = graves location
            if (buckshotTimer <= 0) {

                //if(getX() > 300 + 65 || getX() < 300 - 65 ||
                //getY() > 300 + 65 || getY() < 300 - 65){ 
                Field field=(Field) getWorld();        
                field.removeObject(this);
                // }
            }
            buckshotTimer--;
        }

    }
}
