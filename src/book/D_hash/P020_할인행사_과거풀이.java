package book.D_hash;

import java.util.HashMap;
import java.util.Map;

public class P020_할인행사_과거풀이 {

	public static void main(String[] args) {
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3,2,2,2,1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

		int solution = solution(want, number, discount);
		System.out.println(solution);
	}

	static int solution(String[] want, int[] number, String[] discount){
		int answer = 0;

		// 1. 구매 목록을 Map으로 만들기
		Map<String, Integer> map = new HashMap<>();
		for(int i=0; i<want.length; i++){
			map.put(want[i], number[i]);
		}

		//System.out.println(map);

		// 총 날짜 구하기
		int sum = 0;
		for(int i : number){
			sum += i;
		}

		// 2. 할인 목록을 Map으로 만들기
		for(int i=0; i<discount.length-sum+1; i++){
			Map<String, Integer> discountMap = new HashMap<>();

			for(int j=i; j<i+sum; j++){
				discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
			}

			//System.out.println(discountMap);

			// 두 맵이 서로 같은지 체크
			if(map.equals(discountMap)){
				answer++;
			}
		}

		return answer;
	}
}
