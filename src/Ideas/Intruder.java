package Ideas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class Intruder extends GameObject {


	public Intruder(int x, int y, double width, double height, int yNoMove, int xNoMove) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		int height2 = (int)height;
		int width2 = (int)width;
		this.xNoMove = xNoMove;
		this.yNoMove = yNoMove;
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
		xNoMove-=1;
		super.update();
		x = x - 1 + xdiff;
		y = y + ydiff;
		mouseYa = MouseInfo.getPointerInfo().getLocation().y-400;
		mouseXa = MouseInfo.getPointerInfo().getLocation().x-500;
	}

	void draw(Graphics g) {
		int xInt = (int)width;
		int yInt = (int)height;
		//g.setColor(Color.BLUE);
		//g.fillRect(x, y, xInt, yInt);
		g.drawImage(GamePanel.AntImg, x, y, xInt, yInt, null);
	}
}
