package Ideas;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;

	int killed = 0;
	int end = 0;
	int num = 0;
	int size = 1026;

	long enemyTimer = 0;
	int enemySpawnTime = 2000;

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
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime&&num<60) {
			int y = new Random().nextInt(300) + 250;
			double ySize = 2*y/6.54495*Math.atan(383.6635/(2*(800-y)));
			double xSize = ySize*2;
			addObject(new Intruder(2100, y, xSize, ySize,2100,y));
			enemyTimer = System.currentTimeMillis();
			num++;
			enemySpawnTime-=15;
		}
	}
	
	public void checkCollision() {		
			for (int j = 0; j < objects.size(); j++) {
				GameObject ob2 = objects.get(j);
				if (ob2.x+ob2.width>500 && ob2.x<500) {
					if(ob2.y+ob2.height>400 && ob2.y<400) {
						ob2.isAlive = false;
						killed++;
					}
				}
			}
		}
	
	public void checkSW() {
		int mouseXb = MouseInfo.getPointerInfo().getLocation().x-500;
		for (int j = 0; j < objects.size(); j++) {
			 GameObject ob2 = objects.get(j);
			 if(ob2.x<410-mouseXb) {
				 end = 1;
			 }
		 }
	}
	
	public void updateS(){
		if(size>350) {
			size-=5;
		}
	}
	
	public void reset() {
		objects.clear();
	}
}
