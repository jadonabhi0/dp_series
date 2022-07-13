import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ruff {

    public static int fib(int n){
        if(n <= 1) return n;

        int a = fib(n-1);
        int b = fib(n-2);
        return a+b;

    }

    static Map<Integer, Integer> map = new HashMap<>();
    public static  int fib_memo(int n){
        if (n <= 1) return n;
        if(map.containsKey(n)) return map.get(n);

        int a = fib_memo(n-1);
        int b = fib_memo(n-2);
        map.put(n,a+b);
        return  a+b;
    }

    public static  int fib_tabu(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2 ; i < dp.length ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int fib_opt(int n){
        int a = 0;
        int b = 1;
        int c = 0;

        for(int i = 2 ; i <= n ; i++){
            c = a + b; a = b ; b = c;
        }
        return c;
    }

    public static void main(String[] args) {
//        System.out.println(fib(100));
//        System.out.println(fib_memo(10));
//        System.out.println(map);
        int[] dp = new int[10+1];
//        System.out.println(fib_tabu(10, dp));
//        System.out.println(Arrays.toString(dp));

        System.out.println(fib_opt(10));
    }


}
