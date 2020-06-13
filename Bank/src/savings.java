import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class savings {
	static double number;
	
	public static void main(String[]args) throws IOException {
		String ans = "";
		while(!ans.equalsIgnoreCase("stop")) {
			ans = JOptionPane.showInputDialog("What would you like to do? "
					+ "\nchange"
					+ "\ninterest"
					+ "\ntheoretical"
					+ "\nshow"
					+ "\nstop");
		
			if(ans.equalsIgnoreCase("change"))
				change();
			
			else if(ans.equalsIgnoreCase("interest"))
				interest();
			
			else if(ans.equalsIgnoreCase("theoretical"))
				theoretical();
			
			else if(ans.equalsIgnoreCase("show"))
				open();
			
			else if(ans.equalsIgnoreCase("stop"))
				System.exit(0);
		}
		
	}
	
	
	public static void open() throws FileNotFoundException{     // Shows value inside of file
		File myFile = new File("Saving.txt");
		Scanner scan = new Scanner(myFile);
		
		number = scan.nextDouble();
		JOptionPane.showMessageDialog(null, number);
		
		scan.close();
	}
	
	public static void change() throws IOException {             // Changes value inside file
		open();
		
		PrintWriter outputFile = new PrintWriter("Saving.txt");
		
		String input = JOptionPane.showInputDialog("Enter new value ");
		Double val = Double.parseDouble(input);
		
		outputFile.println(val);
		outputFile.close();
	}
	
	public static void interest() throws FileNotFoundException {  // Shows value after interest
		open();
		double total;
		int compound;
		
		String ans = JOptionPane.showInputDialog("Would you like to change value too? ");
		boolean change = (ans.equalsIgnoreCase("yes"));
		
		String input = JOptionPane.showInputDialog("Enter interest rate (percent) " );
		double percent = Double.parseDouble(input);
		double interest = percent/100;
		String input2 = JOptionPane.showInputDialog("For how long? (depends on rate \"years\" \"days\" etc. ) ");
		int time = Integer.parseInt(input2);
		String input3 = JOptionPane.showInputDialog("How often is it compounded or (continuos) " );
		
		if (input3.equalsIgnoreCase("continous")) {
			total = number * java.lang.Math.exp(interest * time) ;
			if (change) {
				PrintWriter outputFile = new PrintWriter("Saving.txt");
				
				Double val = total;
				
				outputFile.println(val);
				outputFile.close();
			}
		}
		
		else {
			compound = Integer.parseInt(input3);
			total = number*(Math.pow((1+(interest/compound)), (time * compound)));
			if (change) {
				PrintWriter outputFile = new PrintWriter("Saving.txt");
				
				Double val = total;
				
				outputFile.println(val);
				outputFile.close();
			}
		}
		JOptionPane.showMessageDialog(null, total);
		
	}
		
	public static void theoretical() throws FileNotFoundException {  // Shows value after 
																	 // adding, subtracting, multiplying, dividing
		open();	
		String choice = "", t, t2, t3, t4;
		double add, sub, mul, div;
		
		while (!choice.equalsIgnoreCase("a") && !choice.equalsIgnoreCase("s") && !choice.equalsIgnoreCase("m") && !choice.equalsIgnoreCase("d") && !choice.equalsIgnoreCase("stop")) {
		choice = JOptionPane.showInputDialog("Add (a) \nSubtract(s)"
				+ "\nMultiply(m) \nDivide(d) \nStop(stop)");
		}
		
		String ans = JOptionPane.showInputDialog("Would you like to change value too? ");
		boolean change = (ans.equalsIgnoreCase("yes"));
		PrintWriter outputFile = new PrintWriter("Saving.txt");
		if (choice.equalsIgnoreCase("stop"))
			System.exit(0);
			else if (choice.equalsIgnoreCase("a")) {
			t = JOptionPane.showInputDialog("Enter add amount ");
			add = Double.parseDouble(t);
			JOptionPane.showMessageDialog(null, (number + add));
			if (change) {
				Double val = number + add;
				
				outputFile.println(val);
				outputFile.close();
			}
		}
		
		else if (choice.equalsIgnoreCase("s")) {
			t2 = JOptionPane.showInputDialog("Enter subtract amount ");	
			sub = Double.parseDouble(t2);
			JOptionPane.showMessageDialog(null, (number - sub));
			if (change) {
				Double val = number - sub;
				
				outputFile.println(val);
				outputFile.close();
			}
		}
		
		else if (choice.equalsIgnoreCase("m")) {
			t3 = JOptionPane.showInputDialog("Enter multiply amount ");
			mul = Double.parseDouble(t3);
			JOptionPane.showMessageDialog(null, (number * mul));
			if (change) {
				Double val = number * mul;
				
				outputFile.println(val);
				outputFile.close();
			}
		}
		
		else {
			t4 = JOptionPane.showInputDialog("Enter divide amount ");
			div = Double.parseDouble(t4);
			JOptionPane.showMessageDialog(null, (number / div));
			if (change) {
				Double val = number / div;
				
				outputFile.println(val);
				outputFile.close();
			}
			
		}
	}
}
