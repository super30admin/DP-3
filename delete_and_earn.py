class Solution:
    def deleteAndEarn(self, nums):
        """
        Problem Summary:
        You may pick any number x, earn x points for each occurrence of x,
        but then all numbers equal to x-1 and x+1 must be deleted. 
        Find the maximum points possible. This reduces to the House Robber
        pattern once numbers are bucketed by value.

        Optimal Approach:
        Convert values into buckets (bucket[i] = total points from value i),
        then apply House Robber DP because choosing i invalidates i-1 and i+1.

        Time Complexity:  O(N + M)
            N = len(nums)
            M = max(nums)
        Space Complexity: O(M)

        One-liner summaries of all approaches:
        1. Recursive + Memo (Top-Down): Recurse on i → take or skip → memoize.
        2. Bottom-Up DP: Build dp[i] = max(dp[i-1], bucket[i] + dp[i-2]).
        3. Optimized DP (O(1) space): Track only prev and curr like House Robber.
        4. HashMap + DP: Use hash map for sparse nums and apply House Robber.
        5. Final Optimal: Bucket values and run space-optimized House Robber DP.
        """

        # Step 1: Create bucket array (bucket[i] = total points contributed by i)
        max_val = max(nums)
        bucket = [0] * (max_val + 1)

        for num in nums:
            bucket[num] += num

        # Step 2: House Robber DP on bucket array (space optimized)
        if max_val == 0:
            return bucket[0]

        if max_val == 1:
            return max(bucket[0], bucket[1])

        prev = bucket[0]                       # dp[i-2]
        curr = max(bucket[0], bucket[1])       # dp[i-1]

        for i in range(2, max_val + 1):
            new_curr = max(curr, bucket[i] + prev)
            prev = curr
            curr = new_curr

        return curr
