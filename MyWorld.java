import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static final int sizeWorld = 800;

    int count = 0;
    int spawnSpeed = 100;
    int spawnRandom = 0;
    Jet jet = new Jet();

    public MyWorld(){
        this(MyWorld.sizeWorld);
        prepare();
    }

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(int sizeWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(sizeWorld, sizeWorld, 1); 
        prepare();
    }

    public void act(){
        this.count++;
        this.spawnEnemy();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        this.addObject(this.jet,this.getWidth() / 2,this.getHeight() / 2);
    }

    private void spawnEnemy(){
        if(this.count % this.spawnSpeed == 0){
            this.spawnRandom = Greenfoot.getRandomNumber(8);
            switch(this.spawnRandom){
                case 0:
                    this.addObject(new Enemy(this.jet), 0, 0);
                    break;
                case 1:
                    this.addObject(new Enemy(this.jet), this.getWidth() / 2, 0);
                    break;
                case 2:
                    this.addObject(new Enemy(this.jet), this.getWidth(), 0);
                    break;
                case 3:
                    this.addObject(new Enemy(this.jet), 0, this.getHeight());
                    break;
                case 4:
                    this.addObject(new Enemy(this.jet), 0, this.getHeight() / 2);
                    break;
                case 5:
                    this.addObject(new Enemy(this.jet), this.getWidth(), this.getHeight());
                    break;
                case 6:
                    this.addObject(new Enemy(this.jet), this.getWidth() / 2, this.getHeight());
                    break;
                case 7:
                    this.addObject(new Enemy(this.jet), this.getWidth(), this.getHeight() / 2);
                    break;
                default:
                    break;
            }
        }
    }
}
