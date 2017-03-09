public enum Sort {
  SELECTION("Selection Sort", 0),
  BUBBLE("Bubble Sort", 1),
  MERGE("Merge Sort", 2),
  QUICK("Quick Sort", 3);

  private final String sortStrategy;
  private final int strategyNumber;

  Sort(String sortStrategy, int strategyNumber) {
    this.sortStrategy = sortStrategy;
    this.strategyNumber = strategyNumber;
  }

  public String getSortStrategy() {
    return sortStrategy;
  }

  public int getStrategyNumber() {
    return strategyNumber;
  }

  public SortStrategy getSortMethod() {
    switch (strategyNumber) {
      case 0:
        return new SelectionSort();
      case 1:
        return new BubbleSort();
      case 2:
        return new MergeSort();
      case 3:
        return new QuickSort();
      default:
        return new QuickSort();
    }
  }


  public static void main(String[] args) {
    for (Sort p : Sort.values()) {
      System.out.printf("The value of %s is %s \n",
              p, p.getSortStrategy());
    }
  }
}
