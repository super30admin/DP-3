// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        if( nums.size() == 0){
            return 0;
        }
        int size = max_value(nums) ;
        vector<int> new_array(size+ 1,0);
        cout<< max_value(nums) ;
        for (int n:nums){
            new_array[n] = n + new_array[n];
        }
        
         int choose = 0;
         int dont_choose = 0;
            
        
        for (int n:new_array){
            int temp = choose;
            
            choose = dont_choose;
            dont_choose =  max( temp + n, dont_choose);
        }
        
        return max(choose, dont_choose);
    }
    
    int max_value(vector<int>& vals){
        int max = INT_MIN;
        for (int n:vals){
            if (n > max){
                max = n;
            }
        }
        return max;
    }
};