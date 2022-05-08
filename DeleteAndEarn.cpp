//Time complexity = O(N) where N = value of the maximum element in the input array
//Space = O(N) where N = value of the maximum element in the input array

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int size = nums.size();
        if(size==0) return 0;
        if(size==1) return nums[0];
        
        //Convert Data into a house robber format
        int currentMax=0;
        for(int i=0;i<nums.size();i++){
            currentMax = std::max(currentMax,nums[i]);
        }
        vector<int> dp(currentMax+1);
        
        for(auto num: nums){
            dp[num] += num;  
        }
    
        //Make it a house robber problem
        int twoBehind = dp[0]; //two steps behind
        int oneBehind = std::max(dp[0],dp[1]); //one step behind
        
        for(int i=2;i<dp.size();i++){
            int current = std::max(oneBehind, dp[i] + twoBehind);
            twoBehind = oneBehind;
            oneBehind = current;
        }
        return oneBehind;
    }
};
