package Ideas;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;

	private int score = 0;

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

	private void purgeObjects() {
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
			addObject(new Intruder(1000, y, ySize, ySize));
			enemyTimer = System.currentTimeMillis();
		}
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				if (o1.collisionBox.intersects(o2.collisionBox)) {
					if ((o1 instanceof Intruder && o2 instanceof Bullet)
							|| (o2 instanceof Intruder && o1 instanceof Bullet)) {
						score++;
						System.out.println(score);
						o1.isAlive = false;
						o2.isAlive = false;
					} //else if ((o1 instanceof Intruder && o2 instanceof setScope)
							//|| (o2 instanceof Intruder && o1 instanceof setScope)) {
						//o1.isAlive = false;
						//o2.isAlive = false;
					}

				}
			}
		}

	//}
	public void reset() {
		objects.clear();
	}
}
