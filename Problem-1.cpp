//Time Complexity = Exponential
//Space Complexity = O(Maximum_Element)
//Here Time limit will exceed.
class Solution {
public:
    int helper(vector<int> temp, int index, int profit)
    {
        if(index>=temp.size())
            return profit;
        int case0 = helper(temp,index+1,profit);
        int case1 = helper(temp,index+2,profit+temp[index]);
        return max(case0, case1);
    }
    int deleteAndEarn(vector<int>& nums) {
        int i,maxi=INT_MIN;
        for(i=0;i<nums.size();i++)
            maxi=max(maxi,nums[i]);
        vector<int> temp(maxi+1,0);
        for(i=0;i<nums.size();i++)
            temp[nums[i]] += nums[i]; 
        return helper(temp, 0, 0);
    }
};


//Time Complexity = O(Maximum_Element+1) or O(N)
//Space Complexity = O(Maximum_Element+1)
//Where N is the size of the vector nums. 
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int i,maxi=INT_MIN;
        for(i=0;i<nums.size();i++)
            maxi=max(maxi,nums[i]);
        vector<int> temp(maxi+1,0);
        for(i=0;i<nums.size();i++)
            temp[nums[i]] += nums[i]; 
        int skip = 0, take = temp[0], t;
        for(i=1;i<temp.size();i++)
        {
            t = skip;
            skip = max(skip, take);
            take = t + temp[i];
        }
        return max(skip,take);
    }
};
