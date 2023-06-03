/*

// Time Complexity : O(M+N) - > M = max_element in the array and N = number of elements in the nums array.
// Space Complexity : O(M)-> for creating the hashmap;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
Preprocess the data to a houserobber problem.


// Your code here along with comments explaining your approach
You find the frequency of each number, store the product of frequency and the number.
Then the problem is similar to house robber problem.
Here we have used extra memory to store the indexes of the past values
to show which values were chosen for the minimum.

*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        size_t n{nums.size()};
        size_t nums_max = *max_element(nums.begin(),nums.end());
        vector<size_t> dp(nums_max+1,0);
        vector<bool> dp_2(nums_max+1,true);
        for(size_t num:nums){
            dp.at(num)+=num;
        }
        for(size_t i{2};i<=nums_max;++i){
            size_t val_1{dp.at(i)+dp.at(i-2)};
            size_t val_2{dp.at(i-1)};
            if(val_1>val_2){
                dp.at(i) = val_1;
                dp_2.at(i) = true;
            }
            else{
                dp.at(i)  = val_2;
                dp_2.at(i) = false;
            }
        }

        int idx = nums_max;

        while(idx>0){
            if(dp_2.at(idx)){
                cout<<idx<<"->";
                idx = idx - 2;
            }
            else{
                idx = idx - 1;
            }
        }
        cout<<endl;
        return dp.at(nums_max);
    }
};

int main(int argc, char const *argv[])
{
    Solution obj;
    vector<int> nums{2,1,2,4,6,1,2,2,6,7,10,1,4,3,9};
    obj.deleteAndEarn(nums);
    return 0;
}
