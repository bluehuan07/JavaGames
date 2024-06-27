package controller.maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class SquarePanel_2 extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int size = 30;
	int x = 100; // 小球的預設位置
	int y = 100;

	public SquarePanel_2() {
		super();
		this.setBackground(null);
		this.setOpaque(false);
	}

	public SquarePanel_2(int x, int y) {
		super();
		this.setBackground(null);
		this.setOpaque(false);
		this.x = x;
		this.y = y;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("bpp");
		g.setColor(Color.darkGray); // 設定顏色
		System.out.println("x：" + x + "\ty：" + y);
		g.fillRect(x, y, size, size); // (x軸, y軸, 球的寬度, 球的高度)
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

	public boolean ismove(int x, int y, int kc) {
		if (x == 30 && (y >= 180 && y < 270) && kc == 37) {
			return false;
		}
		if (x == 50 && (y >= 170 && y < 270) && kc == 39) {
			return false;
		}
		if (y == 170 && (x >= -30 && x < 30) && kc == 40) {
			return false;
		}
		if (y == 160 && (x >= 60 && x < 160) && kc == 40) {
			return false;
		}
		if (x == 160 && (y >= 170 && y < 270) && kc == 37) {
			return false;
		}
		if (x == 170 && (y >= 190 && y < 270) && kc == 39) {
			return false;
		}
		if (y == 180 && (x >= 180 && x < 460) && kc == 40) {
			return false;
		}
		if (y == 180 && (x >= 410) && kc == 39) {
			return false;
		}
		return true;
	}

}
