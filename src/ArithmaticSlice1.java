public class ArithmaticSlice1 {

    public static int helper(int[] array){
        int [] dp = new int[array.length];
        int ans = 0 ;
        for(int i = 2 ; i < dp.length ; i ++){
            if(array[i]-array[i-1] == array[i-1] - array[i-2]){
                dp[i] = dp[i-1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(helper(array));
    }
}
