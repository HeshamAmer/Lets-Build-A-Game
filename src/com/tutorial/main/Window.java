package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7195787688255122847L;
	public Window(int width,int height,String title,Game game){
		JFrame frame = new JFrame(title);
		Dimension D=new Dimension(width,height);
		frame.setMinimumSize(D);
		frame.setPreferredSize(D);
		frame.setMaximumSize(D);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
}
