package book.F_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P032_영어끝말잇기_과거풀이 {

	public static void main(String[] args) {
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] result = solution(n, words);
		System.out.println(Arrays.toString(result));

		int n2 = 5;
		String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		int[] result2 = solution(n2, words2);
		System.out.println(Arrays.toString(result2));

		int n3 = 2;
		String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
		int[] result3 = solution(n3, words3);
		System.out.println(Arrays.toString(result3));
	}

	static int[] solution(int n, String[] words){
		// 1. 중복 제거를 위해 Set 을 사용해볼까?? 해당 원소를 갖고 있으면 틀렸다고 판단할 수 있잖아
		// 2. 끝말잇기 validation도 필요. 즉, 끝말로 시작하지 않으면 틀린 것

		// 1.
		Set<String> set = new HashSet<>();
		int num = 0;

		for(int i=0; i<words.length; i++){
			String word = words[i];
			num = i+1;

			String prevWord = null;
			if(i != 0){
				prevWord = words[i - 1];
			}

			// (1) 중복 or 끝말잇기 X
			if(set.contains(word) || (prevWord != null && prevWord.charAt(prevWord.length() - 1) != word.charAt(0)) ) {
				break;
			}else{
				set.add(word);
			}
		}

		// 2. num을 이용해 답 구하기 (노트 참조)
		// System.out.println(num);
		// 1) 탈락 번호
		// -
		// -

		// 2) 차례
		// -
		// -

		int ans1 = 0;
		int ans2 = 0;

		// 3. 틀린 사람 1명도 없는 케이스
		// num == leng (X)
		// num == set.size (O) : 정답 집합의 길이가 words 길이와 같으면 OK
		if(num != set.size()){
			int mod = num % n;
			if(mod == 0){
				ans1 = n;
				ans2 = num / n;
			}else{
				ans1 = mod;
				ans2 = (num / n) + 1;
			}
		}

		// 4. 출력
		int[] answer = new int[2];
		answer[0] = ans1;
		answer[1] = ans2;

		return answer;
	}
}
