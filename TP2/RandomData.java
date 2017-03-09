public class RandomData {
  public static int[] generate1d(int nbVals, int min, int max) {
    int[] res = new int[nbVals];
    for (int i = 0; i != nbVals; ++i) {
      res[i] = (int) (Math.random() * (max - min) + min);
    }
    return res;
  }
}
