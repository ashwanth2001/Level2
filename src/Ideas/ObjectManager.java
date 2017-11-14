package Ideas;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;

	private int score = 0;
	int killed = 0;
	int end = 0;
	int num = 0;

	long enemyTimer = 0;
	int enemySpawnTime = 1500;

	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}

		purgeObjects();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public static void main(String[] args) {

	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime && num<50) {
			int y = new Random().nextInt(300) + 250;
			double ySize = 2*y/6.54495*Math.atan(383.6635/(2*(800-y)));
			double xSize = ySize*2;
			addObject(new Intruder(2100, y, xSize, ySize,2100,y));
			enemyTimer = System.currentTimeMillis();
			num+=1;
		}
	}

	public void checkCollision() {		
			for (int j = 0; j < objects.size(); j++) {
				GameObject ob2 = objects.get(j);
				if (ob2.x+ob2.width>500 && ob2.x<500) {
					if(ob2.y+ob2.height>400 && ob2.y<400) {
						//score++;
						//System.out.println(score);
						ob2.isAlive = false;
						killed++;
					}
				}
			}
		}
	
	/*public void checkSW() {
		int mouseXb = MouseInfo.getPointerInfo().getLocation().x-500;
		int mouseYb = MouseInfo.getPointerInfo().getLocation().y-400;
		for (int j = 0; j < objects.size(); j++) {
			GameObject ob2 = objects.get(j);
			
		}
	}*/
	
	public void checkSW() {
		int mouseXb = MouseInfo.getPointerInfo().getLocation().x-500;
		int mouseYb = MouseInfo.getPointerInfo().getLocation().y-500;
		for (int j = 0; j < objects.size(); j++) {
			 GameObject ob2 = objects.get(j);
			 /*if(ob2.x<219-mouseXb&&ob2.y<550-mouseYb) {
				 end = 1;
			 }
			 else if(ob2.x<286-mouseXb&&ob2.y>525-mouseYb) {
				 end = 1;
			 }
			 else if(ob2.x<353-mouseXb&&ob2.y>500-mouseYb) {
				 end = 1;
			 }
			 else if(ob2.x<420-mouseXb){
				 end = 1;
			 }*/
			 
			 
			 /*if(ob2.xNoMove<219 && ob2.yNoMove==550) {
				 end = 1;
			 }
			 else if(ob2.xNoMove<286 && ob2.yNoMove>525) {
				 end = 1;
			 }
			 else if(ob2.xNoMove<353 && ob2.yNoMove>500) {
				 end = 1;
			 }
			 else if(ob2.xNoMove<420){
				 end = 1;
			 }*/
			 if(ob2.x<410-mouseXb) {
				 end = 1;
			 }
		 }
	}
	

	public void reset() {
		objects.clear();
	}
}
