package controller.jumpgame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class JumpgameUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JumpgamePanel ballGame;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JumpgameUI frame = new JumpgameUI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public JumpgameUI() {
		super("JumpgameUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 450;
		int height = 300;
		int x = (int) ((scrsize.getWidth() - width) / 2);
		int y = (int) ((scrsize.getHeight() - height) / 2);
		setBounds(100, 100, width, height);
		setBounds(x, y, width, height);
		
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{435, 0};
		gbl_contentPane.rowHeights = new int[]{260, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		ballGame = new JumpgamePanel();
		GridBagConstraints gbc_ballGame = new GridBagConstraints();
		gbc_ballGame.fill = GridBagConstraints.BOTH;
		gbc_ballGame.gridx = 0;
		gbc_ballGame.gridy = 0;
		ballGame.randgen(1);
		contentPane.add(ballGame, gbc_ballGame);
		this.addKeyListener(ballGame);
//		ballGame.returnY();
//		ballGame.monsterMove();
		
		Thread t1 = new Thread(ballGame);
		t1.start();
		
	}
	
}

