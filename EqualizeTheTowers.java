public class EqualizeTheTowers {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int h : heights) {
            low = Math.min(low, h);
            high = Math.max(high, h);
        }

        int result = Integer.MAX_VALUE;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            int cost1 = totalCost(heights, cost, mid1);
            int cost2 = totalCost(heights, cost, mid2);

            result = Math.min(result, Math.min(cost1, cost2));

            if (cost1 < cost2) {
                high = mid2 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return result;
    }

    private int totalCost(int[] heights, int[] cost, int target) {
        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += Math.abs(heights[i] - target) * cost[i];
        }
        return total;
    }
}
