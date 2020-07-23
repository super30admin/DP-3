class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size()==0)
            return 0;
        int m=0;
        for(int i:nums)
            m=max(m,i);
        vector<int>A(m+1,0);
        for(int i:nums)
            A[i]+=i;
        int dp[A.size()+1][2];
        dp[0][0]=0;
        dp[0][1]=A[0];
        for(int i=1;i<A.size();i++)
        {
            dp[i][0]=max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+A[i];
        }
        return max(dp[A.size()-1][0],dp[A.size()-1][1]);
    }
};