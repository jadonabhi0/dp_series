import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void display_dp(int[] array){
        System.out.println(Arrays.toString(array));
    }

    public static int helper_memo(int n, int[] cost, int[] dp){
        if(cost.length == 2) return Math.min(cost[0],cost[1]);

        if(n <= 1) return dp[n] = cost[n];

        if(dp[n] != 0) return dp[n];

        return dp[n] = Math.min(helper_memo(n - 1, cost, dp), helper_memo(n - 2, cost, dp)) + cost[n];
    }

    public static int helper_tabu(int n, int[] cost, int[] dp){
        if(cost.length == 2) return Math.min(cost[0],cost[1]);

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2 ; i < n ; i++){
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
        }
        return Math.min(dp[n-1], dp[n-2]);
    }

    public static void main(String[] args) {
        int[] cost = new int[]{10,15,20};
        int[] dp = new int[cost.length];
//        System.out.println(helper_memo(cost.length - 1, cost, dp));
        System.out.println(helper_tabu(cost.length , cost, dp));
        display_dp(dp);
    }
}
