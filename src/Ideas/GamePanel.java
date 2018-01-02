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
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	int repeat = 5;
	Timer timer;
	final int MenuState = 0;
	final int GameState = 1;
	final int WinState = 2;
	final int LoseState = 3;
	int currentState = MenuState;
	Font titleFont;
	Font subfont;
	ObjectManager manager;
	Back back;
	int bullets;
	Sandwich sw;
	public static BufferedImage AntImg;
	public static BufferedImage SandwichImg;

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
		g.setFont(subfont);
		g.drawString("Don't move this window", 700,750);
	}

	public void updateGameState() {
		manager.manageEnemies();
		manager.update();
		back.update();
		sw.update();
		manager.updateS();
	    Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Point hotSpot = new Point(0,0);
	    BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT); 
	    Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");        
	    setCursor(invisibleCursor);
	    manager.checkSW();
	    if(manager.end ==1) {
	    		currentState = LoseState;
	    }
	    if(manager.killed>49) {
	    		currentState = WinState;
	    }
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 1000, 800);
		back.draw(g);
		manager.draw(g);
		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		Area a = new Area(new Rectangle(0, 0, 1000, 800));
		a.subtract(new Area(new Ellipse2D.Double(500-(manager.size/2), 400-(manager.size/2), manager.size, manager.size)));
		a.subtract(new Area(new Ellipse2D.Double(315, 215, 370, 370)));
		g2d.fill(a);
		g.fillRect(495, 195, 10, 410);
		g.fillRect(295, 395, 410, 10);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		String b = Integer.toString(bullets);
		g.drawString("Bullets: " + b,50,100);
		String k = Integer.toString(manager.killed);
		g.drawString("Killed: "+k, 750, 100);

	}

	public void drawLoseState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 800);
		g.setColor(Color.RED);
		g.setFont(titleFont);
		g.drawString("You Lost Your Sandwich!!", 200, 350);
	}

	public void drawWinState(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 1000, 800);
		g.setColor(Color.GREEN);
		g.fillRect(-1000,450,3000,1000);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Congratulations!", 325, 250);
		g.drawString("You've earned a bite!", 275, 350);
	}

	public GamePanel() {
		timer = new Timer(repeat, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subfont = new Font("Arial", Font.PLAIN, 24);
		back = new Back(-1000,248,3000,1000);
		bullets = 75;
		manager = new ObjectManager();
		sw = new Sandwich(-300, 100, 800, 600);
		try {
			AntImg = ImageIO.read(this.getClass().getResourceAsStream("Ant.png"));
			SandwichImg = ImageIO.read(this.getClass().getResourceAsStream("Sandwich.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void start() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MenuState) {
			drawMenuState(g);
		} else if (currentState == GameState) {
			drawGameState(g);
		} else if (currentState == LoseState) {
			drawLoseState(g);
		} else if (currentState == WinState) {
			drawWinState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == GameState) {
			updateGameState();
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
			//if (currentState == WinState||currentState == LoseState) {
			//	currentState = MenuState;
			//}
			if (currentState == MenuState) {
				currentState=GameState;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE && bullets>0) {
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
