# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : No, the logic was correct but it gave time limit exceed error
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution:
    def helper(self, nums: List[int], add: int) -> int:
        
       
        ###base
        if len(nums)==0:
            return add
        ###logic
        
        ###Choose
        choose = self.helper(nums[2:],add + nums[0])
        
        ###notChoose
        notChoose = self.helper(nums[1:],add)
        
        return max(choose,notChoose)
    
    
    def deleteAndEarn(self, nums: List[int]) -> int:
        newList = [0 for _ in range(max(nums)+1) ]
        for i in range(len(nums)):
            newList[nums[i]] = newList[nums[i]] + nums[i]
        
        return self.helper(newList,0)
