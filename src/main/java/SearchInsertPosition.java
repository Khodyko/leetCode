public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5) + "  equals 2");
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2) + "  equals 1");
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7) + "  equals 4");
        System.out.println(searchInsert(new int[]{1, 4, 6, 8, 10}, 5) + "  equals 2");
        System.out.println(searchInsert(new int[]{1}, 1) + "  equals 0");
        System.out.println(searchInsert(new int[]{1, 5, 6, 8, 9, 10}, 1) + "  equals 0");
        System.out.println(searchInsert(new int[]{1, 3, 6, 9}, 9) + "  equals 3");
    }

    //Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    //
    //You must write an algorithm with O(log n) runtime complexity.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [1,3,5,6], target = 5
    //Output: 2
    //Example 2:
    //
    //Input: nums = [1,3,5,6], target = 2
    //Output: 1
    //Example 3:
    //
    //Input: nums = [1,3,5,6], target = 7
    //Output: 4
    //
    //
    //Constraints:
    //
    //1 <= nums.length <= 104
    //-104 <= nums[i] <= 104
    //nums contains distinct values sorted in ascending order.
    //-104 <= target <= 104
    //https://leetcode.com/problems/search-insert-position/description/
    public static int searchInsert(int[] nums, int target) {


        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 1 && target == nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target == nums[nums.length - 1]) {
            return nums.length-1;
        }
        if (target <= nums[0]) {
            return 0;
        }
        int middle = start + ((end - start) / 2);


        while (target <nums[end] && target > nums[start] && end-start>1) {
            if(nums[middle]==target){
                return middle;
            }
            if (nums[middle] > target) {
                end = middle;
                middle = start + ((end - start) / 2);
                continue;
            }
            if (nums[middle] < target) {
                start = middle;
                middle = start + ((end - start) / 2);
                continue;
            }
            break;
        }
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return middle - 1;
        } else {
            return middle + 1;
        }
    }
}
