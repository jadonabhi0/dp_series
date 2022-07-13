import java.util.Arrays;

public class BoardPath {

     static int count = 0;
    public static int helper(int n, int tar, int sum, int[] dp){
       if(sum == tar){
           return dp[sum] = 1;
       }

       if(dp[sum] != 0) return dp[sum];

       int count = 0;

       for (int i = 1 ; i <= n && sum + i <= tar; i++){
           count += helper(n, tar, sum+i, dp);
       }
       dp[sum] = count;
       return dp[sum];
    }

    public static int helper_tabu(int sum , int[] dp, int n ){
        dp[sum] = 1;
        dp[sum-1] = 1;
        int end = sum;
        for(int i = sum - 2; i >= 0; i--){
            if(n--> 0){
                dp[i] = 2 * dp[i+1];
            }else {
                dp[i] = 2 * dp[i+1] - dp[end--];
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[] dp = new int[10+1];
        System.out.println(helper(6, 10, 0, dp));
//        System.out.println(helper_tabu(10, dp, 6));
        System.out.println(Arrays.toString(dp));
    }
}
