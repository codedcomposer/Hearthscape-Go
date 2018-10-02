import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CraftingInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CraftingInterface extends Actor
{
    String craftPage="";
    boolean canCraft=false;
    /**
     * Act - do whatever the CraftingInterface wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkCraftClicked();
        checkChangedCraft();
        checkClose();
        checkDeletion();
    }    

    public void checkClose(){
        MouseInfo mouse=Greenfoot.getMouseInfo();
        Field field=(Field) getWorld();
        if(Greenfoot.mousePressed(null) && mouse.getY()<=164 && mouse.getY()>=151 && mouse.getX()>=518 && mouse.getX()<=530){
            field.windowDetail="";
        }
    }

    public void checkDeletion(){
        Field field=(Field) getWorld();
        if(!field.windowDetail.equals("craftinginterface")){
            field.removeObject(this);
        }
    }

    public void checkChangedCraft(){
        Field field=(Field) getWorld();
        if(!craftPage.equals(field.craftPage)){
            craftPage=field.craftPage;
            checkCanCraft();
        }
    }

    public void checkCanCraft(){
        Field field=(Field) getWorld();

        String craftItem[]=field.craftPage();
        int j=0;
        int k=0;
        String craftMaterials[]=new String[28];
        for(int i =0; i<28;i++){
            craftMaterials[i]=field.items[i];
        }
        for(j=0;j<craftItem.length;j++){
            k=0;
            while(k<craftMaterials.length && !craftMaterials[k].equals(craftItem[j])  ){
                k++;
            }
            if(k>=craftMaterials.length){

                canCraft=false;
                j=99;
                setImage("craftinginterfaceno.png");
            }
            else{
                craftMaterials[k]="trans";
            }
        }
        if(j!=99){
            if(j==craftItem.length){
                canCraft=true;
                setImage("craftinginterface.png");
            }
        }
        else{
            canCraft=false;
        }
    }

    public void checkCraftClicked(){
        MouseInfo mouse=Greenfoot.getMouseInfo();
        Field field=(Field) getWorld();
        if(Greenfoot.mousePressed(null) && mouse.getY()<=460 && mouse.getY()>=432 && mouse.getX()>=279 && mouse.getX()<=509 && canCraft){
            field.craftItem();
            checkCanCraft();
        }
    }
}
