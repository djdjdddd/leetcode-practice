package book.D_hash;

import java.util.HashMap;
import java.util.Map;

public class P020_할인행사 {

	public static void main(String[] args) {
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3,2,2,2,1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

		int solution = solution(want, number, discount);
		System.out.println(solution);

		int retry = retry(want, number, discount);
		System.out.println(retry);
	}

	//TODO. 다시
	static int retry(String[] want, int[] number, String[] discount){
		return 0;
	}

	//TODO. 보완...
	//★ 문제 조건 1개를 놓치는 바람에 풀이가 굉장히 복잡해졌음.
	//-> number의 총합은 10 (즉, 항상 10일이고, 구매하는 제품도 무조건 총합이 10개)
	//-> 따라서 HashMap을 서로 equalsAndHashCode 비교하면 되는 거였음...
	static int solution(String[] want, int[] number, String[] discount){
		//1.어떤 걸 몇개 원하는지를 Map에 저장
		HashMap<String, Integer> map1 = new HashMap<>();
		for(int i=0; i<want.length; i++){
			map1.put(want[i], map1.getOrDefault(want[i],0) + number[i]);
		}

		//2.단, discount 길이가 최대 10만이니까...
		int len = discount.length;
		int answer = 0;

		for(int i=0; i<len-9; i++){
			HashMap<String, Integer> map2 = new HashMap<>();

			for(int j=i; j<i+10; j++){
				String d = discount[j];
				//기존 map에서 꺼내지 말고, 그냥 새로운 map에 정보를 저장하는 건 어떨까? 꺼내서 하려니까 너무...
				map2.put(d, map2.getOrDefault(d,0) + 1);
			}
//			System.out.println("map2:" + map2);

			//★ 그리고 마지막으로 map1과 map2의 각 과일의 개수를 비교해서 판단하면 되지 않을까?
			boolean b = true;
			for (String s : want) {
				Integer i1 = map1.get(s);
				Integer i2 = map2.get(s);
				if(i2 == null){
					b = false;
				}else{
					if(i1 > i2){
						b = false;
					}
				}
			}

			if(b){
				answer++;
			}
		}


		return answer;
	}

}
