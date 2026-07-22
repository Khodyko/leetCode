import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[2];
        HashMap<Integer, Integer> s = new HashMap<>();
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            tmp = target - nums[i];
            if (s.containsKey(tmp)) {
                res[0] = s.get(tmp);
                res[1] = i;
                return res;
            }
            s.put(nums[i], i);
        }
        return res;
    }
}
