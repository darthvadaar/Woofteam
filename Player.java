//Player Class
import java.util.*;
public class Player{
	private int hp, x, y, l, w, speed ;
	private String state;
	private Set<Projectile> bullets = new HashSet<Projectile>();
	
	public Player(int x, int y, int speed, String state){
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.state = state;
	}

	public int getX(){return x;}
	public int getY(){return y;}
	public int getL(){return l;}
	public int getW(){return w;}
	public Set<Projectile> getBullets(){return bullets;}
	
	public void shoot(int mx, int my){
		Projectile b = new Projectile("", mx, my, x, y);
		bullets.add(b);
	}
	
	public void updateBullets(int mx, int my){
		if (bullets.size() != 0){
			List<Projectile> toRemove = new ArrayList<Projectile>();
			Iterator itr = bullets.iterator();
			while(itr.hasNext()){
				Projectile b = (Projectile)itr.next();
				b.move();
				if(b.outOfBounds()){
					itr.remove();
				}
			}
			
		}
	}
	
}