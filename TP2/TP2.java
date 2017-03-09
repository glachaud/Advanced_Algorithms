import java.util.Arrays;

public class TP2 {


  public static void main(String args[]) {
    SortStrategy sortingMethod;

    /*
    for (Sort p : Sort.values()) {
      sortingMethod = p.getSortMethod();
      int[] res = RandomData.generate1d(100000, 0, 500);
      System.out.println("Starting compilation for " + p.getSortStrategy().toString());
      long start = System.currentTimeMillis();
      sortingMethod.sort(res);
      long elapsed = System.currentTimeMillis() - start;
      System.out.println("Compilation terminated. It took " + elapsed + " ms");
    }
    */

    // Create sorting algorithm
    SortFactory sortFactory = new SortFactory();
    SortStrategy sortingAlgorithm = sortFactory.createSort("Quick Sort");
    int[] res2 = RandomData.generate1d(1000, 0, 500);
    System.out.println(Arrays.toString(res2));
    sortingAlgorithm.sort(res2);
    System.out.println(Arrays.toString(res2));

  }


  public static int minArray(int[] array) {
    int min = array[0];
    for (int i = 0; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }
    return min;
  }


}
