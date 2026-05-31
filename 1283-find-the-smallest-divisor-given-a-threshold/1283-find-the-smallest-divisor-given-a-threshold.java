class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int l = 1;
        int r = 0;

        for(int num : nums) {
            r = Math.max(r, num);
        }

        int ans = r;

        while(l <= r) {

            int mid = l + (r - l) / 2;

            if(valid(nums, mid, threshold)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private boolean valid(int[] nums, int div, int threshold) {

        int total = 0;

        for(int num : nums) {

            total += (num + div - 1) / div;

            if(total > threshold) {
                return false;
            }
        }

        return true;
    }
}