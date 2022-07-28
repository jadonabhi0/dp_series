package BFS;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Lis {

    public static void helper(int[] array){
        int [] dp = new int[array.length];
        int max = 0;
        int omax = 0;
        int maxidx = 0;
        for(int i = 0 ; i < dp.length ; i++){
            max = 0;
            for(int j = 0 ; j < i ; j++){
                if(array[i] >= array[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            if (dp[i] > omax){
                omax = dp[i];
                maxidx = i;
            }

        }
        System.out.println(Arrays.toString(dp));
        System.out.println(omax);


        class Pair{

            String path;
            int i;
            int val;
            int len;

            Pair(String path, int i, int val, int len){
                this.path = path;
                this.i = i;
                this.val = val;
                this.len = len;
            }

        }


        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(" "+array[maxidx], maxidx, array[maxidx], omax));

        while(q.size() > 0){
            Pair rm = q.removeFirst();
            if (rm.len == 1){
                System.out.println(rm.path);
            }

            for(int i = rm.i-1 ; i >= 0 ; i--){
                if (dp[i] == rm.len - 1 && rm.val >= array[i]){
                    q.add(new Pair(rm.path+" "+array[i], i, array[i], dp[i]));
                }
            }

        }
        System.out.println(q);

    }


    public static void main(String[] args) {
        int[] arr = {10, 22, 42, 33, 21, 50, 41, 60, 80, 3};
        helper(arr);

    }

}
