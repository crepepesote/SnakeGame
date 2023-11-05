package View.CustomComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import javax.swing.JPanel;

public class SnakePanel extends JPanel {

	private ArrayList<int[]> snakeBody;
	private int[] barrier;
	private int[] food;
	private boolean colision;
	private boolean eat;

	public SnakePanel(int x, int y, int width, int height) {
		this.setOpaque(false);
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		snakeBody = new ArrayList<>();
		barrier = new int[] { 0, 0 };
		food = new int[] { 0, 0 };
		this.initComponents();
	}

	public void initComponents() {
		snakeBody = new ArrayList<>();
		eat = true;
		colision = false;
		int[] secondPart = { 4 * 40, 1 * 40 };
		int[] firstPart = { 5 * 40, 1 * 40 };
		snakeBody.add(secondPart);
		snakeBody.add(firstPart);
	}

	// Calcular nueva posicion
	public boolean avanzar(String dir) {
		int newX = 0;
		int newY = 0;
		switch (dir) {
			case "r": {
				newX = 40;
				break;
			}
			case "l": {
				newX = -40;
				break;
			}
			case "u": {
				newY = -40;
				break;
			}
			case "d": {
				newY = 40;
				break;
			}
		}
		int[] newPosicion = { snakeBody.get(snakeBody.size() - 1)[0] + newX,
				snakeBody.get(snakeBody.size() - 1)[1] + newY };
		newPosicion = this.refactorposicion(newPosicion, newX, newY);
		if (this.eatVerify(newPosicion)) {
			eat = false;
			this.colisionVerify();
			if (colision) {
				return false;
			}
			this.repaint();
			return true;

		} else {
			this.colisionVerify();
			if (colision) {
				return false;
			}
			this.repaint();
			return true;
		}
	}

	// calcular posicion si se sale del tablero
	public int[] refactorposicion(int[] posicion, int x, int y) {
		if (snakeBody.get(snakeBody.size() - 1)[0] + x < 0) {
			posicion[0] = (40 * 16);
		} else if (snakeBody.get(snakeBody.size() - 1)[0] + x > (40 * 16)) {
			posicion[0] = 0;
		}
		if (snakeBody.get(snakeBody.size() - 1)[1] + y < 0) {
			posicion[1] = (40 * 14);
		} else if (snakeBody.get(snakeBody.size() - 1)[1] + y > (40 * 14)) {
			posicion[1] = 0;
		}
		return posicion;
	}

	// Verificar si ha colisionado contra ella o contra la barrera
	private void colisionVerify() {
		int[] head = snakeBody.get(snakeBody.size() - 1);
		if (barrier[0] == head[0] && barrier[1] == head[1]) {
			colision = true;
		} else {
			for (int i = 0; i < snakeBody.size() - 1; i++) {
				if ((snakeBody.get(i)[0] == head[0] && snakeBody.get(i)[1] == head[1])) {
					colision = true;
					break;
				}
			}
		}
	}

	// Verificar si al moverse a comido
	private boolean eatVerify(int[] move) {
		snakeBody.add(move);
		if (move[0] == food[0] && move[1] == food[1]) {
			return true;
		} else {
			snakeBody.remove(0);
			return false;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			for (int[] snake : snakeBody) {
				g.setColor(Color.GREEN);
				g.fillRoundRect(snake[0], snake[1], 40, 40, 0, 0);
				g.setColor(Color.BLACK);
			}

		} catch (ConcurrentModificationException e) {
			this.repaint();
		}

	}

	public ArrayList<int[]> getSnakeBody() {
		return snakeBody;
	}

	public void setSnakeBody(ArrayList<int[]> snakeBody) {
		this.snakeBody = snakeBody;
	}

	public boolean isColision() {
		return colision;
	}

	public void setColision(boolean colision) {
		this.colision = colision;
	}

	public int[] getBarrier() {
		return barrier;
	}

	public void setBarrier(int[] barrier) {
		this.barrier = barrier;
	}

	public int[] getFood() {
		return food;
	}

	public void setFood(int[] food) {
		this.food = food;
	}

	public boolean isEat() {
		return eat;
	}

	public void setEat(boolean eat) {
		this.eat = eat;
	}
}