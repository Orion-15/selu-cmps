import java.io.*;
import java.util.Scanner;

public class FileRead {

	public static String returnLine(int LineNum) throws IOException {
	//File IO
		File inputFile = new File("buffer.txt");
		String fileString = new String();
		Scanner in = new Scanner(inputFile);
	//Read File
		for(int i = 0; i < LineNum; i++) {
			fileString = in.nextLine();
		}

		in.close(); //No memory leaks

	// Return the line read
		return fileString;
	}

}
