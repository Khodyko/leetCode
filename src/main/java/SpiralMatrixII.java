import java.util.Arrays;

public class SpiralMatrixII {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    // Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
//
//
//
//Example 1:
//
//
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
//Example 2:
//
//Input: n = 1
//Output: [[1]]
//https://leetcode.com/problems/spiral-matrix-ii/description/
    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int value = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                arr[top][i] = value;
                value++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                arr[i][right] = value;
                value++;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    arr[bottom][i] = value;
                    value++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    arr[i][left] = value;
                    value++;
                }
                left++;
            }

        }
        return arr;

    }
}