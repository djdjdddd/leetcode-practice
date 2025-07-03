package book.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P027_다단계칫솔판매 {

	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		int[] result = solution(enroll, referral, seller, amount);
		System.out.println(Arrays.toString(result));
	}

	static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
		//sam -> edward -> mary -> center
		//타고 타고 가야하니까 맵(K,V)
		Map<String, String> map = new HashMap<>();
		Map<String, Integer> profit = new HashMap<>();	//누적금 계산용

		//1.그래프/트리 만들기
		for(int i=0; i<enroll.length; i++){
			String e = enroll[i];
			String r = referral[i];
			map.put(e, r);
			profit.put(e, 0);
		}

		//트리 타고 가면서 계산
		for(int i=0; i<seller.length; i++){
			int amt = amount[i] * 100;

			String curr = seller[i];
//			profit.put(curr, amount[i] * 10 * 9);	//fucking idiot... 이러니 누적이 안되지
			profit.put(curr, profit.getOrDefault(curr,0) + amount[i] * 10 * 9);

			String next = map.get(seller[i]);

			while(!"-".equals(next)){
				amt = amt / 10;
				if(amt == 0){	//0원 미만이면 끝
					break;
				}

				//90%를 얻어야 하므로 원금-10%
				int temp = amt / 10;	//10%

				profit.put(next, profit.getOrDefault(next,0) + amt - temp);//90% 누적
				next = map.get(next);
			}
//			System.out.println(profit);
		}

		//출력: enroll 배열의 이름 순서대로
		int[] result = new int[profit.size()];
		int idx = 0;
		for(String e : enroll){
			result[idx] = profit.get(e);
			idx++;
		}

		return result;
	}
}
