package util;

import java.awt.GridBagConstraints;

public class DispositionUI {

	public static GridBagConstraints setGridBagConstraint(Double weightx, Double weighty, int gridx, int gridy,
			int gridheight, int gridwidth) {
		GridBagConstraints gbc_btn = new GridBagConstraints();
		gbc_btn.weightx = weightx;
		gbc_btn.weighty = weighty;
		gbc_btn.gridx = gridx;
		gbc_btn.gridy = gridy;
		gbc_btn.gridheight = gridheight;
		gbc_btn.gridwidth = gridwidth;
		return gbc_btn;
	}

}
