package controller.jumpGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class BallPanel extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;

	private static final int ballsize = 30;
	private static final int x = 20; // 小球的預設位置
	int y = 200;

	public BallPanel() {
		this.setBackground(null);
		this.setOpaque(false);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("bpp");
		g.setColor(Color.darkGray); // 設定顏色
		g.fillOval(x, y, ballsize, ballsize); // (x軸, y軸, 球的寬度, 球的高度)
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("BP keyPressed");
//		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//			System.out.println(e.getKeyCode());
//			x = x - 10; // 往左移動
//		}
//		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//			System.out.println(e.getKeyCode());
//			x = x + 10; // 往右移動
//		}
		if (e.getKeyCode() == 32) {
			if (y == 200) {
				System.out.println(e.getKeyCode());
				y = y - 50; // 往上移動
			}
		}
		this.repaint();
		System.out.println("BP keyPressed off");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
