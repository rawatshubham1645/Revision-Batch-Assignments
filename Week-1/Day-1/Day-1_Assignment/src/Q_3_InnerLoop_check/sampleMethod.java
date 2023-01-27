package Q_3_InnerLoop_check;

public class sampleMethod {
	public static void main(String[] args) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
			int number = (int)(Math.random() * 10);
			System.out.println(number);
			}
			}
	}

}

/* so here the inner loop will run 2 times for every value of i */