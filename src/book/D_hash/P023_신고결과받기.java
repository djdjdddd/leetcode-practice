package book.D_hash;

import java.util.*;

public class P023_신고결과받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		int[] result = solution(id_list, report, k);
		System.out.println(Arrays.toString(result));
	}

	static int[] solution(String[] id_list, String[] report, int k){
		//★구해야 하는 답에 초점을 맞추면..
		// - 누가 누구를 신고했는지에 대한 정보 (횟수는 불필요)
		// - 그 누구가 '몇 번' 신고당했는지에 대한 정보
		// A -> B -> 몇번
		// 따라서 Map 안에 Map을 갖는 형태로..?

		// 1번 해시맵: 누가 -> 누구를(여러명), 근데 중복 허용 안하니까 List 말고 Set
		Map<String, Set<String>> map1 = new HashMap<>();

		// 2번 해시맵: 누구가 -> 몇번
		Map<String, Integer> map2 = new HashMap<>();

		// 데이터 처리
		for(String r : report){
			String[] split = r.split(" ");
			String r1 = split[0];
			String r2 = split[1];

			//1
			Set<String> names = map1.get(r1);
			if(names == null){
				Set<String> set = new HashSet<>();
				set.add(r2);
				map1.put(r1, set);
			}else{
				names.add(r2);
				map1.put(r1, names);
			}

			//2
			map2.put(r2, map2.getOrDefault(r2, 0) + 1);
		}
		System.out.println(map1);
		System.out.println(map2);

		//
		int[] answer = new int[id_list.length];
		for(int i=0; i<id_list.length; i++){
			String r1 = id_list[i];
			Set<String> set = map1.get(r1);

			if(set != null){
				for(String s : set){
					if(map2.get(s) >= k){
						answer[i]++;
					}
				}
			}
		}

		return answer;
	}

}
