

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		String sentence = "GTP hydrolysis triggers the Ras pathway.";
		System.out.println("Sentence: "+sentence);
	    System.err.println("Parsing... (the first sentence will take longer until all dictionaries are loaded)");
		PrintWriter print = new PrintWriter("input.txt");
		print.print(sentence);
		print.close();
		
		ProcessBuilder pb = new ProcessBuilder("java", "-jar", "jeniatagger.jar","--models","models","--nt","input.txt");
		File commands = new File("input.txt");
		File dirOut = new File("output.txt");
		File dirErr = new File("error.txt");
		

		pb.redirectInput(commands);
		pb.redirectOutput(dirOut);
		pb.redirectError(dirErr);
		
		pb.start();
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner scan = new Scanner(new File("output.txt"));
		while (scan.hasNext()){
			System.out.println(scan.nextLine());
		}



		



	}

}
