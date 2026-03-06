public class CheckifBinaryStringHasatMostOneSegmentofOnes {
    public static void main(String[] args) {
        
    }

  //https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/?envType=daily-question&envId=2026-03-06
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
