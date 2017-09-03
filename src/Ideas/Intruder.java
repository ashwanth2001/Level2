package Ideas;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Intruder extends GameObject{
	int speed;

	public Intruder(int x, int y, int width, int height, int speed) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		speed = 4;
	}

	void update() {
		super.update();
		y = y - speed;
		if (y < 0) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}
}
