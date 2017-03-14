public class BubbleSort implements SortStrategy {
  public static void main(String[] args) {
  }

  public void swap(int[] arrayToSort, int i, int j) {
    int tmp = arrayToSort[i];
    arrayToSort[i] = arrayToSort[j];
    arrayToSort[j] = tmp;
  }

  @Override
  public void sort(int[] arrayToSort) {
    if (arrayToSort.length < 2) {
      return;
    }
    boolean hadToSwap = false;
    do {
      hadToSwap = false;
      for (int i = 0; i != arrayToSort.length - 1; ++i) {
        if (arrayToSort[i] > arrayToSort[i + 1]) {
          this.swap(arrayToSort, i, i + 1);
          hadToSwap = true;
        }
      }
    } while (hadToSwap);
  }
}
