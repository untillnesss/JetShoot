import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @versdion (a version number or a date)
 */
public class Bullet extends Actor
{

    public Bullet(){
        this.setImage(new GreenfootImage(10,2));
        this.getImage().setColor(Color.RED);
        this.getImage().fillRect(0 , 0, 10, 2);
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        this.move(10);

        this.overlapingScreen();
    }

    private void overlapingScreen(){
        if(this.getWorld() == null) return;

        if(this.isAtEdge()){
            this.getWorld().removeObject(this);
        }
    }
}
