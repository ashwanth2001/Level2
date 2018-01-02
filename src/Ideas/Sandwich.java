package Ideas;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class Sandwich extends GameObject {

	public Sandwich(int x, int y, double width, double height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		int height2 = (int)height;
		int width2 = (int)width;
		this.collisionBox = new Rectangle(x,y, width2,height2);
	}

	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println(x + "," + y);// these co-ords are relative to the component
	}

	int mouseXa;
	int mouseYa;

	void update() {
		int mouseYb = MouseInfo.getPointerInfo().getLocation().y-400;
		int mouseXb = MouseInfo.getPointerInfo().getLocation().x-500;

		int xdiff = mouseXa - mouseXb;
		int ydiff = mouseYa - mouseYb;
		super.update();
		x = x + xdiff;
		y = y + ydiff;
		mouseYa = MouseInfo.getPointerInfo().getLocation().y-400;
		mouseXa = MouseInfo.getPointerInfo().getLocation().x-500;
	}

	void draw(Graphics g) {
		int xInt = (int)width;
		int yInt = (int)height;
		g.drawImage(GamePanel.SandwichImg, x, y, xInt, yInt, null);
	}
}
