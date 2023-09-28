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
    int health = 3;

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
        this.fired();
    }

    public void followJet(){
        this.move(1);
        this.turnTowards(this.jet.getX(), this.jet.getY());
    }

    public void fired(){
        Actor bullet = this.getOneIntersectingObject(Bullet.class);
        if(bullet != null){
            this.getWorld().removeObject(bullet);
            this.health--;
        }
        if(this.health == 0){
            this.getWorld().removeObject(this);
        }
    }
}
