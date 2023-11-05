package View.CustomPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Levels;
import Model.ReadFile;
import ObjectThreads.Barriers;
import ObjectThreads.Food;
import ObjectThreads.Game;
import ObjectThreads.Points;
import View.CustomComponents.PaintObjects;
import View.CustomComponents.GameInfoPanel;
import View.CustomComponents.SnakePanel;
import View.CustomComponents.TableGamePanel;

public class MyFrame extends JFrame implements ActionListener, KeyListener {

	private ReadFile file;
	private MenuPanel menu;
	private GameInfoPanel scorePanel;
	private TableGamePanel table;
	private SnakePanel snake;
	private PaintObjects ob;
	private CustomStartPanel startGame;
	private CustomLostPanel reStartGame;
	private Barriers barrier;
	private Food food;
	private Game snakeMove;
	private Points score;
	private int actualmenu;

	public MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize((17 * 38) + 16, (15 * 38) + 120);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.initComponents();
		this.requestFocus(true);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.repaint();
	}

	private void initComponents() {
		file = new ReadFile();
		try {
			file.readFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
		actualmenu = 0;
		menu = new MenuPanel(0, 0, this.getWidth(), this.getHeight(), this);
		this.add(menu);
		startGame = new CustomStartPanel((int) (this.getWidth() * 0.15), (int) (this.getHeight() * 0.15),
				(int) (this.getWidth() * 0.7), (int) (this.getHeight() * 0.7), file.getLevels(), this);
		reStartGame = new CustomLostPanel((int) (this.getWidth() * 0.15), (int) (this.getHeight() * 0.15),
				(int) (this.getWidth() * 0.7), (int) (this.getHeight() * 0.7), file.getLevels(), this);
		scorePanel = new GameInfoPanel(0, 0, (17 * 40), 80);
		table = new TableGamePanel(0, 80, 17 * 40, 15 * 40);
		snake = new SnakePanel(0, 80, 17 * 40, 15 * 40);
		ob = new PaintObjects(0, 80, 17 * 40, 15 * 40, snake);
	}

	public void showPlayMenu() {
		actualmenu = 1;
		this.remove(menu);
		this.add(startGame);
		this.add(scorePanel);
		this.add(table);
		this.revalidate();
		this.repaint();
	}

	public void showRePlayMenu() {
		actualmenu = 2;
		score.setNamePlayer(startGame.getNamePlayer().getText());
		String[] results = file.comprobate(score.getNamePlayer(), startGame.getLevels().getSelectedItem().toString(),
				Integer.parseInt(scorePanel.getScore().getText()));
		this.remove(snake);
		this.remove(ob);
		this.remove(table);
		this.remove(scorePanel);
		this.add(reStartGame);
		this.add(scorePanel);
		this.add(table);
		this.revalidate();
		this.repaint();
	}

	public void showHistory() {
		actualmenu = 3;
		this.remove(menu);
		this.add(scorePanel);
		this.add(table);
		this.revalidate();
		this.repaint();
	}

	public void play() {
		boolean bander = true;
		String namePlayed;
		if (actualmenu == 1) {
			namePlayed = startGame.getNamePlayer().getText().replace(" ", "");
			reStartGame.getLevels().setSelectedIndex(startGame.getLevels().getSelectedIndex());
			reStartGame.getNamePlayed().setText(startGame.getNamePlayer().getText());
			this.remove(startGame);

		} else if (actualmenu == 2) {
			namePlayed = reStartGame.getNamePlayed().getText().replace(" ", "");
			startGame.getLevels().setSelectedIndex(reStartGame.getLevels().getSelectedIndex());
			startGame.getNamePlayer().setText(reStartGame.getNamePlayed().getText());
			this.remove(reStartGame);

		}
		if (bander) {
			reset();
			this.remove(table);
			this.add(ob);
			this.add(snake);
			this.add(table);
			this.repaint();
			this.revalidate();
		}
	}

	public void reset() {
		snake.initComponents();
		scorePanel.reStart();
		Levels lv = (Levels) startGame.getLevels().getSelectedItem();
		snakeMove = new Game(snake, this, lv.getInitialVelocity());
		snakeMove.start();
		barrier = new Barriers(snakeMove, ob, lv.getTimeBarrier());
		food = new Food(snakeMove, ob, snake, lv.getTimeFood());
		barrier.start();
		food.start();
		score = new Points(snakeMove, food, scorePanel);
		score.start();
		this.revalidate();
		this.repaint();
	}

	public void backToMenu() {
		if (actualmenu == 1) {
			this.remove(startGame);
		} else if (actualmenu == 2) {
			this.remove(reStartGame);
		}
		this.remove(table);
		this.remove(scorePanel);
		this.add(menu);
		this.revalidate();
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		try {
			switch (source) {
				case "playMenu": {
					showPlayMenu();
					break;
				}
				case "play": {
					play();
					break;
				}
				case "backToMenu": {
					backToMenu();
					break;
				}
				case "history": {
					showHistory();
					break;
				}
				case "changeTable": {
					break;
				}
			}
		} catch (Exception e) {
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (snakeMove.isAlive()) {
			switch (keyCode) {
				case KeyEvent.VK_W:
					snakeMove.addNewDirection("u");
					break;
				case KeyEvent.VK_S:
					snakeMove.addNewDirection("d");
					break;
				case KeyEvent.VK_A:
					snakeMove.addNewDirection("l");
					break;
				case KeyEvent.VK_D:
					snakeMove.addNewDirection("r");
					break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
