# Did this code successfully run on Leetcode : YES

# TC: O(n)
# SC: O(max(n, max(nums)))

# Approach 
# get max number from nums
# create array with that size
# arr[i] will be total sum of i in nums
# after this transformation problem reduces to house robber
# meaning you can either rob i and i + 2 or only i + 1

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxi = max(nums)
        arr = [0]*(maxi+1)
        for n in nums:
            arr[n] += n
        skip = 0
        take = 0
        for i in range(len(arr)):
            # skip
            # prev skip
            temp = skip
            skip = max(skip, take)
            # take
            take = temp + arr[i]
        return max(skip, take)