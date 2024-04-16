class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / myPowHelper(x, -n);
        }
        return myPowHelper(x, n);
    }

    private double myPowHelper(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double partialAnswer = myPowHelper(x, n / 2);
        if (n % 2 == 0) {
            return partialAnswer * partialAnswer;
        } else {
            return partialAnswer * partialAnswer * x;
        }
    }
}