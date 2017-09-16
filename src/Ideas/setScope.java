package Ideas;

import java.awt.Rectangle;

public class setScope extends GameObject{

	int speed;
	int x = 395;
	int y = 495;
	int width = 10;
	int height = 10;

	public setScope(int x, int y, int width, int height) {
			super();
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.collisionBox = new Rectangle(x,y,width,height);
		}
}
