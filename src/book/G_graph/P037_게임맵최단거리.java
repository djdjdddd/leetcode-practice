package book.G_graph;

import java.util.*;

public class P037_게임맵최단거리 {

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		solution(maps);
		System.out.println(solution(maps)); // 결과: 11
	}

	//방향
	static int[][] d = {{0,1}, {0,-1}, {-1,0}, {1,0}};

	static int solution(int[][] maps){
		//1.현재 위치에서 갈 수 있는 좌표(방향) 구하고
		//2.방문했는지 체크
		//3.방문 안했다면

		int n = maps.length;
		int m = maps[0].length;

		ArrayDeque<Point> deq = new ArrayDeque<>();
		deq.addLast(new Point(0,0));	//시작점. (1,1)이지만 배열이 0부터 시작하니까 (0,0)을 넣었음
		boolean[][] visited = new boolean[n][m];
		int cnt = 0;

		while(!deq.isEmpty()){
			Point curr = deq.pollFirst();

			if(curr.x == n-1 && curr.y == m-1){
				break;
			}

			//curr에서 갈 수 있는 좌표를 모두 체크
			for(int i=0; i<4; i++){
				int nx = curr.x + d[i][0];
				int ny = curr.y + d[i][1];

				//올바른 좌표일 때만
				if(nx >= 0 && nx <= n-1 && ny >= 0 && ny <= m-1){
					//벽(0)인지 길(1)인지 체크
					if(!visited[nx][ny] && maps[nx][ny] == 1){
						visited[nx][ny] = true;
//						cnt++;	//TODO. 이건 탐색 횟수를 세는거지 거리가 아님
						deq.addLast(new Point(nx, ny));
						System.out.printf("nx:%d, ny:%d%n", nx, ny);
					}
				}
			}
		}

		return cnt;
	}

	static class Point{
		int x;
		int y;

		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
