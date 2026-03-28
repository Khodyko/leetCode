public class Main {
public static void main(){}

    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        if(k==0){
            return true;}
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                   if(mat[i][j] != mat[i][(j+k)%m])
                    return false;
                    
                } 
        
            }
        
return true;
    }
}
