import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    Jet jet;
    
    public Enemy(Jet jet){
        this.jet = jet;
        this.setImage("alien1.png");
        this.getImage().scale(50, 50);
        this.getImage().rotate(90);
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        this.followJet();
    }

    public void followJet(){
        this.move(1);
        this.turnTowards(this.jet.getX(), this.jet.getY());
    }
}
