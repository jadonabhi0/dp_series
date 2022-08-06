public class InterLeavingString {

    public static boolean helper_rec(String s1, String s2, String s3, int i, int j, Boolean[][] dp){
        if (s1.length() + s2.length() != s3.length()) return false;
        if (i == s1.length() && j == s2.length()) return true;
        if (dp[i][j] != null) return dp[i][j];
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            boolean f1 = helper_rec(s1, s2, s3, i+1, j, dp);
            dp[i][j] = f1;
            if (f1) return true;

        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            boolean f1 = helper_rec(s1, s2, s3, i, j+1, dp);
            dp[i][j] = f1;
            if (f1) return true;
        }
        dp[i][j] = false;
        return false;
    }

    public static boolean helper_tabu(String s1, String s2, String s3){
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                }else{
                    dp[i][j] =  (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(helper_rec(s1, s2, s3, 0, 0, new Boolean[s1.length()+1][s2.length()+1]));
        System.out.println(helper_tabu(s1, s2, s3));
    }
}
