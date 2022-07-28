package BFS;

import java.util.Arrays;

public class LisMaxSum {

    public static void helper(int[] array){
        int[] dp =  new int[array.length];
        int sum = 0;
        int max = 0;
        int maxSum = 0;

        for(int i = 0 ; i < dp.length ; i++){
            sum = array[i];
            max = 0;
            for(int j = 0 ; j < i ; j++){
                if(array[j] <= array[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = sum + max;
            maxSum = Math.max(maxSum, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(maxSum);
    }


    public static void main(String[] args) {

        int[] arr = {10, 22, 42, 33, 21, 50, 41, 60, 80, 3};
        helper(arr);

    }

}
