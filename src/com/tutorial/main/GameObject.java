package com.tutorial.main;

import java.awt.Graphics;

public abstract class GameObject {
	protected int x,y;
	protected ID id;
	protected int velX,velY;
	protected String text;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public GameObject(int x,int y, ID id){
		this.x=x;
		this.y=y;
		this.id=id;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public void setID(ID id){
		this.id=id;
	}
	public ID getID(){
		return this.id;
	}
	public void setVelX(int velX){
		this.velX=velX;
	}
	public void setVelY(int velY){
		this.velY=velY;
	}
	public int getVelX(){
		return velX;
	}
	public int getVelY(){
		return velY;
	}
}
