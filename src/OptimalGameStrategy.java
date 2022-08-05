public class OptimalGameStrategy {

    public static int helper(int [] array){

        int [][] dp= new int[array.length][array.length];

        for(int g = 0 ; g < dp.length ; g++){
            for(int i = 0 , j = g ; j < dp.length ; j++, i++){
                if(g == 0){
                    dp[i][j] = array[i];
                }else if(g == 1){
                    dp[i][j] = Math.max(array[i], array[j]);
                }else{
                    int v1 = array[i] + Math.min(dp[i+2][j], dp[i+1][j-1]);
                    int v2 = array[j] +  Math.min(dp[i+1][j-1], dp[i][j-2]);
                    dp[i][j] = Math.max(v1 ,v2);
                }
            }
        }
        return dp[0][dp.length-1];
    }


    public static void main(String[] args) {
        System.out.println(helper(new int[]{20, 30, 2, 10}));
    }

}
