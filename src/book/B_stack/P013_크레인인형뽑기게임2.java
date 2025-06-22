package book.B_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class P013_크레인인형뽑기게임2 {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};

		int result = solution(board, moves);
		System.out.println("result: " + result);	//4
	}

	static int solution(int[][] board, int[] moves){
		//1.board 정보를 각 칼럼에 저장
		int len = board.length;
		ArrayDeque<Integer>[] cols = new ArrayDeque[len+1];
		for(int i=1; i<=len; i++){
			cols[i] =  new ArrayDeque<>();
		}

		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++){
				if(board[j][i] != 0){
					cols[i+1].addFirst(board[j][i]);
				}
			}
		}

//		System.out.println(cols[1]);
//		System.out.println(cols[2]);
//		System.out.println(cols[3]);
//		System.out.println(cols[4]);
//		System.out.println(cols[5]);

		//2.moves 통해서 인형 뽑기
		int answer = 0;
		Deque<Integer> pocket = new ArrayDeque<>();
		for(int move : moves){
			Deque<Integer> col = cols[move];
			if(!col.isEmpty()){
				int poll = col.pollLast();

				if(!pocket.isEmpty() && pocket.peek() == poll){
					pocket.pop();
					answer += 2;
				}else{
					pocket.push(poll);
				}
			}
		}

		return answer;
	}

}
