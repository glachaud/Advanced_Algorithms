public class QuickSort implements SortStrategy {
  public static void main(String[] args) {
  }

  public void swap(int[] data, int i, int j) {
    int tmp = data[i];
    data[i] = data[j];
    data[j] = tmp;
  }

  public int partition(int[] data, int begin, int end, int pivotIdx) {
    this.swap(data, pivotIdx, --end);
    pivotIdx = end;
    int pivot = data[pivotIdx];
    // invariant is that everything before begin is known to be < pivot
    // and everything after end is known to be > pivot
    while (begin != end) {
      if (data[begin] >= pivot) {
        this.swap(data, begin, --end);
      } else {
        ++begin;
      }
    }
    this.swap(data, pivotIdx, begin);
    return begin;
  }

  @Override
  public void sort(int[] data) {
    sort(data, 0, data.length);
  }

  public void sort(int[] data, int begin, int end) {
    if ((end - begin) < 2) {
      return;
    }
    int m = partition(data, begin, end, (end - begin) / 2);
    this.sort(data, begin, m);
    this.sort(data, m + 1, end); // +1 for convergence}
  }
}
