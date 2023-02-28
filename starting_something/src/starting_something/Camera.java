package starting_something;

public class Camera {

	public float x, y;
	
	public Camera(float x, float y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public void tick(Player player) {
		x = -player.x + Game.WIDTH / 2;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	
	
}
