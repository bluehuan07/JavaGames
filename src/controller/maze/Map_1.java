package controller.maze;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Map_1 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Map_1() {
		super();
		this.setBackground(null);
		this.setOpaque(false);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("bpp");
		g.setColor(Color.PINK); 
		g.fillRect(0, 0, 30, 70);
		g.fillRect(80, 0, 80, 80);
		g.fillRect(200, 0, 240, 60);
		g.setColor(Color.orange);
		g.fillRect(30, 140, 240, 30);
		g.setColor(Color.blue);
		g.fillRect(0, 200, 210, 30);
		g.fillRect(300, 110, 100, 120);
	}
	
}
