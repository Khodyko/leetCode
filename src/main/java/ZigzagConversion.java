import java.nio.charset.StandardCharsets;

public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3) + " equals PAHNAPLSIIGYIR");
        System.out.println(convert("PAYPALISHIRING", 4) + " equals PINALSIGYAHRPI");
    }

    //The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
    //
    //P   A   H   N
    //A P L S I I G
    //Y   I   R
    //And then read line by line: "PAHNAPLSIIGYIR"
    //
    //Write the code that will take a string and make this conversion given a number of rows:
    //
    //string convert(string s, int numRows);
    //
    //
    //Example 1:
    //
    //Input: s = "PAYPALISHIRING", numRows = 3
    //Output: "PAHNAPLSIIGYIR"
    //Example 2:
    //
    //Input: s = "PAYPALISHIRING", numRows = 4
    //Output: "PINALSIGYAHRPI"
    //Explanation:
    //P     I    N
    //A   L S  I G
    //Y A   H R
    //P     I
    //Example 3:
    //
    //Input: s = "A", numRows = 1
    //Output: "A"
    //
    //
    //Constraints:
    //
    //1 <= s.length <= 1000
    //s consists of English letters (lower-case and upper-case), ',' and '.'.
    //1 <= numRows <= 1000
    //https://leetcode.com/problems/zigzag-conversion/submissions/1899079724/

    public static String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        byte[][] arr =new byte[numRows][s.length()];
        int pointer=0;
        int y=-1;
        int x=0;
        while(pointer<bytes.length){
           //go down
            while(y<numRows && pointer<bytes.length){
                y+=1;
                if(y<numRows) {
                    arr[y][x]=bytes[pointer];
                    pointer+=1;
                }
            }
            y -= 1;
            //go right up
            while(y>0 && pointer<bytes.length){
                y-=1;
                x+=1;
                arr[y][x]=bytes[pointer];
                pointer+=1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (arr[i][j] != 0) {
                    result.append((char) arr[i][j]);
                }
            }
        }

        return  result.toString();
    }


}
