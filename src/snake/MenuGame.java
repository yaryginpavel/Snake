package snake;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Shell;

public class MenuGame {

	Shell shell;
	Canvas canvas;
	Menu menuBar, fileMenu;

	MenuItem fileStartItem;
	MenuItem fileExitItem;

	MenuItem fileMenuHeader;

	Board board = null;

	public MenuGame(Canvas can, Shell sh) {
		shell = sh;
		canvas = can;
		menuBar = new Menu(shell, SWT.BAR);
		fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHeader.setText("&Меню");

		fileMenu = new Menu(shell, SWT.DROP_DOWN);
		fileMenuHeader.setMenu(fileMenu);

		fileStartItem = new MenuItem(fileMenu, SWT.PUSH);
		fileStartItem.setText("&Старт");

		fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
		fileExitItem.setText("&Выход");

		fileStartItem.addSelectionListener(new fileStartItemListener());
		fileExitItem.addSelectionListener(new fileExitItemListener());

		shell.setMenuBar(menuBar);
	}

	class fileStartItemListener implements SelectionListener {
		public void widgetSelected(SelectionEvent event) {
			if (board == null)
				board = new Board(canvas, shell);
			else {
				board.remove();
				board = new Board(canvas, shell);
			}
		}

		public void widgetDefaultSelected(SelectionEvent event) {
			new Board(canvas, shell);
		}
	}

	class fileExitItemListener implements SelectionListener {
		public void widgetSelected(SelectionEvent event) {
			shell.getDisplay().close();
		}

		public void widgetDefaultSelected(SelectionEvent event) {
			shell.getDisplay().close();
		}
	}
}
