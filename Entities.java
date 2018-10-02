import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entities extends Actor
{
    public int xCo;
    public int yCo;
    public boolean visible=true;
    public Entities(int x, int y){
        xCo=x;
        yCo=y;
        getImage().setTransparency(0); //transparency = 0, invisible
        visible=false; // not visibile
    }

    public boolean outOfBounds(){
        Field field=(Field) getWorld();
        if(xCo>field.xCo-300 && xCo<field.xCo+300 && yCo>field.yCo-300 && yCo<field.yCo+300){

            return false;
        }
        else{

            return true;
        }
    }
    public boolean contains(String s,String check){
        String keepo=check.substring(0,1);
        if(s.indexOf(keepo)>=0){
            return true;
        }
        return false;
    }
   
    }
    

  
