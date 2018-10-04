import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Actor
{
    /**
     * Act - do whatever the HUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        showStyles();
        showSkills();
        showSkillsDetails();
        showBackpack();
        showEquip();
        showSpells();
    }  

    public void showSkillsDetails(){
        Field field=(Field) getWorld();
        if(field.window.equals("skills") ){
            MouseInfo mouse=Greenfoot.getMouseInfo();

            if(Greenfoot.mousePressed(null)&&mouse.getX()>=609 && mouse.getX()<=663 && mouse.getY()>=360 && mouse.getY()<=381 && !field.windowDetail.equals("hitpoints")){

                field.addObject(new Dynamic("Constitution: ","hitpoints"),680,480);
                field.addObject(new Dynamic("","hitpoints"),680,500);
                field.addObject(new XPBar("hitpoints"),680,550);
                field.windowDetail="hitpoints";

            }
            else if(Greenfoot.mousePressed(null)&&mouse.getX()>=688 && mouse.getX()<=743 && mouse.getY()>=360 && mouse.getY()<=381 && !field.windowDetail.equals("attack")){

                field.addObject(new Dynamic("Attack: ","attack"),680,480);
                field.addObject(new Dynamic("","attack"),680,500);
                field.addObject(new XPBar("attack"),680,550);
                field.windowDetail="attack";

            }
            else if(Greenfoot.mousePressed(null)&&mouse.getX()>=688 && mouse.getX()<=743 && mouse.getY()>=399 && mouse.getY()<=421 && !field.windowDetail.equals("defence")){

                field.addObject(new Dynamic("Defence: ","defence"),680,480);
                field.addObject(new Dynamic("","defence"),680,500);
                field.addObject(new XPBar("defence"),680,550);
                field.windowDetail="defence";

            }
            else if(Greenfoot.mousePressed(null)&&mouse.getX()>=609 && mouse.getX()<=663 && mouse.getY()>=399 && mouse.getY()<=421 && !field.windowDetail.equals("mining")){

                field.addObject(new Dynamic("Mining: ","mining"),680,480);
                field.addObject(new Dynamic("","mining"),680,500);
                field.addObject(new XPBar("mining"),680,550);
                field.windowDetail="mining";

            }
            else if(Greenfoot.mousePressed(null)&&mouse.getX()>=609 && mouse.getX()<=663 && mouse.getY()>=439 && mouse.getY()<=462 && !field.windowDetail.equals("woodcutting")){

                field.addObject(new Dynamic("Woodcutting: ","woodcutting"),680,480);
                field.addObject(new Dynamic("","woodcutting"),680,500);
                field.addObject(new XPBar("woodcutting"),680,550);
                field.windowDetail="woodcutting";

            }
            else if(Greenfoot.mousePressed(null)&&mouse.getX()>=688 && mouse.getX()<=743 && mouse.getY()>=439 && mouse.getY()<=462 && !field.windowDetail.equals("crafting")){

                field.addObject(new Dynamic("Crafting: ","crafting"),680,480);
                field.addObject(new Dynamic("","crafting"),680,500);
                field.addObject(new XPBar("crafting"),680,550);
                field.windowDetail="crafting";

            }
        }
    }

    public void showStyles(){
        Field field=(Field) getWorld();
        if(Greenfoot.mousePressed(null) && !field.window.equals("styles")){
            MouseInfo mouse=Greenfoot.getMouseInfo();
            if (mouse.getX()>=566 && mouse.getX()<=599 && mouse.getY()<=338 && mouse.getY()>=305) {   
                field.window="styles";
                field.windowDetail="";
                field.addHUD("styles");
            }

        }
    }

    public void showSkills(){
        Field field=(Field) getWorld();
        if(Greenfoot.mousePressed(null) && !field.window.equals("skills")){
            MouseInfo mouse=Greenfoot.getMouseInfo();
            if (mouse.getX()>=599 && mouse.getX()<=634 && mouse.getY()<=338 && mouse.getY()>=305) {   
                field.window="skills";
                field.windowDetail="";
                field.addHUD("skills");
            }

        }
    }

    public void showBackpack(){
        Field field=(Field) getWorld();
        if(Greenfoot.mousePressed(null) && !field.window.equals("backpack")){
            MouseInfo mouse=Greenfoot.getMouseInfo();
            if (mouse.getX()>=670 && mouse.getX()<=699 && mouse.getY()<=338 && mouse.getY()>=305) {   
                field.window="backpack";
                field.addHUD("backpack");
                field.windowDetail="";
            }
        }
    }

    public void showEquip(){
        Field field=(Field) getWorld();
        if(Greenfoot.mousePressed(null) && !field.window.equals("equip")){
            MouseInfo mouse=Greenfoot.getMouseInfo();
            if (mouse.getX()>=701 && mouse.getX()<=733 && mouse.getY()<=338 && mouse.getY()>=305) {   
                field.window="equip";
                field.addHUD("equip");
                field.windowDetail="";
            }
        }
    }

    public void showObjective(){
        Field field=(Field) getWorld();
        if(Greenfoot.mousePressed(null) && !field.window.equals("objective")){
            MouseInfo mouse=Greenfoot.getMouseInfo();

        }
    }

    public void showSpells() { //770 340
        Field field=(Field) getWorld();
        if(Greenfoot.mousePressed(null) && !field.window.equals("spells")){
            MouseInfo mouse=Greenfoot.getMouseInfo();
            if (mouse.getX()>=770 && mouse.getX()<=800 && mouse.getY()<=340 && mouse.getY()>=305) {   
                field.window="spells";
                field.addHUD("spells");
                field.windowDetail="";
            }
        }
    }
}

