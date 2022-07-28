import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSum {

    // backtracking solution
    public static void helper(int[] array, int idx, int tar, List<Integer> list){
        if(tar == 0){
            System.out.println(list);
            return;
        }
        if(idx == array.length) return;
        if(array[idx] > tar){
            helper(array, idx+1, tar,list);
        }
        else{
            list.add(array[idx]);
            helper(array, idx+1, tar-array[idx],list);
            list.remove(list.size()-1);
            helper(array, idx+1, tar,list);
        }

    }


    // tabulation method

    public static void helper_tabu(int[] array, int tar){
        boolean[][] dp = new boolean[array.length+1][tar+1];

        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j  < dp[0].length ; j++){

                if(j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                }else{
                  if(dp[i-1][j]){
                      dp[i][j] = dp[i-1][j];
                  }else if(j >= array[i-1]) {
                      if (dp[i - 1][j - array[i - 1]]) {
                          dp[i][j] = true;
                      }
                  }
                }
            }
        }
//        for(boolean[] ar : dp) System.out.println(Arrays.toString(ar));
//        System.out.println(dp[array.length][tar]);
    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 10, 11, 6, 1};
        helper(array, 0, 11,new ArrayList<>());
        helper_tabu(array, 11);
    }
}
