class Solution {
    public int threeSumMulti(int[] nums, int target) {
        int n=nums.length;
        int ans=0;
        int mod=(int)1e9+7;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            int left=i+1 , right=n-1;
            while(left<right)
            {
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==target)
                {
                    if(nums[left]==nums[right])
                    {
                        int len=right-left+1;
                        ans+=(len*(len-1)/2);
                        ans%=mod;
                        break;
                    }
                    int freqL=0,leftVal=nums[left];
                    int freqR=0,rightVal=nums[right];
                    while(nums[left]==leftVal){
                        left++;freqL++;
                    }
                    while(nums[right]==rightVal){
                        right--;freqR++;
                    }
                    ans+=(freqL*freqR);
                    ans%=mod;
                }else if(sum>target) right--;
                else left++;
            }
        }
    return ans;
    }
}