public class ComplexF
{
    private Fraction m_a;
    private Fraction m_b;
    
    public ComplexF(Fraction a, Fraction b)
    {
        m_a = a;
        m_b = b;
    }
    
    public ComplexF(Fraction f1)
    {
        this(f1, new Fraction(0));
    }
    
    public ComplexF(Complex c)
    {
        this(c.getA(), c.getB());
    }
    
    public ComplexF(int a, int b)
    {
        this(new Fraction(a, 1), new Fraction(b, 1));
    }
    
    public ComplexF add(ComplexF other)
    {
        return new ComplexF(m_a.add(other.getA()), m_b.add(other.getB()));
    }
    
    public ComplexF multiply(ComplexF other)
    {
        Fraction first = m_a.multiply(other.getA());
        Fraction outside = m_a.multiply(other.getB());
        Fraction inside = m_b.multiply(other.getA());
        Fraction last = m_b.multiply(other.getB()).multiply(new Fraction(-1));
        //System.out.println(first + " " + outside + " " + inside + " " + last);
        //System.out.println(first.add(last) + " " + outside.add(inside));
        return new ComplexF(first.add(last), outside.add(inside));
    }
    
    public Fraction getA() { return m_a; }
    public Fraction getB() { return m_b; }
    
    public String toString()
    {
        String retval = "";
        if (m_a.getNum() == 0) { return m_b + "i"; }
        retval += m_a;
        if (m_b.getNum() == 0) { return retval; }
        if (m_b.getNum() < 0) { retval += " - "; }
        else { retval += " + "; }
        retval += new Fraction(Math.abs(m_b.getNum()), m_b.getDenom()) + "i";
        return retval;
    }
    
    public String toStringP()
    {
        return "(" + toString() + ")";
    }
    
    public static void main(String[] args)
    {
        Complex c = new Complex(1, -2);
        Complex c_2 = new Complex(3, -5);
        ComplexF c1 = new ComplexF(c);
        
        Fraction f1 = new Fraction(-10, 7);
        Fraction f2 = new Fraction(5);
        ComplexF c2 = new ComplexF(c_2);
        System.out.print(c1.toStringP() + " * " + c2.toStringP() + " = ");
        System.out.println(c1.multiply(c2));
    }
}