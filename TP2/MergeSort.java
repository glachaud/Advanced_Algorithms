public class MergeSort implements SortStrategy {
  public static void main(String[] args) {
  }

  public void mergeSorted(int arrayToSort[], int begin, int middle, int end) {
    int[] tmp = new int[middle - begin];
    System.arraycopy(arrayToSort, begin, tmp, 0, tmp.length);
    int i = 0, j = middle, dest = begin;
    while ((i < tmp.length) && (j < end)) {
      arrayToSort[dest++] = (tmp[i] < arrayToSort[j] ? tmp[i++] : arrayToSort[j++]);
    }
    while (i < tmp.length) {
      arrayToSort[dest++] = tmp[i++];
    }
  }

  /**
   *
   * Sorts the given array using the merge sort method.
   * This algorithm uses a divide and conquer approach.
   * It recursively cuts the array in half until there is
   * at most one element inside the sub array, then it merges
   * the sorted sub arrays back together (using the mergeSorted method)
   *
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
    int middle = (end + begin) / 2;
    this.sort(arrayToSort, begin, middle);
    this.sort(arrayToSort, middle, end);
    this.mergeSorted(arrayToSort, begin, middle, end);
  }
}
