''' Time Complexity : O(n + k) ; where k = max(nums) 
    Space Complexity : O(k) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No


   Approach : Craete array of frequency, by storing the points we can get from num at its respective index
              This will give similar problem to House Robber, where we cannot take the next element as it has to be deleted 

'''

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        n = len(nums)
        max_val = 0
        for i in range(n):
            max_val = max(max_val, nums[i])

        # Pre Processing array of Frequency 
        arr = [0] * (max_val+1)
        for n in nums:
            arr[n] += n
        
        ## House Robber
        prev = arr[0]
        curr = max(arr[0],arr[1])
        for i in range(2,max_val+1):
            temp = curr 
            curr = max(curr, prev + arr[i])
            prev = temp
        return curr


        