public class MaxNonAdjacentSum {

    public static int helper(int[] array){
        int inc = array[0];
        int exc = 0;
        int ans = 0;
        for(int i = 1 ; i < array.length ; i++){
           int ninc = exc + array[i];
           int nexc = Math.max(inc, exc);
           inc = ninc;
           exc = nexc;
        }
        return ans = Math.max(inc, exc);
    }

    public static void main(String[] args) {

        int[] arr = {5, 10, 10, 100,5,  6};
        System.out.println(helper(arr));

    }
}
