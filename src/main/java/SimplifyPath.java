import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/.../a/../b/c/../d/./")+ " eq /.../b/d");
    }

    //https://leetcode.com/problems/simplify-path/
    public static String simplifyPath(String path) {
        String[] arr= path.split("/");
        Deque<String> q=new ArrayDeque<>();

        for(String d:arr){
            if(!d.isEmpty() && !".".equals(d)){
                if("..".equals(d)){
                    if(!q.isEmpty()){
                        q.pollLast();
                    }
                } else {
                    q.add(d);
                }
            }
        }
        return "/"+ String.join("/", q);
    }
}
