public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123) + " eq 321");
        System.out.println(reverse(-123) + " eq -321");
    }

//7. Reverse Integer
//Medium
//Topics
//premium lock icon
//Companies
//Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//
//Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//
// 
//
//Example 1:
//
//Input: x = 123
//Output: 321
//Example 2:
//
//Input: x = -123
//Output: -321
//Example 3:
//
//Input: x = 120
//Output: 21
// 
//
//Constraints:
//
//-231 <= x <= 231 - 1

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
        sb.reverse();
        String minus = x > 0 ? "" : "-";

        int newInt = 0;
        try {

            newInt = Integer.parseInt(minus+sb.toString());
        } catch (NumberFormatException e) {
            //do nothing
        }
        return newInt;
    }
}
