#Time complexity : O(n+max_element)
#Space complexity : O(n+max_element)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        points = defaultdict(int)
        for num in nums:
            if(num in points.keys()):
                points[num]+=num
            else:
                points[num] = num
        max_num = max(nums)
        maxPoints = [0]*(max_num+1)
        maxPoints[1] = points[1]
        for i in range(2,len(maxPoints)):
            maxPoints[i] = max(maxPoints[i-1],maxPoints[i-2]+points[i])
        return maxPoints[max_num]