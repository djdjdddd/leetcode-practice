package book.D_hash;

import java.util.HashMap;

public class P018_두개의수로특정값만들기 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,8};
		int target = 6;
		boolean answer = solution(arr, target);
		System.out.println(answer);

		int[] arr2 = {2,3,5,9};
		int target2 = 10;
		boolean answer2 = solution(arr2, target2);
		System.out.println(answer2);
	}

	static boolean solution(int[] arr, int target){
		boolean answer = false;

		//브루트 포스 O(N2) -> 해시 O(N)
		HashMap<Integer, Integer> map = new HashMap<>();	//TODO.풀이에선 Set 사용
		for(int num : arr){
			if(map.get(num) != null){
				answer = true;
			}else{
				map.put(target - num, 0);
//				map.put(target - num, null);
			}
//			System.out.println("num:" + num + ", map:" + map);
		}

		return answer;
	}
}
