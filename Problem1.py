#Time complexity: O(n) where n is the length of input array
#Space complexity: O(n) where n is the length of input array
#Works on leetcode: yes
#Approach: Since alternate values of selected number are deleted and they cant be counted, this can be reduced to house robber
# problem. We store the frequency of each number as the sum, so if number 3 occurs twice freq[3]=6. For resulting array, we
# use the "prev" variable to keep memory of last maximum amount and "cur" keep tracks of the current maximum amount. 
class Solution:
    #Function to find the maximum number of points you can earn by applying given operations.
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        freq = [0]*(max(nums)+1)
        for n in nums:
            freq[n] += n
        prev, cur =0,0
        for f in freq:
            prev, cur = cur, max(cur, prev+f)
        return cur
        