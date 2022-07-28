package Subsequences;

import java.util.ArrayList;
import java.util.List;

public class LIS {

    // backtracking solution and print all Subsequences.LIS
    List<List<Integer>> ans;
    public void helper(int[] array, List<Integer> list, int idx){
        if(idx == array.length){
            if (list.size() >= 2)
                ans.add(new ArrayList<>(list));
                return;
        }
//        if (list.isEmpty())list.add(array[idx]);
        if(list.isEmpty() || list.get(list.size()-1) <= array[idx]){
            list.add(array[idx]);
            helper(array, list, idx+1);
            list.remove(list.size()-1);
            helper(array, list, idx+1);
        }
        else{
//            list.remove(list.size()-1);
            helper(array, list, idx+1);

        }
    }

    // brut solution
    public static int helper_(int[] array, int prev, int curr){
        if (curr == array.length) return 0;
        int a = 0;
        if(prev == -1 || array[prev] < array[curr]){
            a = helper_(array, curr, curr+1) + 1;
        }
        int b = helper_(array,prev,  curr+1);
        return  Math.max(a, b);
    }

    public static int helper_memo(int[] array, int prev, int curr, int[][] dp){
        if (curr == array.length) return 0;
        if (prev != -1 && dp[prev][curr] != 0) return dp[prev][curr];
        int a = 0;
        if(prev == -1 || array[prev] < array[curr]){
            a = helper_memo(array, curr, curr+1, dp) + 1;
        }
        int b = helper_memo(array,prev,  curr+1, dp);

        if (prev != -1){
            dp[prev][curr] = Math.max(a, b);
        }
        return  Math.max(a, b);
    }



    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] array = {4,4,3,2,1};
//        int[][] dp = new int[array.length][array.length];

        lis.ans = new ArrayList<>();
        lis.helper(array, new ArrayList<>(), 0);
        System.out.println(lis.ans);
//        System.out.println(helper_(array, -1, 0));
//        System.out.println(helper_memo(array, -1, 0, dp));
    }


}
