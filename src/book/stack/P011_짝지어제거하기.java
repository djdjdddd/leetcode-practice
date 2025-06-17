package book.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class P011_짝지어제거하기 {

	public static void main(String[] args) {
		String s1 = "baabaa";
		String s2 = "cdcd";

		int answer1 = solution(s1);
		int answer2 = solution(s2);

		System.out.println(answer1);
		System.out.println(answer2);
	}

	static int solution(String s){
		//'짝' -> 스택을 이용하면 편함

		//현재 문자와 top을 비교해서
		// - 같으면 pop(제거)
		// - 다르면 push(쌓기)
		//최종적으로 스택이 비어있으면? 올바른 케이스

		Deque<Character> stack = new ArrayDeque<>();
		for(Character c : s.toCharArray()){
			if(stack.isEmpty()){
				stack.push(c);
			}else{
				Character peek = stack.peek();
				if(c == peek){
					stack.pop();	//동일한 문자면 제거 (짝 지어 제거된 것)
				}else{
					stack.push(c);	//다른 문자면 계속 쌓아
				}
			}
		}

		int answer = 0;
		if(stack.isEmpty()){
			answer = 1;
		}

		return answer;
	}
}
