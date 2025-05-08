package leetcode.binary.missing_number;

public class Solution {

  public static void main(String[] args) {
    //https://leetcode.com/problems/missing-number/description/
    int[] nums1 = new int[]{3,0,1};
    int res1 = solution(nums1);
    System.out.println(res1); //2

    int[] nums2 = new int[]{0,1};
    int res2 = solution(nums2);
    System.out.println(res2); //2

    int[] nums3 = new int[]{9,6,4,2,3,5,7,0,1};
    int res3 = solution(nums3);
    System.out.println(res3); //8
  }

  private static int solution(int[] nums) {
    int len = nums.length;
    int[] arr = new int[len+1];
    for(int i=0; i<len; i++){
      arr[nums[i]] = 1;
    }

    int res = 0;
    for(int i=0; i<=len; i++){  //arr은 n+1개라서 i<=len 까지
      if(arr[i] == 0) res = i;
    }

    return res;
  }

}
