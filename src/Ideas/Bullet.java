package Ideas;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{
	public Bullet(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.collisionBox = new Rectangle(x,y,width,height);
	}

	void update() {
		super.update();
	}

	void draw(Graphics g) {
	}
}
