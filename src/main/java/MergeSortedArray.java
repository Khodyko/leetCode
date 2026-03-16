import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1= new int[]{1,2,3,0,0,0};
        merge(nums1,3, (new int[]{2,5,6}), 3);
        System.out.println(Arrays.toString(nums1) + " eq 1,2,2,3,5,6");
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num=new int[nums1.length];
        int n1=0;
        int n2=0;
        for (int i = 0; i < nums1.length; i++) {
            if((n1>=nums1.length || m<=n1) && (nums2==null || n2>=nums2.length || n<=n2)){
                break;
            }else if(nums2==null || n2>=nums2.length || (nums1[n1]<=nums2[n2] && n1<=(m-1))){
                num[i]=nums1[n1];
                n1+=1;
            } else {
                num[i]=nums2[n2];
                n2+=1;
            }
        }
        System.arraycopy(num, 0, nums1, 0, nums1.length);

    }
}
