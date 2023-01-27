package q_1_pseduCode;

public class Precedence {
	public static void main(String[] args) {
		int a = 10, b = 5, c = 1, result;
		result = a-++c-++b;
		System.out.println(result);
		}

}

//Explanation
/*
 * Here the exprression uses Preincriment operator and this means that in this
 * expression first value of c and b will increase by 1 before it is used in the
 * expression
 * 
 * So the output is => 1
 */