public class SortFactory {

  public static void main(String[] args) {
  }

  public SortStrategy createSort(String sortStrategy) {
    SortStrategy resultSort;
    for (Sort p : Sort.values()) {
      if (sortStrategy.equals(p.getSortStrategy())) {
        resultSort = p.getSortMethod();
        return resultSort;
      }
    }
    System.out.println("Sorry, this sorting algorithm isn't implemented");
    System.out.println("We'll use quick sort instead");
    return new QuickSort();
  }
}
