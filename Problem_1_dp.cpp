//Time Complexity: O(n), where n is the size of the array.
//Space Complexity: O(n), where n is the max element of the array. 

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size()==0){
            return 0;
        }
        int max = 0;
        for(int i=0; i<nums.size(); i++){
            max = std::max(max,nums.at(i));
        }
        int comp[max+1];
        for(int i=0; i<max+1; i++){
            comp[i] = 0;
        }
        for(int i=0; i<nums.size(); i++){
            comp[nums.at(i)] += nums.at(i);
        }
        int skip = 0;
        int take = 0;
        for(int i=1; i<max+1; i++){
            int temp = skip;
            skip = std::max(skip,take);
            take = temp + comp[i];
        }
        return std::max(skip,take);
    }
};