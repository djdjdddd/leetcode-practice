package book.E_tree;

public class P026_예상대진표 {

	public static void main(String[] args) {
		int n = 8;
		int a = 4;
		int b = 7;
		int answer = solution(n, a, b);
		System.out.println(answer);
	}

	static int solution(int n, int a, int b){
		//계속 2로 나눠서 서로 1로 같아질 때까지 센다. (홀수면 +1 하고 2로 나누고)
		int answer = 0;

		while(true){
			if(a > 1){
				if(a % 2 == 0){
					a /= 2;
				}else{
					a = (a + 1) / 2;
				}
			}

			if(b > 1){
				if(b % 2 == 0){
					b /= 2;
				}else{
					b = (b + 1) / 2;
				}
			}

			answer++;
			if(a == b){
				break;
			}
		}

		return answer;
	}
}
