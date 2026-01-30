public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}) + " equals 2.00000");
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{1,2}) + " equals 2.50000");
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
        int[] nums3 = new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int sum=0;

//        while(nums1.length>i && nums2.length>j){
//
//        }
        return 0f;
    }
}
