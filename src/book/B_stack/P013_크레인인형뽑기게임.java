package book.B_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P013_크레인인형뽑기게임 {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};

		int result = solution(board, moves);
		System.out.println("result: " + result);	//4
	}

	static int solution(int[][] board, int[] moves){
		//1. 각 칼럼을 만들어야 하고, 칼럼 자료구조로 스택을 이용
		//2. 1번째, 2번째, ... n번째 칼럼을 기억해야 하므로 해시맵 사용??
		Map<Integer, Deque<Integer>> map = new HashMap<>();
		for(int i=1; i<=board.length; i++){
			map.put(i, new ArrayDeque<>());
		}

		for(int i=0; i<board.length; i++){
			Deque<Integer> deq = null;
			for(int j=0; j<board.length; j++){
				deq = map.get(i+1);
				deq.addFirst(board[j][i]);
			}
//			System.out.println(deq);
		}

		//3. moves
		Deque<Integer> pocket = new ArrayDeque<>();
		int answer = 0;


		//★★★★★★★★★★★★★★★★★★★
		//deq을 쓸 때 주의할 점
		// 뽑을 때 NPE가 날 수 있음 (ex)Integer가 아닌 int로 받을 때 ---> int poll = deq.pollLast();
		// 따라서 항상 isEmpty를 체크하고 뽑도록 하자. (이러면 int 써도 무방)
		for(int move : moves){
			Deque<Integer> deq = map.get(move);
			int poll = 0;
			if(!deq.isEmpty()){
				poll = deq.pollLast();
				while(!deq.isEmpty() && poll == 0){
					poll = deq.pollLast();
				}
			}

			//★ 0이 빈칸이라는 걸 잊고 있었다...

			//4. 바구니 체크
			if(!pocket.isEmpty()){
				int peek = pocket.peek();
				if(peek == poll){
//					System.out.println("peek:" + peek + ", poll:" + poll);
//					System.out.println(deq);
					pocket.pop();
					answer += 2;
				}else{
					pocket.push(poll);
				}
			}else{
				pocket.push(poll);
			}
		}


		return answer;
	}

}
