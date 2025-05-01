package leetcode.array.palindrome_number;

import java.util.*;

class Solution {
	public boolean isPalindrome(int x) {
		// 1. 뒤집기 전에 일단 배열에 1개씩 넣어
		// 2. 뒤집은 다음 순차적으로 비교

		String str = String.valueOf(x);
		boolean res = true;

		// 뒤집어야 하니까.. 배열 말고 리스트를 쓰자 (쉽게 뒤집기 위해서)
		List<Character> list = new ArrayList<>();
		for(char c : str.toCharArray()){
			list.add(c);
		}

		// 뒤집기
		Collections.reverse(list);

		// 비교
		for(int i=0; i<str.length(); i++){
			char a = str.charAt(i);
			if(a != list.get(i)){
				res = false;
			}
		}

		return res;
	}
}
