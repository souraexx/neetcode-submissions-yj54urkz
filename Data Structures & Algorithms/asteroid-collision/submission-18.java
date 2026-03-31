class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> collision = new Stack<>();
        for (int asteroid:asteroids) {
            boolean destroyed = false;
            while (!collision.isEmpty() && asteroid<0 && collision.peek()>0) {
                if (Math.abs(asteroid)>Math.abs(collision.peek())) {
                    collision.pop();
                } else {
                    if (Math.abs(asteroid) == collision.peek()) {
                        collision.pop();
                    }
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) {
                collision.push(asteroid);
            }
        }
        int n = collision.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = collision.get(i);
        }
        return arr;
    }
}