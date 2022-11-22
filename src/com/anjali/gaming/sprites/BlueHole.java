package com.anjali.gaming.sprites;

import javax.imageio.ImageIO;

public class BlueHole extends Sprite {
	public BlueHole(int x,int speed) throws Exception
	{
		this.x=x;
		this.speed=speed;
		y=0;
		w=150;
		h=150;
		bi=ImageIO.read(BlueHole.class.getResource("bluehole.gif"));
	}
	@Override
	public void move() {
	}
}
