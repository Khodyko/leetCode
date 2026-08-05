public class HouseRobberIV {



    public int minCapability(int[] nums, int k) {
        int left=0;
        int right=1;

        for(int num : nums){
            right=Math.max(right, num);
        }

        int mid;

        while(left<=right){
            mid = (right + left) / 2 ;
            if(isCanRob(k, mid, nums)){
                right=mid;
            } else {
                left=mid+1;
            }
        }

        return left;
    }

    boolean isCanRob(int k, int mid, int[] nums){
        int housesForRobbing=0;
        for(int i=0; i<nums.length; i++){
            if(mid>=nums[i]) {
                housesForRobbing++;
                i++;
            }
        }
        return housesForRobbing>=k;
    }
}
