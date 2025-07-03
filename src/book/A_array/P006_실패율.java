package book.A_array;

import java.util.*;
import java.util.stream.Collectors;

public class P006_실패율 {
	public static void main(String[] args) {
		int N = 4;
//		int N = 5;
//		int[] stages = new int[]{2,1,2,6,2,4,3,3};
		int[] stages = new int[]{4,4,4,4,4};

		int[] result = solution(N, stages);
		System.out.println(Arrays.toString(result));
	}

	static int[] solution(int N, int[] stages){
		//우선 정렬 (문제 쉽게 풀기 위해)
		Arrays.sort(stages);


		//(스테이지) 1부터 시작해서 N까지
		int[] ch = new int[N];	//각 스테이지의 도전자 수
		int[] fail = new int[N];//각 스테이지의 실패자 수
		int temp = 0;
		int j = 0;	//이걸 왜 while문 안에 넣는 빡통 짓을 했을까..

		for(int i=1; i<=N; i++){
			ch[i-1] = stages.length - temp;	//처음엔 8-0, 두번째엔 8-1,

			//stages를 순회하며
			while(j < stages.length && stages[j] == i){	//★while문이라서 j < stages.length 라는 조건이 더 필요했음.
				j++;
				temp++;
				fail[i-1]++;
			}
		}

		System.out.println("도전자 수 : " + Arrays.toString(ch));
		System.out.println("실패자 수 : " + Arrays.toString(fail));


		//실패율 계산
		//★주의) 3/7 같은 것도 있으니 double로
		Map<Integer, Double> map = new HashMap<>();
		for(int i=0; i<N; i++){
			map.put(i+1, (double) fail[i] / ch[i] );
		}
		System.out.println("실패율 : " + map);


		//정렬 (★이게 말이 안되는데;;)
		List<Map.Entry<Integer, Double>> collect = map.entrySet()
				.stream()
//				.sorted((o1, o2) -> Double.compare(o1.getValue(), o2.getValue()))
				.sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
				.collect(Collectors.toList());

		System.out.println(collect);

		//
		int[] res = new int[N];
		for(int i=0; i<collect.size(); i++){
			res[i] = collect.get(i).getKey();
		}

		return res;
	}
}
