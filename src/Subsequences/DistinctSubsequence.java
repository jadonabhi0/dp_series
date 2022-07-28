package Subsequences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequence {

    public static int helper(String s1, String s2){
        int[][] dp = new int[s2.length()+1][s1.length()+1];

        for(int i = 0 ; i <= s1.length() ; i++){
            dp[0][i] = 1;
        }
        System.out.println(Arrays.toString(dp[0]));
        for(int i = 0 ; i < s2.length() ; i++){
            for(int j = 0 ; j < s1.length() ; j++){
                if(s1.charAt(j) == s2.charAt(i)){
                    dp[i+1][j+1] = dp[i+1][j] + dp[i][j];
                }else{
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[s2.length()][s1.length()];
    }


    public static int dist_subsequenceII(String s, Map<Character, Integer> map){

        int[] dp = new int[s.length()+1];
        dp[0]  = 1;
        int  mod = 1000000007;
        for (int i = 0 ; i < s.length() ; i++){
            if (!map.containsKey(s.charAt(i))){
                dp[i+1] = 2 * dp[i] % mod;
            }else{
                dp[i+1] = ((2 * dp[i]) - dp[map.get(s.charAt(i)) - 1]) % mod;
            }
            map.put(s.charAt(i), i+1);
        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(map);
        return dp[s.length()]-1 % mod;
    }

    public static void main(String[] args) {

//        System.out.println(helper("rabbbit", "rabbit"));
        System.out.println(dist_subsequenceII("abc", new HashMap<>()));
    }
}
