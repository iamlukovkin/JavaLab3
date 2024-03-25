import java.util.ArrayList;
import java.util.Collections;

public class SquareEquation {
    private final double aCoefficient;
    private final double bCoefficient;
    private final double cCoefficient;

    public SquareEquation(double aCoefficient, double bCoefficient, double cCoefficient) {
        this.aCoefficient = aCoefficient;
        this.bCoefficient = bCoefficient;
        this.cCoefficient = cCoefficient;
    }

    private double getDiscriminant() {
        return bCoefficient * bCoefficient - 4 * aCoefficient * cCoefficient;
    }

    private double getRootFirst() {
        return (-bCoefficient + Math.sqrt(getDiscriminant())) / (2 * aCoefficient);
    }

    private double getRootSecond() {
        return (-bCoefficient - Math.sqrt(getDiscriminant())) / (2 * aCoefficient);
    }

    public double[] getSolution() {
        if (getDiscriminant() < 0) {
            return new double[]{Double.NaN, Double.NaN};
        }
        return new double[]{getRootFirst(), getRootSecond()};
    }

    public String toString() {
        return STR."Квадратное уравнение: \{aCoefficient}x^2 + \{bCoefficient}x + \{cCoefficient} = 0";
    }

    public double getExtremeValue() {
        return -bCoefficient / (2 * aCoefficient);
    }

    public double[][] getIntervalOfRaiseAndDown() {
        if (getDiscriminant() < 0) {
            return null;
        }
        double extremeValue = getExtremeValue();
        if (aCoefficient > 0) {
            return new double[][]{
                    {Double.NEGATIVE_INFINITY, extremeValue},
                    {extremeValue, Double.POSITIVE_INFINITY}
            };
        } else {
            return new double[][] {
                    {extremeValue, Double.POSITIVE_INFINITY},
                    {Double.NEGATIVE_INFINITY, extremeValue},
            };
        }
    }

    public static double[] getMaxAndMinRoots(ArrayList<SquareEquation> equations) {
        double[] maxAndMinRoots = new double[2];
        ArrayList<Double> roots = new ArrayList<>();
        for (SquareEquation equation : equations) {
            roots.add(equation.getRootFirst());
            roots.add(equation.getRootSecond());
        }
        maxAndMinRoots[0] = Collections.max(roots);
        maxAndMinRoots[1] = Collections.min(roots);
        return maxAndMinRoots;
    }
}