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
		game.move();
		game.repaint();
	}
	
	public void start(){
		myTimer.start();
	} 
}
//______________________________________________________
//_______________________PANEL__________________________

class Panel extends JPanel implements KeyListener{
	private boolean []keys;
	private Woofteam mainFrame;
//	Image enemyImg1;
	
	public Panel(Woofteam m){
		keys = new boolean[KeyEvent.KEY_LAST+1];
		try {
//    		enemyImg1 = new ImageIcon("e1.gif").getImage();
		} 
		catch (IOException e) {
		}
		mainFrame = m;
		setSize(800,850);
        addKeyListener(this);
		
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
   
    public void controls(){
		if(keys[KeyEvent.VK_RIGHT] ){
			p1.moveR();
		}
		if(keys[KeyEvent.VK_LEFT] ){
			p1.moveL();
		}
		if(keys[KeyEvent.VK_SPACE] ){
			if (p1.getBullet().getX() == p1.getBullet().getdummyX() && p1.getBullet().getY() == p1.getBullet().getdummyY()){
				p1.shoot();
			}
		}
	}
	
	public void move(){
		//all movement is controlled through this method
		
	}
    
    public void paintComponent(Graphics g){
    	Font f = new Font("Monospaced",Font.BOLD, 20);
    	g.setFont(f);
    	g.setColor(Color.black);
    	g.drawRectangle();
//		g.drawImage(playerImg, 125 + 50 * i, 780, this);
						
    }
    
    
    
    
    
    
    
}










