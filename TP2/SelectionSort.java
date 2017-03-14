/**
 * Created by guillaumelachaud on 2/21/17.
 */
public class SelectionSort implements SortStrategy {
  public static void main(String[] args) {
  }

  public void swap(int[] arrayToSort, int i, int j) {
    int tmp = arrayToSort[i];
    arrayToSort[i] = arrayToSort[j];
    arrayToSort[j] = tmp;
  }

  public int minimumIndex(int[] arrayToSort, int begin, int end) {
    int res = begin;
    for (int i = begin; i != end; ++i) {
      if (arrayToSort[i] < arrayToSort[res]) {
        res = i;
      }
    }
    return res;
  }

  @Override
  public void sort(int[] arrayToSort) {
    if (arrayToSort.length < 2) {
      return;
    }
    for (int i = 0; i != arrayToSort.length - 1; ++i) {
      this.swap(arrayToSort, i, minimumIndex(arrayToSort, i, arrayToSort.length));
    }
  }
}
