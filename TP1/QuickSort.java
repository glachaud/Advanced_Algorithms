/**
 * Created by guillaumelachaud on 2/21/17.
 */
public class QuickSort {
  public static void main(String[] args) {
  }

  public static void swap(int[] data, int i, int j) {
    int tmp = data[i];
    data[i] = data[j];
    data[j] = tmp;
  }

  public static int partition(int[] data, int begin, int end, int pivotIdx) {
    swap(data, pivotIdx, --end);
    pivotIdx = end;
    int pivot = data[pivotIdx];
    // invariant is that everything before begin is known to be < pivot
    // and everything after end is known to be > pivot
    while (begin != end) {
      if (data[begin] >= pivot) {
        swap(data, begin, --end);
      } else {
        ++begin;
      }
    }
    swap(data, pivotIdx, begin);
    return begin;
  }

  public static void sort(int[] data) {
    sort(data, 0, data.length);
  }

  public static void sort(int[] data, int begin, int end) {
    if ((end - begin) < 2) {
      return;
    }
    int m = partition(data, begin, end, (end - begin) / 2);
    sort(data, begin, m);
    sort(data, m + 1, end); // +1 for convergence}
  }
}
