import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class Animation extends Application {

  @Override
  public void start(Stage stage) {
    stage.setTitle("Complexity Graph");
    //defining the axes
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    xAxis.setLabel("Size of input");
    //creating the chart
    final LineChart<Number, Number> lineChart =
            new LineChart<Number, Number>(xAxis, yAxis);

    // Sort comparisons

    lineChart.setTitle("Complexity Graph, Sorting");
    lineChart.setCreateSymbols(false);
    //defining a series

    //populating the series with data
    int numberOfSorts = Sort.values().length;
    int minSizeInput = 1;
    int maxSizeInput = 10000;
    int step = 100;
    int minValueInput = 0;
    int maxValueInput = 500;
    XYChart.Series[] series = new XYChart.Series[numberOfSorts];
    for (int i = 0; i < numberOfSorts; i++) {
      series[i] = new XYChart.Series();
    }

    int[][] res = new int[numberOfSorts][];
    long[] start = new long[numberOfSorts];
    long[] elapsed = new long[numberOfSorts];
    SortStrategy sortingMethod;
    int strategyNumber;
    for (Sort p : Sort.values()) {
      sortingMethod = p.getSortMethod();
      strategyNumber = p.getStrategyNumber();
      series[strategyNumber].setName(p.getSortStrategy());
      for (int i = minSizeInput; i < maxSizeInput; i += step) {
        res[strategyNumber] = RandomData.generate1d(i, minValueInput, maxValueInput);
        start[strategyNumber] = System.currentTimeMillis();
        sortingMethod.sort(res[strategyNumber]);
        elapsed[strategyNumber] = System.currentTimeMillis() - start[strategyNumber];
        series[strategyNumber].getData().add(new XYChart.Data(i, elapsed[strategyNumber]));
      }
    }
    Scene scene = new Scene(lineChart, 1000, 800);
    for (int i = 0; i < numberOfSorts; i++) {
      lineChart.getData().add(series[i]);
    }


    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}