package snake;

import java.io.FileWriter;
import java.io.IOException;

public class PrintGame {

	public PrintGame(int count, String timer) {
		Output tmp1 = new Output();
		char[] buffer = tmp1.enter();

		try (FileWriter writer = new FileWriter("C:\\Users\\Pavel\\workspace\\SNAKE\\print.txt", false)) {
			String old = new String(buffer);
			old = old.substring(0, 66);
			String text = timer + "  ";
			if (count > -1 && count < 10)
				text += "00";
			if (count > 9 && count < 100)
				text += "0";
			text += count + " очков" + "\r\n" + old;
			writer.write(text);
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}
}