package book.A_array;

import java.util.*;

public class P006_실패율3 {

	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2,1,2,6,2,4,3,3};
		int[] result = solution(N, stages);

//		solution(4, new int[]{4,4,4,4,4});
	}

	static int[] solution(int N, int[] stages){
		//1.
		int[] count = new int[N+1];
		int len = stages.length;
		for(int i=0; i<len; i++){
			count[stages[i]-1]++;	//
		}
//		System.out.println(Arrays.toString(count));

		//2.
		Double[] fail = new Double[N];
		for(int i=0; i<N; i++){
			if(count[i] == 0){
				fail[i] = 0.0;
			}
			fail[i] = (double) count[i] / len;
//			System.out.println(count[i] + " / " + len);
			len -= count[i];
		}
		System.out.println(Arrays.toString(fail));

		//3.실패율이 높은 스테이지부터 내림차순으로 반환 (실패율이 같다면 작은 번호의 스테이지가 먼저)



//		List<Double> list = new ArrayList<>();
//		for(int i=0; i<fail.length; i++){
//			list.add(fail[i]);
//		}
//		Collections.sort(list, (o1, o2) -> Double.compare(o2, o1));
//		System.out.println(list);

		return new int[]{};
	}

}
