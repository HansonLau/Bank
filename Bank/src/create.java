import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class create {
	public static void main(String[]args) throws FileNotFoundException {
		
		PrintWriter newFile = new PrintWriter("Saving.txt");
		newFile.println("100");
		newFile.close();
	}
}
