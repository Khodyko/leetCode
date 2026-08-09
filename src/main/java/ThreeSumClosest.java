import java.util.Arrays;

public class ThreeSumClosest {

    static void main() {
        ThreeSumClosest threeSumClosest =new ThreeSumClosest();
        IO.println(threeSumClosest.threeSumClosest(new int[]{-1,2,1,-4},2));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left;
        int right;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target-sum) < Math.abs(target-result)){
                    result=sum;
                }
                if(sum==target){
                    return result;
                }
                else if(sum<target){
                    left++;
                } else {
                    right--;
                }
            }

        }
        return result;
    }

}
