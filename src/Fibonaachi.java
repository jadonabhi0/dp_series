import java.util.HashMap;

public class Fibonaachi {

    public static int fib_brut(int n){
        if(n <= 1) return n;
        int ans = fib_brut(n-1) + fib_brut(n-2);
        return ans;
    }

    static HashMap<Integer, Long> map = new HashMap<>();
    public static long fib_Memo(int n){
        if(map.containsKey(n)){
            return map.get(n);
        }
        if (n <= 1) return n;
        long ans = fib_Memo(n-1) + fib_Memo(n-2);
        map.put(n,ans);
        return ans;
    }

    public static long fib_tabu(int n){
        long[] dp = new long[n+1];
        for(int i = 0 ; i < dp.length ; i++){
            if (i <= 1){
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static long fib_opt(int n){
        int a = 0 ; int b = 1 ; int c = 0;
        for(int i = 1 ; i < n ; i ++){
            c = a + b;
            a = b ; b = c;
        }
        return b;
    }

    public static void main(String[] args) {
//        System.out.println(fib_brut(25));
//        System.out.println(fib_Memo(10));
//        System.out.println(fib_tabu(10));
        System.out.println(fib_opt(10));
    }

    // 1.) Faith -> (Math Relation)
    // 2.) Recursive Tree (Recursive Code with Tree)
    // 3.) Recursive Code with Memoization
    // 4.) Observation
    // 5.) Memoization -> Tabulation
    // 6.) optimization

}
