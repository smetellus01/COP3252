public class Fraction
{
  private int numerator = 0;		// numerator (and keeps sign)
  private int denominator = 1;		// always stores positive value

  public Fraction()
  {
  }

  public Fraction(int n, int d)
  {
    if (set(n,d)==false)
	set(0,1);
  }

  public boolean set(int n, int d)
  {
    if (d > 0)
    {
	numerator = n;
	denominator = d;
	return true;
    }
    else
	return false;
  }
  
  public String toString()
  {
    return (numerator + "/" + denominator);
  }

  public int getNumerator()
  {
    return numerator;
  }

  public int getDenominator()
  {
    return denominator;
  }

  public double decimal()
  {
    return (double)numerator / denominator;
  }



public Fraction simplify()
{
  
  int num = this.getNumerator();
  int denom = this.getDenominator();

  if(num == 0)
  {
    denom = 1;
  }
  else
  {
    for(int i = denom; i < 0; i--)
    {
      if(num % i == 0 && denom % i == 0)
      {
          num = num / i;
          denom = denom / i;
      }
    }
  }

  if(denom < 0)
  {
    denom = denom * -1;
    num = num * -1;
  }

  Fraction newFract = new Fraction(num, denom);
  return newFract;

}

public Fraction add(Fraction f)
{
  
  int num1 = this.getNumerator();
  int denom1 = this.getDenominator();
  int denom2 = f.getDenominator();
  int num2 = f.getNumerator();

  int num = 0;
  int denom = 0;

  num = ((num1*denom2)+(num2*denom1));
  denom = (denom1*denom2);
  
  if(denom < 0)
  {
    denom = denom * -1;
    num = num * -1;
  }

  Fraction newFract = new Fraction(num, denom);
  newFract = newFract.simplify();
  return newFract;

}

public Fraction subtract(Fraction f)
{
  
  int num1 = this.getNumerator();
  int denom1 = this.getDenominator();
  int denom2 = f.getDenominator();
  int num2 = f.getNumerator();

  int num = 0;
  int denom = 0;

  num = ((num1*denom2)-(num2*denom1));
  denom = (denom1*denom2);
  
  if(denom < 0)
  {
    denom = denom * -1;
    num = num * -1;
  }

  Fraction newFract = new Fraction(num, denom);
  newFract = newFract.simplify();
  return newFract;

}

public Fraction multiply(Fraction f)
{
  
  int num1 = this.getNumerator();
  int denom1 = this.getDenominator();
  int denom2 = f.getDenominator();
  int num2 = f.getNumerator();

  int num = 0;
  int denom = 0;

  num = num1*num2;
  denom = denom1*denom2;
  
  if(denom < 0)
  {
    denom = denom * -1;
    num = num * -1;
  }

  Fraction newFract = new Fraction(num, denom);
  newFract = newFract.simplify();
  return newFract;

}

public Fraction divide(Fraction f)
{
  
  int num1 = this.getNumerator();
  int denom1 = this.getDenominator();
  int denom2 = f.getDenominator();
  int num2 = f.getNumerator();

  int num = 0;
  int denom = 0;

  num = num1*denom2;
  denom = denom1*num2;
  
  if(denom < 0)
  {
    denom = denom * -1;
    num = num * -1;
  }

  Fraction newFract = new Fraction(num, denom);
  newFract = newFract.simplify();
  return newFract;

}
}
