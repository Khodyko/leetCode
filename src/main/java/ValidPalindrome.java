public class ValidPalindrome {
    public static void main(String[] args) {
       
    }

  //https://leetcode.com/problems/valid-palindrome/
  public static boolean isPalindrome(String s) {
        int st = 0;
        int e = s.length() - 1;
        while(st<e){
            char cst = s.charAt(st);
            char ce = s.charAt(e);

            if (!Character.isLetterOrDigit(cst)) {
                st++;
                continue;
            }
            if (!Character.isLetterOrDigit(ce)) {
                e--;
                continue;
            }
            if (Character.toLowerCase(cst) != Character.toLowerCase(ce)) {
                return false;
            }
            st++;
            e--;
        }
        return true;
    }
}
