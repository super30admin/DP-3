// Time Complexity O(n + max)
// Space Complexity O(max)
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int max_elem = *max_element(nums.begin(), nums.end());
        vector<int> freq(max_elem + 1, 0);

        for (int num : nums) {
            freq[num] += num;
        }

        vector<int> memo(max_elem + 1, 0);
        memo[0] = freq[0];
        memo[1] = max(freq[0], freq[1]);

        for (int i = 2; i <= max_elem; i++) {
            memo[i] = max(memo[i-1], freq[i] + memo[i - 2]);
        }

        return memo[max_elem];
    }
};