import java.util.*;
class RemoveTheBalls {
    public int findLength(int[] color, int[] radius) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < color.length; i++) {
            if (!stack.isEmpty()) {
                int j = stack.peek();
                if (color[i] == color[j] && radius[i] == radius[j]) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(i);
        }
        return stack.size();
    }
}
