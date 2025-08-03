package book.G_graph;

import java.util.*;

public class P036_다익스트라 {

	public static void main(String[] args) {
		int[][] graph = {{0,1,9},{0,2,3},{1,0,5},{2,1,1}};
		int start = 0;
		int n = 3;	//노드 개수
		int[] solution = solution(graph, start, n);
		System.out.println(Arrays.toString(solution));
	}

	static int[] solution(int[][] graph, int start, int n){
		//1.자료구조 세팅 (인접 리스트 사용)
		List<List<Node>> adj = new ArrayList<>();
		for(int i=0; i<n; i++){
			adj.add(new ArrayList<>());
		}

		for(int i=0; i<graph.length; i++){
			adj.get(graph[i][0]).add(new Node(graph[i][1], graph[i][2]));
		}


		//2.알고리즘 (다익스트라)
		boolean[] visited = new boolean[n];//방문 여부

		int[] dist = new int[n];	//최소 비용
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;		//최소 비용

		//TODO. 개선 포인트 1 - 직전 노드 정보 알려면 prev 이용
//		int[] prev = new int[n];	//직전 노드
//		Arrays.fill(prev, -1);

		//일반 큐가 아니라 우선순위 큐 사용
//		Deque<Node> deq = new ArrayDeque<>();
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.offer(new Node(start, 0));	//시작 노드

		while(!pq.isEmpty()){
			Node curr = pq.poll();	//처음엔 시작 노드인 0

			//TODO. 개선 포인트 2 - 방문 처리 다르게도 가능
			if(!visited[curr.to]){
				visited[curr.to] = true;

				//0에서 갈 수 있는 노드
				for(Node next : adj.get(curr.to)){
					if(dist[next.to] > dist[curr.to] + next.cost){	//dist[1] > dist[0] + 9
						dist[next.to] = dist[curr.to] + next.cost;
						pq.offer(new Node(next.to, dist[next.to]));	//다음 노드 정보(노드번호, 그 노드까지의 거리)
					}
				}
			}
		}

		System.out.println(Arrays.toString(dist));

		return null;
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
