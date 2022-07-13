import java.util.Arrays;
import java.util.HashMap;

public class DecodeWays {

    static HashMap<String, Integer> map = new HashMap<>();
    public static int helper_memo(String str){
        if(map.containsKey(str)) return map.get(str);
        if(str.length() == 0) return 1;
        if(str.charAt(0) == '0') return 0;
        int c1 = 0;
        c1 += helper_memo(str.substring(1));
        if(str.length() >= 2 && Integer.parseInt(str.substring(0,2)) <= 26){
            c1 += helper_memo(str.substring(2));
        }
        map.put(str, c1);
        return c1;

    }
//  incomplete
    public static int helper_memo2(String str, int n, int [] dp, int idx){
        if(dp[n] != 0) return dp[n];
        if(str.length() == 0) return dp[n] = 1;
        if(str.charAt(0) == '0') return 0;
        int c1 = 0;
        c1 += helper_memo2(str.substring(1),n+1,dp,idx);
        if(str.length() >= 2 && Integer.parseInt(str.substring(0,2)) <= 26){
            c1 += helper_memo2(str.substring(2),n+1,dp,idx);
        }
        return dp[n] = c1;
    }


    public static void main(String[] args) {
        String st = "111321";
//        System.out.println(helper_memo(st));
//        System.out.println(map);

        int[] dp = new int[st.length()+1];
        System.out.println(helper_memo2(st, 0, dp, st.length()));
        System.out.println(Arrays.toString(dp));


    }
}
