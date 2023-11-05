package ObjectThreads;

import View.CustomComponents.PaintObjects;

public class Barriers extends Thread {

	private Game snake;
	private PaintObjects ob;
	private int timeSleep;

	public Barriers(Game snake, PaintObjects ob, int timeSleep) {
		this.snake = snake;
		this.ob = ob;
		this.timeSleep = timeSleep;
	}

	@Override
	public void run() {
		while (snake.isAlive()) {
			ob.generarBarrier();
			try {
				Thread.sleep((timeSleep * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
