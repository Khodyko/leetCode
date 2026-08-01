public class LongestCommonPrefix {

    public static void main(String[] args) {
       IO.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int prefLang = prefix.length();
        String tmpStr;
        for (int i = 1; i < strs.length; i++) {
            tmpStr = strs[i];
            while (prefLang>tmpStr.length() || !tmpStr.substring(0,prefLang).equals(prefix.substring(0,prefLang))){
                if(prefLang==0){
                    return "";
                }
                prefLang--;
            }
        }
        return prefix.substring(0,prefLang);
    }
}
