import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        protectTask();
//        customersManager();
//        equationsManager();
//        complexNumbersManager();
    }

    private static void complexNumbersManager() {
        ArrayList<Fraction> fractions = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            ComplexNumber numerator = new ComplexNumber(i / 10.0, i + 1 / 10.0);
            ComplexNumber denominator = new ComplexNumber(i + 2 / 10.0, i + 3 / 10.0);
            fractions.add(new Fraction(numerator, denominator));
        }
        ArrayList<Fraction> modified = Fraction.changeElements(fractions);
        for (Fraction fraction : fractions) {
            System.out.println(STR."Дробь: \{fraction.toString()}");
        }
        for (Fraction fraction : modified) {
            System.out.println(STR."Дробь: \{fraction.toString()}");
        }
    }

    private static void equationsManager() {
        ArrayList<SquareEquation> equations = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            equations.add(new SquareEquation(i / 10.0, i + 1 / 10.0, i + 2 / 10.0));
        }
        for (SquareEquation equation : equations) {
            System.out.println(equation);
            double[] roots = equation.getSolution();
            System.out.println(STR."Корни уравнения: \{roots[0]}, \{roots[1]}");
            System.out.println(STR."Экстремум: \{equation.getExtremeValue()}");
            double[][] intervals = equation.getIntervalOfRaiseAndDown();
            if (intervals == null) {
                System.out.println("Квадратное уравнение не имеет корней.");
            } else {
                System.out.println(STR."Интервал возрастания: (\{intervals[0][0]}\{intervals[0][1]}");
                System.out.println(STR."Интервал убывания: (\{intervals[1][0]}\{intervals[1][1]}");
            }
            System.out.println();
        }
        double[] maxAndMinRoots = SquareEquation.getMaxAndMinRoots(equations);
        System.out.println(STR."Максимальное и минимальное значение корня: \{maxAndMinRoots[0]}, \{maxAndMinRoots[1]}");
    }

    private static void customersManager() {
        ArrayList<Customer> customers = new ArrayList<>();
        for (int customerId = 0; customerId < 10; customerId++) {
            customers.add(new Customer(customerId));
        }
        ArrayList<Customer> orderedBySurnameCustomers = Customer.getCustomersOrderedBySurname(customers);
        ArrayList<Customer> orderedByCardNumberRangeCustomers = Customer.getCustomersOrderedByCardNumberRange(customers, 5, 8);
        System.out.println("\nСортировка по фамилии:");
        for (Customer customer : orderedBySurnameCustomers) {
            System.out.println(customer.toString());
        }
        System.out.println("\nСортировка по номеру кредитной карты:");
        for(Customer customer : orderedByCardNumberRangeCustomers) {
            System.out.println(customer.toString());
        }
    }

    private static void protectTask() {
        ComplexNumber aCoefficient = new ComplexNumber(1, 1);
        ComplexNumber bCoefficient = new ComplexNumber(1, 1);
        ComplexNumber cCoefficient = new ComplexNumber(1, 1);
        SquareEquationWithComplexValues equation = new SquareEquationWithComplexValues(aCoefficient, bCoefficient, cCoefficient);
        ComplexNumber[] solveOfEquation = equation.solve();
        System.out.println(STR."x1 = \{solveOfEquation[0].toString()}");
        System.out.println(STR."x2 = \{solveOfEquation[1].toString()}");
    }
}