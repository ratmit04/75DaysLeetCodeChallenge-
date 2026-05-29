class Solution {
    public int maxProduct(int[] nums) {
        int maxP=Integer.MIN_VALUE;
        int curr=1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            curr*=nums[i];
            maxP=Math.max(maxP,curr);
            if(curr==0){curr=1;}
        }
        curr=1;
        for(int i=n-1;i>=0;i--){
            curr*=nums[i];
            maxP=Math.max(maxP,curr);
            if(curr==0){curr=1;}
        }
        return maxP;
    }
}