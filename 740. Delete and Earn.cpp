class Solution {
public:
    //tc-O(N)
    //SC-O(N)
    int deleteAndEarn(vector<int>& nums) {
     
        int n=10001;
        vector<int>sum(n,0);
        for(auto num:nums){
            sum[num]+=num;
        }
        vector<int>dp(n,0);
        dp[0]=0;
        dp[1]=sum[1];
        int max_points=INT_MIN;
        for(int i=2;i<n;i++){
          dp[i]=max(dp[i-2]+sum[i],dp[i-1]);
        }
        return dp[n-1];
    }
};