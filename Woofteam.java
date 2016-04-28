//Woofteam.java - Main game
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Woofteam extends JFrame implements ActionListener{
	Timer myTimer;
	Panel game;
	
	public Woofteam(){
		super("Woofteam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,850);
		setResizable(false);
		setVisible(true);
		myTimer = new Timer(10, this);
		game = new Panel(this);
		add(game);
	}

	public static void main(String[]args){
		Woofteam b = new Woofteam();
	}
		
	@Override
	public void actionPerformed(ActionEvent evt){
		game.controls();
		game.updateBullets();
		game.repaint();
	}
	
	public void start(){
		myTimer.start();
	} 
}
//______________________________________________________
//_______________________PANEL__________________________

class Panel extends JPanel implements KeyListener, MouseMotionListener {
	private boolean []keys;
	private Woofteam mainFrame;
	private Player p = new Player(500,500,3,"");
	private int mx, my;
//	Image enemyImg1;
	
	public Panel(Woofteam m){
		keys = new boolean[KeyEvent.KEY_LAST+1];
//		try {
////    		enemyImg1 = new ImageIcon("e1.gif").getImage();
//		} 
//		catch (IOException e) {
//		}
		mainFrame = m;
		setSize(800,850);
		mx = 0;
		my = 0;
        addKeyListener(this);
        addMouseMotionListener(this);
	}
		
    public void addNotify() {
        super.addNotify();
        requestFocus();
        mainFrame.start();
    }
	
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }
    
    public void keyReleased(KeyEvent e) {
    	keys[e.getKeyCode()] = false;
    }
    
    public void updateBullets(){
    	p.updateBullets(mx, my);
    }
   
    public void controls(){
		if(keys[KeyEvent.VK_RIGHT] ){
			p.shoot(mx, my);
		}
		if(keys[KeyEvent.VK_LEFT] ){
		}
		if(keys[KeyEvent.VK_SPACE] ){
		}
	}
	
	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
	}
	public void mouseDragged(MouseEvent e){
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	

    
    public void paintComponent(Graphics g){
    	Font f = new Font("Monospaced",Font.BOLD, 20);
    	g.setFont(f);
    	g.setColor(Color.black);
    	g.fillRect(0, 0, 850,850);
    	g.setColor(Color.red);
    	g.fillRect(p.getX(), p.getY(), 50,50);
    	for(Projectile b : p.getBullets()){
    		g.fillRect(b.getX(), b.getY(), 10, 10);
    	}
    	
//		g.drawImage(playerImg, 125 + 50 * i, 780, this);
						
    }
    
    
    
    
    
    
    
}










