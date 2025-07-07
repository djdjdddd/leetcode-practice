package book.F_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P032_영어끝말잇기 {

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
		//체크
		//1.횟수 : 2번 이상 나온 단어인지
		//2.단어 : 끝말잇기가 제대로 안 된 단어인지

		int[] result = new int[2];

		String firstWord = words[0];
		char end = firstWord.charAt(firstWord.length()-1);

		Set<String> set = new HashSet<>();
		set.add(firstWord);	//★처음에 이거 안 넣어서 계속 실패하고 있었음;;

		for(int i=1; i<words.length; i++){	//어차피 0번째는 체크 안해도 되겠네
			String word = words[i];
			char start = word.charAt(0);

			//끝말잇기가 안되거나 OR 이미 나온 단어일 경우
			if(start != end || set.contains(word)){
				result[0] = i%n + 1;	// idx%n => 번호
				result[1] = i/n + 1;	// idx/n => 차례
				return result;	//★★★★★ 가장 먼저 탈란 사람의 [번호,차례]를 구하라고 해서...
			}

			set.add(word);
			end = word.charAt(word.length()-1);	//end = start 가 아니지..
		}

		return result;
	}
}
