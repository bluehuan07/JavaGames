package controller.jumpGame;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.PickUI;

public class JumpUI extends JFrame implements KeyListener, Runnable {

	private static final long serialVersionUID = 1L;

	private BallPanel BP = new BallPanel();
	private RectPanel RP = new RectPanel();
	private FakePanel FP = new FakePanel();

	Thread t1 = new Thread(this);

	boolean SB = true;
	boolean RB = true;
	boolean EB = false;

	/**
	 * Launch the application.
	 * 
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		JumpUI frame = new JumpUI();
		frame.setVisible(true);
		frame.setFocusable(true);

	}

	/**
	 * Create the frame.
	 */
	public JumpUI() {
		super("FirstUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		addKeyListener(this);
		JOptionPane.showMessageDialog(JumpUI.this, "按空白建開始遊戲");
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc;
		gbl.columnWeights = new double[] { 0.5, 0.5 };
		gbl.rowWeights = new double[] { 0.1, 0.9 };
		getContentPane().setLayout(gbl);

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		getContentPane().add(BP, gbc);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		getContentPane().add(RP, gbc);

	}

	@Override
	public void paint(Graphics g) {

		super.paint(g); // 呼叫從父類JFrame繼承的paint方法，這樣才不會留存之前的螢幕內容
		System.out.println("fup");
		FP.paint(g);

	}

	// 這裡是move方法用來呼叫Rect類中的moveRP
	private void move() {
		System.out.println("fum");
		RP.moveRP();
		RP.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (SB) {
			t1.start();
			SB = false;
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("FU keyPressed");
		System.out.println(e.getKeyCode());
		if (!SB) {
			BP.keyPressed(e);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int tmpt = 0;
		try {
			int Score = 0;
			while (RB) {

				System.out.println("main");

				move();

				if (BP.y != 200) {
					BP.y = BP.y + 10;
					BP.repaint();
				}

				if (RP.x < -55) {
					Score = Score + 1;
				}

				if (BP.y >= 170 && BP.y <= 200) {
					if (RP.x >= 20 && RP.x <= 50) {
						break;
					}
				}
				if (tmpt > 80) {
					Thread.sleep(250);
				} else if (tmpt > 40) {
					Thread.sleep(400);
				} else {
					Thread.sleep(600);
				}
				tmpt++;
			}
			JOptionPane.showMessageDialog(JumpUI.this, "結束 得分：" + Score);
			PickUI frame = new PickUI();
			frame.setVisible(true);
			dispose();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
