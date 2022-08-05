package SubStrings;

public class LCS {

    public static int helper(String str1, String str2){
        String ans ="";
        int len = Integer.MIN_VALUE;
        for (int i = 0 ; i < str1.length() ; i++){
            for(int j = 0 ; j < i ; j++){
                if(str2.contains(str1.substring(j,i))){
                    int length = str1.substring(j, i).length();
                    if(len < length) {
                        ans = str1.substring(j, i);
                        len = length;
                    }
                }
            }
        }

        System.out.println(ans);
        return len;
    }


    public static void main(String[] args) {
        System.out.println(helper("xyzabcp", "pqabcxy"));
    }

}
