import java.nio.charset.StandardCharsets;
import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([])"));
    }

    //20. Valid Parentheses
//    Easy
//            Topics
//    premium lock icon
//            Companies
//    Hint
//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//    An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//    Every close bracket has a corresponding open bracket of the same type.
//
//
//    Example 1:
//
//    Input: s = "()"
//
//    Output: true
//
//    Example 2:
//
//    Input: s = "()[]{}"
//
//    Output: true
//
//    Example 3:
//
//    Input: s = "(]"
//
//    Output: false
//
//    Example 4:
//
//    Input: s = "([])"
//
//    Output: true
//
//    Example 5:
//
//    Input: s = "([)]"
//
//    Output: false
//
//
//
//    Constraints:
//
//            1 <= s.length <= 104
//    s consists of parentheses only '()[]{}'.

    // https://leetcode.com/problems/valid-parentheses/
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Deque<Character> waitCh = new ArrayDeque<>();
        for (Character ch : s.toCharArray()) {
            if (map.get(ch) != null) {
                waitCh.addLast(map.get(ch));
            } else if (
                    waitCh.peekLast() != null &&
                            (
                                    (waitCh.peekLast().equals(ch))
                            )) {
                waitCh.pollLast();
            } else {
                return false;
            }
        }

        return waitCh.isEmpty();
    }

}
