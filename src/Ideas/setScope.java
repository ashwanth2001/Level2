package Ideas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class setScope extends GameObject{

	public setScope(int x, int y, int width, int height) {
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
		g.setColor(Color.YELLOW);
		g.drawRect(x, y, (int)width, (int)height);
	}
}

