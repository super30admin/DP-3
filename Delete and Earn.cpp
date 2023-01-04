        // TC: O(n) + O(max(n))
        // SC: O(max(n))
        
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        // null
        if(nums.size() == 0) return 0;
        // finding the max in nums to create vector
        int maxnum = INT_MIN;
        for(int num: nums) maxnum = max(num, maxnum); // O(n)
        vector<int> v(maxnum + 1, 0);
        // consolidating question into v by aggregating into corresponding indices
        for(int num: nums) v[num] += num;
        // house robber
        int prev = v[0];
        int curr = max(v[0], v[1]);
        for(int i = 2; i < v.size(); i++) { // O(max(n))
            int temp = curr;
            //        choose        no choose   
            curr = max(prev + v[i], temp);
            prev = temp;
        }
        return curr;
    }
};