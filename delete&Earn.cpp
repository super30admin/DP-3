// Recursive - TLE
// Time Complexity : O(nlogn +2^n) // n=unique elements
// Space Complexity : O(n) // recursive stack + map + set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: CREATE SET AND MAP FIRST; IN CHOOSING STEP, CHECK IF PREV EL PRESENT IN SET OR NOT 

// Your code here along with comments explaining your approach
// 1. Create ordered set of unique elements and a freq map
// 2. Each step, either dont choose el in set at curr index or choose it
// 3. If choosing, check whether prev el is present in set, if yes then index+=2 else index++
// 4. If index reaches end of set, update maxSum


class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size() == 0)
            return 0;
        set<int> unique;
        unordered_map<int,int> counter;
        int maxSum = 0;
        for(auto num: nums){
            unique.insert(num);
            counter[num]++;
        }

        dfs(unique,counter,0,0,maxSum);
        return maxSum;
    }
    
    void dfs(set<int>& unique, unordered_map<int,int>& counter, int index, int sum, int& maxSum){
        // base
        if(index >=  unique.size()){
            maxSum = max(maxSum, sum);
            return;
        }
        // logic
        int curr = *next(unique.begin(),index);
        // dont choose
        dfs(unique,counter,index+1,sum, maxSum);
        // choose
        sum += curr*counter[curr];
        if(counter.find(curr+1) != counter.end())
            index+=2; // skip the next element
        else
            index++;
        dfs(unique,counter,index,sum, maxSum);
    }
};

// DP solution
// Time Complexity : O(nlogn) // n=unique elements
// Space Complexity : O(n) // cache + map + set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: CREATE SET AND MAP FIRST; IN CHOOSING STEP, CHECK IF PREV EL PRESENT IN SET OR NOT 

// Your code here along with comments explaining your approach
// 1. Create ordered set of unique elements and a freq map and a cache with size +1
// 2. First element of cache is 0; Each step, select maximum by either: dont choose el in set at curr index or choose it
// 3. If choosing, check whether prev el is present in set, if yes then index+=2 else index++
// 4. Return last element

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size() == 0)
            return 0;
        if(nums.size() == 1)
            return nums[0];
        set<int> unique;
        unordered_map<int,int> counter;
        int maxSum = 0;
        for(auto num: nums){
            unique.insert(num);
            counter[num]++;
        }
        vector<int> cache(unique.size()+1,0);
        // if only 1 el then no option
        int first_el = *unique.begin();
        cache[1] = first_el * counter[first_el];

        for(int i=2;i<cache.size();i++){
            int dont_choose = cache[i-1];
            int el = *next(unique.begin(),i-1);
            int choose = el*counter[el];
            if(counter.find(el-1) != counter.end()) // num-1 found 
                choose += cache[i-2];
            else
                choose += cache[i-1];
            cache[i] = max(choose,dont_choose);
        }
        return cache.back();
    }
};