package controller.maze;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Map_2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Map_2() {
		super();
		this.setBackground(null);
		this.setOpaque(false);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("bpp");
		g.setColor(Color.PINK); 
		g.fillRect(0, 200, 30, 70);
		g.fillRect(80, 190, 80, 80);
		g.fillRect(200, 210, 240, 60);
	}
	
}
