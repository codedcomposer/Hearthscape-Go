import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dynamic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dynamic extends Text
{
    String textLabel="";
    String text="";
    int left=0;
    int right=0;
    int up=0;
    int down=0;
    public Dynamic(String tL,String t){
        textLabel=tL;
        text=t;

    }

    /**
     * Act - do whatever the Dynamic wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        display();
        checkDeletion();
    }    

    public void display(){
        Field field=(Field) getWorld();
        if(text.equals("hitpoints")&&!textLabel.equals("")){
            super.display(textLabel,Integer.toString(field.hitpointsLevel)+"/35","orange",20);
        }
        else if(text.equals("hitpoints")){
            super.display("","Allows for better endurance \n and recovery in battle","orange",14);
        }
        else if(text.equals("attack") && !textLabel.equals("")){
            super.display(textLabel,Integer.toString(field.attackLevel)+"/35","orange",20);
        }
        else if(text.equals("attack")){
            super.display("","Allows for stronger special \n moves with lower cooldowns","orange",14);
        }
        else if(text.equals("mining") && !textLabel.equals("")){
            super.display(textLabel,Integer.toString(field.miningLevel)+"/25","orange",20);
        }
        else if(text.equals("mining")){
            super.display("","Allows for faster rate \n of gathering from rocks","orange",14);
        }
        else if(text.equals("defence") && !textLabel.equals("")){
            super.display(textLabel,Integer.toString(field.defenceLevel)+"/35","orange",20);
        }
        else if(text.equals("defence")){
            super.display("","Allows for more resistance to \n enemy attack and special moves","orange",14);
        }
        else if(text.equals("woodcutting") && !textLabel.equals("")){
            super.display(textLabel,Integer.toString(field.woodcuttingLevel)+"/25","orange",20);
        }
        else if(text.equals("woodcutting")){
            super.display("","Allows for faster rate \n of gathering from trees","orange",14);
        }
        else if(text.equals("crafting") && !textLabel.equals("")){
            
            super.display(textLabel,Integer.toString(field.craftingLevel)+"/25","orange",20);
        }
        else if(text.equals("crafting")){
            super.display("","Allows for more \n item crafting options","orange",14); 
        }
        
        else if(text.equals("chop")||text.equals("lunge")||text.equals("block")){
            if(field.style.equals("chop")){
                super.display("","Balanced training, grants XP to \n constitution, attack, defence equally","orange",13);
            }
            else if(field.style.equals("lunge")){
                super.display("","Aggressive training, grants XP to \n only attack","orange",14);
            }
            else if(field.style.equals("block")){
                super.display("","Defensive training, grants XP to \n only defence","orange",14);
            }
        }
    }

    public void checkDeletion(){
        Field field=(Field) getWorld();
        MouseInfo mouse=Greenfoot.getMouseInfo();
        if(field.window.equals("skills") && field.windowDetail.equals(text)){

        }
        else if(field.window.equals("styles") && (text.equals("chop")||text.equals("lunge")||text.equals("block"))){
        }
        else{
            field.removeObject(this);

        }
    }
}
