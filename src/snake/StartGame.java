//package snake;
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.layout.RowData;
//import org.eclipse.swt.layout.RowLayout;
//import org.eclipse.swt.widgets.Button;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;
//
//public class StartGame {
//	public static void main(String[] args) 
//	  {
//	    Display display = new Display();
//	    Shell shell = new Shell(display);
//	
//	RowLayout rowLayout = new RowLayout();
//	rowLayout.wrap = false;
//	rowLayout.pack = false;
//	rowLayout.justify = true;
//	rowLayout.type = SWT.VERTICAL;
//	rowLayout.marginLeft = 10;
//	rowLayout.marginTop = 5;
//	rowLayout.marginRight = 10;
//	rowLayout.marginBottom = 5;
//	rowLayout.spacing = 5;
//	shell.setLayout(rowLayout);
//	new Button(shell, SWT.PUSH).setText("   Мы либо будем играть в эту дурацкую игру   ");
//	new Button(shell, SWT.PUSH).setText("либо не будем");
//    shell.pack();
//    shell.open();
//    
//    while (!shell.isDisposed()) 
//    {
//      if (!display.readAndDispatch()) 
//        display.sleep();
//    }
//  }
//
//}
