public class CountSubmatricesWithEqualFrequencyofXandY {
    public static void main(String[] args) {
        char[][] array = {
                {'.', 'X'},
                {'.', 'Y'}
        };
        System.out.println(numberOfSubmatrices(array));
    }

    public static int numberOfSubmatrices(char[][] grid) {
        int result=0;
        int[] x=new int[grid[0].length], y=new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int sumX=0, sumY=0;
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='X'){
                    sumX+=1;
                } else if (grid[i][j]=='Y') {
                    sumY+=1;
                }
                x[j]+=sumX;
                y[j]+=sumY;

                if(x[j]>0 && x[j]==y[j]){
                    result++;
                }
            }
        }
        return result;
    }
}
