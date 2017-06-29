import java.lang.*;
import java.io.*;
import java.util.*;


public class Solution {
	private static LinkedList<String> memo = new LinkedList<String>();


	public static void combine() {

		int staticSize = memo.size();
		LinkedList<String> memocopy = new LinkedList<String>();

		for (int i = 0; i < staticSize; i++)
			memocopy.add(memo.get(i));

		memo = new LinkedList<String>();
		for (int i = 0; i < staticSize; i++) {
			String temp = memocopy.get(i);
			// System.out.println(temp);
			memo.add(temp + "0");
			memo.add(temp + "1");
			// System.out.println(Arrays.asList(memo).toString());
			// memo.remove(i);
		}
		// for (int i = 0; i < staticSize; i++)
		// 	memo.remove(i);

	}
	public static void helper(String till_now) {
		for (int i = 0; i < memo.size(); i++) {
			String ele = memo.get(i);
			ele = ele + till_now;
			memo.remove(i);
		    memo.add(i, ele);
		}

	}
	public static LinkedList<String> getCombinations(String input) {
		int num_x = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if (c == 'X') {
				String till_now = sb.toString();
				sb = new StringBuilder();
				if (num_x == 0) {
					memo.add(till_now + "0");
					memo.add(till_now + "1");
					num_x++;
				} else {					
					helper(till_now);
					combine();
				}
			} else {
				sb.append(c);
			}
			// System.out.println(Arrays.asList(memo).toString());		
			// System.out.println(num_x);

		}
		String endpart = sb.toString();
		if (memo.size() == 0) {
			LinkedList<String> templist = new LinkedList<String>();
			templist.add(endpart);
			return templist;
		} else {
			helper(endpart);
		}
		return memo;
		
	}
	public static void main(String[] args) {
		LinkedList<String> result = getCombinations(args[0]);
		for (String s : result) {
			System.out.println(s);
		}
	}
}