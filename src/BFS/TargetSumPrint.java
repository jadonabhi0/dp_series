package BFS;

import java.util.ArrayDeque;
import java.util.Arrays;

public class TargetSumPrint {

    public static void helper_tabu(int[] array, int tar) {
        boolean[][] dp = new boolean[array.length + 1][tar + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (j >= array[i - 1]) {
                        if (dp[i - 1][j - array[i - 1]]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }

        // printing subset

        class Pair{
            String path;
            int i;
            int j ;

            Pair(String path, int i, int j){
                this.path = path;
                this.i = i;
                this.j = j;
            }
        }

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair("", array.length, tar));

        while (q.size() > 0){
            Pair rm = q.removeFirst();
            if(rm.i == 0 && rm.j == 0){
                System.out.println(rm.path);
            }
            else {
                boolean exc = dp[rm.i-1][rm.j];
                if(exc){
                    q.add(new Pair(rm.path, rm.i-1, rm.j));
                }

                if(rm.j >= array[rm.i - 1]){
                    boolean inc = dp[rm.i-1][rm.j - array[rm.i - 1]];
                    if(inc){
                        q.add(new Pair(rm.path+array[rm.i - 1]+" ", rm.i - 1, rm.j - array[rm.i-1]));
                    }
                }
            }

        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 10, 11, 6, 1};
        helper_tabu(array, 11);
    }

}
