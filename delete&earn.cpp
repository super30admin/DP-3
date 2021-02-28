// Time Complexity: O(N)Where N is the size of nums vector
// Space Complexity: O(2N) Where N is the size of nums vector
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No







class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int prev = -1;
        int rows = nums.size();
        int cols = 2;
        int t[rows][cols];
        t[0][0] = nums[0];
        t[0][1] = 0;
        prev = nums[0];
        for(int i = 1; i < rows;i++){
            for(int j = 0; j < cols;j++){
                if(nums[i]==prev){
                    if(j==0)t[i][j] = t[i-1][j]+nums[i];
                    else t[i][j] = t[i-1][j];
                }
                else if (nums[i]-1==prev){
                    if(j==0)t[i][j] = nums[i] + t[i-1][1];
                    else t[i][j] = max(t[i-1][0],t[i-1][1]);
                }
                else{
                    if(j==0)t[i][j] = nums[i]+ max(t[i-1][0],t[i-1][1]);
                    else t[i][j] = max(t[i-1][0],t[i-1][1]);
                }
            }
            prev = nums[i];
        }
        return max(t[rows-1][0],t[rows-1][1]);
        
    }
};