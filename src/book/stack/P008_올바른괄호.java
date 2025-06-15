package book.stack;

import java.util.*;
public class P008_올바른괄호 {

	public static void main(String[] args) {
		String s1 = "()()";
		String s2 = "(())()";
		String s3 = "(()()))";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
	}

	static boolean solution(String s){
		// "("일 땐 스택에 push
		// ")"일 땐 스택에 있는 "("을 pop
		Deque<Character> stack = new ArrayDeque<>();

		for(char c : s.toCharArray()){
			if(c == '('){
				stack.push(c);
			}else if(c == ')'){
				if(stack.isEmpty()){
					return false;
				}
				stack.pop();
			}
		}

		return stack.isEmpty();
	}
}
