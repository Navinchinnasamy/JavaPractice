import java.util.Scanner;

public class Fibonaci {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = scan.nextInt();
		int j = 1;
		int t = 0;
		String output = "";
		System.out.println("\n FIBONACI SERIES: \n----------------\n");
		for(int i=0; i<n;){
			t = i + j;
			j = i;
			i = t;
			if(j > 0){
				output += (i == 1) ? " " + j : " -> " + j;
			}
		}
		System.out.println(output + "\n\n ----XXXX---- \n   The End!");
	}
}