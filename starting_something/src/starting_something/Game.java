package starting_something;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {

	public static int WIDTH = 480, HEIGHT = 480;
	public static int SCALE = 1;
	public static Player player;
	public World world;
	private Camera camera;
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		player = new Player(128, 128);
		world = new World();
		camera = new Camera(0, 0);
	}
	
	public void tick() {
		player.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.setColor(new Color(27, 26, 33));
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		g.translate(camera.getX(), camera.getY());
		
		player.render(g);
		
		world.render(g);
		
		g.translate(-camera.getX(), -camera.getY());
		
		bs.show();
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.setTitle("Starting Something");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		new Thread(game).start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			player.velX = 1;
		}
		
		else if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			player.velX = -1;
		}
		
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			if(player.velY == 0) {
				player.velY = -player.velJump;
			}
		}
		
		/*
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
		}
		*/
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			player.velX = 0;
		}

		/*
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			player.jump = false;
		}
		
		/*
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}
		*/
	}

}
