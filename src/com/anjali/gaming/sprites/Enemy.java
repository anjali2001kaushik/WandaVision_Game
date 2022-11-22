package com.anjali.gaming.sprites;

import java.io.IOException;

import javax.imageio.ImageIO;

import com.anjali.gaming.Constants;


public class Enemy extends Sprite implements Constants{
	public Enemy(int x,int speed)throws IOException{
		this.x=x;
		y=40;
		w=100;
		h=100;
		this.speed=speed;
		bi=ImageIO.read(Enemy.class.getResource("enemy.gif"));
	}
//  @Override
	public void move() {
		y=y+speed;
	}
	public void outOfScreen() {
		if(y>BOARD_HEIGHT) {
			y = 0;
		}
	}
}