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

	public void updateMenuState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 1000, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("SHOOT EM", 25, 100);
	}

	public void updateGameState() {
		manager.update();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Point hotSpot = new Point(0,0);
	    BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT); 
	    Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");        
	    setCursor(invisibleCursor);
		manager.manageEnemies();
		manager.checkCollision(); 
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 1000, 800);
		manager.draw(g);
		manager.checkCollision();
		g.setColor(Color.GRAY);
		g.fillRect(0, 600, 1000, 200);
		g.setColor(Color.blue);
		g.fillRect(0, 0, 1000, 250);
		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		Area a = new Area(new Rectangle(0, 0, 1000, 800));
		a.subtract(new Area(new Ellipse2D.Double(350, 250, 300, 300)));
		g2d.fill(a);
		g.fillRect(495, 240, 10, 320);
		g.fillRect(340, 395, 320, 10);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
	}

	public void updateEndState() {

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 1000, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("You've been invaded!", 100, 100);
	}

	public GamePanel() {
		timer = new Timer(repeat, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		manager = new ObjectManager();
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
		int Mx = e.getX();
		int My = e.getY();
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
				manager.addObject(new Bullet(495, 395, 10, 10));
				System.out.println("a");
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
