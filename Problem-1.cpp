//TC = O(n)
//SC = O(n)

//used dp, like in house robber problem, this is a variation of same
class Solution {
public:
    	int deleteAndEarn(vector<int>& nums) {
		vector<int> cnt(10002);
		for(int i=0;i<nums.size();i++)
		{
			cnt[nums[i]]+=nums[i];
		}

		vector<int> dp(10002);
		dp[1]=cnt[1];
		dp[2]=max(cnt[1],cnt[2]);
		for(int i=3;i<dp.size();i++)
		{
			dp[i]=max(dp[i-2]+cnt[i],dp[i-1]);
		}

		return max(dp[10000],dp[9999]);
	}
};