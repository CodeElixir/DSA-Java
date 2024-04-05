class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = Integer.MIN_VALUE;
        int maxCapacity = 0;
        int capacity = 0;
        int actualCapacity = Integer.MAX_VALUE;
        for (int i = 0; i < weights.length; i++) {
            maxCapacity += weights[i];
            minCapacity = Math.max(minCapacity, weights[i]);
        }
        while (minCapacity <= maxCapacity) {
            capacity = (minCapacity + maxCapacity) / 2;
            int daysForCap = getDaysWithCapacity(weights, capacity);
            if (daysForCap <= days) {
                maxCapacity = capacity - 1;
                actualCapacity = Math.min(actualCapacity, capacity);
            } else {
                minCapacity = capacity + 1;
            }
        }
        return actualCapacity;
    }

    private int getDaysWithCapacity(int[] weights, int capacity) {
        int days = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > capacity) {
                days = days + 1;
                sum = weights[i];
            }
        }
        return days;
    }
}