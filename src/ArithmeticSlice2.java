import java.util.HashMap;

public class ArithmeticSlice2 {

    public static int helper(int[] array){
        int ans = 0;
        HashMap<Integer,Integer>[] map = new HashMap[array.length];
        for(int i = 0 ; i < array.length ; i++){
            map[i] = new HashMap<>();
        }

        for(int i = 1 ; i < map.length ; i++){
            for(int j = 0 ; j < i ; j++){
                long cd = (long)array[i] - (long)array[j];
                if(cd >= Integer.MAX_VALUE || cd <= Integer.MIN_VALUE) continue;
                int ansEndingOnJ = map[j].getOrDefault((int)cd, 0);
                int ansEndingOnI = map[i].getOrDefault((int)cd, 0);
                ans += ansEndingOnJ;
                map[i].put((int)cd, ansEndingOnI + ansEndingOnJ + 1);
            }
        }
         return ans;
    }


    public static void main(String[] args) {
        int[] array = {2,4,6,8,10};
        System.out.println(helper(array));
    }
}
