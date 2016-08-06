package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class ScreenLogger extends GameObject {

	private static Font serifFont = new Font("Serif", Font.BOLD, 24);
	protected String text="Hello world!";

	public ScreenLogger(int x, int y, ID id) {
		super(x, y, id);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		g.setFont(serifFont);
		FontMetrics fm = g.getFontMetrics();
		int w = fm.stringWidth(text);
		int h = fm.getAscent();
		g.drawString(text, 60 - (w / 2), 10 + (h / 4));

	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
