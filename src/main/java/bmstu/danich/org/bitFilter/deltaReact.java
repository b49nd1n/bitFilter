package bmstu.danich.org.bitFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class deltaReact {
    ArrayList<Short> coeffsH;
    ArrayList<Short> exit;

    public deltaReact(ArrayList<Short> coeffs) {
        coeffsH = coeffs;
    }

    public List<Double> DeltaReact() {
        exit = new ArrayList<Short>();
        short convResShort;
        System.out.println("Delta");
        ArrayList<Integer> tempCoeffs = new ArrayList<>(2 * coeffsH.size());
        ArrayList<Integer> tempInput  = new ArrayList<>(2 * coeffsH.size());
        tempInput.add((int) Short.MAX_VALUE);
        coeffsH.forEach(aShort -> {
                    tempCoeffs.add(Integer.valueOf(aShort));
                }
        );

        for (int counter = coeffsH.size(); counter < 2 * coeffsH.size(); ++counter) {
            tempCoeffs.add(0);
            tempInput.add(0);
            tempInput.add(0);
        }

        int convRes = 0;
        for (int counterCoeff = 0; counterCoeff < tempCoeffs.size(); ++counterCoeff) {
            convRes = 0;
            for (int counterConvolution = 0; counterConvolution <= counterCoeff; ++counterConvolution) {
                convRes += tempCoeffs.get(counterCoeff - counterConvolution) * tempInput.get(counterConvolution);
            }

            convResShort = (short) ((convRes * Math.pow(2, -15)) / 1);
            System.out.println(counterCoeff + " " + convRes + " " + convResShort);
            exit.add(convResShort);
        }
        return exit.stream().map(aShort -> aShort * Math.pow(2,-15)).collect(Collectors.toList());
    }
}