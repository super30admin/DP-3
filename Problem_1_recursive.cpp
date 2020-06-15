//Time Complexity: 2^n, where n is the size of the array.
//Space Complexity: O(1) 
class Solution {
private:
     int helper(int comp[], int index, int sum, int size){
        if(index >= size){
            return sum;
        }
        int case_1 = helper(comp, index+1, sum, size);
        int case_2 = helper(comp, index+2, sum+comp[index], size);
        return max(case_1,case_2);
    }
    
    
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
        
        return helper(comp, 0, 0, max+1);
    }
   
};