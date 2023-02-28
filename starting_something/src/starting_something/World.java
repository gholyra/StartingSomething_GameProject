package starting_something;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {

	public static List<Blocks> blocks = new ArrayList<Blocks>();
	
	public World() {
		for(int xx = 0; xx < 14; xx++) {
			for(int yy = 15; yy > 8; yy--) {
				blocks.add(new Blocks(xx*32, yy*32));
			}
		}
	}
	
	public static boolean isFree(int x, int y) {
		for(int i = 0; i < blocks.size(); i++) {
			Blocks blocoAtual = blocks.get(i);
			if(blocoAtual.intersects(new Rectangle(x, y, 32, 32))) {
				return false;
			}
		}
		return true;
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < blocks.size(); i++) {
			blocks.get(i).render(g);
		}
	}
}
