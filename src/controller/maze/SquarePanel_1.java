package controller.maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class SquarePanel_1 extends JPanel implements KeyListener {

	/* 主角方塊 */
	private static final long serialVersionUID = 1L;
	private static final int size = 30;
	int x = 100; // 小球的預設位置
	int y = 100;
	Boolean bons = false;

	public SquarePanel_1() {
		super();
		this.setBackground(null);
		this.setOpaque(false);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("bpp");
		g.setColor(Color.darkGray); // 設定顏色
		System.out.println("x：" + x + "\ty：" + y);
		g.fillRect(x, y, size, size); // (x軸, y軸, 球的寬度, 球的高度)
		/* 如果找到彩蛋位置 */
		if (bons) {
			g.setColor(Color.yellow);
			g.fillOval(x + 5, y + 5, size - 10, size - 10);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("BP keyPressed");
		if (e.getKeyCode() == 37 && ismove(x, y, e.getKeyCode())) {
			System.out.println(e.getKeyCode());
			x = x - 10; // 往左移動
		}
		if (e.getKeyCode() == 38 && ismove(x, y, e.getKeyCode())) {
			System.out.println(e.getKeyCode());
			y = y - 10; // 往上移動
		}
		if (e.getKeyCode() == 39 && ismove(x, y, e.getKeyCode())) {
			System.out.println(e.getKeyCode());
			x = x + 10; // 往右移動
		}
		if (e.getKeyCode() == 40 && ismove(x, y, e.getKeyCode())) {
			System.out.println(e.getKeyCode());
			y = y + 10; // 往下移動
		}
		if (x == -30) {
			x = 430;
		}
		if (x == 440) {
			x = -20;
		}
		this.repaint();
		System.out.println("BP keyPressed off");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/* 不能走的地方 */
	public boolean ismove(int x, int y, int kc) {
		if (x == 30 && (y >= 0 && y < 70) && kc == 37) {
			return false;
		}
		if (x == 50 && (y >= 0 && y < 80) && kc == 39) {
			return false;
		}
		if (y == 70 && (x >= 0 && x < 30) && kc == 38) {
			return false;
		}
		if (y == 80 && (x >= 60 && x < 160) && kc == 38) {
			return false;
		}
		if (x == 160 && (y >= 0 && y < 80) && kc == 37) {
			return false;
		}
		if (x == 170 && (y >= 0 && y < 60) && kc == 39) {
			return false;
		}
		if (y == 60 && (x >= 180 && x < 460) && kc == 38) {
			return false;
		}
		if (y == 60 && (x >= 410) && kc == 39) {
			return false;
		}
		if (y == 110 && (x >= 10 && x < 270) && kc == 40) {
			return false;
		}
		if (x == 0 && (y >= 120 && y < 170) && kc == 39) {
			return false;
		}
		if (y == 170 && (x >= 10 && x < 270) && kc == 38) {
			return false;
		}
		if (x == 270 && (y >= 120 && y < 170) && kc == 37) {
			return false;
		}
		if (y == 170 && (x >= -20 && x < 200) && kc == 40) {
			return false;
		}
		if (x == 410 && (y >= 180 && y < 230) && kc == 39) {
			return false;
		}
		if (y == 230 && (x >= -20 && x < 200) && kc == 38) {
			return false;
		}
		if (x == 210 && (y >= 180 && y < 230) && kc == 37) {
			return false;
		}
		if (y == 80 && (x >= 280 && x < 400) && kc == 40) {
			return false;
		}
		if (x == 270 && (y >= 90 && y < 230) && kc == 39) {
			return false;
		}
		if (y == 230 && (x >= 280 && x < 400) && kc == 38) {
			return false;
		}
		if (x == 400 && (y >= 90 && y < 230) && kc == 37) {
			return false;
		}
		return true;
	}

}
