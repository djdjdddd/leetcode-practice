package book.D_hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P024_메뉴리뉴얼 {

	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		String[] result = solution(orders, course);
		System.out.println(Arrays.toString(result));
	}

	static String[] solution(String[] orders, int[] course){
		//1.일단 orders 원소 하나씩 돌면서 n개(2,3,4)짜리 Set 만들어
		for(String order : orders){
			for(int i=0; i<order.length(); i++){
				for(int j=i+1; j<order.length(); j++){
					Set<Character> set = new HashSet<>();
					set.add(order.charAt(i));
					set.add(order.charAt(j));
				}
			}
		}

		//2.Map:{Set, 개수}


		//3.2개짜리 맵, 3개짜리 맵, 4개짜리 맵

		//4.각 맵에서 개수가 큰 것대로 정렬하고 뽑아 -> 그리고 배열에 넣어

		//5.그 배열에서 알파벳 순으로 정렬

		return null;
	}
}
