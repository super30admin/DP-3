// Time Complexity : O(n+max_element)
// Space Complexity : O(max_element)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Converting into the DP array was a bit tricky to understand. Have to get clarity on the conversion


// Your code here along with comments explaining your approach (Similar to rob house problems)

//1. Edge case
//A. if nums size is zero return zero
//B. if nums.size is equal to one return the amount
//C. if nums.size is equal to two return the maximum amount

//2. Calculate the amount received
//A.Create aDp array
//B.Fill the key and value pair. Eg: if key is 2 accumulate number of 2's into the value
//C.Make decision from chose dont chose option

class Solution {
    int maximum_points (vector<int>& nums){
        
        int maximum_element = INT_MIN; 
        
        for(int i=0; i<nums.size();i++){
            if(maximum_element<nums[i]){
                maximum_element = nums[i];
            }
        }
        //A.Dp array declaration
        vector <int> points_for_the_element(maximum_element+1,0);
        
        //B.Filling of DP array
        for(int i=0; i<nums.size();i++){
            points_for_the_element[nums[i]] += nums[i];
        }
        
        int choose=0;
        int dont_choose=0;
        //C
        for(int i=1; i<points_for_the_element.size();i++){
            int temp = dont_choose;
            dont_choose = max(choose, dont_choose);
            choose = temp+points_for_the_element[i];
         }
        
        return max(choose, dont_choose);
    }
    
public:
    int deleteAndEarn(vector<int>& nums) {
        //1.A
        if(nums.size()==0){
            return 0;
        }
        if(nums.size()==1){
            return nums[0];
        }
        if(nums.size()==1){
            return max(nums[0], nums[1]);
        }
        
        return maximum_points(nums);
    }
};
