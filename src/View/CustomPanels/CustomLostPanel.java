package View.CustomPanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Levels;
import View.CustomComponents.CustomTextPlace;
import View.CustomComponents.CustomButton;

public class CustomLostPanel extends JPanel {

	private CustomButton playStart;
	private CustomButton backToMenu;
	private CustomTextPlace namePlayed;
	private JLabel score;
	private JLabel bestScore;
	private JLabel theBestScore;
	private JLabel lostLabel; // Added for "YOU LOST" message

	private JComboBox<Levels> levels;

	public CustomLostPanel(int x, int y, int width, int height, ArrayList<Levels> lvs, ActionListener listener) {
		this.setLayout(null);
		this.setBounds(x, y, width, height);

		// Agrega un borde negro al panel
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));

		// Establece el fondo del panel a un color que combine con negro
		this.setBackground(new Color(200, 200, 200)); // Puedes ajustar el color como desees

		this.initComponents(listener, lvs);
	}

	private void initComponents(ActionListener listener, ArrayList<Levels> lvs) {
		// "YOU LOST" Label
		lostLabel = new JLabel("YOU LOST");
		lostLabel.setFont(new Font("Arial", Font.BOLD, 36));
		lostLabel.setForeground(Color.RED);
		int labelX = (this.getWidth() - lostLabel.getPreferredSize().width) / 2;
		int labelY = (int) (this.getHeight() * 0.1);
		lostLabel.setBounds(labelX, labelY, lostLabel.getPreferredSize().width, lostLabel.getPreferredSize().height);
		this.add(lostLabel);

		// Components
		namePlayed = new CustomTextPlace("Put a name", (int) (this.getWidth() * 0.2), (int) (this.getHeight() * 0.26),
				(int) (this.getWidth() * 0.6), (int) (this.getHeight() * 0.08), getForeground(), getBackground());

		levels = new JComboBox<>();
		levels.setBounds((int) (this.getWidth() * 0.3), (int) (this.getHeight() * 0.4), (int) (this.getWidth() * 0.4),
				(int) (this.getHeight() * 0.08));
		for (Levels level : lvs) {
			levels.addItem(level);
		}
		this.add(levels);

		playStart = new CustomButton("REPLAY", (int) (this.getWidth() * 0.104), (int) (this.getHeight() * 0.55),
				(int) (this.getWidth() * 0.386), (int) (this.getHeight() * 0.111));
		playStart.setActionCommand("play");
		playStart.addActionListener(listener);
		this.add(playStart);

		backToMenu = new CustomButton("MENU", (int) (this.getWidth() * 0.55), (int) (this.getHeight() * 0.55),
				(int) (this.getWidth() * 0.38), (int) (this.getHeight() * 0.111));
		backToMenu.setActionCommand("backToMenu");
		backToMenu.addActionListener(listener);
		this.add(backToMenu);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		ImageIcon ic = new ImageIcon("images/startmenu.jpg");
		Icon icon = new ImageIcon(
				ic.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		icon.paintIcon(this, g2, 0, 0);
	}

	public JComboBox<Levels> getLevels() {
		return levels;
	}

	public void setLevels(JComboBox<Levels> levels) {
		this.levels = levels;
	}

	public CustomTextPlace getNamePlayed() {
		return namePlayed;
	}

	public void setNamePlayed(CustomTextPlace namePlayed) {
		this.namePlayed = namePlayed;
	}

	public JLabel getScore() {
		return score;
	}

	public void setScore(JLabel score) {
		this.score = score;
	}

	public JLabel getBestScore() {
		return bestScore;
	}

	public void setBestScore(JLabel bestScore) {
		this.bestScore = bestScore;
	}

	public JLabel getTheBestScore() {
		return theBestScore;
	}

	public void setTheBestScore(JLabel theBestScore) {
		this.theBestScore = theBestScore;
	}

}
