import java.util.*;

/**
 * https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
 */
public class Anagram1 {

    public static void main(String[] args) {
        String[] words = {"abba", "baba", "bbaa", "cd", "cd"};
        System.out.println(new Anagram1().removeAnagrams(words) + " eq [abba, cd]");
    }


    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> current = new HashSet<>();
        String[] lastAna=new String[1];
        for (String word : words) {
            if (isAnagram(lastAna, word)) {
                result.add(word);
            }
        }
        return result;
    }

    public boolean isAnagram(String[] lastAna, String str) {
        char[] sorted = str.toCharArray();
        Arrays.sort(sorted);
        String strSorted = new String(sorted);
        if(strSorted.equals(lastAna[0])){
            return false;
        } else {
            lastAna[0]=strSorted;
            return true;
        }
    }

}
