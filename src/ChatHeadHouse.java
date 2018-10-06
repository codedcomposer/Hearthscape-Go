import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChatHeadHouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChatHeadHouse extends Chat
{
    /**
     * Act - do whatever the ChatHeadHouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        House house=(House) getWorld();
        if(!house.chatting ){
            house.removeObject(this);
        }
    }    
}
