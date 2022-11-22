package com.anjali.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements Constants {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//constructor
	GameFrame() throws Exception{
		Board board =new Board();
		
		this.setSize(BOARD_WIDTH,BOARD_HEIGHT);//bina iske kone mein bnega
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Isse frame puri trh se bnd ho jaayega mem se bhi
		setTitle("My Game-2022");
  		setLocationRelativeTo(null);
  		setResizable(false);
		this.add(board);
		setVisible(true);
		
	}
	
	//Timer(Internally thread)-GameLoop
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		GameFrame obj=new GameFrame();
	//	System.out.println(Thread.currentThread());//Thread is like a worker
//		obj.setSize(700,500);//bina iske kone mein bnega
//		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Isse frame puri trh se bnd ho jaayega mem se bhi
//		obj.setVisible(true);
		//ye main ka kaam nhi hai
		
	}

}