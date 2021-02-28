//TC: O(n) where n is number of elements
//SC: O(n) since we use n-dimensional array to store counts.

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        //store counts of all numbers in array:
       
        int maxval = 0;
        //get max
        for(int i=0; i<nums.size(); i++){
            if(nums[i]>maxval) maxval = nums[i];
        }
        
        int counts[maxval+1];
        
        for(int i=0; i<maxval+1; i++)
            counts[i] = 0;
        
        for(int i=0; i<nums.size(); i++)
            counts[nums[i]]++;
        

        //get list of counts and follow same idea as house robber problem

        //assign zeroth to prev
        int prev_max = 0*counts[0];
        //assign first to current
        int curr_max = max(prev_max, counts[1]*1);
        
        for(int i=2; i<maxval+1; i++){
            //set a temp equal to current.
            int temp = curr_max;
            //check if prev + new is greater than current_max
            curr_max = max(curr_max, prev_max + i*counts[i]);
            //cout<<curr_max<<endl;
            prev_max = temp;
        }
            
        return curr_max;

    }
};