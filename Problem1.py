class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # Create a frequency dictionary to count the occurrences of each number
        freq = collections.Counter(nums)

        # Get the maximum value in the input array
        max_num = max(nums)

        # Initialize the dp array with zeros
        dp = [0] * (max_num + 1)

        # Base cases
        dp[1] = freq[1]

        # Iterate from 2 to max_num
        for i in range(2, max_num + 1):
            # Choose the maximum between two options:
            # 1. Skip the current number and take the previous maximum
            # 2. Take the current number and add it to the maximum of two steps back
            dp[i] = max(dp[i - 1], dp[i - 2] + i * freq[i])

        # Return the maximum points obtained from the last element of the dp array
        return dp[max_num]