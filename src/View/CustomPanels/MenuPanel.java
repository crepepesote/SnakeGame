package View.CustomPanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import View.CustomComponents.CustomButton;

public class MenuPanel extends JPanel {

	private CustomButton play;
	private Font comicSansFont = new Font("Comic Sans MS", Font.PLAIN, 24);

	public MenuPanel(int x, int y, int width, int height, ActionListener listener) {
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.setBackground(Color.BLACK);
		this.initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		play = new CustomButton("PLAY", (this.getWidth() - 200) / 2, (this.getHeight() - 50) / 2, 200, 50);
		play.setFont(comicSansFont);
		play.setBackground(Color.GREEN);
		play.setForeground(Color.WHITE);
		play.setActionCommand("playMenu");
		play.addActionListener(listener);
		this.add(play);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		// Dibujar fondo con patrón de serpiente (opcional)
		g2.setColor(new Color(25, 25, 25)); // Color de fondo oscuro
		for (int x = 0; x < getWidth(); x += 20) {
			for (int y = 0; y < getHeight(); y += 20) {
				g2.fillRect(x, y, 10, 10);
			}
		}

		// Dibujar serpiente decorada
		g2.setColor(Color.GREEN);

		// Cabeza de la serpiente
		g2.fillRoundRect(100, 100, 40, 40, 20, 20);

		// Cuerpo de la serpiente
		for (int i = 1; i < 100; i++) {
			g2.fillRoundRect(100 + i * 20, 100, 20, 40, 10, 10);
		}

		// Agregar más elementos visuales relacionados con serpientes aquí

		// Dibujar título del juego
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
		String title = "Snake Game";
		int titleWidth = g2.getFontMetrics().stringWidth(title);
		g2.drawString(title, (getWidth() - titleWidth) / 2, 50);
	}

}
