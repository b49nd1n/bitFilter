package bmstu.danich.org.bitFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class constant1React {
    ArrayList<Short> coeffsH;
    ArrayList<Short> exit;

    public constant1React(ArrayList<Short> coeffs) {
        coeffsH = coeffs;
    }

    public List<Double> ConstantReact() {
        exit = new ArrayList<Short>();
        int   counterCoeff;
        short convResShort;
        int   convRes = 0;
        System.out.println("Constant 1");
        ArrayList<Integer> accumualtor = new ArrayList<Integer>(2 * coeffsH.size());

        coeffsH.forEach(aShort -> accumualtor.add(Integer.valueOf(aShort)));

        for (int i = 0; i < coeffsH.size(); i++) {
            accumualtor.add(0);
        }

        int signal = Short.MAX_VALUE;

        for (counterCoeff = 0; counterCoeff < accumualtor.size(); ++counterCoeff) {
            convRes = 0;

            for (int counterConvolution = 0; counterConvolution <= counterCoeff; ++counterConvolution) {
                convRes += accumualtor.get(counterCoeff - counterConvolution);
            }

            int a = convRes * signal;
            int b = (int) ((a * Math.pow(2, -15)) / 1);
            convResShort = (short) b;
            System.out.println(counterCoeff + " " + convRes + " " + convResShort + " " + a);
            exit.add(convResShort);
        }

        return exit.stream().map(aShort -> aShort*Math.pow(2,-15)).collect(Collectors.toList());
    }

}
