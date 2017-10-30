package Ideas;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;

	private int score = 0;
	int killed = 0;

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
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			int y = new Random().nextInt(300) + 250;
			double ySize = 2*y/6.54495*Math.atan(383.6635/(2*(800-y)));
			addObject(new Intruder(1500, y, ySize, ySize));
			enemyTimer = System.currentTimeMillis();
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


	public void reset() {
		objects.clear();
	}
}
