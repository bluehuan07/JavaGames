package controller;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.jumpgame.JumpgameUI;
import util.DispositionUI;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PickUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickUI frame = new PickUI();
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
	public PickUI() {
		super("PickUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 450;
		int height = 300;
		int x = (int) ((scrsize.getWidth() - width) / 2);
		int y = (int) ((scrsize.getHeight() - height) / 2);
		setBounds(100, 100, width, height);
		setBounds(x, y, width, height);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 414, 241);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);

		JButton btnNewButton_1 = new JButton("跳球遊戲1");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JumpgameUI frame = new JumpgameUI();
				frame.setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton_1, DispositionUI.setGridBagConstraint(0.33, 0.33, 0, 0, 1, 1));

		JButton btnNewButton_2 = new JButton("跳球遊戲2");
		panel.add(btnNewButton_2, DispositionUI.setGridBagConstraint(0.33, 0.33, 1, 1, 1, 1));

		JButton btnNewButton_3 = new JButton("跳球遊戲3");
		panel.add(btnNewButton_3, DispositionUI.setGridBagConstraint(0.33, 0.33, 2, 2, 1, 1));
	}

}
