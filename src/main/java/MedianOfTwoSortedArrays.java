public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) + " equals 2.00000");
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}) + " equals 2.50000");
        System.out.println(findMedianSortedArrays(new int[]{-10,-9,-8}, new int[]{1, 2}) + " equals -8.0000");
    }


    //4. Median of Two Sorted Arrays
    //Hard
    //Topics
    //premium lock icon
    //Companies
    //Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    //
    //The overall run time complexity should be O(log (m+n)).
    //
    //
    //
    //Example 1:
    //
    //Input: nums1 = [1,3], nums2 = [2]
    //Output: 2.00000
    //Explanation: merged array = [1,2,3] and median is 2.
    //Example 2:
    //
    //Input: nums1 = [1,2], nums2 = [3,4]
    //Output: 2.50000
    //Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    //
    //
    //Constraints:
    //
    //nums1.length == m
    //nums2.length == n
    //0 <= m <= 1000
    //0 <= n <= 1000
    //1 <= m + n <= 2000
    //-106 <= nums1[i], nums2[i] <= 106
    //https://leetcode.com/problems/median-of-two-sorted-arrays/description/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = 0;
        int right = len1;

        while (left <= right) {
            int part1 = (left + right) / 2;
            int part2 = (len1 + len2 + 1) / 2 - part1;

            int leftMax1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
            int rightMin1 = (part1 == len1) ? Integer.MAX_VALUE : nums1[part1];
            int leftMax2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
            int rightMin2 = (part2 == len2) ? Integer.MAX_VALUE : nums2[part2];

            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(leftMax2, leftMax1) + Math.min(rightMin2, rightMin1)) / 2.0;
                } else {
                    return (double) Math.max(leftMax1, leftMax2);
                }
            } else if (leftMax1 > rightMin2) {
                right = part1 - 1;
            } else {
                left = part1 + 1;
            }

        }
        return 0.0;
    }
}
