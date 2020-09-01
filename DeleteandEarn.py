// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        x=max(nums)
        dum=[0]*(x+1) #create a new array
        for i in nums:#add sum to the new array so that indices are inserted with correct sum
            dum[i]+=i
        c=0
        dc=0
        for i in dum: # choose and dont choose between two options in the newly created array
            temp=dc
            dc=max(c,dc)
            c=i+temp
        return max(c,dc) #the maximum will be in the final variables of c and dc which will be returned