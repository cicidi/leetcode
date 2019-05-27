package algorithm.smart_solution;

/**
 * @author cicidi on 5/26/19
 * Lintcode 728. Three Distinct Factors
 * url https://www.lintcode.com/problem/three-distinct-factors/description
 */
public class ThreeDistinctFactors {
    /**
     * @param n: the given number
     * @return: return true if it has exactly three distinct factors, otherwise false
     */
    public boolean isThreeDisctFactors(long n) {
        // write your code here

        double eps = 1e-9;
        double sqrt = Math.sqrt(n);
        int intValue = (int) sqrt;
        if (sqrt - intValue < eps) {
            return isPrime(intValue);
        } else {
            return false;
        }
    }

    public boolean isPrime(double n) {

        for (double i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
