package controller.jumpGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import controller.PickUI;

public class JumpUI extends JFrame implements KeyListener, Runnable {

	private static final long serialVersionUID = 1L;

	private BallPanel BP = new BallPanel();
	private RectPanel RP = new RectPanel();
	private FakePanel FP = new FakePanel();

	JLabel lblNewLabel;

	Thread t1 = new Thread(this);

	boolean SB = true;
	boolean RB = true;
	boolean EB = false;

	int Score = 0;

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
		gbl.columnWeights = new double[] { 1 };
		gbl.rowWeights = new double[] { 1 };
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

		lblNewLabel = new JLabel("分數： " + Score, SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 57, 125, 45);
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 0, 0, 30);// 與外框的邊界(上,下,左,右)
		getContentPane().add(lblNewLabel, gbc);

	}

	/**
	 * 如果都是在paint繪製時圖案皆會閃爍 <br>
	 * 但是如果不寫內容會沒東西 <br>
	 * 所以寫一個FakePanel <br>
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("fup");
		FP.paint(g);
	}

	private void move() {
		/* 分塊往前移動 */
		System.out.println("fum");
		RP.moveRP();
		RP.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		/* 按任意建開始遊戲開始判定 */
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

			while (RB) {

				System.out.println("main");

				move();

				if (BP.y != 200) {
					/* 圓球跳起下降的過程 */
					BP.y = BP.y + 10;
					BP.repaint();
				}

				if (RP.x < -55) {
					/* 分數判定 */
					Score = Score + 1;
					lblNewLabel.setText("分數： " + Score);
				}

				if (BP.y >= 170 && BP.y <= 200) {
					if (RP.x >= 20 && RP.x <= 50) {
						/* 結束遊戲 */
						break;
					}
				}
				/* 用來加速 */
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
