import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MapleLog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapleTree extends Entities
{

    public MapleTree(int x, int y){
        super(x,y);
    }

    /**
     * Act - do whatever the SmallTree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Field field=(Field) getWorld();
        move();
        if(getImage().getTransparency()==255){
            checkFacing();
            collide();
            estimateCollide();
            paintBoundary();
            checkDeletion();
        }

    }    

    public void move(){
        Field field=(Field) getWorld();
        setLocation(xCo-field.xCo+300,yCo-field.yCo+300);
        if(!super.outOfBounds() && visible==false && getImage().getTransparency()!=255){
            getImage().setTransparency(255);   
            visible=true;
        }
        else if(outOfBounds() && getImage().getTransparency()!=0){
            getImage().setTransparency(0); 
            visible=false;
        }
    }

    public void collide(){
        Field field=(Field) getWorld();
        if(!closeCollide().equals("none")){
            if(super.contains(closeCollide(),"left")){
                if(getX()<290 && getX()>280 && getY()<290 && getY()>280){
                    field.collides("left");
                }
                else{      
                    field.resetCollides("left");
                }
            }
            if(super.contains(closeCollide(),"right")){
                if(getX()<320 && getX()>=310 && getY()<290 && getY()>280){
                    field.collides("right");
                }
                else{
                    field.resetCollides("right");
                }
            }
            if(super.contains(closeCollide(),"up")){
                if(getY()<=280 & getY()>270 && getX()<320 && getX()>280){
                    field.collides("up");
                }
                else{
                    field.resetCollides("up");
                }
            }
            if(super.contains(closeCollide(),"down")){
                if(getY()<300 & getY()>290 && getX()<320 && getX()>280){
                    field.collides("down");
                }
                else{
                    field.resetCollides("down");
                }
            }
        }
    }

    public String closeCollide(){
        Field field=(Field) getWorld();
        String s="";
        if(getX()<290 && getX()>270 && getY()<310 && getY()>260){
            s+="left";
        }

        if(getX()<330 && getX()>=310 && getY()<310 && getY()>260){
            s+="right";
        }

        if(getY()<=280 & getY()>260 && getX()<330 && getX()>270){
            s+="up";
        }

        if(getY()<310 & getY()>290 && getX()<330 && getX()>270){
            s+="down";
        }
        if(!s.equals("")){
            return s;
        }
        else{
            return "none";
        }
    }

    public void paintBoundary(){
        Field field=(Field) getWorld();
        if(getX()>270 && getX()<330 && getY()>250 && getY()<350){
            if(getY()>280){
                field.paintOrder(MapleTree.class);
            }
            else if(getY()<=280){
                field.paintOrder(Graves.class);
            }
        }
    }

    public void checkDeletion(){
        Field field=(Field) getWorld();
        if(getX()>=250 && getX()<=350 && getY()>=250 && getY()<=350 && field.treeDrop ){
            field.treeDrop=false;
            field.assignDrop("MapleTree");
            field.removeObject(this);
            field.resetCollides("up");
            field.resetCollides("down");
            field.resetCollides("left");
            field.resetCollides("right");
            field.closeTree=false;
        }
    }

    public void checkFacing(){
        Field field=(Field) getWorld();
        if(!closeCollide().equals("none")){
            if(field.characterDir.equals("upleft") && (super.contains(closeCollide(),"up") || super.contains(closeCollide(),"left"))){
                field.closeTree=true;
            }
            else if(field.characterDir.equals("upright") && (super.contains(closeCollide(),"up") || super.contains(closeCollide(),"right"))){
                field.closeTree=true;
            }
            else if(field.characterDir.equals("downright") && (super.contains(closeCollide(),"down") || super.contains(closeCollide(),"right"))){
                field.closeTree=true;
            }
            else if(field.characterDir.equals("downleft") && (super.contains(closeCollide(),"down") || super.contains(closeCollide(),"left"))){
                field.closeTree=true;
            }
            else if(field.characterDir.equals("up") && super.contains(closeCollide(),"up")){
                field.closeTree=true;
            }
            else if(field.characterDir.equals("down") && super.contains(closeCollide(),"down")){
                field.closeTree=true;
            }
            else if(field.characterDir.equals("left") && super.contains(closeCollide(),"left")){
                field.closeTree=true;
            }
            else if(field.characterDir.equals("right") && super.contains(closeCollide(),"right")){
                field.closeTree=true;
            }
            else{
                field.closeTree=false;

            }

        }
    }

    public void estimateCollide(){
        Field field=(Field) getWorld();
        if(getX()<=350 && getX()>=250 && getY()<=350 && getY()>=250){

            field.closeMT=true;
        }
        else{
            field.closeMT=false;
        }
    }
}
