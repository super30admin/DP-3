# Time Complexity : O(n+k) where n is the length of nums and k is max(nums) 
# Space Complexity : O(k) auxiliary space is needed as we used a DP array of size k
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return
        if len(nums)==1:
            return nums[0]
        arr = [0 for _ in range(max(nums)+1)] # Create a DP array for size maximum of numbers + 1 #O(k)
        for i in range(len(nums)): # O(n)
            arr[nums[i]] += nums[i] # Add nums[i] to index nums[i] in arr for every occurence of it
        # print(arr)
        prev = 0 # Initialize prev and curr to the first 2 elements of arr. arr[0] is always 0 as 0+0+0+.... how many ever times is still 0
        curr = arr[1]
        for i in range(2,len(arr)): # O(k)
            # Iterate through i = 2 to the end of arr
            temp = curr
            curr = max(curr, arr[i]+prev) # Change curr to the max of curr and arr[i] + prev
            prev = temp # Swap prev with the curr before the update
        return curr # Return curr
            