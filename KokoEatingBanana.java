class KokoEatingBanana {
    public int kokoEat(int[] arr, int k) {
        int low = 1, high = 0;
        for (int n : arr) high = Math.max(high, n);
        int ans = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canEatAll(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canEatAll(int[] arr, int k, int s) {
        int hours = 0;
        for (int bananas : arr) {
            hours += (bananas + s - 1) / s;
        }
        return hours <= k;
    }
}
