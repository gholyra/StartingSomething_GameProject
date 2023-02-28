package starting_something;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{

	public int spd = 3;
	public boolean right, left, jump, down;
	
	public int velY, velX;
	
	public int gravity = 3;
	public int initialYPos;
	public int velJump = 8;
	
	public Player(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void tick() {
		
		x += (velX * spd);
		
		if(velY < gravity) {
			velY += 1;
		}
		
		if(World.isFree(x, y + velY)) {
			y += velY;
		} else {
			velY = 0;
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE); //Seta a cor do elemento gr�fico que ser� criado
		g.fillRect(x, y, 32, 32);
	}
	
}
