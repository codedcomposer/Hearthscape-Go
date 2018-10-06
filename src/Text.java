import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    String chatContent="";
    String chat="";
    int index=0;
    int counter=0;
    boolean inHouse=false;
    int chatCounter=0;
    boolean space=false;
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        House house=(House) getWorld();
        if(!Greenfoot.isKeyDown("space")){
            space=false;
        }
        if(chatCounter!=house.chatCounter){
            chatCounter=house.chatCounter;
        }
        if(inHouse && house.chatting){
            if(Greenfoot.isKeyDown("space") && inHouse && !space){
                space=true;
                if(!chat.equals(chatContent)){
                    chat=chatContent;
                    setImage(new GreenfootImage(chatContent, 25, Color.black, new Color(0, 0, 0, 0)));
                }
                else{
                    house.chatCounter(this);

                }
            }
            else if(!chat.equals(chatContent) && index<chatContent.length()){
                if(counter==2){
                    chat+=chatContent.substring(index,index+1);
                    setImage(new GreenfootImage(chat, 25, Color.black, new Color(0, 0, 0, 0)));
                    index++;
                    counter=0;
                }
                else{
                    counter++;
                }
            }
            else{

            }
        }
        else if(inHouse && !house.chatting){

            house.removeObject(this);
        }
    }    

    void display(String textLabel, String text){
        setImage(new GreenfootImage(textLabel+text, 25, Color.black, new Color(0, 0, 0, 0)));
        chatContent=text;
    }

    void display(String textLabel, String text,String colour){
        if(colour.equals("white")){
            Field field=(Field) getWorld();
            setImage(new GreenfootImage(textLabel+text, 25, Color.white, new Color(0, 0, 0, 0)));
        }
        if(colour.equals("orange")){
            Field field=(Field) getWorld();
            setImage(new GreenfootImage(textLabel+text, 25, Color.orange, new Color(0, 0, 0, 0)));
        }
        if(colour.equals("red")){
            Field field=(Field) getWorld();
            setImage(new GreenfootImage(textLabel+text, 25, Color.orange, new Color(0, 0, 0, 0)));
        }
    }

    void display(String textLabel, String text,String colour,int size){
        if(colour.equals("white")){
            Field field=(Field) getWorld();
            setImage(new GreenfootImage(textLabel+text, size, Color.white, new Color(0, 0, 0, 0)));
        }
        if(colour.equals("orange")){
            Field field=(Field) getWorld();
            setImage(new GreenfootImage(textLabel+text, size, Color.orange, new Color(0, 0, 0, 0)));
        }
    }

    void displayLines(String text,int size){
        displayLines(text,size,0);
    }

    void displayLines(String text,int size,int index){
        chat="";
        this.index=0;
        inHouse=true;
        chatContent=text;

    }
}
