import java.lang.*;
import java.io.*;
import java.util.*;

public class Solution2 {
	/*recursive solution. Every recursive call should replace an X with 0 and one and 
	Call the function on the resulting strings. Complexity is O(n + 2^k) where n is
	length of string and k is number of Xs. Even though 2^k should theoratically 
	dominate, in case of  */
	public static LinkedList<String> getCombinations(String input) {
		LinkedList<String> memo = new LinkedList<String>();
		int x_in = -1;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c == 'X') {
				x_in = i;
				break;
			}
		}
		if (x_in == -1) {
			memo.add(input);
			return memo;
		}
		String temp0 = input.substring(0,x_in) + "0" + input.substring(x_in+1);
		String temp1 = input.substring(0,x_in) + "1" + input.substring(x_in+1);
		memo.addAll(getCombinations(temp0));
		memo.addAll(getCombinations(temp1));
		return memo;
	}

	public static void main(String[] args) {
		if (args.length != 0) {
			LinkedList<String> memo = getCombinations(args[0]);
			for (String s: memo)
				System.out.println(s);
		} else {
			System.out.println("Usage: java Solution2 [Input String]");
		}
	}	
}