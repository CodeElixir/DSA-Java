class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (res.isEmpty() || start > res.get(res.size() - 1).get(1)) {
                List<Integer> interval = new ArrayList<>();
                interval.add(start);
                interval.add(end);
                res.add(interval);
            } else {
                List<Integer> prevInt = res.get(res.size() - 1);
                prevInt.set(0, Math.min(start, prevInt.get(0)));
                prevInt.set(1, Math.max(end, prevInt.get(1)));
            }
        }
        return res.stream().map(a -> a.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}