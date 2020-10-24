#Time Complexity : O(max(len(nums)), max(len(arr)))
#Space Complexity : O(max(nums))
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        arr = [0] * (max(nums)+1)

        #create array of sums of numbers at index where index is equal to the number
        for num in nums:
            arr[num] += num

        #either skip or take and find maximum 
        prevMax, currMax = 0, 0
        for i in range(len(arr)):
            temp = currMax
            currMax = max(prevMax+arr[i], currMax)
            prevMax = temp

        return max(prevMax, currMax)
