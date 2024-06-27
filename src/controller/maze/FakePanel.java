package controller.maze;

import java.awt.Graphics;

import javax.swing.JPanel;

public class FakePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final int x = 20;
	private static final int y = 20; // 新增三個球拍屬性的final變數,因為已經確定下來了不會再改
	private static final int WIDTH = 10;
	private static final int HEIGHT = 10;

	public FakePanel() {

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("MU FP p");
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
}
