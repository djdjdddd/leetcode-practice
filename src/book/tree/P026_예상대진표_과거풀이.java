package book.tree;

public class P026_예상대진표_과거풀이 {

	public static void main(String[] args) {
		solution(8, 4, 7);
	}

	static int solution(int n, int a, int b){
		int answer = 1;

		// n번째 라운드에서 맞붙게 된다. n을 구하라
		int max = 0;
		int min = 0;

		if(a > b){
			max = a;
			min = b;
		}else{
			max = b;
			min = a;
		}

		while(true){
			if( (min % 2 == 1) && (min + 1 == max) ){
				break;
			}

			max = (max + 1) / 2;
			min = (min + 1) / 2;

			answer++;
		}

		return answer;
	}
}
