public class MinCostToMakeStringIdentical {

    public static int helper(String str1, String str2, int c1, int c2){
        int [][] dp  = new int[str1.length()+1][str2.length()+1];

        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1 ; j < dp[0].length ; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        int lcs =  dp[dp.length-1][dp[0].length-1];
        int cost1 = str1.length() - lcs;
        int cost2 = str2.length() - lcs;
        int ans = cost1 * c1 + cost2 * c2;
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(helper("abcd", "aecd", 5, 5));
    }

}
