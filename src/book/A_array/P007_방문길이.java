package book.A_array;

import java.util.*;

public class P007_방문길이 {

	public static void main(String[] args) {
//		String dirs1 = "ULURRDLLU";
//		int answer = solution(dirs1);
//		System.out.println(answer);		//7

		String dirs2 = "LULLLLLLU";
		int answer2 = solution(dirs2);
		System.out.println(answer2);	//7
	}

	static int solution(String dirs){
		//★어떻게 한번 지나간 길이란 걸 알 수 있을까?? -> 방문 여부 체크법
		// 1. 점(위치) : visited[x][y]
		// 2. 선분(간선) : Set<String>

		int x = 0;
		int y = 0;
//		int x2 = x;		//★주의. 매번 갱신을 해주지 않으면 좌표 바깥으로 벗어나는 케이스에서는 틀림
//		int y2 = y;
		Set<String> set = new HashSet<>();

		for(char c : dirs.toCharArray()){
			int x2 = x;		//★주의. 매번 갱신을 해주지 않으면 좌표 바깥으로 벗어나는 케이스에서는 틀림
			int y2 = y;

			if(c == 'U'){
				y2 += 1;
			}else if(c == 'D'){
				y2 -= 1;
			}else if(c == 'R'){
				x2 += 1;
			}else if(c == 'L'){
				x2 -= 1;
			}

			if( x2 < -5 || x2 > 5 || y2 < -5 || y2 > 5 ){
				continue;
			}

			String path1 = x + "," + y + "," + x2 + "," + y2;
			String path2 = x2 + "," + y2 + "," + x + "," + y;
			set.add(path1);
			set.add(path2);
			System.out.println(path1);
//			System.out.println(set);

			x = x2;		//시작점(x1,y1)에 도착점(x2,y2)을 대입하고 반복
			y = y2;
		}

		return set.size() / 2;
	}
}
