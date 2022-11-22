package com.anjali.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.anjali.gaming.sprites.BlueHole;
import com.anjali.gaming.sprites.Enemy;
import com.anjali.gaming.sprites.Friend;
import com.anjali.gaming.sprites.Player;
import com.anjali.gaming.sprites.Sprite;

public class Board extends JPanel implements Constants{
	
	/**
	 * 
	 */

	//constructor
	BufferedImage bi;
	Player player;
	Friend friend;
	BlueHole bluehole[];
	String gameMessage="";
//	Enemy enemy;
	Enemy enemies[];
	//throw early catch later
	  public Board() throws Exception{
		setSize(1000,600);
		bi=ImageIO.read(Board.class.getResource("game-bg.jpg"));
		player=new Player();
		friend=new Friend();
		bluehole = new BlueHole[3];
		enemies=new Enemy[3];//all enemies are null initial
		loadEnemies();
		loadBlueHole();
		setFocusable(true);
		bindEvents();
		gameLoop();
		
	}
	  void isGameWin() {
		  if(player.outOfScreen()) {
			  gameMessage="GAME WIN";
			  timer.stop();
		  }
	  }
	  boolean isCollide(Sprite one, Sprite two) {
		  int xDistance =Math.abs(getX()-two.getX());
		  int yDistance =Math.abs(getY()-two.getY());
		  int w=Math.max(one.getW(), two.getW());
		  int h=Math.max(one.getH(),two.getH());
		  return xDistance<=w && yDistance<=h;
		  
	  }
	  void checkCollision() {
		  for(Enemy e: enemies) {
			  if(isCollide(player,e)) {
				  gameMessage="Game Over";
				  timer.stop();
			  }
		  }
	  }
	  void printMessage(Graphics pen) {
		  pen.setColor(Color.RED);
		  pen.setFont(new Font("times",Font.BOLD, 40));
		  pen.drawString(gameMessage,BOARD_WIDTH/2,BOARD_HEIGHT/2);
		  
	  }
	  void bindEvents() {
		  this.addKeyListener(new KeyAdapter() {
			  @Override
			  public void keyPressed(KeyEvent e) {
				  //TODO Auto-generated method stub
				  player.move();
				  if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					  player.move();
					  
				  }
			  }
			  
		});
	  }
	  Timer timer;
	  void gameLoop() {
		  //Delay
		  timer=new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("Timer call");
				repaint();
				checkCollision();
				isGameWin();
			}
		});
		  timer.start();
		  
	  }
	  void loadBlueHole() throws Exception
	  {
		  int x=180;
		  int speed=1;
		  final int GAP=200;
		  for(int i=0;i<bluehole.length;i++)
		  {
			  bluehole[i]=new BlueHole(x,speed);
			  x=x+GAP;
		  }
	  }
	  void loadEnemies() throws IOException {
		  int x=200;
		  int speed=8;
		 final int GAP=200;
		  for(int i=0;i<enemies.length;i++) {
			  enemies[i]=new Enemy(x,speed);
			  x=x+GAP;
			  speed+=4;
			  
		  }
	  }
	  void printBlueHole(Graphics pen)
	  {
		  for(BlueHole bg:bluehole)
		  {
			  bg.draw(pen);
//			  bg.move();
		  }
	  }
	  void printEnemies(Graphics pen) {
		  for(Enemy e:enemies) {
			  e.draw(pen);
			  e.move();
	          e.outOfScreen();
		  }
	  }
	//painting on board
	@Override//when you inherit any class then you have chances to change that propertyE.g Michael Jackson
	public void paintComponent(Graphics pen) {
//		pen.setColor(Color.RED);
//		pen.fillRect(10, 50, 70, 50);
//		pen.drawRect(20, 100, 100, 100);
//		pen.drawOval(300, 0, 100,100);
//		pen.setFont(new Font("times",Font.BOLD,50));
//		pen.drawString("game 2022", 300, 300);
		pen.drawImage(bi,0,0,1000,600,null);  
		player.draw(pen);
		friend.draw(pen);
		printBlueHole(pen);
		//enemy.draw(pen);
		printEnemies(pen);
		if(gameMessage.length()>0){
		printMessage(pen);
		}
		
	}
}

