// Time Complexity : Max (n, m) ..... maximum between n and m  
//                   ... n is number of elements in original array; 
//                   ... m is maximum amount in n (in original data set)              
// Space Complexity : O(m) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leet code :
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.
*/

/*
Explanation : 
A frequency map is created to store frequency of each unique value.
Then this new data set is used traversed. From this onwards, problem becaomes similar to house robber.

For map, we can not use unordered_map, as we need to access elements in sequencial manner and 
perform dp logic on it. Therefore, array is used. 
In order to get required size for this new array, we need to find maximum value in original array.
Also, the numbers missing in original array will have default value 0 in new array.

If original array = [2,2,2,4,6,6]
output = 2*3 + 4 + 6*2 = 22
If we use map, there is not way to find missing number which is 1, 3, 5 in original array.

If array of size 6 is created then map/array will look like below
         _____________________________
         | 0 | 0 | 6 | 0 | 4 | 0 | 12 |     <<<< this array is used for house robber logic
         -----------------------------
index =    0   1   2   3   4   5   6
*/

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size() == 0) return 0;

        int maxVal = 0;
        for(auto i : nums){            // O(n)
            maxVal = max(i, maxVal);
        }

        vector<int>dp(maxVal+1, 0); // initialzie new vector to 0

        for(auto i: nums){     // O(n)
            dp[i] += i;
        }

        int prev = 0;
        int current=dp[0];

        for(int i=1; i<dp.size(); i++){      //O(m)
            int temp = current;
            current = max(current, dp[i]+prev);
            prev = temp;
        }
        return current;
    }
};