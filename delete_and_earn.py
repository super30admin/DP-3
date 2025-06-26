# Time Complexity : O(n + k), where n is the length of nums and k is the maximum value in nums
# Space Complexity : O(k), where k is the maximum value in nums
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
def deleteAndEarn(nums):
    # Edge case: if the input list is empty
    if not nums:
        return 0

    # I first determined the maximum number in nums to size the helper array appropriately
    max_num = max(nums)

    # I created a points array where each index represents a value in nums, and the value at each index stores
    # the total points that can be earned by deleting all occurrences of that number
    points = [0] * (max_num + 1)
    for num in nums:
        points[num] += num

    # I applied a dynamic programming approach similar to the House Robber problem.
    # I kept track of two variables: take and skip.
    # take: maximum points if I take the current number
    # skip: maximum points if I skip the current number
    take = 0
    skip = 0

    for i in range(len(points)):
        take_i = skip + points[i]  # If I take i, I must have skipped i-1
        skip_i = max(skip, take)   # If I skip i, I take the maximum of previous skip or take
        take, skip = take_i, skip_i

    # Finally, I return the maximum of taking or skipping the last value
    return max(take, skip)
