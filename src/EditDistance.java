import java.sql.Array;
import java.util.Arrays;

public class EditDistance {

    public static int helper(String str1, String str2){
        // convert str1 into str2 with minimum operations
        // 1. replace
        // 2. delete
        // 3. inserts

        if(str1.length() == 0) return str2.length();
        if(str2.length() == 0) return str1.length();
        if(str1.charAt(0) == str2.charAt(0)) return helper(str1.substring(1), str2.substring(1));
        else {
            int replace = helper(str1.substring(1),str2.substring(1));
            int insert = helper(str1.substring(1),str2);
            int delete = helper(str1, str2.substring(1));
            return Math.min(replace, Math.min(insert, delete)) + 1;
        }

    }

    public static int helper_tabu(String str1, String str2){
        if (str1.equals(str2)) {
            return 0;
        }
        if (str1.length() == 0 || str2.length() == 0) {
            return Math.abs(str1.length() - str2.length());
        }
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= str2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
//        for(int[] i : dp){
//            System.out.println(Arrays.toString(i));
//        }
        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
//        System.out.println(helper("intention", "execution"));
        System.out.println(helper_tabu("rabbbit", "rabbit"));
    }
}
