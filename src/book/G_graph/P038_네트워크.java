package book.G_graph;

import java.util.*;

public class P038_네트워크 {

  public static void main(String[] args) {
    int n = 3;
    int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
    int solution = solution(n, computers);
    System.out.println(solution);

    int n2 = 3;
    int[][] computers2 = {{1,1,0}, {1,1,1}, {0,1,1}};
    int solution2 = solution(n2, computers2);
    System.out.println(solution2);
  }

  static int solution(int n, int[][] computers){
    //1.DFS(BFS도 가능할 듯)로 방문하지 않은 노드에 대해 탐색을 수행
    //2.DFS 한 사이클 돌린 횟수 = 네트워크 수 라고 할 수 있음

    ArrayDeque<Integer> deq = new ArrayDeque<>();
    boolean[] visited = new boolean[n];
    int cnt = 0;  //네트워크 개수

    for(int i=0; i<n; i++){ //TODO. 서로 다른 네트워크일 수도 있어서 모든 노드에 대해 체크해봐야 함.
      if(!visited[i]){
        visited[i] = true;
        deq.push(i);
        cnt++;

        while(!deq.isEmpty()){
          int curr = deq.pop();

          for(int j=0; j<computers[curr].length; j++){
            int flag = computers[curr][j];
//            System.out.println("i:"+i+", j:"+j);
//            System.out.println("flag:"+flag);

            if(visited[j]) continue;
            if(i == j) continue;

//            visited[j] = true;  //TODO. 아이고 이 화상아... flag가 0인 것도 있어서 방문 안하는 경우도 있는데, 방문 처리하면 어떡하냐;;

            if(flag == 1){
              visited[j] = true;  //
              deq.push(j);
            }
          }
        }
      }
    }

    return cnt;
  }
}
