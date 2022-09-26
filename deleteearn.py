'''
Time Complexity: O(N)
Space Complexity: O(1)
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        temp_arr = [0]*(max(nums)+1)
        skip = 0
        take = 0
        for i in nums:
            temp_arr[i] += i
        print(temp_arr)
        for i in range(0,len(temp_arr)):
            temp = skip
            skip = max(skip, take)
            take = temp+temp_arr[i]
            
        return max(skip, take)
            
        