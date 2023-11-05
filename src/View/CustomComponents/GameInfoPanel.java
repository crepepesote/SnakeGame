package View.CustomComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameInfoPanel extends JPanel {

	public JLabel scoreTitle;
	public JLabel foodConsumedTittle;
	public JLabel velocityTitle;
	public JLabel time;
	public JLabel score;
	public JLabel foodConsumed;
	public JLabel velocity;

	public GameInfoPanel(int x, int y, int width, int height) {
		this.setBackground(Color.GREEN);
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents();
	}

	private void initComponents() {

		velocityTitle = new JLabel("Velocity: ");
		velocityTitle.setFont(new Font("Arial", Font.BOLD, 24));
		velocityTitle.setBounds((int) (this.getWidth() * 0.05), (int) (this.getHeight() * 0.55),
				(int) (this.getWidth() * 0.25), (int) (this.getHeight() * 0.25));
		this.add(velocityTitle);

		foodConsumedTittle = new JLabel("Triangles consumed: ");
		foodConsumedTittle.setFont(new Font("Arial", Font.BOLD, 24));
		foodConsumedTittle.setBounds((int) (this.getWidth() * 0.05), (int) (this.getHeight() * 0.2),
				(int) (this.getWidth() * 0.5), (int) (this.getHeight() * 0.25));
		this.add(foodConsumedTittle);

		scoreTitle = new JLabel("Score: ");

		time = new JLabel("0");

		velocity = new JLabel("0");
		velocity.setFont(new Font("Arial", Font.PLAIN, 24));
		velocity.setBounds((int) (this.getWidth() * 0.82), (int) (this.getHeight() * 0.55),
				(int) (this.getWidth() * 0.25), (int) (this.getHeight() * 0.25));
		this.add(velocity);

		foodConsumed = new JLabel("0");
		foodConsumed.setFont(new Font("Arial", Font.PLAIN, 24));
		foodConsumed.setBounds((int) (this.getWidth() * 0.82), (int) (this.getHeight() * 0.2),
				(int) (this.getWidth() * 0.3), (int) (this.getHeight() * 0.25));
		this.add(foodConsumed);

		score = new JLabel("0");
	}

	public void reStart() {
		score.setText("0");
		velocity.setText("0");
		foodConsumed.setText("0");
		this.repaint();
		this.revalidate();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}

	public JLabel getTime() {
		return time;
	}

	public JLabel getScore() {
		return score;
	}

	public void setScore(JLabel score) {
		this.score = score;
	}

	public JLabel getFoodConsumed() {
		return foodConsumed;
	}

	public void setFoodConsumed(JLabel foodConsumed) {
		this.foodConsumed = foodConsumed;
	}

	public JLabel getVelocity() {
		return velocity;
	}

	public void setVelocity(JLabel velocity) {
		this.velocity = velocity;
	}
}