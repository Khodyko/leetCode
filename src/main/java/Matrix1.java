import java.util.HashSet;
import java.util.Set;

public class Matrix1 {

    public static void main(String[] args) {

    }

    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        for(int i=0; i<n; i++){
            Set<Integer> row =new HashSet<>();
            Set<Integer> col =new HashSet<>();
            for(int j=0; j<n;j++){
                row.add(matrix[i][j]);
                col.add(matrix[j][i]);
            }
            if(row.size()<n || col.size()<n){
                return false;

            }
        }
        return true;
    }
}
