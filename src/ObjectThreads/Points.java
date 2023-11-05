package ObjectThreads;

import View.CustomComponents.GameInfoPanel;

public class Points extends Thread {

	private Game snake;
	private Food food;
	private int foodEat;
	private int score;
	private int velocity;
	private GameInfoPanel scorePanel;
	private String namePlayer;

	public Points(Game snake, Food food, GameInfoPanel scorePanel) {
		this.snake = snake;
		this.food = food;
		this.scorePanel = scorePanel;
		foodEat = 0;
		score = 0;
		velocity = 200;
		namePlayer = "";
	}

	@Override
	public void run() {
		while (snake.isAlive()) {
			try {
				if (velocity - snake.getAdvanceVelocity() != Integer.parseInt(scorePanel.getVelocity().getText())) {
					scorePanel.getVelocity().setText("" + (velocity - snake.getAdvanceVelocity()));
				}
				Thread.sleep(100);
				if (foodEat != food.getFoodEat()) {
					foodEat = food.getFoodEat();
					scorePanel.getFoodConsumed().setText("" + foodEat);
					score += food.getTimeToEat();
					scorePanel.getScore().setText("" + score);
				}

			} catch (InterruptedException e) {
			}
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getNamePlayer() {
		return namePlayer;
	}

	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}

}
