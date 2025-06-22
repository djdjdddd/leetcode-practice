package book.C_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P016_기능개발 {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		int[] solution = solution(progresses, speeds);

		System.out.println(Arrays.toString(solution));
	}

	static int[] solution(int[] progresses, int[] speeds){
		//★왜 큐를 쓰는가?
		//문제에서 구해야 하는 답의 형태가 "뒤의 기능은 앞의 기능이 배포될 때 함께 배포되어야 합니다. 각 배포마다 몇 개의 기능이 배포되는지 반환..."
		//이므로 답을 구하기 편한 자료구조가 바로 큐


		//1.처음엔 값(progress)을 넣으려고 했지만, 인덱스(몇 번째 기능인지)를 넣는게 훨씬 효율적
		int len = progresses.length;
		Deque<Integer> deq = new ArrayDeque<>();
		for(int i=0; i<len; i++){
			deq.addLast(i);	//큐에 값이 아니라 인덱스를
		}


		//2.큐의 front(반댓말 rear)가 완료되면 그때부터 완료된 개수 세면 됨.
		List<Integer> list = new ArrayList<>();
		while(!deq.isEmpty()){
			//하루마다 ++
			for(int i=0; i<len; i++){
				progresses[i] += speeds[i];	//누적합
			}
			int cnt = 0;

			//100 이상인 것들 체크
			//★단순히.. 맨 앞에 있는게 100 이상? 미만? 체크 -> 완료된 것들 모두 체크
			int peek = deq.peek();	//★주의) addLast, pollFirst 해야 정방향 큐임 (그래야 peek 했을 때 처음 넣은 값이 나옴)
									//★혹은 peekFirst(), peekLast() 사용
//			System.out.println("peek:" + peek + ", progresses[peek]:" + progresses[peek]);
			if(progresses[peek] >= 100){
				//TODO. do-while 로 교체 가능
				do {
					deq.pollFirst();
					cnt++;
				} while (!deq.isEmpty() && progresses[deq.peek()] >= 100);
			}

			if(cnt != 0){
				list.add(cnt);
			}
		}

		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++){
			answer[i] = list.get(i);
		}

		return answer;
	}
}

