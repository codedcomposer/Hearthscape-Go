import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ItemSlot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemSlot extends Actor
{
    int position;
    int x;
    int y;
    boolean init=true;
    boolean visible=true;
    boolean draggingThis=false;
    String file="trans";
    boolean equip=false;
    public ItemSlot(int p){
        position=p;
        
    }

    /**
     * Act - do whatever the ItemSlot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        if(init){
            Field field=(Field) getWorld();
            x=this.getX();
            y=this.getY();
            init=false;
            String file=field.items[position];
            setImage(field.items[position]+".png"); 
        }
        checkEquip();
        checkMoved();
        type();

    }   
    public void checkEquip(){
        Field field=(Field) getWorld();
        if(field.items[position].equals("awpasiimov")){
            equip=true;
        }
        else{
            equip=false;
        }
    }
    public void type(){
        Field field=(Field) getWorld();
        if(field.window.equals("backpack")){
            if(!file.equals(field.items[position])){
                setImage(field.items[position]+".png"); 
                 file=field.items[position];

            }
             if(field.resetTrans && getImage().getTransparency()==50){
                getImage().setTransparency(255);
                field.resetTrans=false;
            }
        }
        else{
            field.removeObject(this);
        }

    }

    public void checkMoved(){
        MouseInfo mouse=Greenfoot.getMouseInfo();
        Field field=(Field) getWorld();
        if(field.window.equals("backpack")){
            if(mouse!=null && mouse.getButton()==1){
                if(Greenfoot.mouseDragged(this)){

                    setLocation(mouse.getX(),mouse.getY());
                    field.dragging=true;
                    draggingThis=true;
                    if(getImage().getTransparency()!=255){
                            getImage().setTransparency(255);
                        }
                }
                else if(Greenfoot.mouseDragEnded(this)){

                    if(mouse.getX()<562){

                        field.dirSpawn(field.items[position]);
                        field.items[position]="trans";
                        getImage().setTransparency(0);
                        setLocation(x,y);

                    }
                    else{
                        getImage().setTransparency(0);
                        fullTransparency();
                        if(field.lastSelected<=27){
                            field.swapItems(position);
                            
                        }
                        getImage().setTransparency(255);
                        field.lastSelected=99;
                        setLocation(x,y);
                        
                    }
                    field.dragging=false;
                    draggingThis=false;
                    
                }
                else if(field.dragging){
                    if(mouse.getX()>this.getX()-19 && mouse.getX()<=this.getX()+19 && mouse.getY()>this.getY()-16 && mouse.getY()<=this.getY()+16){
                        if(!draggingThis ){
                            getImage().setTransparency(50);
                        }
                        else{
                            getImage().setTransparency(255);
                        }
                        field.lastSelected=position;

                    }
                    else{
                        if(field.lastSelected==position){
                            field.lastSelected=99;

                        }
                        if(getImage().getTransparency()!=255){
                            getImage().setTransparency(255);
                        }
                    }

                }
                else{
                    
                        getImage().setTransparency(255);
                    
                }

            }
            else if(mouse!=null && mouse.getButton()==3 && equip && Greenfoot.mouseClicked(this)){
                field.equipItem(field.items[position],position);
            }
        }
       
    }
    public void fullTransparency(){
        Field field=(Field) getWorld();
        if(getImage().getTransparency()!=255){
                            getImage().setTransparency(255);
                            field.resetTrans=true;
                        }
    }
}
