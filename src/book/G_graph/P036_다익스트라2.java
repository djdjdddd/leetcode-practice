package book.G_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P036_다익스트라2 {

	public static void main(String[] args) {
		int[][] graph = {{0,1,9},{0,2,3},{1,0,5},{2,1,1}};
		int start = 0;
		int n = 3;	//노드 개수
		int[] solution = solution(graph, start, n);
		System.out.println(Arrays.toString(solution));
	}

	static int[] solution(int[][] graph, int start, int n){
		//1.자료구조
		//그래프 표현 (인접 리스트로)
		List<List<Node>> adj = new ArrayList<>();
		for(int i=0; i<n; i++){
			adj.add(new ArrayList<>());
		}

		for(int[] g : graph){
			int from = g[0];
			int to = g[1];
			int cost = g[2];
			adj.get(from).add(new Node(to, cost));	//단방향이므로
		}

		//dist, prev
		int[] dist = new int[n];
		int[] prev = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(prev, -1);

		//2.탐색
		//다익스트라 알고리즘 사용
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
		pq.offer(new Node(start, 0));	//시작점
		dist[start] = start;
		prev[start] = start;

		while(!pq.isEmpty()){
			Node curr = pq.poll();

			for(Node next : adj.get(curr.to)){
				if(dist[next.to] > dist[curr.to] + next.cost){
					dist[next.to] = dist[curr.to] + next.cost;
					prev[next.to] = curr.to;
//					System.out.println(next);
					pq.offer(next);
				}
			}
		}

//		System.out.println(Arrays.toString(prev));

		return dist;
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
