import java.util.Scanner;
import java.io.*;

public class FileOperations {
	/* Reads input.txt file and create output.txt file and copy the content of input.txt file
	public static void main(String args[]) throws IOException {
		FileReader in = null;
		FileWriter out = null;
		
		try {
			in = new FileReader("input.txt");
			out = new FileWriter("output.txt");
			
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if(in != null){
				in.close();
			}
			if(out != null){
				out.close();
			}
		}
	}
	*/
	
	public static void main(String args[]) throws IOException {
		Scanner scn = new Scanner(System.in);
		FileWriter out = null;
		
		try{
			System.out.println("Enter some text to copy to file: ");
			String text = scn.nextLine();
			out = new FileWriter("output.txt");
			
			out.write(text);
		}finally{
			if(out != null){
				out.close();
			}
			scn.close();
		}
	}
}