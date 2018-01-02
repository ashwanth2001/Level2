package Ideas;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	double width;
	double height;
	int height2 = (int)height;
	int width2 = (int)width;
	int xNoMove,yNoMove;
	boolean isAlive = true;
	Rectangle collisionBox;
	
	void update(){
		collisionBox.setBounds(x,y,width2,height2);
	}
	void draw(Graphics g){

	}
	public GameObject(){
		collisionBox = new Rectangle(x,y,width2,height2);
	}
}
