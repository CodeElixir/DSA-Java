class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0 && Math.abs(asteroids[i]) > stack.peek()) {
                stack.pop();
            }
            
            if (!stack.isEmpty() && asteroids[i] < 0 && Math.abs(asteroids[i]) == stack.peek()) {
                stack.pop();
                continue;
            }

            if (stack.isEmpty() || asteroids[i] > 0 || stack.peek() < 0) {
                stack.push(asteroids[i]);
            }
        }
        
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;
    }
}