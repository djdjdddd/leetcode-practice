package book.array;

import java.util.*;

public class P001_정렬API {
	public static void main(String[] args) {
		solution(new int[]{4, 2, 3, 1, 5});
		solution(new int[]{1, -5, 2, 4, 3});
	}

	static void solution(int[] priArr){
		// 1. 배열
		// 1.1 기본형 배열 : 오름차순만 지원
		Arrays.sort(priArr);
		Arrays.sort(priArr, 1, 3);	// fromIndex, toIndex 가능
//		Arrays.sort(priArr, Comparator.reverseOrder());	// 오름차순 외 Comparator 활용한 정렬 X
//		Arrays.sort(priArr, (o1, o2) -> o1 - o2);	// X (불가, 기본형 primitive type은 compare 메서드가 없으니)

		// 1.2. 참조형 배열
		Integer[] refArr = {1, 3, 2, 4};
		Arrays.sort(refArr, Comparator.reverseOrder());
		Arrays.sort(refArr, (o1, o2) -> o2.compareTo(o1));	// 동일
		Arrays.sort(refArr, (o1, o2) -> Integer.compare(o2, o1));	// 동일
		Arrays.sort(refArr, (o1, o2) -> o2 - o1);	// 주의 (오버플로우 가능성)


		// 2. ArrayList
		// 2.1 정렬
		List<Integer> list = new ArrayList<>();
		Collections.sort(list);
		Collections.sort(list, Comparator.reverseOrder());
		Collections.sort(list, (o1, o2) -> Integer.compare(o2, o1));


		// 3. TreeSet 사용 (정렬과 중복제거 동시에)
		// 3.1. 기본 생성자 : natural ordering
		Set<Integer> natural = new TreeSet<>();
		// 3.2. Comparator를 인자로 받는 생성자
		Set<Integer> comparator = new TreeSet<>(Comparator.reverseOrder());
		// 3.3. 다른 Collection을 인자로 받는 생성자
		Set<Integer> collection = new TreeSet<>(list);
	}
}
