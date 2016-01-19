package snake;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Output {
	private char[] buffer;

	public Output() {
		File f = new File("C:\\Users\\Pavel\\workspace\\SNAKE\\print.txt");

		try (FileReader reader = new FileReader(f)) {
			buffer = new char[(int) f.length()];
			reader.read(buffer);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public char[] enter() {
		return buffer;
	}
}