public class BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5)+ " eq true");
        System.out.println(hasAlternatingBits(7)+ " eq false");
        System.out.println(hasAlternatingBits(11)+ " eq false");
    }

    // Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
    //
    //
    //
    //Example 1:
    //
    //Input: n = 5
    //Output: true
    //Explanation: The binary representation of 5 is: 101
    //Example 2:
    //
    //Input: n = 7
    //Output: false
    //Explanation: The binary representation of 7 is: 111.
    //Example 3:
    //
    //Input: n = 11
    //Output: false
    //Explanation: The binary representation of 11 is: 1011.
    //
    //
    //Constraints:
    //
    //1 <= n <= 231 - 1

    //https://leetcode.com/problems/binary-number-with-alternating-bits/description/?envType=daily-question&envId=2026-02-18
    public static boolean hasAlternatingBits(int n) {
        String a= Integer.toBinaryString(n);
        return !a.contains("11") && !a.contains("00");
    }
}
