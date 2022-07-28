import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {

    static int count = 0;

    // recursion and backtracking solution
    // it gives the total permutations
    public static void helper(int[] array, int tar,List<Integer> list){
        if (tar == 0){
            count++;
            System.out.println(list);
            return;
        }

        for (int i = 0 ; i < array.length ; i++){
            if(array[i] <= tar){
                list.add(array[i]);
                helper(array, tar - array[i], list);
                list.remove(list.size()-1);
            }
        }

    }

    // tabulation method
    // this prints the combination
    public static int helper_tabu(int[] array, int tar){
        int[] dp = new int[tar+1];
        dp[0] = 1;
        for (int i = 0 ; i < array.length ; i++){
            for(int j = array[i] ; j < dp.length ; j++){
                dp[j] = dp[j] + dp[j-array[i]];
            }
//            System.out.println(Arrays.toString(dp));
        }

        return dp[tar];
    }


    public static int helper_tabu2(int[] array, int tar){
        int[] dp = new int[tar+1];
        dp[0] = 1;
        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 0 ; j < array.length ; j++) {
                if (i >= array[j]) {
                    dp[i] = dp[i] + dp[i - array[j]];
                }
            }
        }
        return dp[tar];
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] arr = {1,2,5};
//        helper(arr,  7,list);
//        System.out.println(count);

        System.out.println(helper_tabu(arr, 5));

//        System.out.println(helper_tabu2(arr, 11));
    }

}
