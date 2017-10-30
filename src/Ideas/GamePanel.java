package Ideas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	int repeat = 5;
	Timer timer;
	final int MenuState = 0;
	final int GameState = 1;
	final int EndState = 2;
	int currentState = MenuState;
	Font titleFont;
	ObjectManager manager;
	Back back;
	int bullets;

	public void updateMenuState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 1000, 800);
		g.setColor(Color.GREEN);
		g.fillRect(-1000,450,3000,1000);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Take down 50 ants!", 290, 250);
		g.setColor(Color.RED);
		g.drawString("Save your sandwich!", 280, 350);
	}

	public void updateGameState() {
		manager.manageEnemies();
		manager.update();
		back.update();
	    Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Point hotSpot = new Point(0,0);
	    BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT); 
	    Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");        
	    setCursor(invisibleCursor);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 1000, 800);
		back.draw(g);
		manager.draw(g);
		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		Area a = new Area(new Rectangle(0, 0, 1000, 800));
		a.subtract(new Area(new Ellipse2D.Double(325, 225, 350, 350)));
		g2d.fill(a);
		g.fillRect(495, 240, 10, 320);
		g.fillRect(340, 395, 320, 10);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		String b = Integer.toString(bullets);
		g.drawString("Bullets: " + b,50,100);
		String k = Integer.toString(manager.killed);
		g.drawString("Killed: "+k, 750, 100);

	}

	public void updateEndState() {

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 1000, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("You Lost Your Sandwich!!", 100, 100);
	}

	public GamePanel() {
		timer = new Timer(repeat, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		manager = new ObjectManager();
		back = new Back(-1000,248,3000,1000);
		bullets = 75;
	}

	void start() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MenuState) {
			drawMenuState(g);
		} else if (currentState == GameState) {
			drawGameState(g);
		} else if (currentState == EndState) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MenuState) {
			updateMenuState();
		} else if (currentState == GameState) {
			updateGameState();
		} else if (currentState == EndState) {
			updateEndState();
		}
	}

	public void mouseMoved(MouseEvent e) {
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == EndState) {
				currentState = MenuState;
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				manager.checkCollision();
				bullets--;
			}
			revalidate();
			repaint();
		}
}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
