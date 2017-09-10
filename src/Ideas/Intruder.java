package Ideas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Intruder extends GameObject{

	public Intruder(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {
		super.update();
		x = x - 1;
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
