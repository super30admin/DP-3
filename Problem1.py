# Time complexity : O(n,max(m)) --> n is the lenght of nums and m is the max number in the list
# Space complexity : O(max(m)) --> m is the max number in the list
# Leetcode : Solved and submitted

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # finding the length of the list
        n = len(nums)
        
        # finding the max number from the list
        max_num = nums[0]
        for i in range(1,n):
            max_num = max(max_num,nums[i])
        
        # create a temp array with the length as the max number of the given input List, and then finding the amount that each int element in the list can
        # provide, which is basically multiply the number with it's occurences
        arr = [0 for _ in range(max_num+1)]
        m = len(arr)
        for i in range(n):
            arr[nums[i]] += nums[i]
        
        # taking two variables to store the first two values, prev is the first element of the list arr itself, then curr is the current max
        prev = arr[0]
        curr = max(prev,arr[1])
        
        # we traverse from the 2nd index till the end of the list, store the current max as it will be replaced, then find the current max by adding the 
        # index+2 values with that value, compare with the next element value plus the prev max, then make the curr_max till now to the prev
        # and finally returing the current max we have calculated till now
        for i in range(2,m):
            temp = curr
            curr = max(curr, prev + arr[i])
            prev = temp
        
        return curr
