import java.util.Scanner;
import java.util.Random;

class MathsQuestionsAnswers {
	protected int answer;
	
	MathsQuestionsAnswers(){
		answer = 0;
	}
	
	protected String generateQuestion(int difficult) {
		Random rand = new Random();
		
		int rand_int1 = rand.nextInt((int) Math.pow(10, difficult));
		int rand_int2 = rand.nextInt((int) Math.pow(10, difficult));
		int operation = rand.nextInt(4);
		String question;
		switch(operation)
		{
			case 1:
				question = String.valueOf(rand_int1)+" + "+String.valueOf(rand_int2)+" = ? ";
				answer   = rand_int1+rand_int2;
				break;
			case 2:
				question = String.valueOf(rand_int1)+" - "+String.valueOf(rand_int2)+" = ? ";
				answer   = rand_int1-rand_int2;
				break;
			case 3:
				question = String.valueOf(rand_int1)+" * "+String.valueOf(rand_int2)+" = ? ";
				answer   = rand_int1*rand_int2;
				break;
			case 4:
				question = String.valueOf(rand_int1)+" % "+String.valueOf(rand_int2)+" = ? ";
				answer   = rand_int1%rand_int2;
				break;
			default:
				question = String.valueOf(rand_int1)+" % "+String.valueOf(rand_int2)+" = ? ";
				answer   = rand_int1%rand_int2;
				break;
		}
				
		return question;
	}
	
	protected boolean verifyAnswer(int ans) {
		return ans == answer;
	}
}

public class Maths extends MathsQuestionsAnswers {
	public static String userName;
	public static int played = 0;
	public static int guessed = 0;
	public static void main (String args[]) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Let me know your name please?");
		userName = scn.nextLine();
		System.out.println("Greetings "+userName+"!");
		int dificult = 1;
		System.out.print("Set a difficult level in integers: ");
		dificult = scn.nextInt();
		
		playGame(dificult);
		scn.close();
	}
	
	public static boolean isNumeric(String str)  
	{  
		try {  
			double d = Double.parseDouble(str);  
		} catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}

	private static void playGame(int difficult){
		Maths m = new Maths();
		System.out.println(m.generateQuestion(difficult));
		played++;
		Scanner scn = new Scanner(System.in);
		String ans = scn.nextLine();
		if(isNumeric(ans)){
			if(m.verifyAnswer(Integer.parseInt(ans))){
				guessed++;
				System.out.println("You got it! Congrats!! ("+guessed+" / "+played+")");
			} else {
				System.out.println("Sorry! You got wrong!! ("+guessed+" / "+played+")");
			}
		} else {
			System.out.println("Sorry answer must be an integer! ("+guessed+" / "+played+")");
		}
		System.out.println("*****************************************************************");
		System.out.print("Want to guess again? [y/n/c] (c to change difficulty level): ");
		String choice = scn.nextLine();
		if(choice.equals("y") || choice.equals("c")){
			if(choice.equals("c")){
				System.out.print("Set a difficult level in integers: ");
				difficult = scn.nextInt();
			}
			playGame(difficult);
		} else {
			System.out.println("Thanks for playing!");
			scn.close();
		}
	}
}
