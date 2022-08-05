public class TempleOfferings {


    public static int helper(int [] array){
        int[] larr = new int[array.length];
        int[] rarr = new int[array.length];

        larr[0] = 1;
        for(int i = 1 ; i < larr.length-1 ; i++){
            if(array[i] > array[i-1]){
                larr[i] += larr[i-1] + 1;
            }else{
                larr[i] = 1;
            }
        }
        rarr[array.length-1] = 1;
        for(int i = rarr.length-2 ; i >= 0 ; i--){
            if (array[i] > array[i+1]){
                rarr[i] = rarr[i+1] + 1;
            }else{
                rarr[i] = 1;
            }
        }


        int ans = 0;

        for(int i = 0 ; i < array.length ; i++){
            ans += Math.max(larr[i], rarr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] array = {2,4,5,6,7,1,2,3,2,11,7};
        System.out.println(helper(array));
    }

}
