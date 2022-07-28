import java.util.Arrays;
import java.util.Comparator;

public class RussianDoll {

    public static int helper(int[][] array){
        Arrays.sort(array, (a, b) -> b[0] - a[0]);

        for(int [] ar: array){
            System.out.println(Arrays.toString(ar));
        }

        int[] dp = new int[array.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < array.length ; i++){
            dp[i] = 1;
            for(int j = 0 ; j < i ; j++){
                if(array[i][0] < array[j][0] && array[i][1] < array[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {

        int[][] array = new int[][]{{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}};
        System.out.println(helper(array));

    }

}
