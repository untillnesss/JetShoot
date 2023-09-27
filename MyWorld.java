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
    
    public MyWorld(){
        this(MyWorld.sizeWorld);
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
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Jet jet = new Jet();
        addObject(jet,401,322);
        jet.setLocation(402,404);
    }
}
