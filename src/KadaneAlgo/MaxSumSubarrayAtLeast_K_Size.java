package KadaneAlgo;

class MaxSumSubarrayAtLeast_K_Size {


    public static int helper(int[] array, int k){
        int ans = 0;
        int sum = array[0];
        int[] dp = new int[array.length];
        dp[0] = sum;

        for(int i = 1 ; i < array.length ; i++){
            if (sum > 0 ){
                sum += array[i];
            }else{
                sum = array[i];
            }
            dp[i] = sum;
        }

        int exactk = 0;
        for(int i = 0 ; i < k ; i++){
            exactk += array[i];
        }
        if (exactk > ans){
            ans = exactk;
        }

        for(int i = k ; i < array.length ; i++){
            exactk = exactk + array[i] - array[i-k];
            if (exactk > ans){
                ans = exactk;
            }
            int morethank = dp[i-k] + exactk;

            if (morethank > ans){
                ans = morethank;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] array = {4, 3, 2, -6, -14, 7, -1, 4, 5, 7, -10, 2, 9, -10, -5, -9, 6, 1};
        int k = 2;
        System.out.println(helper(array, k));

    }

}
