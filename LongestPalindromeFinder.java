import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LongestPalindromeFinder {

	public static void main(String[] args) {
		ArrayList<String> longestPalindromes = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		String str;
		
		while(true) {
			
			while(true) {
				System.out.print("Enter String: ");
				str = scan.nextLine();
				if(str.equals("")) {
					System.out.println("Please enter a String!");
					continue;
				}
				break;
			}
			
			longestPalindromes = longestPalindromes(str);
			Iterator<String> itr = longestPalindromes.iterator();
			
			if(!itr.hasNext()) System.out.println("No Palindrome string found!");
			else {
				System.out.println("\nLongest Palindromes: ");
				while(itr.hasNext()) System.out.println(itr.next());
			}
			
			String choice;
			while(true) {
				System.out.print("\nDo you want to continue? (y/n): ");
				choice = scan.nextLine();
				
				if(choice.equalsIgnoreCase("y")) break;
				else if(choice.equalsIgnoreCase("n")) {System.exit(0);}
				else System.out.println("\nPlease enter valid choice!\n");
			}
			continue;
		}
	}
	
	public static ArrayList<String> longestPalindromes(String str) {
		int maxLength=2;
		int length = str.length();
		ArrayList<String> allPalindromes = new ArrayList<String>();
		ArrayList<String> longestPalindromes = new ArrayList<String>();
		
		for(int i=0;i<length;i++) {
			for(int j=i+2;j<length;j++) {
				String subString = str.substring(i, j);
				StringBuilder sb = new StringBuilder(subString);
				if(subString.equals(sb.reverse().toString()))
					allPalindromes.add(subString);
			}
		}
		if(!allPalindromes.isEmpty()) {
			System.out.println("\nAll Palindromes:");
			for(String string : allPalindromes) {
				System.out.println(string);
				int stringLength = string.length();
				if(stringLength>maxLength) maxLength=stringLength;
			}
		}
		
		for(String string : allPalindromes) {
			int stringLength = string.length();
			if(stringLength==maxLength) longestPalindromes.add(string);
		}
		
		return longestPalindromes;
	}

}
