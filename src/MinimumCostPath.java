public class MinimumCostPath {

    public static void helper(int[][] array, int[][] dp){
       for(int i = 0 ; i < array.length ; i++){
           for(int j = 0 ; j < array[0].length ; j++){
               if(i == 0 && j == 0) dp[i][j] = array[i][j];
               else if (i == 0) dp[i][j] = array[i][j] + dp[i][j-1];
               else if(j == 0) dp[i][j] = array[i][j] + dp[i-1][j];
               else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + array[i][j];
           }
       }
    }

    public static void main(String[] args) {
        int[][] array = {{2,8,4,1,6,4,2},{6,0,9,5,3,8,5},{1,4,3,4,0,6,5},{6,4,7,2,4,6,1},{1,0,3,7,1,2,7},{1,5,3,2,3,0,9},{2,2,5,1,9,8,2}};
        int[][] dp = new int[array.length][array[0].length];
        helper(array,dp);
        System.out.println(dp[6][6]);
    }
}

