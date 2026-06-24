public class MaxIncreasing {


    public static void main(String[] args) {

    }


    public int maximumDifference(int[] nums) {
        int slow = 0;
        int fast = 1;
        int tmpMin = 0;
        int tmpMax = 0;
        int result = Integer.MIN_VALUE;
        while (fast < nums.length) {
            tmpMin = nums[slow];
            tmpMax = nums[fast];
            result = Math.max(result, tmpMax - tmpMin);
            slow = tmpMax < tmpMin ? fast : slow;
            fast += 1;
        }
        if(result<0){
            return -1;
        }
        return result;
    }
}
