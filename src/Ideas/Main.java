package Ideas;

import javax.swing.JFrame;

public class Main {
	JFrame frame;
	static int width = 1000;
	int height = 800;
	GamePanel g;
	public static void main(String args[]) {
		Main main = new Main();
		main.Jsetup();
		
	}
	void Jsetup() {
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public Main() {
		frame = new JFrame();
		g = new GamePanel();
		frame.add(g);
		frame.addKeyListener(g);
	}
}
