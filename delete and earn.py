# // Time Complexity : O(nlogn)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        # create a frequency hashmap
        count = {}
        for num in nums:
            if num in count:
                count[num] += 1   
            else:
                count[num] = 1
                
        # sort the list with  unique elements
        nums = sorted(list(set(nums)))
        
        # base cases
        earn1, earn2 = 0, 0
        
        for i in range(len(nums)):
            
            # calculate current earn using the hashmap
            curEarn = nums[i] * count[nums[i]]
            
            # if ith value is plus one of previous value
            if i > 0 and nums[i] == nums[i-1]+1:
                
                # calculate the max from previous two indicies
                temp = earn2
                earn2 = max(curEarn+earn1, earn2)
                earn1 = temp
                
            # if the ith value is not i-1th value plus 1
            else:
                temp = earn2
                earn2 = curEarn + earn2
                earn1 = temp
                
        return earn2 