import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/pascals-triangle/

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> last=new ArrayList<>();
        last.add(1);
        list.add(last);
        if(numRows>1){
            for(int i = 1; i<numRows;i++){
                last=getNextList(last);
                list.add(last);
            }
        }
        return list;
    }

    public List<Integer> getNextList(List<Integer> last){
        List<Integer> result=new ArrayList<>();
        result.add(1);
        for(int i=0;i<last.size()-1;i++){
            result.add(last.get(i)+last.get(i+1));
        }
        result.add(1);
        return result;
    }
}
