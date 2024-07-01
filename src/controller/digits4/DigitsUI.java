package controller.digits4;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.PickUI;
import util.DispositionUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DigitsUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField textFA;
	private JTextField textFB;
	private JTextField textFC;

	int A2B;
	int max = 9 * 9 * 8 * 7, min = 1023;
	int[] allans = new int[max];
	int i = 0, k = 0, tmp1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitsUI frame = new DigitsUI();
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
	public DigitsUI() {
		super("DigitsUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);

		JOptionPane.showMessageDialog(DigitsUI.this, "請先決定在1000~9876選一個\n且數字不重複的");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_panel = new GridBagLayout();
		contentPane.setLayout(gbl_panel);
		setContentPane(contentPane);

		creatallnumber();
		max = allans.length - 1;

		/* 為了格子大小統一 */
		JPanel fackPane1 = new JPanel();
		contentPane.add(fackPane1, DispositionUI.setGridBagConstraint(0.25, 0.25, 0, 1, 1, 1));
		JPanel fackPane2 = new JPanel();
		contentPane.add(fackPane2, DispositionUI.setGridBagConstraint(0.25, 0.25, 3, 1, 1, 1));

		JLabel lblNewLabel_1 = new JLabel("我猜是：" + allans[0]);
		contentPane.add(lblNewLabel_1, DispositionUI.setGridBagConstraint(0.25, 0.25, 1, 0, 2, 1));
		JLabel lblNewLabel_2 = new JLabel("A：");
		contentPane.add(lblNewLabel_2, DispositionUI.setGridBagConstraint(0.25, 0.25, 1, 1, 1, 1));
		JLabel lblNewLabel_3 = new JLabel("B：");
		contentPane.add(lblNewLabel_3, DispositionUI.setGridBagConstraint(0.25, 0.25, 1, 2, 1, 1));
		JLabel lblNewLabel_4 = new JLabel("C：");
		contentPane.add(lblNewLabel_4, DispositionUI.setGridBagConstraint(0.25, 0.25, 1, 3, 1, 1));

		GridBagConstraints tGBC;
		textFA = new JTextField();
		textFA.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		textFA.setHorizontalAlignment(JTextField.CENTER);
		tGBC = DispositionUI.setGridBagConstraint(0.25, 0.25, 2, 1, 1, 1);
		tGBC.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(textFA, tGBC);

		textFB = new JTextField();
		textFB.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		textFB.setHorizontalAlignment(JTextField.CENTER);
		tGBC = DispositionUI.setGridBagConstraint(0.25, 0.25, 2, 2, 1, 1);
		tGBC.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(textFB, tGBC);

		textFC = new JTextField();
		textFC.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		textFC.setHorizontalAlignment(JTextField.CENTER);
		tGBC = DispositionUI.setGridBagConstraint(0.25, 0.25, 2, 3, 1, 1);
		tGBC.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(textFC, tGBC);

		JButton btnNewButton = new JButton("確認");
		tGBC = DispositionUI.setGridBagConstraint(0.25, 0.25, 3, 3, 1, 1);
		contentPane.add(btnNewButton, tGBC);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/* 刪除與電腦猜的數字不同AB的數字 */
				int tmp = allans[0];
				i = 0;
				if (textFA.getText().equals("") || textFB.getText().equals("")) {
					JOptionPane.showMessageDialog(DigitsUI.this, "請輸入數字");
				} else {
					int inputA = Integer.parseInt(textFA.getText());
					int inputB = Integer.parseInt(textFB.getText());
					do {
						if (inputA + inputB > 4) {
							JOptionPane.showMessageDialog(DigitsUI.this, "輸入錯誤");
							break;
						}
						if (inputA == 4) {
							JOptionPane.showMessageDialog(DigitsUI.this, "答案是：" + tmp + "\n我很厲害吧~~~");
							JOptionPane.showMessageDialog(DigitsUI.this, "遊戲結束");
							PickUI frame = new PickUI();
							frame.setVisible(true);
							dispose();
							break;
						}
						if (max == 0) {
							JOptionPane.showMessageDialog(DigitsUI.this, "你484騙我\n請重新開始");
							DigitsUI frame = new DigitsUI();
							frame.setVisible(true);
							dispose();
							break;
						}
						if (AB(allans[max], tmp, inputA, inputB)) {
							while (AB(allans[i], tmp, inputA, inputB)) {
								i++;
							}
							allans[i] = allans[max];
						}
						max--;
					} while (max > i);
					lblNewLabel_1.setText("我猜是：" + allans[0]);
				}

			}
		});
	}

	/* 所有數字放入allans */
	public void creatallnumber() {
		do {
			allans[i] = 1023 + k;
			if (testnuber(allans[i])) {
				i++;
			}
			k++;
			tmp1 = i - 1;
		} while (allans[tmp1] != 9876);
	}

	/* 在創造時確認有沒有出現相同的數字 */
	public static boolean testnuber(int input) {
		int a = input / 1000;
		int b = (input % 1000) / 100;
		int c = (input % 100) / 10;
		int d = input % 10;
		if (a == b || a == c) {
			return false;
		}
		if (a == d || b == c) {
			return false;
		}
		if (b == d || c == d) {
			return false;
		}
		return true;
	}

	/* 判斷有幾個A */
	public static int testA(String input, String a2b) {
		int a = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == a2b.charAt(i)) {
				a++;
			}
		}
		return a;
	}

	/* 判斷有幾個B */
	public static int testB(String input, String a2b) {
		int b = 0;
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < a2b.length(); j++) {
				if (input.charAt(i) == a2b.charAt(j) && i != j) {
					b++;
				}
			}
		}
		return b;
	}

	/* 判斷數字有沒有相同的AB數 */
	public static boolean AB(int input, int a2b, int A_, int B_) {
		String inputs = input + "";
		String a2bs = a2b + "";
		int a = testA(inputs, a2bs);
		int b = testB(inputs, a2bs);
		if (a == A_ && b == B_) {
			return true;
		}
		return false;
	}

}
