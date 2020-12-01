// Time Complexity - O(n)
// Space Complexity - O(10001)

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> v(10001,0);
        
        for(auto num:nums){
            v[num] += num;
        }  
        
        int prev = v[1], curr = max(v[1],v[2]), tempPrev;
        
        for(int i=3;i<v.size();i++){
            tempPrev = prev;
            prev = curr;
            curr = max(tempPrev+v[i], curr);
        }
        
        return curr;
        
    }
};