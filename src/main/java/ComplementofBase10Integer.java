public class ComplementofBase10Integer {
    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5) + " eq 2");
    }

    //https://leetcode.com/problems/complement-of-base-10-integer/description/?envType=daily-question&envId=2026-03-11
    public static int bitwiseComplement(int n) {
        String str = Integer.toBinaryString(n);
        return n ^ Integer.parseInt("1".repeat(str.length()), 2);
    }
}
