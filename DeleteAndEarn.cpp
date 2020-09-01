// N - nums Size
// M - countArray size
// T : O(M)
// S : O(M)
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size()==0) return 0;
        int mx = INT_MIN;
        for(auto i: nums)
            mx = max(mx, i);
        
        vector<int> countArray(mx+1,0);
        for(int i=0;i<nums.size();i++){ // N - nums Size
           // cout<<nums[i];
            countArray[nums[i]]+=nums[i];
        }
        //HOUSE ROBBER
        int C =0;
        int DC = 0;
        for(int i=0;i<countArray.size();i++){ // M - countArray size
            int prev = DC;
            DC  = max(C, DC);
            C = prev+countArray[i];
        }
        return max(C,DC);
    }
};