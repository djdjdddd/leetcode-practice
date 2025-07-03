package book.B_stack;

import java.util.ArrayDeque;

public class P012_주식가격_과거풀이 {

	public static void main(String[] args) {
		solution(new int[]{1, 2, 3, 2, 3});
	}

	static int[] solution(int[] prices) {
		int[] answer = {};

		//
		int leng = prices.length;
		answer = new int[leng]; //return용
		ArrayDeque<Stock> stack = new ArrayDeque<>();

		for(int i=0; i<leng; i++){
			int price = prices[i];
			Stock s = new Stock(i, price);

			//★분기 쳐서 경우에 따라 push 하려니 너무 복잡하다..
			// 그냥 일단 push 하고, 꺼내서 확인하는게 나을지도?

			if(!stack.isEmpty()){
				while(!stack.isEmpty() && stack.peek().price > price){  //★NPE 유의 (isEmpty 조건 안 걸어주면 stack.peek 때 NPE 발생함)
					Stock top = stack.pop();
					answer[top.idx] = i - top.idx;
				}
			}

			stack.push(s);
		}

		// 마지막으로 stack을 비우면서 count 세기
		while(!stack.isEmpty()){
			Stock s2 = stack.pop();
			//System.out.println(s2);
			answer[s2.idx] = leng - 1 - s2.idx; //★아니 왜 2번째 값이 3이 아니고 2가 나오지?
		}

		return answer;
	}

	static class Stock{
		int idx;
		int price;

		Stock(int idx, int price){
			this.idx = idx;
			this.price = price;
		}

		@Override
		public String toString(){
			return "idx = " + idx + ", price = " + price;
		}
	}
}
