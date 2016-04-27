//Weapon class

public class Weapon{
	private int dmg, mag, maxMag;
	private Projectile bullet;
	
	public Weapon(int dmg, int mag, int maxMag, Projectile bullet){
		this.dmg = dmg;
		this.mag = mag;
		this.maxMag = maxMag;
		this.bullet = bullet;
	}
	
}