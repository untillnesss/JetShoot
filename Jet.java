import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jet extends Actor
{
    private int speed = 4;
    /**
     * Act - do whatever the Jet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        this.listenMouse();
        this.listenWSAD();
        this.listenMouseClick();
        this.touchingEnemy();
    }

    private void listenMouse(){
        if(Greenfoot.getMouseInfo() != null){
            this.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        }
    }

    private void listenWSAD(){
        // Gerakin Jet ke atas
        if(Greenfoot.isKeyDown("w")){
            this.setLocation(this.getX(), this.getY() - this.speed);
        }

        // Gerakin Jet ke bawah
        if(Greenfoot.isKeyDown("s")){
            this.setLocation(this.getX(), this.getY() + this.speed);
        }

        // Gerakin Jet ke kiri
        if(Greenfoot.isKeyDown("a")){
            this.setLocation(this.getX() - this.speed, this.getY());
        }

        // Gerakin Jet ke kanan
        if(Greenfoot.isKeyDown("d")){
            this.setLocation(this.getX() + this.speed, this.getY());
        }
    }

    private void listenMouseClick(){
        if(Greenfoot.mousePressed(null)){
            Bullet newBullet = new Bullet();
            newBullet.setRotation(this.getRotation());
            this.getWorld().addObject(newBullet, this.getX(), this.getY());
        }
    }

    private void touchingEnemy(){
        if(this.isTouching(Enemy.class)){
            Actor enemy = this.getOneIntersectingObject(Enemy.class);
            this.getWorld().removeObject(enemy);

            this.getWorld().addObject(new Explosion(this), this.getX(), this.getY());
        }
    }
}
