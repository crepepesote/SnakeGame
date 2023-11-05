package View.CustomPanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Levels;
import View.CustomComponents.CustomButton;

public class CustomStartPanel extends JPanel {

	private CustomButton playStart;
	private CustomButton backToMenu;
	private JTextField namePlayer;
	private JLabel instructionsLabel;
	private JComboBox<Levels> levels;

	public CustomStartPanel(int x, int y, int width, int height, ArrayList<Levels> lvs, ActionListener listener) {
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.setBackground(Color.GRAY); // Establece el fondo gris
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5)); // Establece un borde blanco de 5 píxeles
		this.initComponents(listener, lvs);
	}

	private void initComponents(ActionListener listener, ArrayList<Levels> lvs) {
		// Label para las instrucciones
		instructionsLabel = new JLabel("Instrucciones");
		instructionsLabel.setBounds((int) (this.getWidth() * 0.2), (int) (this.getHeight() * 0.2) - 25,
				(int) (this.getWidth() * 0.6), 20);
		instructionsLabel.setFont(new Font("Arial", Font.BOLD, 16));
		this.add(instructionsLabel);

		// JTextArea para las instrucciones
		JTextArea instructionsTextArea = new JTextArea(
				"Recolecta la mayor cantidad de triángulos\nEvita chocar con las estrellas rojas\nEvita chocar contigo mismo\nDiviértete");
		instructionsTextArea.setEditable(false);
		instructionsTextArea.setBackground(Color.WHITE);
		instructionsTextArea.setForeground(Color.BLACK);
		instructionsTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
		instructionsTextArea.setLineWrap(true);
		instructionsTextArea.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(instructionsTextArea);
		scrollPane.setBounds((int) (this.getWidth() * 0.2), (int) (this.getHeight() * 0.25),
				(int) (this.getWidth() * 0.6), (int) (this.getHeight() * 0.2));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		this.add(scrollPane);

		// Caja de texto para el nombre del jugador
		namePlayer = new JTextField();
		namePlayer.setBounds((int) (this.getWidth() * 0.2), (int) (this.getHeight() * 0.5),
				(int) (this.getWidth() * 0.6), (int) (this.getHeight() * 0.08));
		this.add(namePlayer);

		// ComboBox para seleccionar el nivel
		levels = new JComboBox<>();
		levels.setBounds((int) (this.getWidth() * 0.2), (int) (this.getHeight() * 0.6),
				(int) (this.getWidth() * 0.6), (int) (this.getHeight() * 0.08));
		for (Levels level : lvs) {
			levels.addItem(level);
		}
		this.add(levels);

		// Botón para iniciar el juego
		playStart = new CustomButton("PLAY", (int) (this.getWidth() * 0.2), (int) (this.getHeight() * 0.7),
				(int) (this.getWidth() * 0.6), (int) (this.getHeight() * 0.1));
		playStart.setActionCommand("play");
		playStart.addActionListener(listener);
		this.add(playStart);

		// Botón para volver al menú
		backToMenu = new CustomButton("MENU", (int) (this.getWidth() * 0.2), (int) (this.getHeight() * 0.85),
				(int) (this.getWidth() * 0.6), (int) (this.getHeight() * 0.1));
		backToMenu.setActionCommand("backToMenu");
		backToMenu.addActionListener(listener);
		this.add(backToMenu);
	}

	public JComboBox<Levels> getLevels() {
		return levels;
	}

	public void setLevels(JComboBox<Levels> levels) {
		this.levels = levels;
	}

	public JTextField getNamePlayer() {
		return namePlayer;
	}

	public void setNamePlayer(JTextField namePlayer) {
		this.namePlayer = namePlayer;
	}
}
