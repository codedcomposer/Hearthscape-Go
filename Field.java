import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.*;
/**
 * Write a description of class Field here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Field extends World
{
    private GreenfootImage bgImage = new GreenfootImage("field.png");
    ArrayList itemList=new ArrayList();
    String craftRewards[]={"plank1","plank2","metal1","metal2","metal3","treasurechest1","pack1"};
    String checkItems[]= new String[28];
    String spells[]=new String[6];
    String items[]=new String[28];
    String equips[]=new String[4];
    String spellequips[]=new String [2];
    String none[]={"trans"};
    String craftPack1[]={"plank","plank"};
    String craftPack2[]={"metal","metal"};
    String craftPlank1[]={"oaklog"};
    String craftPlank2[]={"maplelog"};
    String craftMetal1[]={"ironore"};
    String craftMetal2[]={"mithrilore"};
    String craftMetal3[]={"runeore"};

    String craftPage="craftoptionplank1";
    int craftPageCount=0;
    int tempX=0;
    int tempY=0;
    int xCo=0;
    int yCo=0;

    boolean collideLeft=false;
    boolean collideRight=false;
    boolean collideUp=false;
    boolean collideDown=false;

    boolean done=false;
    boolean doneBar=false;
    boolean checkDoing=false;
    boolean treeDrop=false;
    String characterDir="down";
    boolean closeTree=false;
    int xMove=0;
    int yMove=0;
    int value = 100;
    int x=-1000;
    int y=-1000;

    int hitpointsLevel=1;
    int attackLevel=1;
    int craftingLevel=1;
    int defenceLevel=1;
    int woodcuttingLevel=1;
    int miningLevel=1;

    int hitpointsXP=0;
    int attackXP=0;
    int craftingXP=0;
    int defenceXP=0;
    int woodcuttingXP=0;
    int miningXP=0;

    String window="backpack";
    String windowDetail="";
    int i=0;
    boolean skillsHovering=false;
    String style="chop";
    boolean full=false;
    boolean dragging=false;

    boolean closeST=false;
    boolean closeRR=false;
    boolean closeIR=false;
    boolean closeTP=false;
    boolean closeMT=false;
    boolean closeMR=false;

    boolean checkSwap=false;
    int timer=0;
    int lastSelected;
    boolean resetTrans=false;

    double falloutTimerCount = 100;
    double nukeTimerCount = 30;
    /**
     * Constructor for objects of class Field.
     * 
     */
    public Field()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }

    public void act(){
        checkFull();
        craftPage();
        showDoIt();
        checkAnyClose();
        spawnEnemy();
        checkSwapCounter();
        if (Greenfoot.isKeyDown("o")) {
            GreenfootSound welcome = new GreenfootSound("patron.mp3");
            welcome.setVolume(80);
            welcome.play();

        }
    }

    public String[] craftPage(){
        if(craftPageCount<0){
            craftPageCount=0;
        }
        else if(craftPageCount>6){
            craftPageCount=6;
        }
        if(craftPageCount==0){
            craftPage="craftoptionplank1";
            return craftPlank1;
        }
        else if(craftPageCount==1){
            craftPage="craftoptionplank2";
            return craftPlank2;
        }
        else if(craftPageCount==2){
            craftPage="craftoptionmetal1";
            return craftMetal1;
        }
        else if(craftPageCount==3){
            craftPage="craftoptionmetal2";
            return craftMetal2;
        }
        else if(craftPageCount==4){
            craftPage="craftoptionmetal3";
            return craftMetal3;
        }
        else if(craftPageCount==5){
            craftPage="craftoptionchest1";
            return craftPack1;
        }
        else if(craftPageCount==6){
            craftPage="craftoptionpack2";
            return craftPack2;
        }
        return none;
    }

    public void checkSwapCounter(){
        if(checkSwap && timer<10){
            timer++;
        }
        else if(checkSwap && timer>=10){
            timer=0;
            checkSwap=false;
        }
        else{
            timer=0;
        }
    }

    public void swapItems(int pos){
        String ph1=items[pos];
        String ph2=items[lastSelected];
        items[pos]=ph2;
        items[lastSelected]=ph1;
    }

    public void checkAnyClose(){
        if(!closeST && !closeRR && !closeIR && !closeTP && !closeMT && !closeMR){
            closeTree=false;
        }
    }

    public void checkFull(){
        int i=0;
        boolean checkFull=true;
        while(i<28){
            if(items[i].equals("trans")){
                checkFull=false;

            }
            i++;
        }
        if(checkFull){
            full=true;
        }
        else{
            full=false;
        }
    }

    public boolean storeItem(String item){
        int i=0;

        if(!full){
            while(i<=27 && !items[i].equals("trans")){
                i++;
            }
            if(i<=27){
                items[i]=item;  
                return true;
            }
        }
        return false;
    }

    public boolean storeItem(String[] check,String item){
        int i=0;

        while(i<=27 && !check[i].equals("trans")){
            i++;
        }
        if(i<=27){
            check[i]=item;  
            return true;
        }

        return false;
    }

    public void craftItem(){
        String checkCraft[]=craftPage();
        for(int i =0;i<28;i++){
            checkItems[i]=items[i];
        }

        for(int i=0;i<checkCraft.length;i++){
            int index=0;
            while(index<28 && !checkItems[index].equals(checkCraft[i])){
                index++;
            }
            if(index<=27){
                checkItems[index]="trans";
            }
        }
        String ph = craftRewards[craftPageCount];
        String c=ph.substring(ph.length()-1,ph.length());
        int count = Integer.valueOf(c);
        c=ph.substring(0,ph.length()-1);
        int checkSpaces=0;
        for(int i=0;i<=27;i++){
            if(checkItems[i].equals("trans")){
                checkSpaces++; 
            }
        }
        if(checkSpaces>=count){
            for(int i=0;i<count;i++){
                storeItem(checkItems,c);

            }  
            for(int i =0;i<28;i++){
                items[i]=checkItems[i];
            }
        }
    }

    public boolean equipItem(String item,int index){

        if(item.equals("awpasiimov")){
            int i=0;
            for(i=0;i<2;i++){
                if(equips[i].equals("trans") &&i<=1){
                    equips[i]=item;            
                    items[index]="trans";
                    return true;
                }
            }
        }

        return false;
    }

    public boolean equipSpell(int index){
        int i=0;

        while(i<2 && !spellequips[i].equals("trans")){
            i++;
        }
        if(i<2){
            String equippingSpell=spells[index];
            spellequips[i]=equippingSpell;
            spells[index]="trans";
            return true;
        }
        return false;
    }
    public void unequipSpell(int index){
        int i=0;
        while(i<6 && !spells[i].equals("trans")){
            i++;
        }
        if(i<6){
            String unequippingSpell=spellequips[index];
            spells[i]=unequippingSpell;
            spellequips[index]="trans";
        }
        
    }
    public boolean unequipItem(String item, int index){
        if(storeItem(item)){

            equips[index]="trans";
            return true;
        }
        return false;

    }

    public void checkXP(){
        checkAttackXP();
        checkHitpointsXP();
        checkDefenceXP();
        checkCraftingXP();
        checkWoodcuttingXP();
        checkMiningXP();
    }

    public void checkAttackXP(){
        int max=60+(int)Math.pow(attackLevel,1.3);
        if(attackXP>=max){
            attackXP=attackXP-max;
            attackLevel++;
        }
    }

    public void checkHitpointsXP(){
        int max=60+(int)Math.pow(hitpointsLevel,1.3);
        if(hitpointsXP>=max){
            hitpointsXP=hitpointsXP-max;
            hitpointsLevel++;
        }
    }

    public void checkDefenceXP(){
        int max=60+(int)Math.pow(defenceLevel,1.3);
        if(defenceXP>=max){
            defenceXP=defenceXP-max;
            defenceLevel++;
        }
    }

    public void checkCraftingXP(){
        int max=60+(int)Math.pow(craftingLevel,1.3);
        if(craftingXP>=max){
            craftingXP=craftingXP-max;
            craftingLevel++;
        }
    }

    public void checkWoodcuttingXP(){
        int max=60+(int)Math.pow(woodcuttingLevel,1.75);
        if(woodcuttingXP>=max){
            woodcuttingXP=woodcuttingXP-max;
            woodcuttingLevel++;
        }
    }

    public void checkMiningXP(){
        int max=60+(int)Math.pow(miningLevel,1.75);
        if(miningXP>=max){
            miningXP=miningXP-max;
            miningLevel++;
        }
    }

    public void fieldMove(int xIncrease, int yIncrease) {
        xMove=xIncrease;
        yMove=yIncrease;
        tempX+=xCo-(xCo+xIncrease);
        xCo+=xIncrease;
        tempY+=yCo-(yCo+yIncrease);
        yCo+=yIncrease;
        if(tempX>=600 || tempX<=-600){
            tempX=0;
        }
        if(tempY>=600 || tempY<=-600){
            tempY=0;
        }
        getBackground().drawImage(bgImage, tempX, tempY);
        getBackground().drawImage(bgImage, tempX + bgImage.getWidth(), tempY);
        getBackground().drawImage(bgImage, tempX - bgImage.getWidth(), tempY);
        getBackground().drawImage(bgImage,tempX , tempY-600);
        getBackground().drawImage(bgImage, tempX, tempY+600);
        getBackground().drawImage(bgImage,tempX+bgImage.getWidth() , tempY-600);
        getBackground().drawImage(bgImage,tempX-bgImage.getWidth() , tempY-600);
        getBackground().drawImage(bgImage,tempX+bgImage.getWidth() , tempY+600);
        getBackground().drawImage(bgImage,tempX-bgImage.getWidth() , tempY+600);

    }

    public void resetMoveValue(){
        xMove=0;
        yMove=0;
    }

    public int getXCo(){
        return xCo;
    }

    public int getYCo(){
        return yCo;
    }

    public void collides(String dir){
        if(dir.equals("left")){
            collideLeft=true;
        }

        if(dir.equals("right")){
            collideRight=true;
        }
        if(dir.equals("up")){
            collideUp=true;
        }
        if(dir.equals("down")){
            collideDown=true;
        }
    }

    public void resetCollides(String dir){
        if(dir.equals("left")){
            collideLeft=false;
        }
        if(dir.equals("right")){
            collideRight=false;
        }
        if(dir.equals("up")){
            collideUp=false;
        }
        if(dir.equals("down")){
            collideDown=false;
        }
    }

    public void paintOrder(Class c){
        setPaintOrder(ItemDrop.class);
        setPaintOrder(c);

        setPaintOrder(AvatarBack.class);
        setPaintOrder(Avatar.class);
        setPaintOrder(DoIt.class);
        setPaintOrder(Bar.class);
        setPaintOrder(HUD.class);
        setPaintOrder(Chest.class);
        setPaintOrder(Hitpoints.class);
        setPaintOrder(HitpointsLevel.class);
        setPaintOrder(Attack.class);
        setPaintOrder(AttackLevel.class);
        setPaintOrder(Mining.class);
        setPaintOrder(MiningLevel.class);
        setPaintOrder(Crafting.class);
        setPaintOrder(CraftingLevel.class);
        setPaintOrder(Woodcutting.class);
        setPaintOrder(WoodcuttingLevel.class);
        setPaintOrder(Defence.class);
        setPaintOrder(DefenceLevel.class);
        setPaintOrder(Dynamic.class);
        setPaintOrder(XPBar.class);
        setPaintOrder(ChopStyle.class);
        setPaintOrder(LungeStyle.class);
        setPaintOrder(BlockStyle.class);
        setPaintOrder(ItemSlot.class);
        setPaintOrder(EquipSlot.class);
        setPaintOrder(Equip.class);
        setPaintOrder(CraftButton.class);
        setPaintOrder(CraftingInterface.class);
        setPaintOrder(CraftOption.class);
        setPaintOrder(LeftArrow.class);
        setPaintOrder(RightArrow.class);
        setPaintOrder(CraftingItem.class);
        setPaintOrder(DynamicCraft.class);

        //setPaintOrder(Abilities.class);
        setPaintOrder(SpellSlot.class);
        setPaintOrder(EquippedSpell.class);

        setPaintOrder(BuckshotIcon.class);
        setPaintOrder(QuickdrawIcon.class);
        setPaintOrder(FirestrikeIcon.class);
    }

    public void showDoIt(){
        if(Greenfoot.isKeyDown(" ") && !done && !doneBar && closeTree){
            DoIt doit = new DoIt();
            addObject(doit, 680, 128);
            Bar bar = new Bar();
            addObject(bar,682,246);
        }

    }

    public void assignDrop(String str){
        if(str.equals("SmallTree")){
            woodcuttingXP+=60;
            dirSpawn("oaklog");
        } else if (str.equals("MapleTree")) {
            woodcuttingXP+=60;
            dirSpawn("maplelog");
        }  else if (str.equals("IronRock")) {
            miningXP+=60;
            dirSpawn("ironore");
        } else if (str.equals("MithrilRock")) {
            miningXP+=60;
            dirSpawn("mithrilore");
        } else if (str.equals("RuneRock")) {
            miningXP+=60;
            dirSpawn("runeore");
        }
        else if (str.equals("TomatoPlant")) {
            craftingXP+=60;
            dirSpawn("tomato");
        }
    }

    public void dirSpawn(String item){
        if(characterDir.equals("up")){
            spawn(item,0,-35);
        }
        else if(characterDir.equals("down")){
            spawn(item,0,+35);
        }
        else if(characterDir.equals("left")){
            spawn(item,-35,0);
        }
        else if(characterDir.equals("right")){
            spawn(item,+35,0);
        }
        else if(characterDir.equals("upright")){
            spawn(item,+35,-35);
        }
        else if(characterDir.equals("upleft")){
            spawn(item,-35,-35);
        }
        else if(characterDir.equals("downleft")){
            spawn(item,-35,+35);
        }
        else if(characterDir.equals("downright")){
            spawn(item,+35,+35);
        }
    }

    public void spawn(String item, int x, int y){
        addObject(new ItemDrop(xCo+x,yCo+y,item),300+x,300+y);
    }

    public void spawnEnemy(){
        if(Greenfoot.getRandomNumber(100)==1){
            int num=5;
            num=Greenfoot.getRandomNumber(4);
            if(num==0){
                Bomber bomber=new Bomber();
                addObject(bomber,Greenfoot.getRandomNumber(601),600);
            }
            else if(num==1){
                Bomber bomber=new Bomber();
                addObject(bomber,Greenfoot.getRandomNumber(601),0);
            }
            else if(num==2){
                Bomber bomber=new Bomber();
                addObject(bomber,600,Greenfoot.getRandomNumber(601));
            }
            else if(num==3){
                Bomber bomber=new Bomber();
                addObject(bomber,0,Greenfoot.getRandomNumber(601));
            }
            paintOrder(Bomber.class);
        }
    }

    public void prepareResources(){ //random number includes 0 and excludes the limit
        Random r = new Random();
        int ran = r.nextInt(3)+1;
        int ran2 = r.nextInt(3)+1;

        while(x<=1000 || y<=1000){
            if(x>=1000){
                y+=(Greenfoot.getRandomNumber(50)+90);
                x=-1000;
            }
            else{
                x+=(Greenfoot.getRandomNumber(50)+50);
            }

            if(Greenfoot.getRandomNumber(7)==2){
                int rand1=(Greenfoot.getRandomNumber(20)+20)-(Greenfoot.getRandomNumber(20)+20);
                int rand2=(Greenfoot.getRandomNumber(20)+20)-(Greenfoot.getRandomNumber(20)+20);

                if(Greenfoot.getRandomNumber(2)==0){
                    ran = r.nextInt(5)+1; //1,2,3,4,5,6
                    if(ran ==1) {
                        addObject(new SmallTree(x+rand1,y+rand2),0,0);
                    } else if (ran == 2){
                        addObject(new MapleTree(x+rand1,y+rand2),0,0);  
                    } else if (ran == 3){
                        addObject(new IronRock(x+rand1,y+rand2),0,0);
                    } else if (ran == 4) {
                        addObject(new MithrilRock(x+rand1,y+rand2),0,0); 
                    } else if (ran == 5){
                        addObject(new RuneRock(x+rand1,y+rand2),0,0); 
                    } 
                }
            }
        }
    }

    public void addHUD(String type){
        if(type.equals("skills")){
            addObject(new Hitpoints(),635,370);
            addObject(new HitpointsLevel(),644,370);

            addObject(new Attack(),715,370);
            addObject(new AttackLevel(),724,370);

            addObject(new Mining(),635,410);
            addObject(new MiningLevel(),644,410);

            addObject(new Defence(),715,410);
            addObject(new DefenceLevel(),724,410);

            addObject(new Woodcutting(),635,450);
            addObject(new WoodcuttingLevel(),644,450);

            addObject(new Crafting(),715,450);
            addObject(new CraftingLevel(),724,450);
        }
        if(type.equals("styles")){
            addObject(new ChopStyle(),635,390);

            addObject(new LungeStyle(),715,390);

            addObject(new BlockStyle(),675,450);

            if(style.equals("chop")){
                addObject(new Dynamic("","chop"),683,500);
            }
            else if(style.equals("lunge")){
                addObject(new Dynamic("","lunge"),683,500);
            }
            else if(style.equals("block")){
                addObject(new Dynamic("","block"),683,500);
            }
        }
        if(type.equals("backpack")){
            int yPos=368;
            int k=0;
            for(int i=0;i<7;i++){

                addObject(new ItemSlot(k++),625,yPos);

                addObject(new ItemSlot(k++),664,yPos);

                addObject(new ItemSlot(k++),703,yPos);

                addObject(new ItemSlot(k++),742,yPos);
                yPos+=30;
            }
            addObject(new CraftButton(),683,589);
        }
        if(type.equals("equip")){
            addObject(new EquipSlot("weaponslot1"),637,390);
            addObject(new Equip(0),640,395);
            addObject(new EquipSlot("weaponslot2"),723,390);
            addObject(new Equip(1),720,395);
        }

        if (type.equals("spells")){
            addObject(new SpellSlot(0),615,500);
            addObject(new SpellSlot(1),680,500);
            addObject(new SpellSlot(2),745,500);
            addObject(new SpellSlot(3),615,550);
            addObject(new SpellSlot(4),680,550);
            addObject(new SpellSlot(5),745,550);
            addObject(new EquippedSpell(0),644,380);
            addObject(new EquippedSpell(1),725,380);
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Graves graves = new Graves();
        addObject(graves, 297, 302);
        Text text = new Text();
        addObject(text, 36, 569);
        removeObject(text);

        prepareResources();

        HUD hud = new HUD();
        addObject(hud, 452, 445);

        hud.setLocation(681, 452);

        DoIt doit = new DoIt();
        addObject(doit, 416, 377);

        removeObject(doit);

        AvatarBack avatarBack = new AvatarBack();
        addObject(avatarBack, 682, 150);
        setPaintOrder(AvatarBack.class);
        setPaintOrder(Avatar.class);
        setPaintOrder(DoIt.class);
        setPaintOrder(Bar.class);
        setPaintOrder(HUD.class);
        setPaintOrder(Chest.class);
        ValueBar valuebar = new ValueBar();
        addObject(valuebar, 377, 412);
        Bomber bomber = new Bomber();
        addObject(bomber, 515, 215);
        bomber.setLocation(549, 354);
        removeObject(valuebar);
        removeObject(bomber);
        Bomber bomber2 = new Bomber();
        addObject(bomber2, 504, 448);

        Bomber bomber3 = new Bomber();
        addObject(bomber3, 512, 196);
        bomber2.setLocation(506, 422);
        Bomber bomber4 = new Bomber();
        addObject(bomber4, 374, 75);
        Bomber bomber5 = new Bomber();
        addObject(bomber5, 200, 87);
        Bomber bomber6 = new Bomber();
        addObject(bomber6, 40, 223);
        Bomber bomber7 = new Bomber();
        addObject(bomber7, 41, 367);
        Bomber bomber8 = new Bomber();
        addObject(bomber8, 183, 529);
        Bomber bomber9 = new Bomber();
        addObject(bomber9, 394, 530);
        Avatar avatar2 = new Avatar();
        addObject(avatar2, 681, 110);
        //avatar2.setLocation(684, 133);

        Health health = new Health();
        addObject(health, 56, 63);
        health.setLocation(56, 69);
        HP hp = new HP();
        addObject(hp, 111, 69);
        hp.setLocation(161, 66);

        hp.setLocation(78, 32);
        health.setLocation(169, 31);

        //add
        //Abilities ability = new Abilities();
        //addObject(ability,680,235);
        //ability.setLocation(560,200);


        // 600 275



        for(int i=0;i<28;i++){
            items[i]="trans";
        }
        for(int i=0;i<4;i++){
            equips[i]="trans";
        }
        for(int i =0;i<6;i++){
            spells[i]="trans";
        }
        for(int i=0;i<2;i++){
            spellequips[i]="trans";
        }
        spells[0]="buckshot";
        spells[1]="dash";
        spells[2]="firestrike";
        spells[3]="buckshot";
        spells[4]="dash";
        spells[5]="firestrike";
        addHUD("backpack");
        addObject(new ItemDrop(50,50,"metal"),50,50);
    }
}
