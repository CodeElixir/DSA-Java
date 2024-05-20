class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        max = leftSum;

        for (int i = 0; i < k; i++) {
            leftSum -= cardPoints[k - 1 - i];
            rightSum += cardPoints[cardPoints.length - 1 - i];
            max = Math.max(max, leftSum + rightSum);
        }

        return max;
    }
}