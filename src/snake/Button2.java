//package snake;
//
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.events.SelectionAdapter;
//import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.widgets.Button;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;
//
//
//public class Button2 { /* ��� ��� ������ - �� �������� - ���� ��������� - �.�. ���� ����� ����� 
//    main-����� */
// 
//    private Shell shell;
// 
//    public Button2(Display display) { // ����������� ������ ������
// 
//        shell = new Shell(display); // ���������� ����
// 
//        shell.setText("Button"); // ����������� ��������� ���� 
// 
//        initUI(); // ��������� ����� initUI() ������ ������ 
// 
//        shell.setSize(200, 150);
//        shell.setLocation(300, 300);
// 
//        shell.open(); // ������ ���� �������
// 
//        while (!shell.isDisposed()) { /*��� ������ - ���� ���� ��������� ���� �� ����p���� �����
//            ����� �������� -  ������� ������� � ����������� �� ��� */
//             if (!display.readAndDispatch()) {
//               display.sleep();
//             }
//           }
//    }
//
//    public void initUI() { // ���� ����� ������� ������
// 
//        Button quit = new Button(shell, SWT.PUSH); // ������ ������
//        quit.setText(" ������� ��� ��� "); // ����������� � �������
//        quit.setBounds(40, 50, 100, 30); // ��������� ������� ��� ������
//         
//        quit.addSelectionListener(new SelectionAdapter() { // �������������� ����� addSelectionListener
//            @Override // ��� ��������� ���������� � ��������������� ������
//            public void widgetSelected(SelectionEvent e) {
//                shell.getDisplay().dispose(); // ��������� ����
//                System.exit(0); // ��������� ���������� ���������.
//            }
//        }
//        );
//    }
// 
// 
//    public static void main(String[] args) { // ����� ����� ��� ���������� ����� ��������� - ���  ����������������� ������� ���� ������
//    	Display display = new Display();
//        Button2 ex = new Button2(display);
//        display.dispose(); // ����������� ������ ������� display
//    }
//}