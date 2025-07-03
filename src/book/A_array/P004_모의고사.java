package book.A_array;

import java.util.*;

public class P004_모의고사 {
	public static void main(String[] args) {
		int[] res1 = solution(new int[]{1,2,3,4,5});
		System.out.println(Arrays.toString(res1));
//		int[] res2 = solution(new int[]{1,3,2,4,2});
//		System.out.println(Arrays.toString(res2));
	}

	static int[] solution(int[] arr){
		//어떤 반복되는 패턴 같은 건 배열로 표현하면 좋다.
		int[] p1 = new int[]{1,2,3,4,5};
		int[] p2 = new int[]{2,1,2,3,2,4,2,5};
		int[] p3 = new int[]{3,3,1,1,2,2,4,4,5,5};

		int[] cnt = new int[3];

		//순회하며 정답 비교 O(n)
		for(int i=0; i<arr.length; i++){
			if(arr[i] == p1[i%5]) cnt[0]++;
			if(arr[i] == p2[i%8]) cnt[1]++;
			if(arr[i] == p3[i%10]) cnt[2]++;
		}

		//가장 많이 맞힌 학생 찾기
		//우선 최대값을 찾고, 거기에 부합하는 학생 번호 찾기
		int max = 0;
		for(int i=0; i<cnt.length; i++){
			max = Math.max(max, cnt[i]);
		}

		List<Integer> list = new ArrayList<>();
		for(int i=0; i<cnt.length; i++){
			if(cnt[i] == max){
				list.add(i+1);
			}
		}

		Collections.sort(list);	//리스트 정렬
		int[] res = new int[list.size()];
		int i = 0;
		for(int num : list){
			res[i] = num;
			i++;
		}

		return res;
	}
}
