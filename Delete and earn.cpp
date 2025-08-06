class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int maxele =0;
        for(int i:nums)
        maxele = max(maxele,i);
        vector<int>arr(maxele+1,0);
        for(int i =0;i<nums.size();i++) // create frequency array (bucket sort kind)
          arr[nums[i]] += nums[i];

        vector<int>dp(maxele+1,0); // use house robbere logic 
        dp[0]=arr[0];
        if(maxele>=1) // for edge case 
        dp[1]=max(arr[0],arr[1]);
        int i =2;
        while(i<=maxele)
        {
            dp[i]= max(dp[i-1],dp[i-2]+arr[i]);
            i++;
        }
        return dp[maxele];
         
        
    }
};