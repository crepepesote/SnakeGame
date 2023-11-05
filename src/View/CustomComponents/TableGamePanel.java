package View.CustomComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class TableGamePanel extends JPanel {

	public TableGamePanel(int x, int y, int width, int height) {
		this.setLayout(null);
		setBackground(Color.BLACK);
		this.setBounds(x, y, width, height);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);

	}
}