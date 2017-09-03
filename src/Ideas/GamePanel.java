package Ideas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MenuState = 0;
	final int GameState = 1;
	final int EndState = 2;
	int currentState = MenuState;
	Font titleFont;

	public void updateMenuState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("SHOOT EM", 25, 100);
	}

	public void updateGameState() {

	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
	}

	public void updateEndState() {

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		Graphics2D g2d = (Graphics2D) g;
		Area a = new Area(new Rectangle(50, 50, 100, 100));
		a.subtract(new Area(new Ellipse2D.Double(75, 75, 50, 50)));
		g2d.fill(a);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("You've been invaded!", 100, 100);
	}

	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
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

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
