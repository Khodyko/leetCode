public class CountSubmatriceswithTopLeftElementandSumLessThanK {
    public static void main(String[] args) {
        int[][] array = {
                {7, 2, 9},
                {1, 5, 0},
                {2, 6, 6}
        };
        System.out.println(countSubmatrices(array, 20));
    }

    // https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/?envType=daily-question&envId=2026-03-18
    public static int countSubmatrices(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i>0){
                    grid[i][j]+=grid[i-1][j]-(j>0?grid[i-1][j-1]:0);
                }
                if(j>0){
                    grid[i][j]+=grid[i][j-1];
                }
                if(grid[i][j]<=k){
                    result+=1;
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
