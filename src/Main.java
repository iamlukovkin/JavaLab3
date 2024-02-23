import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        for (int customerId = 0; customerId < 10; customerId++) {
            customers.add(new Customer(customerId));
        }
        ArrayList<Customer> orderedBySurnameCustomers = Customer.getCustomersOrderedBySurname(customers);
        ArrayList<Customer> orderedByCardNumberRangeCustomers = Customer.getCustomersOrderedByCardNumberRange(customers, 5, 8);
        System.out.println("\nСортировка по фамилии:");
        Customer.displayCustomers(orderedBySurnameCustomers);
        System.out.println("\nСортировка по номеру кредитной карты:");
        Customer.displayCustomers(orderedByCardNumberRangeCustomers);

        ArrayList<SquareEquation> equations = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            equations.add(new SquareEquation(i / 10.0, i + 1 / 10.0, i + 2 / 10.0));
        }
        for (SquareEquation equation : equations) {
            equation.displayAllInfo();
            System.out.println();
        }
        double[] maxAndMinRoots = SquareEquation.getMaxAndMinRoots(equations);
        System.out.println("Максимальное и минимальное значение корня: " + maxAndMinRoots[0] + ", " + maxAndMinRoots[1]);

        ArrayList<Fraction> fractions = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            ComplexNumber numerator = new ComplexNumber(i / 10.0, i + 1 / 10.0);
            ComplexNumber denominator = new ComplexNumber(i + 2 / 10.0, i + 3 / 10.0);
            fractions.add(new Fraction(numerator, denominator));
        }
        ArrayList<Fraction> modified = Fraction.changeElements(fractions);
        Fraction.displayFractions(fractions);
        System.out.println();
        Fraction.displayFractions(modified);

    }
}