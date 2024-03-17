package laskin;

public class Laskin {
    private double result;

    public void setZero() {
        result = 0.0;
    }

    public double getResult() {
        return result;
    }

    public void add(double n) {
        result += n;
    }

    public void subtract(double n) {
        result -= n;
    }

    public void product(double n) {
        result *= n;
    }


    public void divide(double n) {
        if (n == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        result /= n;
    }

    public void square(double n) {
        result = n * n;
    }

    public void squareroot(double n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot take the square root of a negative number");
        }
        result = Math.sqrt(n);
    }

    public void currentON() {
        result = 0.0;
    }

    public void currentOFF() {
        // Assuming this method might be intended for cleanup or state preservation if needed
    }
}
