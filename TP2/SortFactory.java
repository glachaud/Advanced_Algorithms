public class SortFactory {

  public static void main(String[] args) {
  }
  

  public SortStrategy createSort(String sortStrategy) {
    if (sortStrategy.equalsIgnoreCase(Sort.SELECTION.name())) {
      return new SelectionSort();
    } else if (sortStrategy.equalsIgnoreCase(Sort.BUBBLE.name())) {
      return new BubbleSort();
    } else if (sortStrategy.equalsIgnoreCase(Sort.MERGE.name())) {
      return new MergeSort();
    } else if (sortStrategy.equalsIgnoreCase(Sort.QUICK.name())) {
      return new QuickSort();
    } else {
      return new QuickSort();
    }


  }
}
