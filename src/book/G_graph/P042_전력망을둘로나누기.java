package book.G_graph;

import java.util.*;

public class P042_전력망을둘로나누기 {

	public static void main(String[] args) {
		int n = 9;
		int[][] wires = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
		int solution = solution(n, wires);
		System.out.println(solution);	//3

		int n2 = 4;
		int[][] wires2 = {{1,2}, {2,3}, {3,4}};
		int solution2 = solution(n2, wires2);
		System.out.println(solution2);	//0

		int n3 = 7;
		int[][] wires3 = {{1,2}, {2,7}, {3,7}, {3,4}, {4,5}, {6,7}};
		int solution3 = solution(n3, wires3);
		System.out.println(solution3);	//1
	}

	static int solution(int n, int[][] wires){
		//1.트리(그래프) 자료구조 만들기
		//2.특정 연결을 끊었을 때 생기는 두 트리(그래프)의 노드 개수 세기
		//3.차이 구하기
		//4.최소값 갱신하면서

		//1.
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0; i<=n; i++){
			adj.add(new ArrayList<>());
		}

		for(int[] wire : wires){
			int from = wire[0];
			int to = wire[1];
			adj.get(from).add(to);	//양방향
			adj.get(to).add(from);	//양방향
		}
//		System.out.println(adj);

		//2.각각의 노드에 대해서 모든 연결을 하나씩 끊어보면서
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++){
			for(int node : adj.get(i)){
				//TODO. 근데 생각을 해보니까??
				// a -> b 라고 한다면 b를 방문했다고 처리해버리고, a에서 갈 수 있는 다른 노드의 개수만 세도 되지 않나?
				// 어차피 ALL - n(a) = n(b) 일텐데
				// => ★이렇게 생각한 이유는 '연결을 끊은 그래프'를 그때 그때 만드는 작업이 너무 비효율적이라고 생각해서
				boolean[] visited = new boolean[n+1];
				visited[node] = true;	//b를 방문했다고 처리

				//n(a) 구하기
				int cntA = 0;
				ArrayDeque<Integer> deq = new ArrayDeque<>();
				deq.push(i);
				while(!deq.isEmpty()){
					int curr = deq.pop();
					visited[curr] = true;
					cntA++;

					for(int next : adj.get(curr)){
						if(!visited[next]){
							deq.push(next);
						}
					}
				}

				int cntB = n - cntA;
				int diff = Math.abs(cntA - cntB);
				min = Math.min(min, diff);
//				System.out.println("차이:" + diff);

//				String format = String.format("%d -> %d 연결을 끊었을 때 n(a) = %d", i, node, cntA);
//				System.out.println(format);
			}
		}

		return min;
	}
}
