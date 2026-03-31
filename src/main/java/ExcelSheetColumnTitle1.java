public class ExcelSheetColumnTitle1 {
    public static void main(String[] args) {
       
    }

  //https://leetcode.com/problems/excel-sheet-column-title/
   public String convertToTitle(int columnNumber) {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb=new StringBuilder();
        while(columnNumber>0) {
            columnNumber --;
            sb.append(abc.charAt(columnNumber%26));
            columnNumber /= 26;
        }
         return sb.reverse().toString();
    }
}
