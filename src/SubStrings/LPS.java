package SubStrings;

public class LPS {

    public static void helper(String str){
        boolean[][] dp = new boolean[str.length()][str.length()];
        int len = 0 ;
        for(int g = 0 ; g < dp.length ; g++){
            for(int i = 0 , j = g ; j < dp.length ; i++, j++){
                if(g == 0){
                    dp[i][j] = true;
                }else {
                    boolean b = str.charAt(i) == str.charAt(j);
                    if(g == 1){
                        dp[i][j] = b;
                    }else{
                        dp[i][j] = (b && dp[i+1][j-1]);
                    }
                }
                if(dp[i][j]) len = g + 1;
            }
        }
        System.out.println(len);
    }


    public static void main(String[] args){
        helper("abccbc");
    }
}








