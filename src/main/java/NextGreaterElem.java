import java.util.HashMap;

/**
 * https://leetcode.com/problems/next-greater-element-i/description/
 */
public class NextGreaterElem {

    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> place=new HashMap<>();
        int[] result=new int[nums1.length];
        for(int i = 0; i<result.length; i++){
            result[i]=-1;
        }

        for(int i = 0; i<nums1.length; i++){

            place.put(nums1[i], i);

        }

        Integer tmp;
        for(int i = 0; i<nums2.length; i++){
            tmp=place.get(nums2[i]);
            if(tmp!=null){
                for(int j=i; j<nums2.length; j++){
                    if(nums2[j]>nums2[i]){
                        result[tmp]=nums2[j];
                        break;
                    }
                }

            }
        }
        return result;
    }
}
