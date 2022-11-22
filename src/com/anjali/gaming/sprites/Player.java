package com.anjali.gaming.sprites;

import java.io.IOException;

import javax.imageio.ImageIO;

import com.anjali.gaming.Constants;


public class Player extends Sprite implements Constants{
	public Player()throws IOException{
		x=20;
		y=350;
		w=100;
		h=180;
		speed=10;
		bi=ImageIO.read(Player.class.getResource("player.gif"));
	}
	public boolean outOfScreen() {
		if(x>BOARD_WIDTH) {
			return true;
		}
		return false;
	}
//	@Override
	public void move() {
		x=x+speed;
	}
}
