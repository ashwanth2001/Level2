
package Ideas;

import javax.swing.JFrame;

public class Main {
	JFrame frame;
	GamePanel g;
	final static int width = 1000;
	final static int height = 800;
	

public static void main(String args[]) {
		Main main = new Main();
		main.Jsetup();
		
	}
	void Jsetup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setLocation(0,0);
		frame.setVisible(true);
		g.start();
	}
	public Main() {
		frame = new JFrame();
		g = new GamePanel();
		frame.add(g);
		frame.addKeyListener(g);
	}
}
