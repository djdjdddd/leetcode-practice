package book.C_queue;

import java.util.ArrayDeque;

public class P017_카드뭉치 {

	public static void main(String[] args) {
		String[] cards1 = {"i", "drink", "water"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};
		String result = solution(cards1, cards2, goal);
		System.out.println(result);	//"Yes"


		String[] cards12 = {"i", "water", "drink"};
		String[] cards22 = {"want", "to"};
		String[] goal2 = {"i", "want", "to", "drink", "water"};
		String result2 = solution(cards12, cards22, goal2);
		System.out.println(result2);	//"Yes"
	}

	static String solution(String[] cards1, String[] cards2, String[] goal){
		// ★21, 22, 24 케이스 실패한 이유
		// -> 문제 조건 중에 2 <= goal 길이 <= cards1 길이 + cards2 길이
		// -> 따라서 c1과 c2 둘 다 비어있을 때만 "Yes"라고 할 수 없음.
		// -> 즉, "Yes" 체크를 엉뚱하게 하고 있었음.

		//1.
		ArrayDeque<String> c1 = new ArrayDeque<>();
		for(String card1 : cards1){
			c1.addLast(card1);
		}

		ArrayDeque<String> c2 = new ArrayDeque<>();
		for(String card2 : cards2){
			c2.addLast(card2);
		}

//		String answer = "No";
		String answer = "Yes";
		for(String word : goal){
			if(word.equals(c1.peek())){
				c1.pollFirst();
			}else if(word.equals(c2.peek())){
				c2.pollFirst();
			}else{
//				return answer;
				return "No";
			}
		}

		//TC 21, 22, 24 실패한 이유
//		if(c1.isEmpty() && c2.isEmpty()){
//			answer = "Yes";
//		}

		return answer;
	}
}
