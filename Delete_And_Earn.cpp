/*
 Delete And Earn
 
Time Complexity - max of O(N,M) N being size of array, M being maximum element in array (if array has all same elements)
Space Complexity - O(M) M being maximum element in array
*/

#include <iostream>
#include <unordered_set>
#include <vector>
using namespace std;

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
     
        vector<int> tracker(getMaxElement(nums),0);
        for(int i=0;i<nums.size();i++){
            tracker[nums[i]]+=nums[i];
        }
        int c=0,dc=0;
        for(int i=0;i<tracker.size();i++){
            int temp=c;
            c=dc+tracker[i];
            dc=max(temp,dc);
            
        }
        return max(c, dc);
    }
    
private:
    int getMaxElement(vector<int>& nums){
        int maxElement=INT_MIN;
        for(int num:nums){
            maxElement=max(maxElement,num);
        }
        return maxElement+1;
    }
};
int main(int argc, const char * argv[]) {
    Solution s;
    vector<int> nums{3,4,2};
    std::cout << s.deleteAndEarn(nums) <<"\n";
    return 0;
}
