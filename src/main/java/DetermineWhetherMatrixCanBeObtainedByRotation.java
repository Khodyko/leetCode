public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/submissions/1955959297/?envType=daily-question&envId=2026-03-22
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean i0=true;
        boolean i90 = true;
        boolean i180 = true;
        boolean i270 = true;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (i0 && mat[i][j] != target[i][j]) {
                    i0 = false;
                }
                if (i90 && mat[i][j] != target[j][mat.length -1 - i]) {
                    i90 = false;
                }
                if (i180 && mat[i][j] != target[mat.length-1 - i][mat.length-1 - j]) {
                    i180 = false;
                }
                if (i270 && mat[i][j] != target[mat.length -1 - j][i]) {
                    i270 = false;
                }
            }
        }
        return i0 || i90 || i180 || i270;
    }
}
