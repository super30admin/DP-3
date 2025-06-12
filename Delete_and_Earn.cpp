//Time Complexity:O(m+n)
//Space Complexity : O(n)

#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size()==0)
            return 0;
        int n=nums.size(),maxi = 0;
        for(int i=0;i<n;i++){
            maxi = max(maxi,nums[i]);
        }
        vector<int>arr(maxi+1);
        for(int x:nums){
            arr[x] += x;
        }
        int prev = arr[0];
        int curr = max(arr[0],arr[1]);
        for(int i=2;i<arr.size();i++){
            int temp = curr;
            curr = max(curr,prev+arr[i]);
            prev = temp;
        }
        return curr; 
    }
};