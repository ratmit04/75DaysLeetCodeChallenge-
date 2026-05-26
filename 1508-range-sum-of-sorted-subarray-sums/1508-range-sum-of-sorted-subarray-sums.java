

class Solution {

    int mini = Integer.MAX_VALUE;
    long sum = 0;
    int mod = 1000000007;

    long[] prefix;
    long[] prep;

    public int rangeSum(int[] nums, int n, int left, int right) {

        prefix = new long[n + 1];
        prep = new long[n + 2];

        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, nums[i]);
            sum += nums[i];

            prefix[i + 1] = prefix[i] + nums[i];
            prep[i + 2] = prep[i + 1] + prefix[i + 1];
        }

        long res = (smallestSum(nums, right) - smallestSum(nums, left - 1)) % mod;

        // handle negative modulo
        if (res < 0) res += mod;

        return (int) res;
    }

    private long smallestSum(int[] nums, int k) {
        long left = mini, right = sum, ans = -1;
        long[] ansP = new long[2]; // {count, total}

        while (left <= right) {
            long mid = (left + right) / 2;

            long[] p = countL(nums, mid);

            if (p[0] >= k) {
                ansP = p;
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ansP[1] - (ansP[0] - k) * ans;
    }

    private long[] countL(int[] nums, long target) {
        int left = 0, right = 0, n = nums.length;

        long sum = 0, total = 0, count = 0;

        while (right < n) {
            sum += nums[right];

            while (left <= right && sum > target) {
                sum -= nums[left];
                left++;
            }

            int len = right - left + 1;

            count += len;

            total = (total
                    + (len * prefix[right + 1])
                    - (prep[right + 1] - prep[left])) % mod;

            right++;
        }

        return new long[]{count, total};
    }
}