package book.F_set;

import java.util.HashSet;
import java.util.Set;

public class P031_폰켓몬 {

	public static void main(String[] args) {
		int[] nums = {3,1,2,3};
		int result = solution(nums);
		System.out.println(result);
	}

	static int solution(int[] nums){
		int result = 0;

		//1.Set에 담아서 중복을 제거해
		//2.남은 수 vs N/2
		//2.1.중복 제거한 수 >= N/2 ---> N/2를 반환
		//2.2.중복 제거한 수 < N/2  ---> 중복 제거한 수 반환

		int n = nums.length / 2;
		Set<Integer> set = new HashSet<>();

		for(int num : nums){
			set.add(num);
		}

		if(set.size() >= n){
			result = n;
		}else{
			result = set.size();
		}

		return result;
	}
}
