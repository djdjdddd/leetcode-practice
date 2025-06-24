package book.D_hash;

import java.util.HashMap;
import java.util.Map;

public class P019_완주하지못한선수_과거풀이 {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		String answer = solution(participant, completion);
		System.out.println(answer);//"leo"

		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		String answer2 = solution(participant2, completion2);
		System.out.println(answer2);//"vinko"

		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion3 = {"stanko", "ana", "mislav"};
		String answer3 = solution(participant3, completion3);
		System.out.println(answer3);//"mislav"
	}

	static String solution(String[] participant, String[] completion){
		String answer = "";

		// completion 배열을 해시 셋 or 맵으로 만들어 ->
		Map<String, Integer> map = new HashMap<>();
		for(String s : completion){
			//★★반례 틀린 이유 : 완주자도 중복일 경우 +1을 해줬어야 했는데, 1로 고정하고 있었음 쉬바
			if(map.containsKey(s)){
				map.put(s, map.get(s) + 1);
			}else{
				map.put(s, 1);
			}
		}

		// 1. 동명이인 X 인 경우
		for(String s : participant){
			if(map.containsKey(s)){
				Integer cnt = map.get(s);
				cnt--;
				map.put(s, cnt);
			}else{
				answer = s;
			}
		}

		//System.out.println(map);

		// 2. 동명이인 O인 경우 체크
		if("".equals(answer)){
			for(Map.Entry<String, Integer> entry : map.entrySet()){
				if(entry.getValue() < 0){
					answer = entry.getKey();
				}
			}

		}

		return answer;
	}
}
