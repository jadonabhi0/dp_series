package KadaneAlgo;

public class KadanesAlgo {

    public static void main(String[] args) {

        int[] array = {4, 3, 2, -6, -14, 7, -1, 4, 5, 7, -10, 2, 9, -10, -5, -9, 6, 1};
        int omax = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < array.length ; i++){
            sum += array[i];
            if(sum < 0){
                sum = array[i];
            }
            if (sum > omax){
                omax = sum;
            }
        }

        System.out.println(omax);
    }





}
