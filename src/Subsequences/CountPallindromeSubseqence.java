package Subsequences;

public class CountPallindromeSubseqence {

    public static int helper(String s){
        int [][] dp = new int[s.length()][s.length()];
        for(int g = 0 ; g < dp.length ; g++){
            for(int i = 0, j = g ; j < dp.length ; i++, j++){
                if(g == 0){
                    dp[i][j] = 1;
                }else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if(g == 1){
                        dp[i][j] = b ? 3 : 2;
                    }else {
                        if(b){
                            dp[i][j] = dp[i+1][j] + dp[i][j-1] +1;
                        }else{
                            dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                        }
                    }
                }
            }
        }
        return dp[0][dp.length-1];
    }

    public static void main(String[] args) {

        System.out.println(helper("b"));

    }

}
