package leetcode.binary.missing_number;

public class FollowUp {
  public static void main(String[] args) {
    //Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

    //시간복잡도는 O(n)으로, 공간복잡도는 O(1)으로 제한

    //이럴 경우 추가적인 arr을 사용 못함. 파라미터로 준 nums를 이용해야 되나?
    int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
    
    //★찾았다 빈틈의 실..
    //0~n 까지 더한 합에서 nums에 있는 값을 다 빼면 missing_number를 구할 수 있음.
    //그러면 굳이 추가 배열을 쓰지 않아도 되니까 가능

    int len = nums.length;
    int res = 0;
    for(int i=0; i<=len; i++){
      res += i;
    }

    for(int i=0; i<len; i++){
      res -= nums[i];
    }

    System.out.println(res);
  }
}
