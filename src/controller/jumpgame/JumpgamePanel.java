package controller.jumpgame;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import model.Shape;

public class JumpgamePanel extends JPanel implements KeyListener, Runnable {

	private static final long serialVersionUID = 1L;
	private List<Shape> AS = new ArrayList<Shape>();
	int x = 10;
	int y = 240;
	int bw = 20;
	int bh = 20;

	public void randgen(int n) {
		System.out.println("randgen");
//		Random rand = new Random(); // 亂數
		for (int i = 0; i < n; i++) {
			int x = 200;
			int y = 240;
			int w = 10;
			int h = 10;
			AS.add(new Shape(x, y, w, h));
			System.out.println("AS" + AS.get(i).getX());
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		AS.get(0).draw(g);
//		Shape[] arr = AS.toArray(new Shape[AS.size()]);
//		for (int i = 0; i < AS.size(); i++) {
//			arr[i].draw(g);
//		}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.fillOval(x, y, bw, bh);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("按下");
		System.out.println(e.getKeyCode());
		switch (e.getKeyCode()) {
		case 75: {
			y = y - 30;
			break;
		}
		case 37: {
			x = x - 10;
			if (x < 0) {
				x = x + 10;
			}
			break;
		}
		case 39: {
			x = x + 10;
			break;
		}
		}
		System.out.println("按完");
		this.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void returnY() {
		while (true) {
			try {
				Thread.sleep(1000);
				if (y != 240) {
					y = y + 10;
					System.out.println("returnYif");
				}
				int tmpX = AS.get(0).getX();
				AS.get(0).setX(tmpX-10);
				System.out.println("monsterMove");
				System.out.println("returnY");
				this.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public void monsterMove() {
		System.out.println("monsterMove");
		while (true) {
			try {
				Thread.sleep(1000);
				this.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public void runSun() {
//		monsterMove();
		returnY();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		runSun();
	}

}
