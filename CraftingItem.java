import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CraftingItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CraftingItem extends Actor
{
    int index;
   String checkCraftPage="keepo";
    String file="trans";
    public CraftingItem(int i){
        index=i;
    }

    /**
     * Act - do whatever the CraftingItem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkPage();
        checkDeletion();
    }    

    public void checkPage(){
        Field field=(Field) getWorld();
        if(!checkCraftPage.equals(field.craftPage)){
            if(field.craftPage.equals("craftoptionplank1")){
                if(index==0){
                    checkCraftPage=field.craftPage;
                   setImage(field.craftPlank1[index]+".png"); 
                }
                else{
                    setImage("trans.png");
                }
            }
            else if(field.craftPage.equals("craftoptionplank2")){
                if(index==0){
                    checkCraftPage=field.craftPage;
                    setImage(field.craftPlank2[index]+".png");
                }
                else{
                    setImage("trans.png");
                }
            }
            else if(field.craftPage.equals("craftoptionmetal1")){
                if(index==0){
                    checkCraftPage=field.craftPage;
                    setImage(field.craftMetal1[index]+".png");
                }
                else{
                    setImage("trans.png");
                }
            }
            else if(field.craftPage.equals("craftoptionmetal2")){
                if(index==0){
                    checkCraftPage=field.craftPage;
                    setImage(field.craftMetal2[index]+".png");
                }
                else{
                    setImage("trans.png");
                }
            }
            else if(field.craftPage.equals("craftoptionmetal3")){
                if(index==0){
                    checkCraftPage=field.craftPage;
                    setImage(field.craftMetal3[index]+".png");                    
                }
                else{
                    setImage("trans.png");
                }
            }
            else if(field.craftPage.equals("craftoptionchest1")){
                if(index<=1){
                    checkCraftPage=field.craftPage;
                    setImage(field.craftPack1[index]+".png");                    
                }
                else{
                    setImage("trans.png");
                }
            }
            else if(field.craftPage.equals("craftoptionpack2")){
                if(index<=1){
                    checkCraftPage=field.craftPage;
                    setImage(field.craftPack2[index]+".png");                    
                }
                else{
                    setImage("trans.png");
                }
            }
        }
    }
    public void checkDeletion(){
        Field field=(Field) getWorld();
        if(!field.windowDetail.equals("craftinginterface")){
            field.removeObject(this);
        }
    }
}
