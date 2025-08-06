package book.G_graph;

import java.util.*;

public class P039_미로탈출 {

  public static void main(String[] args) {
    String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
    int solution = solution(maps);
    System.out.println(solution);

    String[] maps2 = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
    int solution2 = solution(maps2);
    System.out.println(solution2);
  }

  static int solution(String[] maps){
    //S 좌표 구하기
    int sx = 0, sy = 0;
    int ex = 0, ey = 0;
    int x = maps.length; //TODO. 얘를 sx,y라고 하고, S의 좌표를 sx, sy가 나을 듯??
    int y = maps[0].length();
    char[][] temp = new char[x][y];

    for(int i = 0; i< x; i++){
      //탐색 편하게 2차원 배열 생성
      for(int j=0; j<maps[i].length(); j++){
        temp[i][j] = maps[i].charAt(j);
      }

      int sIdx = maps[i].indexOf("S");
      if(sIdx > -1){
        sx = i;
        sy = sIdx;
      }

      int eIdx = maps[i].indexOf("E");
      if(eIdx > -1){
        ex = i;
        ey = eIdx;
      }
    }

    //
    boolean[][] visited = new boolean[x][y];
    int[][] dist = new int[x][y];

    //O, L인 길만을 따라 E를 찾으면 끝
    ArrayDeque<Point> deq = new ArrayDeque<>();
    deq.addLast(new Point(sx, sy));

    while(!deq.isEmpty()){
      Point curr = deq.pollFirst();

      //E에 도달했다면 더이상 하지 않고 컷
      if(curr.x == ex && curr.y == ey){
        break;
      }

      for(int i=0; i<d.length; i++){
        int nx = curr.x + d[i][0];
        int ny = curr.y + d[i][1];

        //정상 범위 체크
        if(nx < 0 || nx >= x || ny < 0 || ny >= y){
          continue;
        }

        //이미 방문한 좌표는 패스 (돌아갈까봐 그래 돌아갈까봐~)
        if(visited[nx][ny]){
          continue;
        }

        //통로(O) 또는 레버(L) (TODO. 바보야 'E'도 갈 수 있어야지..)
        char next = temp[nx][ny];
        if(next == 'O' || next == 'L' || next == 'E'){
          //방문했다고 표시하고, 스택에 넣어 (요놈에 연결된 길 탐색할 거니까)
          visited[nx][ny] = true;
          dist[nx][ny] = dist[curr.x][curr.y] + 1;
//          System.out.println("nx:"+nx + ", ny:"+ny);
//          System.out.println("현재 dist:"+dist[curr.x][curr.y] + ", 다음 dist:"+dist[nx][ny]);
          deq.addLast(new Point(nx, ny));
        }
      }
    }

    return dist[ex][ey];
  }

  //direction : 방향
  static int[][] d = {{0,1}, {0,-1}, {-1,0}, {1,0}};

  //TODO. 혹은 이렇게도 가능 (상하좌우 순서)
  int[] dx = {0,0,-1,1};
  int[] dy = {1,-1,0,0};

  static class Point{
    int x;
    int y;

    public Point(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
}
