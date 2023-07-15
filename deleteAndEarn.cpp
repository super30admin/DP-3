#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if (nums.empty()) return 0;

    int maxValue = 0;
    for (int num : nums) {
        maxValue = max(maxValue, num);
    }

    vector<int> arr(maxValue + 1, 0);
    for (int num : nums) {
        arr[num] += num;
    }

    int prev = arr[0];
    int curr = max(arr[0], arr[1]);

    for (int i = 2; i < arr.size(); i++) {
        int temp = curr;
        curr = max(arr[i] + prev, curr);
        prev = temp;
    }

    return curr;
        
    }
};