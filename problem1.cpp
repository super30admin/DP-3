//time complexity : max(n,maxnumber);
//space complexity : o(maxnumber);
class Solution {

public:
    int deleteAndEarn(vector<int>& nums) {
        
        int maxx  = INT_MIN;
        
        for(int i=0;i<nums.size();i++) {
            maxx = max(maxx,nums[i]);
        }
        
        int dp[maxx+1];
        
        for(int i= 0;i<maxx+1;i++) {
            dp[i] =0;
        }
        
        for(auto num : nums) {
            dp[num] = dp[num] + num;
        }
        
        
        int skip = 0;
        int take = dp[0];
        
        
        for(int i= 1;i<maxx+1;i++) {
            int temp = skip;
            skip = max(take,skip);
            
            take = dp[i] + temp;
        }
        
        return max(skip,take);
    }
};