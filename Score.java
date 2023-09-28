import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public int score = 0;

    public Score(){
        this.displayScore();
    }

    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        this.displayScore();
    }

    public void displayScore(){
        this.setImage(new GreenfootImage(String.format(" Poin %s ", this.score),  40, Color.BLACK, Color.WHITE));
    }
    
    public void increase(){
        this.score++;
    }
    
    public void decrease(){
        this.score--;
    }
}
