import java.util.Arrays;

public class TP2 {


  public static void main(String args[]) {
    SortStrategy sortingMethod;

    // Create sorting algorithm
    SortFactory sortFactory = new SortFactory();
    SortStrategy sortingAlgorithm = sortFactory.createSort("Quick Sort");
    int[] res2 = RandomData.generate1d(1000, 0, 500);
    System.out.println(Arrays.toString(res2));
    sortingAlgorithm.sort(res2);
    System.out.println(Arrays.toString(res2));

  }

  /**
   * Searches the array for its smallest element
   * @param arrayToSearch
   * @return the minimum value in the array
   */
  public static int minArray(int[] arrayToSearch) {
    int min = arrayToSearch[0];
    for (int i = 0; i < arrayToSearch.length; i++) {
      if (arrayToSearch[i] < min) {
        min = arrayToSearch[i];
      }
    }
    return min;
  }


}
