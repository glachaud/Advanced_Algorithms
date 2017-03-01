/**
 * Created by guillaumelachaud on 2/8/17.
 */
import java.util.Arrays;
public class TP1 {

    public static void main(String args[]){
        int[] res = RandomData.generate1d(100000, 0, 500);
        // System.out.println(Arrays.toString(res));
        System.out.println("Starting compilation");
        long start = System.currentTimeMillis();
        MergeSort.sort(res);
        long elapsed = System.currentTimeMillis() - start;
        // System.out.println("-------------");
        // System.out.println(Arrays.toString(res));
        // System.out.println("-------------");
        System.out.println("Time elapsed: "+ elapsed);
    }

    public static int minArray(int[] array){
        int min = array[0];
        for(int i=0; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }





}
