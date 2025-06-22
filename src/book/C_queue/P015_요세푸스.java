package book.C_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class P015_요세푸스 {

	public static void main(String[] args) {
		int N = 5;
		int K = 2;
		int answer = solution(N, K);
		System.out.println(answer);	//3

		int N2 = 10;
		int K2 = 3;
		int answer2 = solution(N2, K2);
		System.out.println(answer2);	//4
	}

	static int solution(int N, int K){
		//1.앞-뒤가 이어지는 형태.. 또는 원..처럼 순환하는 경우에는 ==> 큐 자료구조를 사용하면 좋다
		Deque<Integer> deq = new ArrayDeque<>();
		for(int i=1; i<=N; i++){
			deq.addLast(i);
		}

		//2.2. AI 개선 ★
		while (deq.size() > 1) {
			for (int i = 0; i < K - 1; i++) {
				deq.addLast(deq.pollFirst());
			}
			deq.pollFirst(); // K번째 제거
		}

		//2.1. 기존 내 풀이
		/*
		int cnt = 1;
		while(!deq.isEmpty()){
			if(deq.size() == 1){
				break;
			}

			if(cnt == K){
				deq.pollFirst();
				cnt = 1;
			}else{
				deq.addLast(deq.pollFirst());
				cnt++;
			}
		}
		 */

		return deq.poll();
	}
}
