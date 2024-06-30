package controller.maze;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;

public class MazeUI_2 extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	private FakePanel FP = new FakePanel();
	private SquarePanel_2 SP = new SquarePanel_2();
	private Map_2 M2 = new Map_2();
	private CoinPanel CP = new CoinPanel();

	Random rand = new Random();

	int score = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MazeUI_2 frame = new MazeUI_2(100, 100,false,0);
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

	public MazeUI_2(int x, int y, boolean spbons,int sc) {
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
		CP.x = rand.nextInt(40) * 10;
		CP.y = rand.nextInt(16) * 10;
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
			CP.x = rand.nextInt(40) * 10;
			CP.y = rand.nextInt(16) * 10;
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

}
