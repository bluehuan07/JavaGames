package controller.maze;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.PickUI;

public class MazeUI_1 extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	private FakePanel FP = new FakePanel();
	private SquarePanel_1 SP = new SquarePanel_1();
	private Map_1 M1 = new Map_1();

	int score = 0;

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
		getContentPane().add(SP, gbc);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		getContentPane().add(M1, gbc);
		SP.bons = spbons;
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
