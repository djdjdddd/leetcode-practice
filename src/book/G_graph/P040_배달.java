package book.G_graph;

import java.util.*;

public class P040_배달 {

	public static void main(String[] args) {
		int n = 5;
		int[][] road = {{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}};
		int k = 3;
		int solution = solution(n, road, k);
		System.out.println(solution);	//4

		int n2 = 6;
		int[][] road2 = {{1,2,1}, {1,3,2}, {2,3,2}, {3,4,3}, {3,5,2}, {3,5,3}, {5,6,1}};
		int k2 = 4;
		int solution2 = solution(n2, road2, k2);
		System.out.println(solution2);	//4
	}

	static int solution(int n, int[][] road, int k){
		//1.그래프를 나타낼 자료구조인 adj 구현
		//2.다익스트라 이용해서 각 노드까지의 최소 거리 구하기
		//3.k와 비교해서 배달 여부 판단

		//인접리스트 만들기
		List<List<Node>> adj = new ArrayList<>();
		for(int i=0; i<=n; i++){	//마을(노드) 번호가 1부터 n까지라서
			adj.add(new ArrayList<>());
		}

		for(int[] r : road){
			int from = r[0];
			int to = r[1];
			int cost = r[2];
			adj.get(from).add(new Node(to, cost));
			adj.get(to).add(new Node(from, cost));	//★양방향이라서 이렇게도 만들어줘야 함
		}

		//최소비용 메모리
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		//
		ArrayDeque<Node> deq = new ArrayDeque<>();
		int start = 1;
		deq.addLast(new Node(start, 0));	//시작점
		dist[start] = 0;

		while(!deq.isEmpty()){
			Node curr = deq.pollFirst();

			//curr에서 갈 수 있는 마을(next) 탐색
			for(Node next : adj.get(curr.to)){
				//최소비용 갱신되는 곳만 탐색
				if(dist[next.to] > dist[curr.to] + next.cost){
					dist[next.to] = dist[curr.to] + next.cost;
					deq.addLast(next);	//탐색
				}
			}
		}

//		for(int i=0; i<=n; i++){
//			System.out.println("i: " + dist[i]);
//		}

		//배달 갈 수 있는 마을 개수 찾기
		int cnt = 0;
		for(int i=1; i<=n; i++){
			if(dist[i] <= k){
				cnt++;
			}
		}

		return cnt;
	}

	static class Node{
		int to;
		int cost;

		public Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}

		public String toString(){
			return String.format("to:%d, cost:%d", to, cost);
		}
	}
}
