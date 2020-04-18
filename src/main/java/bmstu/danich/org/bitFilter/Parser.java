package bmstu.danich.org.bitFilter;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    static private ArrayList<Short> coeffs115 = new ArrayList<Short>();


    public static ArrayList<Short> parse(String fileName) {

        try {

            ArrayList<Double> coeffs = new ArrayList<Double>();
            File              f      = new File(fileName);
            FileInputStream   i      = new FileInputStream(f);
            Scanner           s      = new Scanner(i);
            while (s.hasNextLine()) {
                coeffs.add(Double.parseDouble(s.nextLine()));
            }

            short temp;
            for (int counter = 0; counter < coeffs.size(); ++counter) {
                temp = (short) Math.round(coeffs.get(counter) * Math.pow(2, 15));
                System.out.println(counter + " " + coeffs.get(counter) + " " + temp); //Проверка считываемости
                coeffs115.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return coeffs115;
    }
} 