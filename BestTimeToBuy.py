"""
The approach here is to set the first index element to i and then at every iteration check if element
at index is less than the ith element if so deduct them and find temp and update total with the max
value of temp. if ith element is smaller than index than set index = i.

Leetcode - Running
Time complexity - O(N)

"""
def BestTime(nums):
    index = 0
    total = 0
    for i in range(1,len(nums)):
        if nums[index] < nums[i]:
            temp = nums[i] - nums[index]
            total = max(total,temp)
        else:
            index = i
    return total

