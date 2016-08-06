package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	public List<String> MoveList;

	private Map<Integer, String> MoveMap;

	public void initMap() {
		MoveMap = new HashMap<Integer, String>();
		MoveMap.put(37, "Left");
		MoveMap.put(38, "Up");
		MoveMap.put(39, "Right");
		MoveMap.put(40, "Down");
	}

	public KeyInput(Handler handler) {
		this.handler = handler;
		initMap();
		MoveList = new ArrayList<String>();
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (GameObject gameObj : handler.object) {
			if (gameObj.id == ID.Player) {
				if (key == KeyEvent.VK_RIGHT) {
					gameObj.setX((gameObj.getX() + 50));

				}
				if (key == KeyEvent.VK_LEFT)
					gameObj.setX(gameObj.getX() - 50);
				if (key == KeyEvent.VK_UP)
					gameObj.setY(gameObj.getY() - 50);
				if (key == KeyEvent.VK_DOWN)
					gameObj.setY(gameObj.getY() + 50);

			}
			if (gameObj.id == ID.LOG) {
				gameObj.setText(MoveMap.get(key));
			}			
			
		}
		
		System.out.println(key);
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	}

}
