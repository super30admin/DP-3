'''
Time Complexity : O(max(n,max(nums))) where n is number of elements in nums array.
Space Complexity: O(max(nums))
Run on LeetCode : YES
'''
class Solution:
    def deleteAndEarn(self, nums: list[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        size = 0
        for num in nums:
            size = max(size,num)

        myArray = [0] * (size + 1)
        
        for num in nums:
            myArray[num] += num
        if len(myArray) == 2:
            return myArray[1]
        
        myArray[2] = max(myArray[2],myArray[1])
        
        for index in range(2, size + 1):
            myArray[index] = max(myArray[index - 1],myArray[index - 2] + myArray[index])
        
        return myArray[size]