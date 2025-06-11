import java.util.*;

class KClosestElements {
    int[] printKClosest(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]
        );
        for (int val : arr) {
            if (val != x) {
                pq.offer(new int[]{Math.abs(val - x), val});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[1];
        }
        return res;
    }
}
