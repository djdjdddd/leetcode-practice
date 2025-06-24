package book.D_hash;

import java.util.HashMap;

public class P019_완주하지못한선수 {

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
		//1.참여 선수 해시맵에 저장 (이때 동명이인은 +1)
		HashMap<String, Integer> map = new HashMap<>();
		for(String p : participant){
			if(map.get(p) == null){
				map.put(p, 1);
			}else{
				map.put(p, map.get(p) + 1);
			}
		}

		//2.완주자를 해시맵에서 하나씩 제거 (즉, 0명이 되면 remove)
		String answer = null;
		for(String c : completion){
			if(map.get(c) <= 1){
				map.remove(c);
			}else{
				map.put(c, map.get(c) - 1);
				answer = c;
			}
		}
//		System.out.println(map);

		//3.마지막에 남은 놈이 정답
		//TODO.익숙해지기: keySet(), entrySet(), values()
		for(String fail : map.keySet()){
			answer = fail;
		}

		return answer;
	}

}
