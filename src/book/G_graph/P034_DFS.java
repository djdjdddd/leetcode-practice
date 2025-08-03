package book.G_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class P034_DFS {

	public static void main(String[] args) {
		int[][] graph = {{1,2},{2,3},{3,4},{4,5}};
		int start = 1;
		int n = 5;
		int[] solution = solution(graph, start, n);
		System.out.println(Arrays.toString(solution));

		int[][] graph2 = {{1,2},{1,3},{2,4},{2,5},{3,6},{5,6}};
		int start2 = 1;
		int n2 = 6;
		int[] solution2 = solution(graph2, start2, n2);
		System.out.println(Arrays.toString(solution2));
	}

	static int[] solution(int[][] graph, int start, int n){
		//1.자료구조 만들기
		//인접 리스트 사용
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0; i<=n; i++){	//숫자 1부터 시작해서 n까지 할라고
			adj.add(new ArrayList<Integer>());
		}

		for(int i=0; i<graph.length; i++){
			adj.get(graph[i][0]).add(graph[i][1]);
		}
//		System.out.println(adj);


		//2.알고리즘 구현(DFS)
		Deque<Integer> deq = new ArrayDeque<>();
		boolean[] visited = new boolean[n+1];
		List<Integer> answer = new ArrayList<>();

		deq.push(start);
		while(!deq.isEmpty()){
			int pop = deq.pop();
			if(!visited[pop]){
				answer.add(pop);
				visited[pop] = true;
				List<Integer> list = adj.get(pop);

				//TODO. 큐가 아니고 스택이기 때문에 '오름차순'으로 수행하고 싶으면 sorting을 반대로 (FILO 잖아..)
//				Collections.sort(list);
				Collections.sort(list, Collections.reverseOrder());

				for(int node : list){
					deq.push(node);
				}
			}
		}

		//3.
		int[] ans = new int[answer.size()];
		for(int i=0; i<answer.size(); i++){
			ans[i] = answer.get(i);
		}

		return ans;
	}
}
