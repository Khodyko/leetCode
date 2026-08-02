import java.util.HashSet;
import java.util.Set;

public class ValidSudoku2 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> res=new HashSet<>();
        for(int i=0; i<board.length;i++){
            for (int j=0; j<board[0].length; j++){
                if('.'==(board[i][j])){
                    continue;
                }
                if(!res.add("s"+i+board[i][j]) || !res.add("c"+j+board[i][j]) ||
                        !res.add("b"+"l"+i/3+"c"+j/3+board[i][j])
                ){
                    return false;
                }
            }
        }
        return true;
    }
}
