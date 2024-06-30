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

import model.CoinPosition;

public class MazeUI_2 extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	private FakePanel FP = new FakePanel();
	private SquarePanel_2 SP = new SquarePanel_2();
	private Map_2 M2 = new Map_2();
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
					MazeUI_2 frame = new MazeUI_2(100, 100, false, 0);
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

	public MazeUI_2(int x, int y, boolean spbons, int sc) {
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
		getContentPane().add(M2, gbc);

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		int tmp = rand.nextInt(LCP.size());
		LItmp.add(tmp);
		CP.x = LCP.get(tmp).getX();
		CP.y = LCP.get(tmp).getY();
		System.out.println("C2.x = " + CP.x + "\tC2.y = " + CP.y);
		getContentPane().add(CP, gbc);

		this.score = sc;

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
		SP.keyPressed(e);
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
		if (SP.y == -30) {
			MazeUI_1 frame = new MazeUI_1(SP.x, 260, SP.bons, score);
			frame.setVisible(true);
			dispose();
		}
		if (SP.y == 270) {
			MazeUI_1 frame = new MazeUI_1(SP.x, -20, SP.bons, score);
			frame.setVisible(true);
			dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void inputPosition() {
		for (int i = 0; i <= 400; i = i + 10) {
			for (int j = 0; j <= 160; j = j + 10) {
				LCP.add(new CoinPosition(i, j));
			}
		}

		for (int i = 180; i <= 400; i = i + 10) {
			for (int j = 170; j <= 180; j = j + 10) {
				LCP.add(new CoinPosition(i, j));
			}
		}

		for (int i = 160; i <= 170; i = i + 10) {
			for (int j = 170; j <= 230; j = j + 10) {
				LCP.add(new CoinPosition(i, j));
			}
		}

		for (int i = 30; i <= 50; i = i + 10) {
			for (int j = 180; j <= 230; j = j + 10) {
				LCP.add(new CoinPosition(i, j));
			}
		}
		for (int i = 0; i <= 50; i = i + 10) {
			LCP.add(new CoinPosition(i, 170));
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
