public class Tester
{
    public static void main()
    {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(-3, -4);
        ComplexF c1 = new ComplexF(f1, f2);
        ComplexF c2 = new ComplexF(f2, f1);
        System.out.println(c1.multiply(c2));
        System.out.println(f2);
    }
}