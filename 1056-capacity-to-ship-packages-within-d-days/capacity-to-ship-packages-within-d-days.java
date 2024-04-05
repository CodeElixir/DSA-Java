class Solution {
    // public int shipWithinDays(int[] weights, int days) {
    //     int minCapacity = Integer.MIN_VALUE;
    //     int maxCapacity = 0;
    //     int capacity = 0;
    //     for (int i = 0; i < weights.length; i++) {
    //         maxCapacity += weights[i];
    //         minCapacity = Math.max(minCapacity, weights[i]);
    //     }
    //     while (minCapacity <= maxCapacity) {
    //         capacity = (minCapacity + maxCapacity) / 2;
    //         int daysForCap = getDaysWithCapacity(weights, capacity);
    //         if (daysForCap <= days) {
    //             maxCapacity = capacity - 1;
    //         } else {
    //             minCapacity = capacity + 1;
    //         }
    //     }
    //     return minCapacity;
    // }

    // private int getDaysWithCapacity(int[] weights, int capacity) {
    //     int days = 1;
    //     int load = 0;
    //     for (int i = 0; i < weights.length; i++) {
    //         load += weights[i];
    //         if (load > capacity) {
    //             days = days + 1;
    //             load = weights[i];
    //         }
    //     }
    //     return days;
    // }
    public static int findDays(int[] weights, int cap) {
        int days = 1; //First day.
        int load = 0;
        int n = weights.length; //size of array.
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > cap) {
                days += 1; //move to next day
                load = weights[i]; //load the weight.
            } else {
                //load the weight on the same day.
                load += weights[i];
            }
        }
        return days;
    }

    public static int shipWithinDays(int[] weights, int d) {
        //Find the maximum and the summation:
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays(weights, mid);
            if (numberOfDays <= d) {
                //eliminate right half
                high = mid - 1;
            } else {
                //eliminate left half
                low = mid + 1;
            }
        }
        return low;
    }
}