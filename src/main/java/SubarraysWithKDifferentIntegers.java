import java.util.*;

public class SubarraysWithKDifferentIntegers {

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2) + " eq 7");
    }

    //Given an integer array nums and an integer k, return the number of good subarrays of nums.
    //
    //A good array is an array where the number of different integers in that array is exactly k.
    //
    //For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
    //A subarray is a contiguous part of an array.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [1,2,1,2,3], k = 2
    //Output: 7
    //Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
    //Example 2:
    //
    //Input: nums = [1,2,1,3,4], k = 3
    //Output: 3
    //Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
    //
    //
    //Constraints:
    //
    //1 <= nums.length <= 2 * 104
    //1 <= nums[i], k <= nums.length
    //https://leetcode.com/problems/subarrays-with-k-different-integers/description/
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return getMax(nums, k) - getMax(nums, k - 1);
    }

    public static int getMax(int[] nums, int k) {
        int l = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            count += right - l + 1;
        }
        return count;
    }


}
