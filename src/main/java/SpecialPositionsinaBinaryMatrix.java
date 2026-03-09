public class SpecialPositionsinaBinaryMatrix {
    public static void main(String[] args) {

    }

  //https://leetcode.com/problems/special-positions-in-a-binary-matrix/?envType=daily-question&envId=2026-03-04
 public int numSpecial(int[][] mat) {
         int rows = mat.length;
        int cols = mat[0].length;
        int[] r =new int[rows];
        int[] c =new int[cols];
        int result=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j]==1){
                    r[i]+=1;
                    c[j]+=1;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (mat[i][j] == 1 && r[i] == 1 && c[j] == 1) {
                result++;
            }
        }
    }
        return result;
    }

  

}
