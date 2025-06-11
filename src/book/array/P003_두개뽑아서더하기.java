package book.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P003_두개뽑아서더하기 {

	public static void main(String[] args) {
		int[] numbers = {5,0,2,7,59,1,3};

		int[] res = solution(numbers);

		System.out.println(Arrays.toString(res));
	}

	private static int[] solution(int[] numbers) {
		//1. 브루트 포스로 2개 더해서 가능한 숫자 모두 구하고 (중복은 제거해야 됨)
		//2. 오름차순 정렬

		Set<Integer> set = new HashSet<>();

		int len = numbers.length;
		for(int i=0; i<len-1; i++){
			for(int j=i+1; j<len; j++){
				set.add(numbers[i] + numbers[j]);
			}
		}

		//set -> 배열
		int[] res = new int[set.size()];
		int i = 0;
		for(int num : set){
			res[i] = num;
			i++;
		}

		Arrays.sort(res);	//배열 정렬

		return res;
	}
}
