//Projectile class

public class Projectile{
	private int dmg, speed, knockback;
	private double x, y, vx, vy, ang;
	private String type;
	
	public int getX(){return (int)x;}
	public int getY(){return (int)y;}
	
	
	public Projectile(String type, int mx, int my, int px, int py){
		//change dmg, speed, knockback depending on type;
		if (type == "asdf"){
			
		}
		else{
			this.dmg = 5;
			this.speed = 3;
			this.knockback = 1;
		}
		this.x = px;
		this.y = py;
		this.ang = Math.atan((my - py)/(mx - px));
		vx = speed * Math.cos(ang);
		vy = speed * Math.sin(ang);
	}
	
	public void move(){
		x += vx;
		y -= vy;
	}
	
	public boolean outOfBounds(){
		if (this.x > 850 || this.y > 850 || this.x < 0 || this.y < 0){
			return true;
		}
		return false;
	}
	

	
}