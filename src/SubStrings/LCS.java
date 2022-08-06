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

//        System.out.println(ans);
        return len;
    }

    public static int helper_tabu(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int omax = 0;
        for(int i = 1 ;i <= s1.length(); i++){
            for(int j = 1 ; j <= s2.length() ; j++){
                boolean ch = s1.charAt(i-1) == s2.charAt(j-1);
               if(ch) dp[i][j] = dp[i-1][j-1] + 1 ;
                omax = Math.max(omax, dp[i][j]);
            }
        }
        return omax;
    }

    public static void main(String[] args) {
        System.out.println(helper("xyzabcp", "pqabcxy"));
        System.out.println(helper_tabu("xyzabcp", "pqabcxy"));
    }

}
