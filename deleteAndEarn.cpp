//SPace complexity: O(maximum)
//time complexity: O(n)+O(maximum)

//ApproachL: this is similar to house robber problem
//only thing is that you have to pre-process the given array first
// such that we find maximum of all the elements first and then create
//new array of the size max_+1 and then start putting maximum earnings
//from individual numbers

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int n=nums.size();
        int max_=INT_MIN;
        for(int i=0;i<n;i++) //n
        {
            max_=max(max_, nums[i]);          
        }
        vector<int> dp(max_+1);
        for(int i=0;i<n;i++) //n
        {
            int index=nums[i];
            dp[index]+=nums[i]; //pre - process the array
        }

        //Apply house robber
        int skip=0;
        int take=dp[0];
        for(int i=1;i<dp.size();i++) //n
        {
            int temp=skip;
            skip=max(skip, take);
            take=temp+dp[i];
        }
        return max(skip,take);
    }
};