package book.tree;

import java.util.HashMap;
import java.util.Map;

public class P027_다단계칫솔판매_과거풀이 {

	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		int[] result = solution(enroll, referral, seller, amount);
	}

	static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
		// 1. 자료구조 만들기 (트리? 그래프?)
		// 2. seller 반복 -> 판매금 분배 : 부모 노드로 거슬러 올라가야 함
		// 3. 자료구조 훑으면서 answer 출력

		// ★★★ 부모 노드를 거슬러 올라갈 수 있게 'Tree 구조'를 만드려면...
		// 1) 인덱스를 이용한 방법 -> X (예시를 보니까 무조건 binary tree가 아니라서)
		// 2) Node 객체 이용 -> X
		// 3) 해쉬맵을 이용할까? (키: 자식노드, 값: 부모노드)
		int leng = enroll.length;
		Map<String, String> map = new HashMap<>();
		Map<String, Integer> sumMap = new HashMap<>();

		for(int i=0; i<leng; i++){
			String e = enroll[i];
			String r = referral[i];

			// 그리고 생각해보니 트리가 안 필요할수도..? 그냥 map을 계속 순회하면 될 거 같은데
			map.put(e, r);  //★부모노드를 찾기 위한 해쉬맵
			sumMap.put(e, 0);
		}
		map.put("-", null);
		sumMap.put("-", 0);

		// 2. seller 반복 -> 판매금 분배
		int leng2 = seller.length;
		for(int i=0; i<leng2; i++){
			String s = seller[i];
			int amt = amount[i] * 100;

			//
			int temp = 0;
			while(true){
				temp = (int)(amt * 0.1);
				amt = amt - temp; // amt : 1080 = 1200 - 120
				// System.out.println(amt); //금액 검증

				int sum = sumMap.get(s) + amt;  // 1080,
				sumMap.put(s, sum);
				amt = temp; // amt : 120

				s = map.get(s);
				if(s == null || amt == 0) break;
			}
		}

		// ★ 정답 검증
		// System.out.println(sumMap);

		// 3. 출력 : 입력으로 주어진 enroll에 이름이 포함된 순서에 따라 나열하면 됩니다.
		int[] answer = new int[leng];

		for(int i=0; i<leng; i++){
			String key = enroll[i];
			answer[i] = sumMap.get(key);
		}

//         int[] answer = new int[sumMap.size()];
//         int idx = 0;
//         for(Map.Entry<String, Integer> entry : sumMap.entrySet()){
//             // System.out.println(entry.getKey() + " : " + entry.getValue());  // "-" 는 제외해야 하는거네
//             if( "-".equals(entry.getKey()) ) continue;

//             answer[idx] = entry.getValue();
//             idx++;
//         }

		return answer;
	}
}
