package com.anjali.gaming.sprites; 

import java.io.IOException;

import javax.imageio.ImageIO;
public class Friend extends Sprite{
	public Friend()throws IOException{
		x=850;
		y=330;
		w=100;
		h=150;
		bi=ImageIO.read(Friend.class.getResource("friend.gif"));
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
