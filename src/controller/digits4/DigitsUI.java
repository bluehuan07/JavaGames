package controller.digits4;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import util.DispositionUI;

import javax.swing.JLabel;

public class DigitsUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField textFA;
	private JTextField textFB;
	private JTextField textFC;

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

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_panel = new GridBagLayout();
		contentPane.setLayout(gbl_panel);
		setContentPane(contentPane);

		JPanel fackPane1 = new JPanel();
		contentPane.add(fackPane1, DispositionUI.setGridBagConstraint(0.25, 0.25, 0, 1, 1, 1));
		JPanel fackPane2 = new JPanel();
		contentPane.add(fackPane2, DispositionUI.setGridBagConstraint(0.25, 0.25, 3, 1, 1, 1));
		JLabel lblNewLabel_1 = new JLabel("New label");
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

	}

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

	public static int testA(String input, String a2b) {
		int a = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == a2b.charAt(i)) {
				a++;
			}
		}
		return a;
	}

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
