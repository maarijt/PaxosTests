import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
	private static LinkedList<String> names = new LinkedList<String>();
	private static LinkedList<Integer> prices = new LinkedList<Integer>();
	private static String[] n = new String[2];
	private static int[] p = new int[2];


	public static void dataSetup(String filename) {
		//Read in the file line by line.
		try {
			Scanner sc = new Scanner(new FileInputStream(new File(filename)));
			while(sc.hasNext()) {
				//Line read in.
				String line = sc.nextLine();
				//Line parsed.
				String[] parsed = line.split(", ");
				//Split properly into relevant parts and add to lists
				names.add(parsed[0]);
				prices.add(Integer.parseInt(parsed[1]));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean getPair(int total) {
		/* Make two indicies...one goes down the list, the other moves in 
		   reverse. Takes advantage of an already sorted list. 
		*/
		int st = 0;
		int en = prices.size() - 1;
		int max_sum = -1;
		boolean found = false;
		//Idea taken from the binary search algorithm on a sorted array.  
		while(st < en) {
			int sum = prices.get(st) + prices.get(en);
			// System.out.println(sum + " " + max_sum);
			if (sum == total) {
				n[0] = names.get(st);
				n[1] = names.get(en);
				p[0] = prices.get(st);
				p[1] = prices.get(en);
				found = true;
				break;
			} else if (sum < total) {
				found = true;
				if (max_sum < sum) {
					n[0] = names.get(st);
					n[1] = names.get(en);
					p[0] = prices.get(st);
					p[1] = prices.get(en);
					max_sum = sum;
					st++;
				} else {
					break;
				}
			} else {
				en--;
			}
		}
		return found;
	}

	public static void main(String[] args) {
		dataSetup(args[0]);
		int total = Integer.parseInt(args[1]);
		boolean found = getPair(total);
		if (found) 
			System.out.println(n[0] + " " + p[0] + ", " + n[1] + " " + p[1]);
		else
			System.out.println("Not possible.");
	}
}