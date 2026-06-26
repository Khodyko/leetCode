/**
 * https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
 */
public class MaximumCountofPositiveIntegerandNegativeInteger {


    public static void main(String[] args) {

    }


    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos += 1;
            } else if (nums[i] < 0) {
                neg += 1;
            }
        }
        return Math.max(pos, neg);
    }
}
