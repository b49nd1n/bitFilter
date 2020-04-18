package bmstu.danich.org.bitFilter;

import javafx.application.Application;
import javafx.stage.Stage;
import org.math.plot.Plot2DPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    static String coeffsPath = "coeffs";

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        ArrayList<Short> coeffs;
        List<Double>     exitOne;
        List<Double>     exitDelta;
        coeffs = Parser.parse(coeffsPath);

        constant1React reactionConOne = new constant1React(coeffs);
        deltaReact     reactionDelta  = new deltaReact(coeffs);
        exitOne = reactionConOne.ConstantReact();
        exitDelta = reactionDelta.DeltaReact();

        assert exitDelta.size() == exitOne.size();
        int size = exitDelta.size();

        double[] x          = new double[size];
        double[] y_delta    = new double[size];
        double[] y_constant = new double[size];

        for (int i = 0; i < size; i++) {
            x[i] = i;
            y_delta[i] = exitDelta.get(i);
            y_constant[i] = exitOne.get(i);
        }

        Plot2DPanel plot_delta = new Plot2DPanel();

        plot_delta.addLinePlot("my plot_delta", x, y_delta);

        JFrame frame = new JFrame("a plot_delta panel");
        frame.setSize(600, 500);
        frame.setContentPane(plot_delta);
        frame.setVisible(true);

        Plot2DPanel plot_constant = new Plot2DPanel();

        plot_constant.addLinePlot("my plot_constant", x, y_constant);

        JFrame frame2 = new JFrame("a plot_constant panel");
        frame2.setSize(600, 500);
        frame2.setContentPane(plot_constant);
        frame2.setVisible(true);

    }
}
