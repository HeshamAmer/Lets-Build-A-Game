package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject{
	Random r = new Random();
	String Text;
	public Player(int x, int y, ID id) {
		super(x, y, id);
		
	}

	@Override
	public void tick() {
		
	
	}

	@Override
	public void render(Graphics g) {
		if (id==ID.Player) g.setColor(Color.WHITE);
		if (id==ID.Player2)g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 32);
	}

}
