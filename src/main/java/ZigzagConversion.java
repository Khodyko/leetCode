import java.nio.charset.StandardCharsets;

public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3) + " equals PAHNAPLSIIGYIR");
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

    public static String convert(String s, int numRows) {
        byte[] arr = new byte[s.length()];
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        int counter = 0;
        int pointer = 0;
        int arrNum = 0;
        int gap = numRows + (Math.max(numRows - 2, 0));
        while (true) {
            if (counter == 0) {
                arr[arrNum] = bytes[pointer];
                bytes[pointer]=0;
                counter = gap;
                arrNum += 1;
                if (arrNum >= s.length()) {
                    break;
                }
            }
            if (bytes.length <= pointer + 1) {
                pointer = 0;
            } else {
                pointer += 1;
            }

            if (bytes[pointer] != 0) {
                counter -= 1;
            }


        }
        return  new String(arr, StandardCharsets.UTF_8);
        //not a chance need to try one more time
    }


}
