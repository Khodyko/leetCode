public class RansomeNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] a=new int[26];
        for(char l:ransomNote.toCharArray()){
            a[l]=a[l]+1;

        }
        for(char l:magazine.toCharArray()){
            a[l]=a[l]-1;
            if(a[l]<0){
                return false;
            }
        }
        return true;
    }
}
