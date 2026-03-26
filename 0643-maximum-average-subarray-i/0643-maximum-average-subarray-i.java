class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        
        // Step 1: Calculate initial window sum
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        
        double maxSum = windowSum;
        
        // Step 2: Slide the window
        for (int i = k; i < n; i++) {
            windowSum += nums[i];        // add next element
            windowSum -= nums[i - k];    // remove previous element
            
            maxSum = Math.max(maxSum, windowSum);
        }
        
        // Step 3: Return max average
        return maxSum / k;
    }
}