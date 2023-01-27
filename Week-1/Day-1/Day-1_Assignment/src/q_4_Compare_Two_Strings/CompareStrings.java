package q_4_Compare_Two_Strings;

public class CompareStrings {
	public static void main(String[] args) {
		
		String str1 = "shubham";
		String str2 = "shubham";
		
		System.out.println(checkString(str1,str2)?str1+" and "+str2+" are Equal":str1+" and "+str2+" are Not Equal");
		
		
	}
	public static  boolean checkString(String str1, String str2) {
		
		
		if(str1.length()==str2.length()) {
			for(int i = 0;i<str1.length();i++) {
				if(str1.charAt(i)!=str2.charAt(i)) {return false;}
			}
		}
		return true;
	}
}
