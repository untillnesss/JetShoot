import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyHealth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyHealth extends Actor
{
    private int healthMax;
    private int currentHealth;

    public EnemyHealth(int healthMax){
        this.healthMax = healthMax;
        this.drawHealth();
    }

    int map(int x, int in_min, int in_max, int out_min, int out_max)
    {   
        long result = (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
        return (int)result;
    }

    /**
     * Act - do whatever the EnemyHealth wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        this.drawHealth();
    }

    public void setCurrentHealth(int health){
        this.currentHealth = health;
    }

    private void drawHealth(){
        this.setImage(new GreenfootImage(102, 12));
        this.getImage().setColor(Color.WHITE);
        this.getImage().drawRect(0, 0, 101, 11);
        this.getImage().setColor(Color.GREEN);

        int mapHealth = this.map(this.currentHealth, 0, this.healthMax, 0, 100);
        this.getImage().fillRect(1, 1, mapHealth, 10);
    }
}
