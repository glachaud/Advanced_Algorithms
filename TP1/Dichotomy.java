/**
 * Created by guillaumelachaud on 2/9/17.
 */
import java.util.Arrays;

public class Dichotomy {
    public static void main(String[] args){
        // int nbVals = Integer.parseInt(args[0]);
        int[] data = new int[10];
        for(int i=0; i != data.length; i++){
            data[i] = 2*i;
        }
        System.out.println(Arrays.toString(data));
        System.out.println(indexOfOrdered(data, Integer.parseInt("5")));
    }

    public static int indexOfOrdered(int[] data, int v){
        int res=lowerBound(data,v);
        if((res==data.length) || (data[res] != v)){
            res = -1;
        }
        return res;
    }
    // index of first element >= v
    public static int lowerBound(int[] data, int v){
        return lowerBound(data, v, 0, data.length);
    }
    public static int lowerBound(int[] data, int v, int begin, int end){
        if(begin == end){return begin;}
        int m = (begin + end)/2;
        return data[m] < v ? lowerBound(data, m, m+1, end) : lowerBound(data, v, begin, m);
    }
    public static int lowerBoundTCO(int[] data, int v){
        int begin=0, end=data.length;
        while(begin != end){
            int m = (begin + end)/2;
            if(data[m] < v){
                begin= m+1;
            }
            else{
                end=m;
            }
        }
        return begin;
    }
}
