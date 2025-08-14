#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We store total points for each number using a map since the numbers may not be continuous.
Then we use bucket sort iterating rom the smallest to largest number, deciding whether to take or skip.
At each step, we only track the last two values to calculate max points earned.
*/
class Solution{
public:
    int deleteAndEarn(vector<int>& nums) {
        unordered_map<int, int> map;
        int min_val = INT_MAX, max_val = 0;

        for(int num : nums){
            map[num] += num;
            max_val = max(max_val, num);
            min_val = min(min_val, num);
        }

        int prev = map[min_val];
        int curr = prev;
        if(map.count(min_val + 1)){
            curr = max(prev, map[min_val + 1]);
        }

        for(int i = min_val + 2; i <= max_val; ++i){
            int temp = curr;
            if(map.count(i)){
                curr = max(curr, map[i] + prev);
            }
            prev = temp;
        }

        return curr;
    }
};
