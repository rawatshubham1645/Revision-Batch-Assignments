package q2_checkPrime;

public class IsPrime {
	public static void main(String s[])
	{
	System.out.println(prime(37) ? "37 is prime" : "37 is not prime");
	}
	public static boolean prime(int input)
	{
	boolean result = false;
	//Write code here to assign true to the variable result, if input is prime otherwise assign false.
	int count= 0;
	for(int i = 1;i<=input;i++) {
		if(input%i==0)count++;
	}
	if(count==2)result= true;
	
	return result;
	}
}
