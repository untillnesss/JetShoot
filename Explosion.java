import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    public int count = 0;
    public int frames = 1;
    Jet jet;
    
    public Explosion(Jet jet){
        this.jet = jet;
        this.setImage("explosion_1.png");
        
        Greenfoot.playSound("explosion.wav");
    }
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        this.count++;
        this.animate();
    }
    
    public void animate(){
        if(this.count % 6 == 0){
            this.setImage(String.format("explosion_%s.png", this.frames));
            // this.setLocation(this.jet.getX(), this.jet.getY());
            this.frames++;
            if(this.frames > 7){
                this.frames = 1;
                this.getWorld().removeObject(this);
            }
        }
    }
}
