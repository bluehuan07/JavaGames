package controller.maze;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Coin_2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int x = 0;
	int y = 0;
	
	public Coin_2() {
		super();
		this.setBackground(null);
		this.setOpaque(false);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("bpp");
		g.setColor(Color.yellow);
		g.fillOval(x, y, 10, 10);
	}

}
