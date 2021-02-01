# Time Complexity :O(n) where n is Max(nums)
# Space Complexity :O(n)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 740

# Given an array nums of integers, you can perform operations on the array.
#
# In each operation, you pick any nums[i] and delete it to earn nums[i] points.
# After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

# You start with 0 points. Return the maximum number of points you can earn by applying such operations.

# Example 1:
#
# Input: nums = [3,4,2]
# Output: 6
# Explanation: Delete 4 to earn 4 points, consequently 3 is also deleted.
# Then, delete 2 to earn 2 points.
# 6 total points are earned.
# Example 2:
#
# Input: nums = [2,2,3,3,3,4]
# Output: 9
# Explanation: Delete 3 to earn 3 points, deleting both 2's and the 4.
# Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
# 9 total points are earned.

def main():
    nums = [2,2,3,3,3,4]
    ans = deleteAndEarn(nums)
    print(ans)

def deleteAndEarn(nums):
    """
    :type nums: List[int]
    :rtype: int
    """

    maxVal = max(nums)
    totalFrequency = [0] * (maxVal + 1)
    dp = [0] * (maxVal + 1)

    for each in nums:
        totalFrequency[each] += each
    dp[0] = 0
    dp[1] = totalFrequency[1]

    for index in range(2, len(dp)):
    # In the question we are asked to remove nums[i] - 1 and nums[i] + 1 if nums[i] is selected.
    #             You will notice that the condition to fill dp[] looks a little different.
    #             Every element can either be picked or deleted. Deleted here means that nums[i] - 1 got picked and as a result
    #             current element is being removed, this is indicated by max(dp[i - 1], ...).
    #             If the current element is picked, then we will get all its points + solution of dp[i - 2]
    #             hence, max (..., totalPointsForNum[i] + dp[i - 2])

    #             In bottomup approach of DP it is important to create solutions based on previous (past) solutions.
    #              You cannot rely on a future solution. Coming back to the question, we have the same problem
    #             How do we handle removal of element nums[i] + 1 ??
    #             That will be handled later on i.e when we solve dp[nums[i] + 1] we will consider two scenarios:
    #             1. It got removed because we picked nums[i] - 1 or
    #             2. It got picked which will be counted with the subsolution of dp[i - 2].
                dp[index] = max(dp[index-1],totalFrequency[index]+dp[index-2])

    return dp[-1]

if __name__ == '__main__':
    main()