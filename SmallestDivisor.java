public class SmallestDivisor {
    int smallestDivisor(int[] arr, int k) {
        int left = 1, right = (int)1e6, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int num : arr) {
                sum += (num + mid - 1) / mid;
            }
            if (sum <= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
