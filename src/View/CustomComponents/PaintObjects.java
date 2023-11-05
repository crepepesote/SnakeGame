package View.CustomComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ConcurrentModificationException;
import java.util.Random;
import javax.swing.JPanel;

public class PaintObjects extends JPanel {

	private SnakePanel snakebody;
	private int[] barrierLocation;
	private int[] foodLocation;

	public PaintObjects(int x, int y, int width, int height, SnakePanel snakebody) {
		this.setOpaque(false);
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.snakebody = snakebody;
		this.initComponents();
	}

	private void initComponents() {
		this.generarBarrier();
		this.generarFood();
	}

	public void generarFood() {
		try {
			Random random = new Random();
			boolean correctLocation = true;
			int[] coordenates = { random.nextInt(17) * 40, random.nextInt(14) * 40 };
			if (barrierLocation[0] == coordenates[0] && barrierLocation[1] == coordenates[1]) {
				correctLocation = false;
				this.generarFood();
			} else {
				for (int[] body : snakebody.getSnakeBody()) {
					if (body[0] == coordenates[0] && body[1] == coordenates[1]) {
						correctLocation = false;
						this.generarFood();
						break;
					}
				}
			}
			if (correctLocation) {
				foodLocation = coordenates;
				snakebody.setFood(foodLocation);
				this.repaint();
			}
		} catch (ConcurrentModificationException e) {
			this.generarFood();

		}
	}

	public void generarBarrier() {
		try {
			Random random = new Random();
			boolean correctLocation = true;
			int[] coordenates = { random.nextInt(17) * 40, random.nextInt(14) * 40 };
			if (foodLocation != null) {
				if (foodLocation[0] == coordenates[0] && foodLocation[1] == coordenates[1]) {
					correctLocation = false;
					this.generarBarrier();
				}
			} else {
				for (int[] body : snakebody.getSnakeBody()) {
					if (body[0] == coordenates[0] && body[1] == coordenates[1]) {
						correctLocation = false;
						this.generarBarrier();
						break;
					}
				}
			}
			if (correctLocation) {
				barrierLocation = coordenates;
				snakebody.setBarrier(barrierLocation);
				this.repaint();
			}

		} catch (ConcurrentModificationException e) {
			this.generarBarrier();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x1 = foodLocation[0];
		int y1 = foodLocation[1];
		int x2 = foodLocation[0] + 20;
		int y2 = foodLocation[1] + 40;
		int x3 = foodLocation[0] + 40;
		int y3 = foodLocation[1];
		int[] xPoints = { x1, x2, x3 };
		int[] yPoints = { y1, y2, y3 };

		// Dibuja un triángulo verde
		g.setColor(Color.GREEN);
		Polygon p = new Polygon(xPoints, yPoints, 3);
		g.fillPolygon(p);

		// Dibuja una estrella azul en lugar del rectángulo
		int xCenter = barrierLocation[0] + 20;
		int yCenter = barrierLocation[1] + 20;
		int outerRadius = 20;
		int innerRadius = 10;
		int numPoints = 5;

		int[] xPointsStar = new int[2 * numPoints];
		int[] yPointsStar = new int[2 * numPoints];

		for (int i = 0; i < 2 * numPoints; i++) {
			double angle = Math.PI * i / numPoints;
			int radius = (i % 2 == 0) ? outerRadius : innerRadius;
			xPointsStar[i] = xCenter + (int) (radius * Math.cos(angle));
			yPointsStar[i] = yCenter + (int) (radius * Math.sin(angle));
		}

		g.setColor(Color.RED);
		Polygon star = new Polygon(xPointsStar, yPointsStar, 2 * numPoints);
		g.fillPolygon(star);
	}

	public int[] getBarrierLocation() {
		return barrierLocation;
	}

	public void setBarrierLocation(int[] barrierLocation) {
		this.barrierLocation = barrierLocation;
	}

}