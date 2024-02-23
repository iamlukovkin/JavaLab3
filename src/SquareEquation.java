import java.util.ArrayList;
import java.util.Collections;

public class SquareEquation {
    private final double a;
    private final double b;
    private final double c;

    public SquareEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void displayAllInfo() {
        System.out.println(this);
        double[] roots = getSolution();
        System.out.println("Корни уравнения: " + roots[0] + ", " + roots[1]);
        System.out.println("Экстремум: " + getExtremum());
        displayIntervalOfRaiseAndDown();
    };

    private double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    private double getRootFirst() {
        return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
    }

    private double getRootSecond() {
        return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }

    public double[] getSolution() {
        if (getDiscriminant() < 0) {
            return new double[]{Double.NaN, Double.NaN};
        }
        return new double[]{getRootFirst(), getRootSecond()};
    }

    public String toString() {
        return "Квадратное уравнение: " + a + "x^2 + " + b + "x + " + c + " = 0";
    }

    public double getExtremum() {
        return -b / (2 * a);
    }

    public void displayIntervalOfRaiseAndDown() {
        if (getDiscriminant() < 0) {
            System.out.println("Квадратное уравнение не имеет корней.");
        }else if (a > 0) {
            System.out.println("Интервал возрастания: (-∞; " + getExtremum() + ").\nИнтервал убывания: (" + getExtremum() + "; +∞).");
        } else {
            System.out.println("Интервал возрастания: (" + getExtremum() + "; +∞).\nИнтервал убывания: (-∞; " + getExtremum() + ").");
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