import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Animation extends Application {

  ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

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
    AnimationVariables animationVariable = (AnimationVariables) context.getBean("animationVariables");
    XYChart.Series[] series = new XYChart.Series[numberOfSorts];
    for (int i = 0; i < numberOfSorts; i++) {
      series[i] = new XYChart.Series();
    }

    int[][] res = new int[numberOfSorts][];
    long[] start = new long[numberOfSorts];
    long[] elapsed = new long[numberOfSorts];
    SortStrategy sortingMethod;
    SortFactory sortFactory = new SortFactory();
    int strategyNumber;
    for (Sort p : Sort.values()) {
      sortingMethod = sortFactory.createSort(p.name());
      strategyNumber = p.ordinal();
      series[strategyNumber].setName(p.name());
      for (int i = animationVariable.getMinSizeInput(); i < animationVariable.getMaxSizeInput(); i += animationVariable.getStep()) {
        res[strategyNumber] = RandomData.generate1d(i, animationVariable.getMinValueInput(), animationVariable.getMaxValueInput());
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