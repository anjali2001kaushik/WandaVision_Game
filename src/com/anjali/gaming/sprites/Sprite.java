package com.anjali.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

//parent classes are the most generic class they don't have objects.
public abstract class Sprite {
	//By default it has default scope
		int x;
		int y;
		int w;
		int h;
		BufferedImage bi;
		int speed;
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getW() {
			return w;
		}
		public void setW(int w) {
			this.w = w;
		}
		public int getH() {
			return h;
		}
		public void setH(int h) {
			this.h = h;
		}
		public BufferedImage getBi() {
			return bi;
		}
		public void setBi(BufferedImage bi) {
			this.bi = bi;
		}
		public int getSpeed() {
			return speed;
		}
		public void setSpeed(int speed) {
			this.speed = speed;
		}
		
		public void draw(Graphics pen) {
			pen.drawImage(bi, x, y, w,h,null);
			
		}
		public abstract void move();
		
}
