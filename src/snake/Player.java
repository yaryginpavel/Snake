package snake;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;

public class Player {

	private final int ALL_DOTS = 200;

	public int x[] = new int[ALL_DOTS];
	public int y[] = new int[ALL_DOTS];

	public int dot_size = 10;

	public int dots;
	public int points = 0;

	public boolean left = false;
	public boolean right = true;
	public boolean up = false;
	public boolean down = false;

	Image ball = new Image(null, "dot.png");
	Image rhead = new Image(null, "rhead.png");
	Image lhead = new Image(null, "lhead.png");
	Image uhead = new Image(null, "uhead.png");
	Image dhead = new Image(null, "dhead.png");

	public Player(int a) {
		dots = a;

		for (int z = 0; z < dots; z++) {
			x[z] = 50 - z * 10;
			y[z] = 50;
		}
	}

	public void move() {

		for (int z = dots; z > 0; z--) { // перемещает состав по цепочке
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (left) { // перемещение головы
			x[0] -= dot_size;
		}

		if (right) {
			x[0] += dot_size;
		}

		if (up) {
			y[0] -= dot_size;
		}

		if (down) {
			y[0] += dot_size;
		}
	}

	public void onKeyDown(Event e) {

		int key = e.keyCode;

		if ((key == SWT.ARROW_LEFT) && (!right)) {
			left = true;
			up = false;
			down = false;
		}

		if ((key == SWT.ARROW_RIGHT) && (!left)) {
			right = true;
			up = false;
			down = false;
		}

		if ((key == SWT.ARROW_UP) && (!down)) {
			up = true;
			right = false;
			left = false;
		}

		if ((key == SWT.ARROW_DOWN) && (!up)) {
			down = true;
			right = false;
			left = false;
		}
	}
}
