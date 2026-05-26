class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for (int i = 0;i<n;i++) {
            int count = 0;
            for (int x : nums) {
                if (x == nums[i]) count++;
            }
            if (count>n/2) return nums[i];
        }
        return nums[0];
    }
}