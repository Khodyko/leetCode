public class LengthofLastWord {
    public static void main(String[] args) {

    }

   public static int lengthOfLastWord(String s) {
        String[] arr=s.split(" ");
        return arr[arr.length-1].length();
    }
}
