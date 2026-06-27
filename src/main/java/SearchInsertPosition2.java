public class SearchInsertPosition2 {
    public static void main(String[] args) {
    }

    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target < nums[0]) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int center = getCenter(end, start);
        while (start < end && center != start && center != end && nums[center]!=target) {
            if (nums[center] > target) {
                end = center;
            } else if(nums[center] < target){
                start = center;
            }
            center = getCenter(end, start);
        }
        if (nums[center] == target) {
            return center;
        } else if (nums[center] > target) {
            return center - 1;
        } else {
            return center + 1;
        }
    }

    public int getCenter(int end, int start){
        return start + ((end - start) / 2);
    }
}
