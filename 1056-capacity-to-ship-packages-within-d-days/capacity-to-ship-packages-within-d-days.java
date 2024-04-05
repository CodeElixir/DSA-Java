class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = Integer.MIN_VALUE;
        int maxCapacity = 0;
        int capacity = 0;
        for (int i = 0; i < weights.length; i++) {
            maxCapacity += weights[i];
            minCapacity = Math.max(minCapacity, weights[i]);
        }
        while (minCapacity <= maxCapacity) {
            capacity = (minCapacity + maxCapacity) / 2;
            int daysForCap = getDaysWithCapacity(weights, capacity);
            if (daysForCap <= days) {
                maxCapacity = capacity - 1;
            } else {
                minCapacity = capacity + 1;
            }
        }
        return minCapacity;
    }

    private int getDaysWithCapacity(int[] weights, int capacity) {
        int days = 1;
        int load = 0;
        for (int i = 0; i < weights.length; i++) {
            load += weights[i];
            if (load > capacity) {
                days = days + 1;
                load = weights[i];
            }
        }
        return days;
    }
}