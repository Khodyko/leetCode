public class FindMinimuminRotatedSortedArray {

    static void main() {

    }


    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int mid =0;
        if(nums[left]<=nums[right]){
            return nums[left];
        }


        while(left<=right){
            mid = left+(right-left)/2;
            if(nums[mid]>=nums[left]){
                left=mid;
            } else {
                right=mid;
            }
            if(left>=(right-1)){
                mid=Math.min(nums[left],nums[right]);
                break;
            }
        }

        return mid;
    }
}
