class Solution:
    """
    Time complexity - O(max(n, max(nums)). n - length of nums
    Space complexity - O(max(nums))
    
    """
    def deleteAndEarn(self, nums: list[int]) -> int:
        max_in_nums = max(nums)
        points = [0 for x in range(0, max_in_nums+1)]
        # store the total sum of each integer in nums
        for num in nums:
            points[num] += num
        # 
        prev_to_prev = 0
        previous = points[1]
        current = previous
        for x in range(2,max_in_nums+1):
            # if choosing x, x-1 is not chosen in previous iteration. so add prev_to_prev for points.
            # if not choosing x, x-1 is chosen in previous iteration. so previous will be the points 
            current = max(previous, prev_to_prev + points[x])
            prev_to_prev = previous
            previous = current
        return current
        
        