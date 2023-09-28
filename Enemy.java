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
    Score score;
    int health = 3;
    EnemyHealth enemyHealth;

    public Enemy(Jet jet, Score score){
        this.jet = jet;
        this.score = score;

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
        if(this.enemyHealth == null){
            this.enemyHealth = new EnemyHealth(this.health);
            this.getWorld().addObject(this.enemyHealth, this.getX(), this.getY());
        }

        this.followJet();
        this.fired();

        if(this.getWorld() == null) return;

        this.enemyHealth.setLocation(this.getX(), this.getY() - 40);
        this.enemyHealth.setCurrentHealth(this.health);
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
            this.destory();

            this.score.increase();
        }
    }

    public void destory(){
        this.getWorld().removeObject(this.enemyHealth);
        this.getWorld().removeObject(this);
    }
}
