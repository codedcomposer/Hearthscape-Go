import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.*;
/**
 * Write a description of class Graves here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Graves extends Actor
{
    String dir="down";
    int frame=0;
    boolean checkUp=false;
    boolean checkDown=false;
    boolean checkLeft=false;
    boolean checkRight=false;
    double constantOneDir=2;
    double constantTwoDir=1;

    boolean spellingBuckShot=false;
    boolean spellingFireStrike=false; 
    
    int timer = 0;
    int itimer = 0;

    int quickdrawTimer = 0;
    int quickdrawFrame = 0;
    int qCooldown = 0;
    int eCooldown = 0;

    /**
     * Act - do whatever the Graves wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Field field=(Field) getWorld();
        
        if(qCooldown>0){
            qCooldown--;
        }
        if(eCooldown>0){
            eCooldown--;
        }
        if(spellingBuckShot){
            buckshoterino();
        }
        if(spellingFireStrike){
            firestrikerino();
        }
        if(!field.checkDoing){
            checkKey();
            checkSpell();
        }
        else{
            standNoDir();
        }
    }  
    public void checkSpell(){
        Field field=(Field) getWorld();
        if(Greenfoot.isKeyDown("q") && qCooldown<=0){
            qCooldown=100;
            String spell=field.spellequips[0];
           useSpell(spell);
        }
        else if(Greenfoot.isKeyDown("e") && eCooldown<=0){
            eCooldown=100;
            String spell=field.spellequips[1];
            useSpell(spell);
        }
    }
    public void useSpell(String spell){
        if(spell.equals("buckshot")){
            if(!spellingBuckShot){
                spellingBuckShot=true;
            }
        }
        else if(spell.equals("firestrike")){
            if(!spellingFireStrike){
                spellingFireStrike=true;
            }
        }
    }
    public void checkSpecAbility() {
        Field field=(Field) getWorld();
        if (Greenfoot.isKeyDown("t")) { //tomato
            timer++;
            if(timer==10){
                if(dir.equals("left")){
                    getWorld().addObject(new TomatoPlant(field.xCo-30,field.yCo+10),getX()-30,getY());
                }
                if(dir.equals("right")){
                    getWorld().addObject(new TomatoPlant(field.xCo+30,field.yCo+10),getX()+30,getY());
                }
                if(dir.equals("up")){
                    getWorld().addObject(new TomatoPlant(field.xCo,field.yCo-20),getX(),getY()-20);
                }
                if(dir.equals("down")){
                    getWorld().addObject(new TomatoPlant(field.xCo,field.yCo+36),getX(),getY()+36);
                }
            }

        } else if (Greenfoot.isKeyDown("q")) { //buckshot (q)
            
        } else if (Greenfoot.isKeyDown("f")) { //rocket (e)
            if (timer == 1) {
                if (dir.equals("left")) {
                    getWorld().addObject(new Rocket(), getX(), getY());
                }
            }
            field.paintOrder(Rocket.class);
        } else if (Greenfoot.isKeyDown("e")) { //quickdraw (e)
            timer++;
            if (timer == 1) {
                
                if(dir.equals("left")){

                    getWorld().addObject(new QuickdrawAnimation("left"), getX()+80, getY());

                    field.fieldMove(-80,0);
                }
                if(dir.equals("right")){
                    getWorld().addObject(new QuickdrawAnimation("right"), getX()-80, getY());

                    field.fieldMove(80,0);

                }
                if(dir.equals("up")){
                    getWorld().addObject(new QuickdrawAnimation("up"), getX(), getY()+80);
                    field.fieldMove(0,-80);
                }
                if(dir.equals("down")){
                    getWorld().addObject(new QuickdrawAnimation("down"), getX(), getY()-80);
                    field.fieldMove(0,80);
                }
                if(dir.equals("downleft")) {
                    field.fieldMove(-40,-40);
                }
                if(dir.equals("upleft")) {
                    field.fieldMove(-40,40);
                }
                if(dir.equals("downright")) {
                    field.fieldMove(40,-40);
                }
                if(dir.equals("upright")) {
                    field.fieldMove(40,40);
                }
            }
        } else if (Greenfoot.isKeyDown("r")) { //firestrike (f)
            timer++;
            if (timer == 1) {
                //getWorld().addObject(new LeftFireball(), getX() - 50, getY());
                
                for(int i=0;i<360;i++){
                    getWorld().addObject(new Fireball("left","firestrike",i), getX(), getY());
                }

                field.paintOrder(Fireball.class);
            }
        } 
        else if (Greenfoot.isKeyDown("g")) { //gun
            timer++;
            if(timer==10){
                field.dirSpawn("awpasiimov");
            } 
        }else { //if the key isnt down
            // if not pressing f, shoot timer is 0
            if(!spellingBuckShot){
                timer = 0;
            }
        }
    }
    public void firestrikerino(){
         Field field=(Field) getWorld();
        timer++;
            if (timer == 1) {
                //getWorld().addObject(new LeftFireball(), getX() - 50, getY());
                
                for(int i=0;i<360;i++){
                    getWorld().addObject(new Fireball("left","firestrike",i), getX(), getY());
                }

                field.paintOrder(Fireball.class);
            }
            if(timer>=2){
            spellingFireStrike=false;
            timer=0;
        }
    }
    public void buckshoterino(){
        Field field=(Field) getWorld();
        timer++;
        if (timer == 1 || timer == 3 || timer==5) { //(timer == 1 || timer == 4 or 5);
            
            if(dir.equals("left")){
                for(int i=225;i>135;i--){
                    getWorld().addObject(new Fireball("left","buckshot",i),getX(),getY());
                }
            }
            if(dir.equals("right")){
                //                 for(int i=45;i>0;i--){
                //                     if (buckshotAmount > 0) {
                //                         getWorld().addObject(new Fireball("right","buckshot",i),getX(),getY());
                //                     } 
                //                 }
                for(int i=315;i<360;i++){

                    getWorld().addObject(new Fireball("right","buckshot",i),getX(),getY());

                }
            }
            if(dir.equals("down")){
                for(int i=135;i>45;i--){

                    getWorld().addObject(new Fireball("right","buckshot",i),getX(),getY());

                }
            }
            if(dir.equals("up")){
                for(int i=315;i>225;i--){
                    getWorld().addObject(new Fireball("down","buckshot",i),getX(),getY());

                    // getWorld().addObject(new Fireball("right","buckshot",i),getX(),getY());

                }

            }

            if(dir.equals("downleft")) {
                for(int i=180;i>90;i--){
                    getWorld().addObject(new Fireball("left","buckshot",i),getX(),getY());

                    getWorld().addObject(new Fireball("right","buckshot",i),getX(),getY());

                }
            }
            if(dir.equals("upleft")) {
                for(int i=270;i>180;i--){
                    getWorld().addObject(new Fireball("left","buckshot",i),getX(),getY());

                    getWorld().addObject(new Fireball("right","buckshot",i),getX(),getY());

                }
            }
            if(dir.equals("downright")) {
                for(int i=90;i>0;i--){
                    getWorld().addObject(new Fireball("left","buckshot",i),getX(),getY());

                    getWorld().addObject(new Fireball("right","buckshot",i),getX(),getY());

                }
            }
            if(dir.equals("upright")) {
                for(int i=360;i>270;i--){
                    getWorld().addObject(new Fireball("left","buckshot",i),getX(),getY());

                    getWorld().addObject(new Fireball("right","buckshot",i),getX(),getY());

                }
            }

        }
        if(timer>=6){
            spellingBuckShot=false;
            timer=0;
        }
        field.paintOrder(Fireball.class);
    }
    //     public void specialAbilityUses(String spec, String amount) {
    //         if (amount == "add") {
    //             if (spec == "buckshot") {
    //                 buckshotAmount++;
    //             } else if (spec == "rocket") {
    //                 rocketAmount++;
    //             } else if (spec == "quickdraw") {
    //                 quickdrawAmount++;
    //             } else if (spec == "flamestrike") {
    //                 firestrikeAmount++;
    //             }
    //         }
    //         if (amount == "subtract") {
    //             if (spec == "buckshot") {
    //                 buckshotAmount++;
    //             } else if (spec == "rocket") {
    //                 rocketAmount++;
    //             } else if (spec == "quickdraw") {
    //                 quickdrawAmount++;
    //             } else if (spec == "flamestrike") {
    //                 firestrikeAmount++;
    //             }
    //         }
    //     }

    public void checkKey(){
        Field field=(Field) getWorld();
        if(direction("upleft")&& !field.collideUp && !field.collideLeft){

            animate("walk","upleft");
            field.fieldMove(-1,-1);

        }
        else if(direction("upright") && !field.collideUp && !field.collideRight){

            animate("walk","upright");
            field.fieldMove(1,-1);

        }
        else if(direction("downleft") && !field.collideDown && !field.collideLeft){

            animate("walk","downleft");
            field.fieldMove(-1,1);

        }
        else if(direction("downright") && !field.collideDown && !field.collideRight){

            animate("walk","downright");
            field.fieldMove(1,1);

        }
        else if (direction("up") && !field.collideUp){

            animate("walk","up");
            field.fieldMove(0,-2);

        }
        else if(direction("down")&& !field.collideDown ){

            animate("walk","down");
            field.fieldMove(0,2);

        }
        else if (direction("left") && !field.collideLeft){

            animate("walk","left");
            field.fieldMove(-2,0);

        }
        else if (direction("right")&& !field.collideRight){

            animate("walk","right");
            field.fieldMove(2,0);

        }
        else {
            stand();
            field.resetMoveValue();
        }
        field.characterDir=dir;
    }

    public void animate(String action, String direction){
        String check=action+direction;
        dir=direction;
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

    public boolean direction(String dir){
        if(dir.equals("upleft")){
            return(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("a"));
        }
        else if(dir.equals("upright")){
            return(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d"));
        }
        else if(dir.equals("downleft")){
            return(Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a"));
        }
        else if(dir.equals("downright")){
            return(Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("d"));
        }
        else if(dir.equals("up")){
            return(Greenfoot.isKeyDown("w"));
        }
        else if(dir.equals("down")){
            return(Greenfoot.isKeyDown("s"));
        }
        else if(dir.equals("left")){
            return(Greenfoot.isKeyDown("a"));
        }
        else if(dir.equals("right")){
            return(Greenfoot.isKeyDown("d"));
        }
        dir=dir;
        return false;
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

    public void standNoDir(){

        setImage("stand"+dir+".png");
        frame=0;
    }
}
