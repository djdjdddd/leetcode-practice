package book.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P012_주식가격 {

	//초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
	//가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] answer = solution(prices);
		System.out.println(Arrays.toString(answer));	//[4, 3, 1, 1, 0]
	}

	static class Info{
		int idx;
		int price;
		int inSec;

		Info(int idx, int price, int inSec){
			this.idx = idx;
			this.price = price;
			this.inSec = inSec;
		}

		public String toString(){
			return "idx:" + this.idx + ", price:" + this.price + ", inSec:" + inSec;
		}
	}

	static int[] solution(int[] prices){
		//가격이 떨어지지 않은 기간...
		//★'떨어졌는지'를 판단하려면 결국 이전 값을? 값들을? 빠르게 -> 그래서 스택 사용하면 좋다??

		int sec = 0;	//스택 in/out 시간을 기억하기 위해
		Deque<Info> stack = new ArrayDeque<>();
		int[] answer = new int[prices.length];

		for(int i=0; i<prices.length; i++){
			int price = prices[i];
			sec++;

			if(stack.isEmpty()){
				stack.push(new Info(i, price, sec));
			}else{
				Info top = stack.peek();

				//★스택에서 pop, peek 한 걸 쓸 때는 NPE를 항상 조심...
				// => top != null 을 먼저 넣어서 방지
				while(top != null && price < top.price){
					Info pop = stack.pop();
					answer[pop.idx] = sec - pop.inSec;	//outSec - inSec
					top = stack.peek();
				}

				stack.push(new Info(i, price, sec));
			}
		}

		while(!stack.isEmpty()){
			Info pop = stack.pop();
			answer[pop.idx] = sec - pop.inSec;
		}

//		System.out.println(Arrays.toString(answer));

		//1 2 3 2 3
		return answer;
	}
}
