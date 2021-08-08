//Time Complexity - O(N)+O(maxElement of nums)
//Space Complexity - O(max element of nums)
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int m=0;
        for(int i=0;i<nums.size();i++){
            m=max(nums[i],m);
        }
        int pre[m+1];
        for(int i=0;i<m+1;i++)
            pre[i]=0;
        for(int i=0;i<nums.size();i++){
            pre[nums[i]]=pre[nums[i]]+nums[i];
        }
        int take=pre[0],skip=0;
        for(int i=1;i<m+1;i++){
            int temp=skip;
            skip=max(skip,take);
            take=temp+pre[i];
        }
        return max(skip,take);
    }
};