public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad") + " eq bab");
        System.out.println(longestPalindrome("cbbd") + " eq bb");
    }

    //Given a string s, return the longest palindromic substring in s.
    //
    //
    //
    //Example 1:
    //
    //Input: s = "babad"
    //Output: "bab"
    //Explanation: "aba" is also a valid answer.
    //Example 2:
    //
    //Input: s = "cbbd"
    //Output: "bb"
    //
    //
    //Constraints:
    //
    //1 <= s.length <= 1000
    //s consist of only digits and English letters.
    // https://leetcode.com/problems/longest-palindromic-substring/description/
    public static String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = checkSides(i, i, s);
            int even = checkSides(i, i + 1, s);
            int max = Math.max(odd, even);
            if (max > end - start+1) {
                start = i - (max - 1) / 2;
                end = i + (max / 2);
            }
        }
        return s.substring(start, end+1);
    }

    public static int checkSides(int start, int end, String s) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return end - start - 1;
    }


}
