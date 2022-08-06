package CatlanNumber;




public class BinaryTreeCount {

    public static int helper(int n){
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2 ; i < dp.length ; i++){
            int l = i-1; int r = 0; int ans = 0;
            while(l >= 0) ans += dp[l--]*dp[r++];
            dp[i] = ans;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(helper(10));
    }


}
