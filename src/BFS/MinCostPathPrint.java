package BFS;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MinCostPathPrint {

    class Pair{
        String path;
        int i;
        int j;

        Pair(String path, int i, int j){
            this.path = path;
            this.i = i;
            this.j = j;
        }

    }

    public  void helper(int[][] array){

        int[][] dp = new int[array.length][array[0].length];

        for(int i = array.length-1 ; i >= 0 ; i--){
            for(int j = array[0].length-1 ; j >= 0 ; j--){
                if (i == array.length-1 && j == array[0].length-1){
                    dp[i][j] = array[i][j];
                }else if(i == array.length-1){
                    dp[i][j] = dp[i][j+1] + array[i][j];
                }else if(j == array[0].length-1){
                    dp[i][j] = dp[i+1][j] + array[i][j];
                }else{
                    dp[i][j] = array[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        for (int[] d : dp) System.out.println(Arrays.toString(d));

        System.out.println(dp[0][0]);

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(""+array[0][0]+"->",0, 0));

        while (q.size() > 0){
            Pair rm = q.poll();

            if(rm.i == array.length -1 && rm.j == array[0].length-1){
                System.out.println(rm.path+" final destination");
            }else if(rm.i == array.length-1){
                q.add(new Pair(rm.path+array[rm.i][rm.j+1]+"->", rm.i, rm.j+1));
            }else if(rm.j == array[0].length-1){
                q.add(new Pair(rm.path+array[rm.i+1][rm.j]+"->", rm.i+1, rm.j));
            }else{
              if (dp[rm.i][rm.j+1] < dp[rm.i+1][rm.j]){
                  q.add(new Pair(rm.path+array[rm.i][rm.j+1]+"->", rm.i, rm.j+1));
              }else if(dp[rm.i][rm.j+1] > dp[rm.i+1][rm.j]){
                  q.add(new Pair(rm.path+array[rm.i+1][rm.j]+"->", rm.i+1, rm.j));
              }else{
                  q.add(new Pair(rm.path+array[rm.i][rm.j+1]+"->", rm.i, rm.j+1));
                  q.add(new Pair(rm.path+array[rm.i+1][rm.j]+"->", rm.i+1, rm.j));
              }
            }

        }
    }


    public static void main(String[] args) {

        int[][] array = {
                {2,8,4,1,6,4,2},
                {6,0,9,5,3,8,5},
                {1,4,3,4,0,6,5},
                {6,4,7,2,4,6,1},
                {1,0,3,7,1,2,7},
                {1,5,3,2,3,0,9},
                {2,2,5,1,9,8,2}};

        MinCostPathPrint p = new MinCostPathPrint();
        p.helper(array);

    }
}
