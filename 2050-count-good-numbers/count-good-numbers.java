class Solution {
    private static final int MOD = 1000000007;
    
    public int countGoodNumbers(long n) {
        long evenPosCount = (n / 2) + (n % 2);
        long oddPosCount = n / 2;
        return (int) ((myPow(5, evenPosCount) * myPow(4, oddPosCount)) % MOD);
    }

    private long myPow(long x, long n) {
        if (n == 0) {
            return 1;
        }
        long partialAnswer = myPow(x, n / 2);
        long ans = (partialAnswer * partialAnswer) % MOD;
        if (n % 2 == 0) {
            return ans;
        } else {
            return (ans * x) % MOD;
        }
    }

}