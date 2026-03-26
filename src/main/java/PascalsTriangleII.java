import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {


    public static void main(String[] args) {

    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> last=new ArrayList<>();
        last.add(1);
        list.add(last);
        if(rowIndex>0){
            for(int i = 1; i<=rowIndex;i++){
                last=getNextList(last);
                list.add(last);
            }
        }
        return last;
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
