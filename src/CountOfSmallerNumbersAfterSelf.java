import java.util.HashMap;
import java.util.Map;

public class CountOfSmallerNumbersAfterSelf {

    static Map<Integer, Integer> map ;
    public static int[] divide(int [] array, int lo, int high){
        if(lo ==  high){
            int[] base = new int[1];
            base[0] = array[lo];
            return base;
        }
        int mid = (lo+high) / 2;

        int[] array1 = divide(array, lo, mid);
        int[] array2 = divide(array, mid+1, high);
        merge(array1, array2);

        return new int[]{};
    }

    public static void merge(int[] array1, int[] array2){
        for(int i = 0 ; i < array1.length ; i++){
            for(int j = 0 ; j < array2.length ; j++){
                if(array1[i] > array2[j]){
                    map.put(array1[i], map.getOrDefault(array1[i], 0) + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {6,1,5,4,3,7,9};
        map = new HashMap<>();
        for(int i : array){
            map.put(i, 0);
        }
        divide(array, 0, array.length-1);
        System.out.println(map);
    }

}
