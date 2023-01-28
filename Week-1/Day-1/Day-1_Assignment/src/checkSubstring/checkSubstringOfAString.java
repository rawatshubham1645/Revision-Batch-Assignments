package checkSubstring;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class checkSubstringOfAString {
	
	
	public static void main(String[] args) {
		/*
		 * Scanner scn = new Scanner(System.in);
		 * System.out.println("Enter The String......abccbdee"); String str =
		 * scn.next();
		 * System.out.println("Enter The Substring that you want to compare......bde");
		 */

		String str = "abccbdee";
		String subStr = "dns";
		/* String subStr = scn.next(); */
		
		System.out.println(checkSubstring(str,subStr));
		
		System.out.println(isSubstring(str,subStr));
	}
	//First method 
	//time complexity-> O(n*m)
	//space complexity->O(1)
	public static boolean checkSubstring(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		
		for(int i = 0;i<n-m;i++) {
			int j;
			for( j = 0;j<m;j++) {
				if(str1.charAt(i+j)!=str2.charAt(j)) {
					
					break;
				}
				
			}
			if(j==m)return true;
		}
		
		return false;
	}
	
	//Second Method by HashMap
	//time complexity -> O(n)+O(m)
	//space -> O(m)
	public static boolean isSubstring(String s1, String s2) {
		Map<Character,Integer> map = new HashMap<>();
		for(int i = 0;i<s2.length();i++) {
		map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0)+1);
		
	}
		
		for(int i = 0;i<s1.length();i++) {
			if(map.containsKey(s1.charAt(i))) {
				map.put(s1.charAt(i), map.get(s1.charAt(i))-1);
				if(map.get(s1.charAt(i))==0) {
					map.remove(s1.charAt(i));
				}
			}
		}
		return map.isEmpty();
}
}