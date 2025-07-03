package book.A_array;

import java.util.*;

public class P005_행렬의곱셈 {
	public static void main(String[] args) {
		int[][] arr1 = new int[][]{{1,4}, {3,2}, {4,1}};
		int[][] arr2 = new int[][]{{3,3}, {3,3}};

		int[][] solution = solution(arr1, arr2);
		System.out.println(Arrays.toString(solution[0]));
		System.out.println(Arrays.toString(solution[1]));
		System.out.println(Arrays.toString(solution[2]));
	}

	static int[][] solution(int[][] arr1, int[][] arr2){
		//공식처럼 암기하기
		//for(x) -> for(y) -> for(i)
		//res[x][y] = arr1[x][i] * arr2[i][y];


		//실제 코드
		int len1 = arr1.length;
		int len2 = arr2.length;
		int[][] res = new int[len1][len2];

		for(int x=0; x<len1; x++){
			for(int y=0; y<len2; y++){
				for(int i=0; i<arr1[0].length; i++){
					res[x][y] += arr1[x][i] * arr2[i][y];	// =가 아니고 +=
				}
			}
		}


		return res;
	}
}
