package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.List;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1550691097823471818L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH * 9 / 12;
	public static final int P1X = WIDTH / 2, P1Y = HEIGHT / 3, P2X = WIDTH / 2 + 80, P2Y = HEIGHT / 3;
	private KeyInput keyInput;
	

	private Thread thread;

	private boolean running = false;

	private Handler handler;

	public Game() {
		handler = new Handler();
		KeyInput keyInput = new KeyInput(handler);
		this.addKeyListener(keyInput);
		new Window(WIDTH, HEIGHT, "Can I beat you?!", this);

		handler.addObject(new Player(P1X, P1Y, ID.Player));
		handler.addObject(new Player(P2X, P2Y, ID.Player2));
		handler.addObject(new ScreenLogger(WIDTH,HEIGHT,ID.LOG));

	}

	public void initialize() {
		for (GameObject G : handler.object) {
			if (G.id == ID.Player) {
				G.setX(P1X);
				G.setY(P1Y);
			} else if (G.id == ID.Player2) {
				G.setX(P2X);
				G.setY(P2Y);
			}
		}

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > handler.TurnTime) {
				timer += handler.TurnTime;
				System.out.println("FPS: " + frames);
				frames = 0;
				initialize();

			}
		}
		stop();
	}

	private void tick() {
		handler.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);

		g.dispose();
		bs.show();
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
	}
}
