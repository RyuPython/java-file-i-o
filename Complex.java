public class Complex extends Number implements Comparable<Complex> {
	private double real;
	private double imag;
	public Complex() { set(0,0); }
	public Complex(double re, double im) { set(re,im); }
	public Complex(Complex other) { /* FILL */ }
	public double re() { return real; }
	public double im() { return imag; }
	public double abs() { /* FILL */ }
	
	// absolute value of the complex value, real^2 + imag^2
	public void set(double re, double im) { /* FILL */ }
	public void set(Complex a) { /* FILL */ }
	// arithmetic operators
	public void add(Complex a, Complex b) // this = a+b
	{ /* FILL */ }
	public void sub(Complex a, Complex b) // this = a-b
	{ /* FILL */ }
	public void mul(Complex a, Complex b) // this = a*b
	{ /* FILL */ }
	
	@Override
	public String toString()
	// should return a String in the form of "(3.1+6.4i)" or "(-3.1-6.4i)"
	// according to the signs. Double values are represented by
	// 1 digit after the decimal point
	{ /* FILL */ }
	
	@Override
	// Override the equals method in the Object class
	public boolean equals(Object other) { /* FILL */ }
	
	@Override
	// returns integer-casted absolute value
	public int intValue() { return (int)doubleValue(); }
	
	@Override
	// Implement the abstract floatValue method in Number
	public float floatValue() { return (float)doubleValue(); }
	
	@Override
	// returns absolute value
	public double doubleValue() { /* FILL */ }
	
	@Override
	// Implement the abstract longValue method in Number
	public long longValue() { return (long)doubleValue(); }
	
	@Override
	// Implement the compareTo method in Comparable
	// returns 1 if |this| > |o|; -1 if |this| < |o|; 0 if |this| == |o|
	public int compareTo(Complex o) {
	{ /* FILL */ } 
}