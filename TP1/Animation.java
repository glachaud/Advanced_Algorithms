import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.Arrays;


public class Animation extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("Complexity Graph");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Size of input");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        /* Sort comparisons

        lineChart.setTitle("Complexity Graph, Sorting");
        lineChart.setCreateSymbols(false);
        //defining a series
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Selection Sort");

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Bubble Sort");

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Merge Sort");

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Quick Sort");
        //populating the series with data
        int[] res1, res2, res3, res4;
        for(int i = 1; i < 8000; i+=100) {
            res1 = RandomData.generate1d(i, 0, 1000);
            res2 = RandomData.generate1d(i, 0, 1000);
            res3 = RandomData.generate1d(i, 0, 1000);
            res4 = RandomData.generate1d(i, 0, 1000);
            long start1 = System.currentTimeMillis();
            SelectionSort.sort(res1);
            long elapsed1 = System.currentTimeMillis() - start1;
            series1.getData().add(new XYChart.Data(i, elapsed1));

            long start2 = System.currentTimeMillis();
            BubbleSort.sort(res2);
            long elapsed2 = System.currentTimeMillis() - start2;
            series2.getData().add(new XYChart.Data(i, elapsed2));

            long start3 = System.currentTimeMillis();
            MergeSort.sort(res3);
            long elapsed3 = System.currentTimeMillis() - start3;
            series3.getData().add(new XYChart.Data(i, elapsed3));

            long start4 = System.currentTimeMillis();
            QuickSort.sort(res4);
            long elapsed4 = System.currentTimeMillis() - start4;
            series4.getData().add(new XYChart.Data(i, elapsed4));
            // series2.getData().add(new XYChart.Data(i, i*Math.log(i)));
        }
        Scene scene  = new Scene(lineChart,1000,800);
        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
        lineChart.getData().add(series3);
        lineChart.getData().add(series4);
        */
        lineChart.setTitle("Complexity Graph, min finding");
        lineChart.setCreateSymbols(false);
        //defining a series
        XYChart.Series series = new XYChart.Series();
        int res[];
        int val;
        series.setName("Minimum of an array");
        for(int i = 1; i < 100000; i+=100) {
            res = RandomData.generate1d(i, 0, 500);
            //val = -2;
            //Arrays.sort(res);
            long start = System.nanoTime();
            TP1.minArray(res);
            long elapsed = (System.nanoTime() - start);
            series.getData().add(new XYChart.Data(i, elapsed));
        }
        Scene scene  = new Scene(lineChart,1000,800);
        lineChart.getData().add(series);


        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}