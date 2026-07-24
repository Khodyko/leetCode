import java.util.*;

public class ValidParentheses2 {

    public static void main(String[] args) {
        ValidParentheses2 v=new ValidParentheses2();
//        v.isValid("()");
//        v.isValid("()[]{}");
//        v.isValid("(]");
        v.isValid("([])");
    }


    public boolean isValid(String s) {
        Deque<Character> q = new ArrayDeque<>();
        Map<Character, Character> m = new HashMap();
        m.put('{', '}');
        m.put('(', ')');
        m.put('[', ']');
        m.put('<', '>');

        Character top;
        for (char c : s.toCharArray()) {
            top = q.peek();
            if (top !=null && ((Character)c).equals(m.get(top))) {
                q.poll();
            } else {
                q.addFirst(c);
            }
        }
        System.out.println(q);
        return q.isEmpty();
    }
}
