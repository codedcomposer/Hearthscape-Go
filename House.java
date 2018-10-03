import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends World
{
    int x=200;
    int y=200;
    String chatContent="";
    int counter=0;
    int index=0;
    boolean chatting=false;
    boolean interacting=false;
    String chatHead;
    boolean init=false;
    boolean init2=false;
    int chatCounter=0;
    String[] chatDatabaseHouse={"","Hey Keeporoni","Please...","Keepo?"};
    /**
     * Constructor for objects of class House.
     * 
     */
    public House()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(480, 352, 1); 
        addObject(new GravesHouse(),110,60);
        addObject(new Kid(),300,200);
        addObject(new Sofa(),190,270);
        addObject(new Piano(),275,100);
    }

    public void act(){
        chatHead();
    }

    public void chat(String s, String character){
        chatting=true;
        chatContent=s;
        index=0;
        addObject(new ChatHouse(),240,302);
        if(character.equals("graves")){
            chatHead="graves";
            addObject(new ChatHeadHouse(),400,299);

        }
        else if(character.equals("kid")){
            chatHead="kid";
            addObject(new ChatHeadHouseKid(),400,299);
        }
        Text t = new Text();
        addObject(t,200,300);
        t.displayLines(s,25,0);

    }

    public void chatCounter(Text t){
        chatCounter++;
        if(chatCounter<4){
            t.displayLines(chatDatabaseHouse[chatCounter],25,0);
            if(chatHead.equals("graves")){
                chatHead="graves";
                addObject(new ChatHeadHouse(),400,299);

            }
            else if(chatHead.equals("kid")){
                chatHead="kid";
                addObject(new ChatHeadHouseKid(),400,299);
            }
        }
        else if(chatCounter==4){
            
            chatting=false;
            init2=true;
        }
    }

    public void chatHead(){
        if(chatCounter%2!=0){
            chatHead="graves";
        }
        else{
            chatHead="kid";
        }
    }
}
