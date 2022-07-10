public class BoardPath {

     static int count = 0;
    public static void helper(int n, int tar, int sum, String ways){
        if(sum > tar) return ;
        if(sum == tar){
            System.out.println(ways);
//            count++;
            return;
        }

        for(int i = 1 ; i <= n ; i++){
            helper(n, tar, sum+i, ways + i + "->");
        }
    }

    public static void main(String[] args) {
        helper(6, 10, 0, "");
//        System.out.println(count);
    }
}
