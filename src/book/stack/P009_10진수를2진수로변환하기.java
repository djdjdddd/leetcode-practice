package book.stack;

public class P009_10진수를2진수로변환하기 {

	public static void main(String[] args) {
		int n = 10;
		int n2 = 27;
		int n3 = 12345;

		solution(n);
//		solution(n2);
//		solution(n3);
	}

	static void solution(int n){
//		n = n >> 1;	//1010 -> 101 -> 10 -> 1

		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.parseInt("1010", 2));
		System.out.println(Integer.toOctalString(n));
		System.out.println(Integer.toHexString(n));

		StringBuilder sb = new StringBuilder();
		while(n != 0){
			n = n >> 1;
			if(n % 2 == 0) sb.append(0);
			else sb.append(1);
		}
//		System.out.println(sb);
	}
}
