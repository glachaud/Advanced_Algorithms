public class QuickSort implements SortStrategy {
  public static void main(String[] args) {
  }

  public void swap(int[] arrayToSort, int i, int j) {
    int tmp = arrayToSort[i];
    arrayToSort[i] = arrayToSort[j];
    arrayToSort[j] = tmp;
  }

  public int partition(int[] arrayToSort, int begin, int end, int pivotIdx) {
    this.swap(arrayToSort, pivotIdx, --end);
    pivotIdx = end;
    int pivot = arrayToSort[pivotIdx];
    // invariant is that everything before begin is known to be < pivot
    // and everything after end is known to be > pivot
    while (begin != end) {
      if (arrayToSort[begin] >= pivot) {
        this.swap(arrayToSort, begin, --end);
      } else {
        ++begin;
      }
    }
    this.swap(arrayToSort, pivotIdx, begin);
    return begin;
  }

  /**
   * Searches the array using the quick sort method.
   * This algorithm uses a divide and conquer approach.
   * At each step, we choose a pivot and partition the array
   * in such a way that all the elements less than the pivot are
   * at its left and all the elements greater than the pivot are
   * at its right. The pivot is then at its right place in the array.
   * @param arrayToSort
   */
  @Override
  public void sort(int[] arrayToSort) {
    sort(arrayToSort, 0, arrayToSort.length);
  }

  public void sort(int[] arrayToSort, int begin, int end) {
    if ((end - begin) < 2) {
      return;
    }
    int m = partition(arrayToSort, begin, end, (end - begin) / 2);
    this.sort(arrayToSort, begin, m);
    this.sort(arrayToSort, m + 1, end); // +1 for convergence}
  }
}
