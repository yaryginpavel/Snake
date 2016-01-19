package snake;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {

	public static void main(String[] args) {
		final int WIDTH = 400;
		final int HEIGHT = 420;
		Display display = new Display();

		Shell shell = new Shell(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);

		FillLayout layout = new FillLayout();
		shell.setLayout(layout);

		shell.setText("SuperSNAKE");
		int borW = shell.getSize().x - shell.getClientArea().width;
		int borH = shell.getSize().y - shell.getClientArea().height;
		shell.setSize(WIDTH + borW, HEIGHT + borH);

		Canvas canvas = new Canvas(shell, SWT.DOUBLE_BUFFERED);
		Image img = new Image(display, "snake2.jpeg");
		canvas.setBackgroundImage(img);

		new MenuGame(canvas, shell);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		img.dispose();
		display.dispose();
	}
}