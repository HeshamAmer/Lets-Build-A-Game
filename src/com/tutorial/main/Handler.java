package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	public int TurnTime=1000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public void tick(){
		for (GameObject gameObj:object){
			gameObj.tick();
		}
		
	}
	public void render(Graphics g){
		for (GameObject gameObj:object){
			gameObj.render(g);
		}
			
	}
	public void addObject(GameObject gameObj){
		this.object.add(gameObj);
	}
	public void remove (GameObject gameObj){
		this.object.remove(gameObj);
	}
}
