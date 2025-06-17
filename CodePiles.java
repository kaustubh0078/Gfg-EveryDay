import java.util.*;
public class CodePiles {
    public int minimumCoins(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        long minCoins = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int upper = upperBound(arr, x + k);
            long removed = prefix[i] + (prefix[n] - prefix[upper] - (long)(x + k) * (n - upper));
            minCoins = Math.min(minCoins, removed);
        }
        return (int)minCoins;
    }

    private int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= key) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
