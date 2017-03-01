/**
 * Created by guillaumelachaud on 2/8/17.
 */

import java.util.Random;

public class RandomData {
  public static int[] generate1d(int nbVals, int min, int max) {
    int[] res = new int[nbVals];
    Random generator = new Random();
    for (int i = 0; i != nbVals; ++i) {
      res[i] = (int) (Math.random() * (max - min) + min);
    }
    return res;
  }
}
