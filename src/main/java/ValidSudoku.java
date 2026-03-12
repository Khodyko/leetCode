import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    if(!seen.add(" in row "+i+" value:"+ board[i][j]) ||
                            !seen.add(" in column "+j+" value:"+ board[i][j]) ||
                            !seen.add(" in block "+i/3+"-"+j/3+" value:"+ board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
