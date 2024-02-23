import java.util.ArrayList;

public class Fraction {
    private ComplexNumber numerator;
    private ComplexNumber denominator;

    public Fraction(ComplexNumber numerator, ComplexNumber denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public static ArrayList<Fraction> changeElements(ArrayList<Fraction> fractions) {
        ArrayList<Fraction> result = new ArrayList<>();
        for (int i = 0; i < fractions.size(); i++) {
            if (i % 2 == 0) {
                result.add(fractions.get(i).add(fractions.get(i + 1)));
            } else {
                result.add(fractions.get(i));
            }
        }
        return result;
    }

    public void setNumerator(ComplexNumber numerator) {
        this.numerator = numerator;
    }

    public Fraction add(Fraction fraction) {
        ComplexNumber denominator = getDenominator().multiply(fraction.getDenominator());
        ComplexNumber firstNumerator = getNumerator().multiply(fraction.getDenominator());
        ComplexNumber secondNumerator = fraction.getNumerator().multiply(getDenominator());
        return new Fraction(firstNumerator.add(secondNumerator), denominator);
    }

    public void setDenominator(ComplexNumber denominator) {
        this.denominator = denominator;
    }

    public ComplexNumber getNumerator() {
        return numerator;
    }

    public ComplexNumber getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return "(" + getNumerator().toString() + ") / (" + getDenominator().toString() + ")";
    }

    public static void displayFractions(ArrayList<Fraction> fractions) {
        for (Fraction fraction : fractions) {
            System.out.println("Дробь: " + fraction.toString());
        }
    }
}
