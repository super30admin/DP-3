//Time complxity is O(n) + O(maxNum + 1)
//Space complexity is O(maxNum + 1) which is linear


/*
Approach:
First we have to process the data and inorder to do that we have to create an array
of the size of the maximum value in the given array + 1. In the newly created array
we add the elements to the index = element. So if we have duplicate elements in the
given array we get the sum of all of them at that index. For example, we have [1,3,3,3,2] in
the given array we will get 9 at index 3 in the newly given array. We are doing this
becuase when we use 3 once 2 and 1 will be eliminated abd we will be left with [3,3]. 
No again we can take twice and our total points will be 9. So in order to  reduce the 
overhead we processed the data and created the new array. Now after that we noticed
that it is the same process which we followed in earlier patterns that is skip and take.
We can do it in single pass, so we are using a buffer to store the intermediate data
as it prevents that data from being overrridden. For skip case, the results is the 
maximum value between skip value and the take value. For the take case, the result is 
the sum of the earlier skip value, which is stored in the buffer to prevent that data
from being overriden, and the current value of the newly created index.
*/

// The code ran perfectly on leetcode.

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size() == 1) return nums[0];
        //finding the maximum number in the given array
        int maxNum = 0;
        for(int i =0; i<nums.size(); i++){
             maxNum = max(maxNum, nums[i]);
        }
        //creating an array of the size maxVal + 1 and process the data
        vector<int> temp(maxNum+1);
        for(int i = 0; i<nums.size(); i++){
            temp[nums[i]] += nums[i];
        }
        
        int skip = 0, take = 0, buff = 0;
        for(int i =0; i<temp.size(); i++){
            buff = skip;
            skip = max(skip, take);
            take = buff + temp[i];
        }
        
        return max(skip,take);
        
    }
};