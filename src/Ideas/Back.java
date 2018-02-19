package Ideas;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Back extends GameObject {
	
	public Back(int x, int y, double width, double height) {
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
		System.out.println(x + "," + y);
	}

	int mouseXa;
	int mouseYa;

	void update() {
		if(mouseYa<400) {
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
	}

	void draw(Graphics g) {
		int xInt = (int)width;
		int yInt = (int)height;
		g.setColor(Color.GREEN);
		g.fillRect(x, y, xInt, yInt);
		g.setColor(Color.RED);
		g.drawLine(x/3+802, y, x+1410, y+(int)height);
		g.setColor(new Color(156, 93, 82));
		for(int i = 0; i<10; i++) {
			g.drawLine(x/3+836+i*33, y, x+1510+100*i, y+(int)height);
		}
		g.drawImage(GamePanel.SandwichImg, 2*x/3+375, y-98, 800, 600, null);
		//g.drawImage(GamePanel.RockImg, x+1500+50, y+50, 80, 100, null);
		//g.drawImage(GamePanel.RockImg, x+1500+200, y+250, 80, 100, null);
		//g.drawImage(GamePanel.RockImg, x+1500+350, y+200, 80, 100, null);
		//g.drawImage(GamePanel.RockImg, x+1500+500, y+100, 80, 100, null);
		//g.drawImage(GamePanel.RockImg, x+1500+650, y+150, 80, 100, null);
	}
}
