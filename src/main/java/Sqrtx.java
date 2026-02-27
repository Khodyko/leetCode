public class Sqrtx {
    public static void main(String[] args) {

    }
    // https://leetcode.com/problems/sqrtx/

    public int mySqrt(int x) {
        if(x<2){
            return x;
        }
        int left = 1;
        while (true) {
            if ((long) left * left > x) {
                break;
            }
            left++;
        }
        return left-1;
    }
}
