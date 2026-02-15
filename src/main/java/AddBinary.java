public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011") + " equals 10101");
    }

    //Example 1:
    //
    //Input: a = "11", b = "1"
    //Output: "100"
    //Example 2:
    //
    //Input: a = "1010", b = "1011"
    //Output: "10101"
    //
    //
    //Constraints:
    //
    //1 <= a.length, b.length <= 104
    //a and b consist only of '0' or '1' characters.
    //Each string does not contain leading zeros except for the zero itself.
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int c = 0;
        int sum;
        while (ai >= 0 || bi >= 0 || c > 0) {
            sum = c;
            if (ai >= 0) {
                sum +=a.charAt(ai)-'0';
                ai--;
            }
            if (bi >= 0) {
                sum +=b.charAt(bi)-'0';
                bi--;
            }
            sb.append(sum % 2);
            c = sum / 2;
        }

        return sb.reverse().toString();
    }
}
