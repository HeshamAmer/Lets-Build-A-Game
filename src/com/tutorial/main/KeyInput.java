package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	public KeyInput(Handler handler){
		this.handler=handler;
	}
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		for (GameObject gameObj:handler.object){
			if (gameObj.id==ID.Player)
			{
				if (key==KeyEvent.VK_RIGHT)	gameObj.setVelX(gameObj.getVelX()+3);
				if (key==KeyEvent.VK_LEFT)	gameObj.setVelX(gameObj.getVelX()-3);
				if (key==KeyEvent.VK_UP)	gameObj.setVelY(gameObj.getVelY()-3);
				if (key==KeyEvent.VK_DOWN)	gameObj.setVelY(gameObj.getVelY()+3);
				
				
			}
			if (gameObj.id==ID.Player2){
				if (key==KeyEvent.VK_D)
				{
					gameObj.setVelX(3);
				}
			}
		}
		System.out.println(key);
	}
	public void keyReleased(KeyEvent e){
		int key=e.getKeyCode();
	}
	

}
