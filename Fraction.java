public class Fraction
{
    private int m_num;
    private int m_denom;

    public Fraction(int num, int denom)
    {
        boolean isNegative = false;
        if (num < 0 && denom < 0) 
        {
            num *= -1;
            denom *= -1;
        }
        else {
            if (num < 0) { num *= -1; isNegative = true; }
            if (denom < 0) { denom *= -1; isNegative = true; }
        }

        m_num = num / euclid(num, denom);
        m_denom = denom / euclid(num, denom);
        if (isNegative) { m_num *= -1; }
    }

    public Fraction(int num)
    {
        this(num, 1);
    }

    public Fraction add(Fraction other)
    {
        return new Fraction(
            m_num * other.m_denom + m_denom * other.m_num,
            m_denom * other.m_denom);
    }

    public Fraction multiply(Fraction other)
    {
        return new Fraction(m_num * other.m_num, m_denom * other.m_denom);
    }

    public int euclid(int x, int y) {
        if (x == 0 || y == 0) {
            return 1;
        }
        if (x < y) {
            int t = x;
            x = y;
            y = t;
        }
        if (x % y == 0) {
            return y;
        } else {
            return euclid(y, x % y);
        }
    }

    public int getNum() { return m_num;}

    public int getDenom() { return m_denom;}

    public String toString()
    {
        if (m_denom == 1) { return String.valueOf(m_num); }
        return m_num + "/" + m_denom;
    }
}