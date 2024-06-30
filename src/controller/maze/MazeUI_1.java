package controller.maze;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.PickUI;
import model.CoinPosition;

public class MazeUI_1 extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	private FakePanel FP = new FakePanel();
	private SquarePanel_1 SP = new SquarePanel_1();
	private Map_1 M1 = new Map_1();
	private CoinPanel CP = new CoinPanel();

	int score = 0;
	List<CoinPosition> LCP = new ArrayList<CoinPosition>();
	List<Integer> LItmp = new ArrayList<Integer>();
	Random rand = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MazeUI_1 frame = new MazeUI_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MazeUI_1() {
		super("MazeUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);

		addKeyListener(this);

		inputPosition();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc;
		gbl.columnWeights = new double[] { 1 };
		gbl.rowWeights = new double[] { 1 };
		getContentPane().setLayout(gbl);

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		getContentPane().add(SP, gbc);

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		getContentPane().add(M1, gbc);

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		int tmp = rand.nextInt(LCP.size());
		LItmp.add(tmp);
		CP.x = LCP.get(tmp).getX();
		CP.y = LCP.get(tmp).getY();
		System.out.println("CP.x = " + CP.x + "\tCP.y = " + CP.y);
		getContentPane().add(CP, gbc);

//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
	}

	public MazeUI_1(int x, int y, boolean spbons, int sc) {
		super("MazeUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);

		addKeyListener(this);

		inputPosition();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc;
		gbl.columnWeights = new double[] { 1 };
		gbl.rowWeights = new double[] { 1 };
		getContentPane().setLayout(gbl);

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		SP.x = x;
		SP.y = y;
		SP.bons = spbons;
		getContentPane().add(SP, gbc);

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		getContentPane().add(M1, gbc);

		this.score = sc;

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		int tmp = rand.nextInt(LCP.size());
		LItmp.add(tmp);
		CP.x = LCP.get(tmp).getX();
		CP.y = LCP.get(tmp).getY();
		System.out.println("CP.x = " + CP.x + "\tCP.y = " + CP.y);
		getContentPane().add(CP, gbc);

//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g); // 呼叫從父類JFrame繼承的paint方法，這樣才不會留存之前的螢幕內容
		System.out.println("MUP");
		FP.paint(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("MU kp：" + e.getKeyCode());
		if (SP.x == 400 && SP.y == 150 && e.getKeyCode() == 37) {
			String tmp = "";
			if (SP.bons) {
				tmp = "\n恭喜找到彩蛋";
			}
			JOptionPane.showMessageDialog(MazeUI_1.this, "逃脫成功！\n金幣得分：" + this.score + tmp);
			PickUI frame = new PickUI();
			frame.setVisible(true);
			dispose();
		}
		SP.keyPressed(e);

		if (SP.x == 120 && SP.y == 230 && e.getKeyCode() == 38) {
			SP.bons = true;
			SP.repaint();
		}

		if (SP.x == CP.x && SP.y == CP.y) {
			score++;
			System.out.println("分數 : " + score);
			int tmp;
			do {
				tmp = rand.nextInt(LCP.size());
			} while (isLItmp(tmp));
			if (LItmp.size() > 5) {
				LItmp.remove(0);
			}
			LItmp.add(tmp);
			CP.x = LCP.get(tmp).getX();
			CP.y = LCP.get(tmp).getY();
			System.out.println("CP.x = " + CP.x + "\tCP.y = " + CP.y);
			CP.repaint();
		}

//		if (SP.x == -30) {
//			MazeUI_1 frame = new MazeUI_1(430,SP.y);
//			frame.setVisible(true);
//			dispose();
//		}
//		if (SP.x == 440) {
//			MazeUI_1 frame = new MazeUI_1(-20,SP.y);
//			frame.setVisible(true);
//			dispose();
//		}
		if (SP.y == -30) {
			MazeUI_2 frame = new MazeUI_2(SP.x, 260, SP.bons, score);
			frame.setVisible(true);
			dispose();
		}
		if (SP.y == 270) {
			MazeUI_2 frame = new MazeUI_2(SP.x, -20, SP.bons, score);
			frame.setVisible(true);
			dispose();
		}
		if (score >= 10) {
			M1.exit = true;
			M1.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void inputPosition() {
		for (int i = 70; i <= 170; i = i + 10) {
			LCP.add(new CoinPosition(0, i));
		}
		for (int i = 70; i <= 110; i = i + 10) {
			LCP.add(new CoinPosition(10, i));
		}
		for (int i = 70; i <= 110; i = i + 10) {
			LCP.add(new CoinPosition(20, i));
		}
		for (int i = 10; i <= 270; i = i + 10) {
			LCP.add(new CoinPosition(20, 170));
		}

		for (int j = 30; j <= 50; j = j + 10) {
			for (int i = 0; i <= 110; i = i + 10) {
				LCP.add(new CoinPosition(j, i));
			}
		}

		for (int j = 60; j <= 150; j = j + 10) {
			for (int i = 80; i <= 110; i = i + 10) {
				LCP.add(new CoinPosition(j, i));
			}
		}

		for (int j = 160; j <= 170; j = j + 10) {
			for (int i = 0; i <= 110; i = i + 10) {
				LCP.add(new CoinPosition(j, i));
			}
		}

		for (int j = 180; j <= 400; j = j + 10) {
			for (int i = 60; i <= 80; i = i + 10) {
				LCP.add(new CoinPosition(j, i));
			}
		}

		for (int j = 180; j <= 270; j = j + 10) {
			for (int i = 90; i <= 110; i = i + 10) {
				LCP.add(new CoinPosition(j, i));
			}
		}

		for (int i = 120; i <= 160; i = i + 10) {
			LCP.add(new CoinPosition(270, i));
		}

		for (int j = 210; j <= 270; j = j + 10) {
			for (int i = 180; i <= 220; i = i + 10) {
				LCP.add(new CoinPosition(j, i));
			}
		}

		for (int j = 0; j <= 400; j = j + 10) {
			LCP.add(new CoinPosition(j, 230));
		}

		for (int i = 90; i <= 220; i = i + 10) {
			LCP.add(new CoinPosition(400, i));
		}

	}

	public boolean isLItmp(int tmp) {
		for (int i = 0; i < LItmp.size(); i++) {
			if (tmp == LItmp.get(i)) {
				return true;
			}
		}
		return false;
	}

}
