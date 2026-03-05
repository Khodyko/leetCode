public class MinimumChangesToMakeAlternatingBinaryString {
    public static void main(String[] args) {
       
    }
//https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/?envType=daily-question&envId=2026-03-05
   public int minOperations(String s) {
        int count = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            if((s.charAt(i)&1)==i%2 ){
                count+=1;
            }
        }
        return Math.min(count, n-count);
    }
}
