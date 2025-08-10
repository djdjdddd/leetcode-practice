package book.G_graph;

import java.util.*;

public class P040_경주로건설 {

	//TODO. AI로 오답 개선 필요
	//https://chatgpt.com/c/6898a8a0-4124-832d-a2ad-bfd3c3deae8c
	public static void main(String[] args) {
		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
		int solution = solution(board);
		System.out.println(solution);	//900

		int[][] board2 = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		int solution2 = solution(board2);
		System.out.println(solution2);	//3800

		int[][] board3 = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		int solution3 = solution(board3);
		System.out.println(solution3);	//2100
	}

	static int solution(int[][] board){
		int n = board.length;

		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};

		Point start = new Point(0,0, null);
		Point end = new Point(n-1, n-1, null);

		boolean[][] visited = new boolean[n][n];
		int[][] costs = new int[n][n];	//최소 금액
		for(int i=0; i<costs.length; i++){
			for(int j=0; j<costs.length; j++){
				costs[i][j] = Integer.MAX_VALUE;
			}
		}
		costs[0][0] = 100;

		ArrayDeque<Point> deq = new ArrayDeque<>();
		deq.addLast(start);

		while(!deq.isEmpty()){
			Point curr = deq.pollFirst();

			for(int i=0; i<dx.length; i++){
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				//범위 밖 좌표인지 체크
				if(nx < 0 || nx >= n || ny < 0 || ny >= n){
					continue;
				}

				//벽인지 체크
				if(board[nx][ny] == 1){
					continue;
				}

				//직선인지 코너링인지 체크
				int cost = 0;
				if( curr.dir == null || (curr.dir[0] == dx[i] && curr.dir[1] == dy[i]) ){
					cost = 100;
				}else{
//					cost = 500;
					cost = 600;	//문제에서 500원이 추가로 든다고 했지, 500원이 든다고 한게 아니었음;;
				}

				if(costs[nx][ny] > costs[curr.x][curr.y] + cost){
					costs[nx][ny] = costs[curr.x][curr.y] + cost;
					int[] dir = new int[]{dx[i], dy[i]};
					deq.addLast(new Point(nx, ny, dir));
				}
			}
		}

		for(int i=0; i<costs.length; i++){
			System.out.println(Arrays.toString(costs[i]));
		}

		return costs[end.x][end.y];
	}

	static class Point{
		int x;
		int y;
		int[] dir;	//TODO.

		public Point(int x, int y, int[] dir){
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}
