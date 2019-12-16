public class Complex
{
    private int m_a;
    private int m_b;
    
    public Complex(int a, int b)
    {
        m_a = a;
        m_b = b;
    }
    
    public Complex(int a)
    {
        this(a, 0);
    }
    
    public Complex add(Complex other)
    {
        return new Complex(m_a + other.getA(), m_b + other.getB());
    }
    
    public Complex multiply(Complex other)
    {
        int first = m_a * other.getA();
        int outside = m_a * other.getB();
        int inside = m_b * other.getA();
        int last = m_b * other.getB() * -1;
        return new Complex(first + last, outside + inside);
    }
    
    public int getA() { return m_a; }
    public int getB() { return m_b; }
    
    public String toString()
    {
        String retval = "";
        if (m_a == 0) { return m_b + "i"; }
        retval += m_a;
        if (m_b == 0) { return retval; }
        if (m_b < 0) { retval += " - "; }
        else { retval += " + "; }
        retval += Math.abs(m_b) + "i";
        return retval;
    }
    
    public String toStringP()
    {
        return "(" + toString() + ")";
    }
    
    public static void main(String[] args)
    {
        Complex c1 = new Complex(2, -3);
        Complex c2 = new Complex(5, 3);
        System.out.print(c1.toStringP() + " * " + c2.toStringP() + " = ");
        System.out.println(c1.multiply(c2));
    }
}