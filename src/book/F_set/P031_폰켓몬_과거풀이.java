package book.F_set;

import java.util.HashSet;
import java.util.Set;

public class P031_폰켓몬_과거풀이 {

	public static void main(String[] args) {
		int[] nums = {3,1,2,3};
		int result = solution(nums);
		System.out.println(result);
	}

	static int solution(int[] nums){
		int answer = 0;

		// Set의 size 또는 N/2 둘 중 하나 아닌가?????????
		Set<Integer> set = new HashSet<>();
		int leng = nums.length;
		for(int i=0; i<leng; i++){
			set.add(nums[i]);
		}

		//
		if(leng/2 > set.size()){
			answer = set.size();
		}else{
			answer = leng/2;
		}

		return answer;
	}
}
