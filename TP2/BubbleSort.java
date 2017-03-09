public class BubbleSort implements SortStrategy {
  public static void main(String[] args) {
  }

  public void swap(int[] data, int i, int j) {
    int tmp = data[i];
    data[i] = data[j];
    data[j] = tmp;
  }

  @Override
  public void sort(int[] data) {
    if (data.length < 2) {
      return;
    }
    boolean hadToSwap = false;
    do {
      hadToSwap = false;
      for (int i = 0; i != data.length - 1; ++i) {
        if (data[i] > data[i + 1]) {
          this.swap(data, i, i + 1);
          hadToSwap = true;
        }
      }
    } while (hadToSwap);
  }
}
