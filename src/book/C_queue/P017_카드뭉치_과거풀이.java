package book.C_queue;

import java.util.*;

public class P017_카드뭉치_과거풀이 {

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
		String answer = "";

		// 1. 준비작업 - 2개 카드에 대해 큐에 담기
		ArrayDeque<String> d1 = new ArrayDeque<>();
		for(int i=0; i<cards1.length; i++){
			d1.add(cards1[i]);
		}

		ArrayDeque<String> d2 = new ArrayDeque<>();
		for(int i=0; i<cards2.length; i++){
			d2.add(cards2[i]);
		}

		ArrayDeque<String> g = new ArrayDeque<>();
		for(int i=0; i<goal.length; i++){
			g.add(goal[i]);
		}

		// 2.
		answer = "Yes";
		// while(!d1.isEmpty() && !d2.isEmpty() && answer == "Yes"){
		while(!g.isEmpty() && answer == "Yes"){
			for(int i=0; i<goal.length; i++){
				String word = goal[i];

				if(!d1.isEmpty() && word.equals(d1.peek())){
					d1.poll();
					g.poll();
				}else if(!d2.isEmpty() && word.equals(d2.peek())){
					d2.poll();
					g.poll();
				}else{
					answer = "No";
				}
			}
		}

		//★테스트 20, 21번 왜 통과 못하는데 ㅡㅡ
		// 혹시 answer 초기값을 Yes가 아니라 No로 해줘야 할까?
        /*
        if(d1.size() == 0 && d2.size() == 0){
            answer = "Yes";
        }
        */

		return answer;
	}
}
