package snake;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Board {

	private Canvas canvas;
	private Shell shell;

	private final int WIDTH = 400;
	private final int HEIGHT = 400;

	private boolean ingame = true;
	public int delay = 120;

	private Display display;
	private Runnable runnable;

	Listener paintListener;
	Listener playListener;
	Listener exitListener;

	public static timer timer;

	private timer timerGame = new timer();
	private Player p = new Player(3);
	private Fruits f = new Fruits(p.dot_size);

	public Board(Canvas can, Shell sh) {
		canvas = can;
		shell = sh;
		timerGame.start();
		initBoard();
	}

	private void initBoard() {
		display = shell.getDisplay();

		paintListener = event -> doPainting(event);
		canvas.addListener(SWT.Paint, paintListener);

		playListener = event -> p.onKeyDown(event);
		canvas.addListener(SWT.KeyDown, playListener);

		exitListener = event -> p.onKeyDown(event);
		canvas.addListener(SWT.KeyDown, exitListener);
		
		
//		canvas.addListener(SWT.KeyDown, new Listener() {
//		@Override
//		public void handleEvent(Event event) {
//
//		}
//		});
		
        canvas.addListener(SWT.Dispose, event -> {
            p.ball.dispose();
            p.lhead.dispose();
            p.rhead.dispose();
            p.dhead.dispose();
            p.uhead.dispose();
            timerGame.stop();
        });
		

		Color col = new Color(display, 0, 250, 154);
		canvas.setBackgroundImage(null);
		canvas.setBackground(col);
		col.dispose();

		initGame();
	}

	private void initGame() {

		f.locateFruits();

		runnable = new Runnable() {

			public void run() {
				if (ingame){
					checkFruits();
					checkCollision();
					p.move();
				}
				canvas.redraw();
				display.timerExec(delay, this);
			}
		};
		display.timerExec(delay, runnable);
	};

	private void doPainting(Event e) {

		GC gc = e.gc;

		gc.setAntialias(SWT.ON);

		if (ingame) {
			drawObjects(e);
		} else {
			Count(e, (WIDTH - 100) / 2, (HEIGHT - 280) / 2);
			Timer(e, (WIDTH - 120) / 2, (HEIGHT - 225) / 2);
			gameOver(e);
			PrintGame tmp = new PrintGame(p.points, timerGame.getTime());
			Output tmp1 = new Output();
			Result(e, tmp1.enter(), (WIDTH - 100) / 2, (HEIGHT + 30) / 2);
		}
	}

	private void drawObjects(Event e) { // рисует яблоко и змею

		GC gc = e.gc;

		gc.drawImage(f.fruits[(p.dots - 3) % 3], f.fruit_x, f.fruit_y);

		for (int z = 0; z < p.dots; z++) {
			if (z == 0) {
				if (p.left)
					gc.drawImage(p.lhead, p.x[z], p.y[z]);
				if (p.right)
					gc.drawImage(p.rhead, p.x[z], p.y[z]);
				if (p.up)
					gc.drawImage(p.uhead, p.x[z], p.y[z]);
				if (p.down)
					gc.drawImage(p.dhead, p.x[z], p.y[z]);
			} else {
				gc.drawImage(p.ball, p.x[z], p.y[z]);
			}
		}

		Count(e, (WIDTH - 140), 10);
		Timer(e, (WIDTH - 140), 30);
	}

	private void gameOver(Event e) {

		GC gc = e.gc;

		String msg = "Игра закончена :(";
		
		timerGame.stop();

		Font font = new Font(display, "Helvetica", 15, SWT.NORMAL);
		Color whiteCol = new Color(display, 255, 255, 255);

		gc.setForeground(whiteCol);
		gc.setFont(font);

		Point size = gc.textExtent(msg);

		gc.drawText(msg, (WIDTH - size.x + 15) / 2, (HEIGHT - size.y - 350));

		font.dispose();
		whiteCol.dispose();
		
		display.timerExec(-1, runnable);
	}

	void checkFruits() { // попали в яблоко - рисуем его
		if ((p.x[0] == f.fruit_x) && (p.y[0] == f.fruit_y)) {
			p.points += ((p.dots++) - 3) % 3 + 1;
			delay -= 2;
			f.locateFruits();
		}
	}

	public void checkCollision() {

		for (int z = p.dots; z > 0; z--) {

			if ((z > 4) && (p.x[0] == p.x[z]) && (p.y[0] == p.y[z])) {
				ingame = false;
			}
		}
		if (p.y[0] > HEIGHT - p.dot_size) {
			p.y[0] = 0;
			// ingame = false;
		}

		if (p.y[0] < 0) {
			p.y[0] = HEIGHT - p.dot_size;
		}

		if (p.x[0] > WIDTH - p.dot_size) {
			p.x[0] = 0;
		}

		if (p.x[0] < 0) {
			p.x[0] = WIDTH - p.dot_size;
		}
	}

	private void Count(Event e, int x, int y) {

		GC gc = e.gc;

		String msg = "Ваш счет : " + p.points;

		Font font = new Font(display, "Helvetica", 13, SWT.NORMAL);
		Color whiteCol = new Color(display, 110, 80, 70);

		gc.setForeground(whiteCol);
		gc.setFont(font);

		gc.drawText(msg, x, y);

		font.dispose();
		whiteCol.dispose();
	};

	private void ResultText(Event e) {
		GC gc = e.gc;

		String msg = "Последние 5 игр:";

		Font font = new Font(display, "Helvetica", 10, SWT.NORMAL);
		Color whiteCol = new Color(display, 0, 0, 0);

		gc.setForeground(whiteCol);
		gc.setFont(font);

		gc.drawText(msg, 158, 135);

		font.dispose();
		whiteCol.dispose();
	};

	private void Result(Event e, char[] result, int x, int y) {
		GC gc = e.gc;

		ResultText(e);
		String msg = new String(result);

		Font font = new Font(display, "Helvetica", 10, SWT.NORMAL);
		Color whiteCol = new Color(display, 0, 0, 0);

		gc.setForeground(whiteCol);
		gc.setFont(font);

		gc.drawText(msg, 160, 150);

		font.dispose();
		whiteCol.dispose();
	};

	private void Timer(Event e, int x, int y) {

		GC gc = e.gc;

		String msg = "Ваше время: " + timerGame.getTime();

		Font font = new Font(display, "Helvetica", 13, SWT.NORMAL);
		Color whiteCol = new Color(display, 0, 0, 0);

		gc.setForeground(whiteCol);
		gc.setFont(font);

		gc.drawText(msg, x, y);

		font.dispose();
		whiteCol.dispose();
	};

	public void remove() {
		canvas.removeListener(SWT.Paint, paintListener);
		canvas.removeListener(SWT.KeyDown, playListener);
		canvas.removeListener(SWT.KeyDown, exitListener);
	}
}