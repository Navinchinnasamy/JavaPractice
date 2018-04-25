import java.util.Scanner;
import java.util.Arrays;

public class Flames {
	private static String condition = "FLAMES";
		
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter name1: ");
		String name1 = scn.nextLine().toLowerCase().replace(" ", "");
		
		System.out.print("\nEnter name2: ");
		String name2 = scn.nextLine().toLowerCase().replace(" ", "");
		
		int remainingCount = getRemainingCount(name1, name2);
		
		String[] conditionAry = condition.split("");
		String result = doFlames(remainingCount, conditionAry);
		
		System.out.println("\n***** ***** ***** *****");
		System.out.println(" Result: "+finalResultText(result)+" ");
		System.out.println("***** ***** ***** *****");
	}
	
	private static int getRemainingCount(String name1, String name2){
		String[] name1ary = name1.split("");
		String[] name2ary = name2.split("");
		
		for(int i=0; i<name1ary.length; i++){
			for(int j=0; j<name2ary.length; j++){
				if(name1ary[i] != null && name2ary[j] != null && name1ary[i].equals(name2ary[j])){
					name1ary[i] = null;
					name2ary[j] = null;
				}
			}
		}
				
		for(int i=0; i<name2ary.length; i++){
			for(int j=0; j<name1ary.length; j++){
				if(name1ary[j] != null && name2ary[i] != null && name1ary[j].equals(name2ary[i])){
					name1ary[j] = null;
					name2ary[i] = null;
				}
			}
		}
		
		name1ary = Arrays.stream(name1ary)
                .filter(value ->
                        value != null && value.length() > 0
                )
                .toArray(size -> new String[size]);
		name2ary = Arrays.stream(name2ary)
                .filter(value ->
                        value != null && value.length() > 0
                )
                .toArray(size -> new String[size]);
				
		return (name1ary.length + name2ary.length);
	}
	
	private static String doFlames(int remainingCount, String[] conditionAry){
		String result = "";
		
		int conditionLength = conditionAry.length;
		int deleteIndex = (remainingCount > conditionLength) ? (remainingCount % conditionLength) : remainingCount;
		deleteIndex = (deleteIndex == 0) ? (conditionLength - 1) : (deleteIndex - 1);
		
		conditionAry[deleteIndex] = null;
		conditionAry = Arrays.stream(conditionAry)
                .filter(value ->
                        value != null && value.length() > 0
                )
                .toArray(size -> new String[size]);
		
		if(conditionAry.length > 1){
			System.out.println(conditionAry.length+" INDEX "+remainingCount+" ==> "+deleteIndex);
			System.out.println("B4: "+Arrays.toString(conditionAry));
			if(deleteIndex < conditionAry.length){
				conditionAry = flipArray(deleteIndex, conditionAry);
			}
			System.out.println("After: "+Arrays.toString(conditionAry));
			return doFlames(remainingCount, conditionAry);
		} else {
			return Arrays.toString(conditionAry);
		}
	}
	
	private static String[] flipArray(int idx, String[] inputAry){
		String[] temp = new String[idx];
		for(int i=0; i+idx<inputAry.length; i++){
			if(i<idx){
				temp[idx-1-i] = inputAry[i];
			}
			inputAry[i] = inputAry[idx+i];
		}
		
		idx = inputAry.length - 1;
		for(int j=0; j<temp.length; j++){
			inputAry[idx-j] = temp[j];
		}
		return inputAry;
	}
	
	private static String finalResultText( String result ){
		switch(result){
			case "[F]":
				result = "Friends";
				break;
			case "[L]":
				result = "Lovers";
				break;
			case "[A]":
				result = "Affection";
				break;
			case "[M]":
				result = "Marriage";
				break;
			case "[E]":
				result = "Enemy";
				break;
			case "[S]":
				result = "Sister / Brother";
				break;
			default:
				result = "Something went wrong";
				break;
		}
		return result;
	}
}