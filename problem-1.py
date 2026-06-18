# LEETCODE PROBLEM 740 DELETE AND EARN
# TIME COMPLEXITY: O(N+ max(N)) where N denotes the number of elements in an array
# SPACE COMPLEXITY:O(max(n))
# Any problem you faced while coding this: I am having difficulty in optimizing this code to a better solution


class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_val=0
        for i in nums:
            max_val=max(max_val,i)
        arr=[0]*(max_val+1)
        for i in nums:
            arr[i]+=i
        prev=arr[0]
        curr=max(arr[0],arr[1])

        for i in range(2,max_val+1):
            temp=curr
            curr=max(curr,arr[i]+prev)
            prev=temp
        return curr