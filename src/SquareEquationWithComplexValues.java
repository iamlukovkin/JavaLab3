public class SquareEquationWithComplexValues {
    private final ComplexNumber aCoefficient;
    private final ComplexNumber bCoefficient;
    private final ComplexNumber cCoefficient;

    public SquareEquationWithComplexValues(ComplexNumber aCoefficient, ComplexNumber bCoefficient, ComplexNumber cCoefficient) {
        this.aCoefficient = aCoefficient;
        this.bCoefficient = bCoefficient;
        this.cCoefficient = cCoefficient;
    }

    public ComplexNumber[] solve() {
        ComplexNumber discriminant = bCoefficient.multiply(bCoefficient).sub(aCoefficient.multiply(new ComplexNumber(4, 0)).multiply(cCoefficient));
        return new ComplexNumber[] {
                bCoefficient.add(discriminant.square()).divide(aCoefficient.multiply(new ComplexNumber(2, 0))),
                bCoefficient.sub(discriminant.square()).divide(aCoefficient.multiply(new ComplexNumber(2, 0)))
        };
    }
}
