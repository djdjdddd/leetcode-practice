package book.C_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P016_기능개발_책풀이 {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		int[] solution = solution(progresses, speeds);
		System.out.println(Arrays.toString(solution));
	}

	static int[] solution(int[] progresses, int[] speeds){
		int[] answer = {};

		/* 2번째 풀이 방법 */

		// 1. 완료일 계산하기
		int leng = progresses.length;
		int[] days = new int[leng];

		for(int i=0; i<leng; i++){
			// (100 - 30) / 30 = 2.xx -> 3으로 올림 필요 (횟수니까)
			// ★ 라고 생각했는데 틀렸음.. 자바 연산 진짜 좆같네..
			// (70 / 30) 즉, 정수형끼리 나눗셈을 하는 순간 결과는 2.xx 가 아니라 정수형인 2가 돼버림
			// ★ 따라서 하나는 부동소수형으로 바꿔줘야 함.
			// 예를 들면, (double) speeds[i]
			int day = (int) Math.ceil( (100 - progresses[i]) / (double) speeds[i] );

			days[i] = day; // 완료일 세팅
		}


		// 2. 한번에 몇개씩 배포되는지 개수 세기
		// - ★ 이 로직은 아예 생각이 안 나서 책을 참조함 ㅠㅠ
		// - maxDay를 정하고, 이보다 큰 값이 존재하면 count를 초기화하면서 다시 셈 (마치 최대값 갱신하는 것처럼)
		int max = days[0];
		int count = 0;
		List<Integer> list = new ArrayList<>();

		for(int i=0; i<leng; i++){
			if(days[i] <= max){
				count++;
			}else{
				list.add(count);
				count = 1;
				max = days[i];
			}
		}
		list.add(count);    // 마지막으로 카운트 된 작업도 추가

		// System.out.println(list);

		int size = list.size();
		answer = new int[size];
		for(int i=0; i<size; i++){
			answer[i] = list.get(i);
		}

		return answer;
	}
}
