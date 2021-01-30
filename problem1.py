// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums==0 or len(nums)==0:
            return 0
        dp=[0 for i in range(max(nums)+1)]          #create a list of size equals to the max number+1
        for i in nums:                              #find the sum of all the same numbers and store it against the index=i in dp
            dp[i]+=i
        c=0                                         #now the problem become similar to house robber problem i.e, choose alternate
        dc=0
        for i in dp:
            temp=dc
            dc=max(c,dc)
            c=temp+i
            
        return max(c,dc)
        
