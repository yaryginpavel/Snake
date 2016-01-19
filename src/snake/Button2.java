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
//public class Button2 { /* это наш класса - по существу - наша программа - т.к. есть точка входа 
//    main-метод */
// 
//    private Shell shell;
// 
//    public Button2(Display display) { // конструктор нашего класса
// 
//        shell = new Shell(display); // дескриптор окна
// 
//        shell.setText("Button"); // прописываем заголовок окна 
// 
//        initUI(); // запускаем метод initUI() нашего класса 
// 
//        shell.setSize(200, 150);
//        shell.setLocation(300, 300);
// 
//        shell.open(); // делаем окно видимым
// 
//        while (!shell.isDisposed()) { /*что значит - этот цикл позволяет окну не исчеpнуть сразу
//            после создания -  ожидать события и реагировать на них */
//             if (!display.readAndDispatch()) {
//               display.sleep();
//             }
//           }
//    }
//
//    public void initUI() { // этот метод создаст кнопку
// 
//        Button quit = new Button(shell, SWT.PUSH); // создаём кнопку
//        quit.setText(" Сыграть еще раз "); // прописываем её навание
//        quit.setBounds(40, 50, 100, 30); // определям границы для кнопки
//         
//        quit.addSelectionListener(new SelectionAdapter() { // переопределяем метод addSelectionListener
//            @Override // это аннотация уведомляет о переопределении метода
//            public void widgetSelected(SelectionEvent e) {
//                shell.getDisplay().dispose(); // закрываем окно
//                System.exit(0); // завершаем исполнение порграммы.
//            }
//        }
//        );
//    }
// 
// 
//    public static void main(String[] args) { // точка входа для исполнения нашей программы - при  непостредственном запуске кода класса
//    	Display display = new Display();
//        Button2 ex = new Button2(display);
//        display.dispose(); // освобождаем память занятую display
//    }
//}