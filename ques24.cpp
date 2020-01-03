Time Complexity-O(n*2)--> O(n) Here 'n' is the MAX element in the input vector
Space Complexity-O(n) Here 'n' is the MAX element in the input vector
Did the code run on Leetcode? Yes
Problems: Took lot of time to come up with the logic, tried using Hashmap as well but i was stuck in middle.
           

#include<vector>
#include <iostream>
#include <algorithm>
using namespace std;

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size()==0)
        {
            return 0;
        }
        int maximum=*max_element(nums.begin(),nums.end());
        vector<int>pointstable(maximum+1,0);
        pointstable[0]=0;
        for(auto a:nums)
        {
            pointstable[a]+=a;
        }
        int n=pointstable.size();
        vector<int>dp(n,0);
        dp[0]=0;
        dp[1]=pointstable[1];
        for(int i=2;i<n;i++)
        {
            dp[i]=max(dp[i-1],dp[i-2]+pointstable[i]);
        }
        return dp[n-1];
    }
};

int main() {
	vector<int>m={2,2,3,3,3,4};
	Solution soln;
	int result=soln.deleteAndEarn(m);
	cout<<result;
	return 0;
}