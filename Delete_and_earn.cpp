/*
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int mx = maxi(nums);
        vector<int> dp(mx+1,0);
        for(int num: nums){
            dp[num]+=num;
        }
        for(int i = 1; i<=mx;i++){
            dp[i]=max((dp[i]+((i-2)<0 ? 0: dp[i-2])),dp[i-1]);
        }
        return dp[mx];
    }
    int maxi(vector<int>& nums){
        int a=0;
        for(int i = 0; i < nums.size(); i++){
            if(nums[i]>a){
                a=nums[i];
            }
        }
        return a;
    }
};