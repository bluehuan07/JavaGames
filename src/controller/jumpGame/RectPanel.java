package controller.jumpGame;

import java.awt.Graphics;
import javax.swing.JPanel;

public class RectPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	int x = 210;
	private static final int y = 200;
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;

	public RectPanel() {
		this.setBackground(null);
		this.setOpaque(false);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("RP pc");
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	public void moveRP() {
		/* 方塊往前移動 */
		System.out.println("moveRP");
		if (x == -60) {
			x = 210;
		}
		x = x - 30;
	}

}
