//Player Class

public class Player{
	private int hp, x, y, l, w, speed ;
	private String state;
	
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
	
	
}