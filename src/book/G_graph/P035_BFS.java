package book.G_graph;

import java.util.Arrays;
import java.util.*;

public class P035_BFS {

	public static void main(String[] args) {
		int[][] graph = {{1,2},{1,3},{2,4},{2,5},{3,6},{3,7},{4,8},{5,8},{6,9},{7,9}};
		int start = 1;
		int n = 9;
		int[] solution = solution(graph, start, n);
		System.out.println(Arrays.toString(solution));	//[1,2,3,4,5,6,7,8,9]

		int[][] graph2 = {{1,3},{3,4},{3,5},{5,2}};
		int start2 = 1;
		int n2 = 5;
		int[] solution2 = solution(graph2, start2, n2);
		System.out.println(Arrays.toString(solution2));	//[1,3,4,5,2]
	}

	static int[] solution(int[][] graph, int start, int n){
		//1.자료구조 세팅 (일단 인접 리스트)
		List<List<Integer>> list = new ArrayList<>();
		for(int i=0; i<=n; i++){
			list.add(new ArrayList<>());
		}
		for(int i=0; i<graph.length; i++){
			list.get(graph[i][0]).add(graph[i][1]);
		}
//		System.out.println(list);


		//2.알고리즘 구현 (BFS)
		Deque<Integer> deq = new ArrayDeque<>();
		List<Integer> answer = new ArrayList<>();
		boolean[] visited = new boolean[n+1];

		deq.addLast(start);
		while(!deq.isEmpty()){
			int poll = deq.pollFirst();	//정방향 큐 : addLast, pollFirst
			if(!visited[poll]){
				visited[poll] = true;
				answer.add(poll);
				List<Integer> nodeList = list.get(poll);
				for(int node : nodeList){
					deq.addLast(node);
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
